package vista;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionCursoDAO;
import mantenimiento.GestionMatriculaDAO;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Text;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class Reporte extends JInternalFrame {
	private JLabel lblNewLabel;
	private JComboBox CBO_Reporte;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	GestionCursoDAO gCurso = new GestionCursoDAO();
	GestionMatriculaDAO gMatricula = new GestionMatriculaDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnPDF;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reporte() {
		setTitle("Reporte Alumnos Matriculados");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Reportar por");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(33, 39, 120, 15);
			getContentPane().add(lblNewLabel);
		}
		{
			CBO_Reporte = new JComboBox();
			CBO_Reporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCBO_Reporte(e);
				}
			});
			CBO_Reporte.setModel(new DefaultComboBoxModel(new String[] {"-Select Item-", "Reporte Alumnos", "Reporte Cursos", "Reporte Matricula"}));
			CBO_Reporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
			CBO_Reporte.setBounds(163, 36, 150, 21);
			getContentPane().add(CBO_Reporte);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 89, 561, 447);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
		
		btnPDF = new JButton("Ver en PDF");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPDFActionPerformed(e);
			}
		});
		btnPDF.setBounds(446, 36, 120, 23);
		getContentPane().add(btnPDF);

	}

	protected void actionPerformedCBO_Reporte(ActionEvent e) {
		int Reporte = CBO_Reporte.getSelectedIndex();
		switch (Reporte) {
		case 1:
			listarEnTBAlumnos();
			break;
		case 2:
			listarEnTBCursos();
			break;
		case 3:
			listarEnTBMatricula();
			break;
		}
	}
	private void listarEnTBMatricula() {
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("Num. Matri");
		modelo.addColumn("Cod. Alum");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		table.setModel(modelo);
		
		modelo.setRowCount(0);
		
		ArrayList<Matricula> matriculas = gMatricula.leer();
		
		for (Matricula m : matriculas) {
			Object fila[] = { m.getNumMatricula(), m.getCodAlumno(), m.getCodCurso(), m.getFecha(), m.getHora() };

			modelo.addRow(fila);
		}
	}
	
	private void listarEnTBCursos() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("Creditos");
		model.addColumn("Horas");
		table.setModel(model);
		
		model.setRowCount(0);
		
		for ( Curso curso : gCurso.leer()) {
			Object[] row = {
					curso.getCodCurso(),
					curso.getAsignatura(),
					curso.getCiclo(),
					curso.getCreditos(),
					curso.getHoras(),
			};
			model.addRow(row);
		}
	}

	private void listarEnTBAlumnos() {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Código Alumno");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");
		table.setModel(model);
		
		model.setRowCount(0);
		ArrayList<Alumno> data = gAlumno.listar();
		for (Alumno a : data) {
			Object fila[] = {a.getCodAlumno(), a.getNombres(), 
					a.getApellidos(), a.getDni(), a.getEdad(), a.getCelular(), a.getEstado()};
			model.addRow(fila);
		}
	}

	protected void btnPDFActionPerformed(ActionEvent e) {
		
		int Reporte = CBO_Reporte.getSelectedIndex();
		switch (Reporte) {
			case 1:
				listarAlumnos();
					break;
			case 2:
				listarCursos();
				break;
			case 3:
				listarMatriculas();
				break;
		}
	}
	
	private void listarMatriculas() {
		String nombrachivo="lista_de_Matriculas.pdf";
		try{
		    //1. define el archivo lógico de trabajo
		    // utiliza import com.itextpdf.text.Document
			Document doc = new Document(PageSize.A4, 40, 40, 60, 60);
		    // 2. define el archivo fisico
		    FileOutputStream fos=new FileOutputStream(nombrachivo);
		    // 3. asocia el archivo logicoyfisico
		    PdfWriter pdfW = PdfWriter.getInstance(doc,fos);
		    // 4. crea el documento para escritura
		    doc.open();
		  
		    ArrayList<Matricula> list = gMatricula.leer();
		    // 1. define una tabla con3columnas
		   
		    doc.addTitle(new Paragraph("Listado de Matriculas") + "");
		    
		    Image img=Image.getInstance("src/imagenes/logosLogos.jpg");
		    img.scaleToFit(100,100);// redimensiona ancho/alto px
		    img.setAlignment(Chunk.ALIGN_LEFT);
		    doc.add(img);
		    
		    Paragraph titulo = new Paragraph("Listado de Matricula", FontFactory.getFont(FontFactory.COURIER, 20f));
		    titulo.setAlignment(Chunk.ALIGN_CENTER);
		    doc.add(titulo);
		    
		    Paragraph p=new Paragraph(LocalDate.now() + "");
		    p.setAlignment(Chunk.ALIGN_RIGHT);
		    doc.add(p);
		    
		    doc.add(new Paragraph("\n\n"));
		    
		    
		    PdfPTable tabla=new PdfPTable(5);
	       
	        String[] headersList = {"Num. Matricula", "Cod. Alumn", "Cod. Curso", "Fecha", "Hora"};
		    
		    for (String header : headersList) {
		    	Paragraph h = new Paragraph(header, FontFactory.getFont("arial", 10f, Chunk.ALIGN_CENTER, BaseColor.WHITE));// color);
		    	PdfPCell celda = new PdfPCell(h);
		    	celda.setBackgroundColor(BaseColor.BLACK);
		    	tabla.addCell(celda);
			}
		    
		    // 2. recorre la lista para agregar las filas
		    for(Matricula m: list){
		        // 3. agrega,acada columna los datos del reporte
		    	tabla.addCell(m.getNumMatricula());
		    	tabla.addCell(m.getCodAlumno());
		    	tabla.addCell(m.getCodCurso());
		    	tabla.addCell(m.getFecha());
		    	tabla.addCell(m.getHora());
		    }
		    // 4. agrega la tabla al pdf
		   
		    doc.add(tabla);		    
		    // 5. al finalizar cierra el documento
		    doc.close();
		    Desktop.getDesktop().open(new File(nombrachivo));
		}catch(Exception e){
		    System.out.println("Error al crear archivo:" +e.getMessage());
		}
	}

	private void listarAlumnos() {
		String nomarchivo="archivo.pdf";
		try{
		    //1. define el archivo lógico de trabajo
		    // utiliza import com.itextpdf.text.Document
			Document doc = new Document(PageSize.A4, 40, 40, 60, 60);
		    // 2. define el archivo fisico
		    FileOutputStream fos=new FileOutputStream(nomarchivo);
		    // 3. asocia el archivo logicoyfisico
		    PdfWriter pdfW = PdfWriter.getInstance(doc,fos);
		    // 4. crea el documento para escritura
		    doc.open();
		  
		    ArrayList<Alumno> list = gAlumno.listar();
		    // 1. define una tabla con3columnas
		   
		    doc.addTitle(new Paragraph("Listado de Alumnos") + "");
		    
		    
		    Image img=Image.getInstance("src/imagenes/logosLogos.jpg");
		    img.scaleToFit(100,100);// redimensiona ancho/alto px
		    img.setAlignment(Chunk.ALIGN_LEFT);
		    doc.add(img);
		    
		    Paragraph titulo = new Paragraph("Listado de Alumno", FontFactory.getFont(FontFactory.COURIER, 20f));
		    
		    titulo.setAlignment(Chunk.ALIGN_CENTER);
		    
		    doc.add(titulo);
		    
		    Paragraph p=new Paragraph(LocalDate.now() + "");
		    p.setAlignment(Chunk.ALIGN_RIGHT);
		    doc.add(p);
		    
		    doc.add(new Paragraph("\n\n"));
		    
		    
		    PdfPTable tabla=new PdfPTable(7);

		    // ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
		    tabla.setWidthPercentage(100f);
		   
		    String[] headersList = {"Codigo", "Nombre", "Apellido", "Dni", "Edad", "Celular", "Estado"};
		    
		    for (String header : headersList) {
		    	Paragraph h = new Paragraph(header, FontFactory.getFont("arial", 10f, Chunk.ALIGN_CENTER, BaseColor.WHITE));// color);
		    	PdfPCell celda = new PdfPCell(h);
		    	celda.setBackgroundColor(BaseColor.BLACK);
		    	tabla.addCell(celda);
			}
		    
		    // 2. recorre la lista para agregar las filas
		    for(Alumno a: list){
		        // 3. agrega,acada columna los datos del reporte
		    	tabla.addCell(a.getCodAlumno());
		        tabla.addCell(a.getNombres());
		        tabla.addCell(a.getApellidos());
		        tabla.addCell(a.getDni());
		        tabla.addCell(a.getEdad()+ "");
		        tabla.addCell(a.getCelular()+ "");
		        tabla.addCell(a.getEstado()+ "");
		    }
		    // 4. agrega la tabla al pdf
		   
		    doc.add(tabla);		    
		    // 5. al finalizar cierra el documento
		    doc.close();
		    Desktop.getDesktop().open(new File(nomarchivo));
		}catch(Exception e){
		    System.out.println("Error al crear archivo:" +e.getMessage());
		}
	}

	private void listarCursos() {
		String nombrachivo="lista_de_Cursos.pdf";
		try{
		    //1. define el archivo lógico de trabajo
		    // utiliza import com.itextpdf.text.Document
			Document doc = new Document(PageSize.A4, 40, 40, 60, 60);
		    // 2. define el archivo fisico
		    FileOutputStream fos=new FileOutputStream(nombrachivo);
		    // 3. asocia el archivo logicoyfisico
		    PdfWriter pdfW = PdfWriter.getInstance(doc,fos);
		    // 4. crea el documento para escritura
		    doc.open();
		  
		    ArrayList<Curso> list = gCurso.leer();
		    // 1. define una tabla con3columnas
		   
		    doc.addTitle(new Paragraph("Listado de Cursos") + "");
		    
		    Image img=Image.getInstance("src/imagenes/logosLogos.jpg");
		    img.scaleToFit(100,100);// redimensiona ancho/alto px
		    img.setAlignment(Chunk.ALIGN_LEFT);
		    doc.add(img);
		    
		    Paragraph titulo = new Paragraph("Listado de Cursos", FontFactory.getFont(FontFactory.COURIER, 20f));
		    titulo.setAlignment(Chunk.ALIGN_CENTER);
		    doc.add(titulo);
		    
		    Paragraph p=new Paragraph(LocalDate.now() + "");
		    p.setAlignment(Chunk.ALIGN_RIGHT);
		    doc.add(p);
		    
		    doc.add(new Paragraph("\n\n"));
		    
		    
		    PdfPTable tabla=new PdfPTable(5);
	       
	        String[] headersList = {"Codigo", "Asignatura", "Ciclo", "Credito", "Horas"};
		    
		    for (String header : headersList) {
		    	Paragraph h = new Paragraph(header, FontFactory.getFont("arial", 10f, Chunk.ALIGN_CENTER, BaseColor.WHITE));// color);
		    	PdfPCell celda = new PdfPCell(h);
		    	celda.setBackgroundColor(BaseColor.BLACK);
		    	tabla.addCell(celda);
			}
		    
		    // 2. recorre la lista para agregar las filas
		    for(Curso c: list){
		        // 3. agrega,acada columna los datos del reporte
		    	tabla.addCell(c.getCodCurso());
		        tabla.addCell(c.getAsignatura());
		        tabla.addCell(c.getCiclo()+ "");
		        tabla.addCell(c.getCreditos()+ "");
		        tabla.addCell(c.getHoras()+ "");
		    }
		    // 4. agrega la tabla al pdf
		   
		    doc.add(tabla);		    
		    // 5. al finalizar cierra el documento
		    doc.close();
		    Desktop.getDesktop().open(new File(nombrachivo));
		}catch(Exception e){
		    System.out.println("Error al crear archivo:" +e.getMessage());
		}
	}
}

