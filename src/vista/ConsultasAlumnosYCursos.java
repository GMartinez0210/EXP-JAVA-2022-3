package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arrays.ArrayAlumno;
import arrays.ArrayCurso;
import entidad.Alumno;
import entidad.Curso;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultasAlumnosYCursos extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField text_Curso;
	private JTextField text_Alumno;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTable table_Alumno;
	private JTable table_Curso;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btn_Consultar;
	private DefaultTableModel modelo_Alumno;
	private DefaultTableModel modelo_Curso;

		//	Arrays Globoterráqueos
	ArrayAlumno AA = new ArrayAlumno();
	ArrayCurso AC = new ArrayCurso();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultasAlumnosYCursos frame = new ConsultasAlumnosYCursos();
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
	public ConsultasAlumnosYCursos() {
		setTitle("Consulta Alumnos y Cursos");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Cod. Curso");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(61, 120, 90, 15);
			getContentPane().add(lblNewLabel);
		}
		{
			text_Curso = new JTextField();
			text_Curso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Curso(e);
				}
			});
			text_Curso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Curso.setBounds(179, 116, 130, 19);
			getContentPane().add(text_Curso);
			text_Curso.setColumns(10);
		}
		{
			text_Alumno = new JTextField();
			text_Alumno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Alumno(e);
				}
			});
			text_Alumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Alumno.setBounds(179, 87, 130, 19);
			getContentPane().add(text_Alumno);
			text_Alumno.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Cod. Alumno");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(61, 91, 90, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Consultar");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(135, 33, 79, 15);
			getContentPane().add(lblNewLabel_2);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 179, 563, 150);
			getContentPane().add(scrollPane);
			{
				table_Alumno = new JTable();
				scrollPane.setViewportView(table_Alumno);
				table_Alumno.setFillsViewportHeight(true);
			}
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(31, 370, 563, 150);
			getContentPane().add(scrollPane_1);
			{
				table_Curso = new JTable();
				scrollPane_1.setViewportView(table_Curso);
				table_Curso.setFillsViewportHeight(true);
			}
		}
		{
			btn_Consultar = new JButton("Consultar");
			btn_Consultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btn_Consultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton(e);
				}
			});
			btn_Consultar.setBounds(392, 118, 85, 21);
			getContentPane().add(btn_Consultar);
		}
		
			//	Tabla Alumno
		modelo_Alumno = new DefaultTableModel();
		modelo_Alumno.addColumn("Cod. Alum");
		modelo_Alumno.addColumn("Nombre");
		modelo_Alumno.addColumn("Apellido");
		modelo_Alumno.addColumn("DNI");
		modelo_Alumno.addColumn("Edad");
		modelo_Alumno.addColumn("Celular");
		modelo_Alumno.addColumn("Estado");
		table_Alumno.setModel(modelo_Alumno);
	
			//	Tabla Curso
		modelo_Curso = new DefaultTableModel();
		modelo_Curso.addColumn("Cod. Curso");
		modelo_Curso.addColumn("Asigntura");
		modelo_Curso.addColumn("Ciclo");
		modelo_Curso.addColumn("Creditos");
		modelo_Curso.addColumn("Horas");
		table_Curso.setModel(modelo_Curso);
	}
	
		//	Metodo Solo Numeros
	void SoloNumeros (KeyEvent e) {
		char caracter = e.getKeyChar();
		if (!(Character.isDigit(caracter))) {
			getToolkit();
			e.consume();
		}
	}
	
		//	Metodo Solo Letras
	void SoloLetras (KeyEvent e) {
		char caracter = e.getKeyChar();
		if (!(Character.isLetter(caracter) || caracter == e.VK_SPACE)) {
			getToolkit();
			e.consume();
		}
	}
		//	No caracteres especiales
	void NoEspeciales (KeyEvent e) {
		char caracter = e.getKeyChar();
		if (!(Character.isLetter(caracter) || Character.isDigit(caracter))) {
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
	
		//	Validando Alumno
	protected void keyTypedText_Alumno(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 1);
	}
	
		//	Validando Curso
	protected void keyTypedText_Curso(KeyEvent e) { 
		NoEspeciales(e);
		BorrandoDigitos(e, 2);
	}
	
		// Metado Leer String
	String LeerString(JTextField text) {
		return text.getText().trim().toString();
	}
	
		//	Metodo Error
	void Error(String x) {
		JOptionPane.showMessageDialog(this, "No relleno el campo " + x, "ERROR", 0);
	}
	
		//	Metodo No Existe
	void NoExiste(String x) {
		JOptionPane.showMessageDialog(this, "No existe el " + x, "ERROR", 0);
	
	}
	
		//	Metodo Mostramos Tabla Alumno
	void MostramosTablaAlumno(Alumno alumno) {
		modelo_Alumno.setRowCount(0);
			Object [] fila = {
					alumno.getCodAlumno(),
					alumno.getNombres(),
					alumno.getApellidos(),
					alumno.getDni(),
					alumno.getEdad(),
					alumno.getCelular(),
					alumno.getEstado(),
			};
			modelo_Alumno.addRow(fila);
	}
	
		//	Metodo Mostramos Tabla Curso
	void MostramosTablaCurso(Curso curso) {
		modelo_Curso.setRowCount(0);
			Object [] fila = {
					curso.getCodCurso(),
					curso.getAsignatura(),
					curso.getCiclo(),
					curso.getCreditos(),
					curso.getHoras()
			};
			modelo_Curso.addRow(fila);
	}
	
		//	Metodo Limpiamos Tablas
	void LimpiamosTablas() {
		modelo_Alumno.setRowCount(0);

		modelo_Curso.setRowCount(0);
	}
	
		//	Btn Consultar
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		LimpiamosTablas();
		String Alumno = LeerString(text_Alumno);
		if (Alumno.length() != 0) {
			Alumno alumno = AA.buscarCod(Alumno);
			if (alumno != null) {
				MostramosTablaAlumno(alumno);
			}
			else {
				NoExiste("ALUMNO");
			}
		}
		String Curso = LeerString(text_Curso);
		if (Curso.length() != 0) {
			Curso curso = AC.buscar(Curso);
			if (curso != null) {
				MostramosTablaCurso(curso);
			}
			else {
				NoExiste("CURSO");
			}
		}
		if (Alumno.length() == 0 && Curso.length() == 0) {
			JOptionPane.showMessageDialog(this, "No ha rellenado ningun campo");
		}
	}
}
