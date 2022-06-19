package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionCursoDAO;
import mantenimiento.GestionMatriculaDAO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class RegistroMatriculaAdicionar extends JInternalFrame {
	private JTextField text_Matricula;
	public static JTextField text_Alumno;
	public static JTextField text_Curso;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblAdicionarMatricula;
	private JLabel lbl_Imagen;
	private JScrollPane scrollPane;
	private JButton btn_Adicionar;
	private JTable table;
	private DefaultTableModel modelo;

	GestionMatriculaDAO gMatricula = new GestionMatriculaDAO();
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	GestionCursoDAO gCurso = new GestionCursoDAO();
	private JButton btnDlgAlumno;
	private JButton btnDlgCurso;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroMatriculaAdicionar frame = new RegistroMatriculaAdicionar();
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
	public RegistroMatriculaAdicionar() {
		setTitle("Registro Matricula Adicionar");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			text_Matricula = new JTextField();
			text_Matricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Matricula.setText(gMatricula.obtenerCodigoCo());
			text_Matricula.setEditable(false);
			text_Matricula.setColumns(10);
			text_Matricula.setBounds(153, 130, 140, 19);
			getContentPane().add(text_Matricula);
		}
		{
			text_Alumno = new JTextField();
			text_Alumno.setEditable(false);
			text_Alumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Alumno.setColumns(10);
			text_Alumno.setBounds(153, 164, 117, 19);
			getContentPane().add(text_Alumno);
		}
		{
			text_Curso = new JTextField();
			text_Curso.setEditable(false);
			text_Curso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Curso.setColumns(10);
			text_Curso.setBounds(432, 132, 117, 19);
			getContentPane().add(text_Curso);
		}
		{
			lblNewLabel = new JLabel("Cod. Curso");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(329, 130, 93, 15);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Cod. Alumno");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(50, 162, 93, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Num. Matricula");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(50, 128, 93, 15);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblAdicionarMatricula = new JLabel("Adicionar Matricula");
			lblAdicionarMatricula.setFont(new Font("Consolas", Font.BOLD, 15));
			lblAdicionarMatricula.setBounds(113, 61, 180, 26);
			getContentPane().add(lblAdicionarMatricula);
		}
		{
			lbl_Imagen = new JLabel("");
			lbl_Imagen.setIcon(new ImageIcon(RegistroMatriculaAdicionar.class.getResource("/imagenes/group_icon-icons.com_63767.png")));
			lbl_Imagen.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Imagen.setBounds(345, 44, 150, 58);
			getContentPane().add(lbl_Imagen);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(48, 217, 524, 311);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
		{
			btn_Adicionar = new JButton("Adicionar");
			btn_Adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtn_Adicionar(e);
				}
			});
			btn_Adicionar.setBounds(472, 164, 100, 21);
			getContentPane().add(btn_Adicionar);
		}
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Num. Matri");
		modelo.addColumn("Cod. Alum");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		table.setModel(modelo);
		
		btnDlgAlumno = new JButton("");
		btnDlgAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDlgAlumno(e);
			}
		});
		btnDlgAlumno.setIcon(new ImageIcon(RegistroMatriculaAdicionar.class.getResource("/imagenes/user (1).png")));
		btnDlgAlumno.setBounds(269, 160, 24, 26);
		getContentPane().add(btnDlgAlumno);
		
		btnDlgCurso = new JButton("");
		btnDlgCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDlgCurso(e);
			}
		});
		btnDlgCurso.setIcon(new ImageIcon(RegistroMatriculaAdicionar.class.getResource("/imagenes/open-book (1).png")));
		btnDlgCurso.setBounds(548, 130, 24, 23);
		getContentPane().add(btnDlgCurso);
		mostramosTabla();
	}
	
		//	Metodo Solo Numeros
	void SoloNumeros (KeyEvent e) {
		char caracter = e.getKeyChar();
		if (!(Character.isDigit(caracter))) {
			getToolkit();
			e.consume();
		}
	}
	
		//	Metodo para no exceder los digitos
	void BorrandoDigitos (KeyEvent e,int field) {
		switch (field) {
			case 1: 
				if(text_Alumno.getText().length() >= 9)
			        e.consume();
						break;
			case 2: 
				if(text_Curso.getText().length() >= 6)
			        e.consume();
						break;
		}
	}
	
		//	Metodo Leer String
	String LeerString(JTextField text) {
		return text.getText().trim().toString();
	}
	
		// Metodo Mostramos Tabla
	void mostramosTabla() {
		modelo.setRowCount(0);
		
		ArrayList<Matricula> matriculas = gMatricula.leer();
		
		for (Matricula m : matriculas) {
			Object fila[] = { m.getNumMatricula(), m.getCodAlumno(), m.getCodCurso(), m.getFecha(), m.getHora() };

			modelo.addRow(fila);
		}
	}
	
		//	Metodo Fecha
	String Fecha() {
		return LocalDate.now() + "";
	}
	
		//	Metodo Hora
	String Hora() {
		return LocalTime.now() + "";
	}	


	//	Btn Adicionar
	protected void actionPerformedBtn_Adicionar(ActionEvent e) {
		adicionarMatricula();
	}

	// Mostrar lista de alumnos registrados
	protected void actionPerformedBtnDlgCurso(ActionEvent e) {
		mostrarDlgCurso();
	}
	// Mostrar lista de cursos
	protected void actionPerformedBtnDlgAlumno(ActionEvent e) {
		mostrarDlgAlumno();
	}
	
	private void mostrarDlgAlumno() {
		DlgListarAlumnosRegistrados aRegistrados = new DlgListarAlumnosRegistrados();
		aRegistrados.setVisible(true);
		aRegistrados.setLocationRelativeTo(this);
	}

	private void mostrarDlgCurso() {
		DlgListarCursos aRegistrados = new DlgListarCursos();
		aRegistrados.setVisible(true);
		aRegistrados.setLocationRelativeTo(this);
	}
	
	private void adicionarMatricula() {
		String numM, codA, codC, fecha, hora;
		
		numM = text_Matricula.getText();
		codA = obtenerCodigoAlumno();
		codC = obtenerCodigoCurso();
		hora = Hora();
		fecha = Fecha();
		
		if (codA == null || codC == null) {
			System.out.println("No se matriculo");
			return;
		} else {
			
			Matricula m = new Matricula();
			
			m.setNumMatricula(numM);
			m.setCodAlumno(codA);
			m.setCodCurso(codC);
			m.setFecha(fecha);
			m.setHora(hora);

			int ok = gMatricula.registrar(m);
			
			if (ok == 0) {
				mensajeError("Error en la actualización ");
			} else {
				gAlumno.actualizarEstadoAlumno(1, codA);
				mensajeExitoso("Matricula exitosa");
				text_Matricula.setText(gMatricula.obtenerCodigoCo());
				mostramosTabla();
			}
		}
		
		
	}

	private String obtenerCodigoCurso() {
		String codCurso = null;
		Curso c = gCurso.listarCurso(text_Curso.getText());
		
		if (text_Curso.getText().length() == 0) {
			mensajeError("El campo del codigo del curso no debe estar vacio");
			text_Curso.requestFocus();
		} else if (c == null) {
			mensajeError("El curso no existe o introdujo mal el codigo. \nPor favor introduce un codigo con el siguiente formato: C1xxxx");
			text_Alumno.requestFocus();
		} else {
			codCurso = c.getCodCurso();
		} 
		
		return codCurso;
	}

	private String obtenerCodigoAlumno() {
		String codAlumno = null;
		Alumno a = gAlumno.listarAlumno(text_Alumno.getText());
		
		if (text_Alumno.getText().length() == 0) {
			mensajeError("El campo del codigo del alumno no debe estar vacio");
			text_Alumno.requestFocus();
		} else if (a == null) {
			mensajeError("No se encuentra al alumno o introdujo mal el codigo. \nPor favor introduce un codigo con el siguiente formato: A2xxxxxxx");
			text_Alumno.requestFocus();
		} else if (a.getEstado() == 1){
			mensajeError("El alumno ya esta matriculado");
			text_Alumno.requestFocus();
		} else if (a.getEstado() == 2) {
			mensajeError("El alumno esta retirado");
			text_Alumno.requestFocus();
		} else {
			codAlumno = a.getCodAlumno();
		} 
		
		return codAlumno;
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj);
		
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}
}
