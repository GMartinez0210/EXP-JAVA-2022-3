package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import arrays.ArrayAlumno;
import arrays.ArrayCurso;
import arrays.ArrayMatricula;
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
	private JTextField text_Alumno;
	private JTextField text_Curso;
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
			text_Alumno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Alumno(e);
				}
			});
			text_Alumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Alumno.setColumns(10);
			text_Alumno.setBounds(153, 164, 140, 19);
			getContentPane().add(text_Alumno);
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
			text_Curso.setColumns(10);
			text_Curso.setBounds(432, 132, 140, 19);
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
			btn_Adicionar.setBounds(395, 164, 100, 21);
			getContentPane().add(btn_Adicionar);
		}
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Num. Matri");
		modelo.addColumn("Cod. Alum");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Estado");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		table.setModel(modelo);
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
	
	//	Validando Codigo Alumno
	protected void keyTypedText_Alumno(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 1);
	}
	
	//	Validando Codigo Curso
	protected void keyTypedText_Curso(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 2);
	}
	
		//	Metodo Leer String
	String LeerString(JTextField text) {
		return text.getText().trim().toString();
	}
	
		//	Metodo Error
	void Error(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No relleno el campo " + x, "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
	
		//	Metodo No Existe
	void NoExiste(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No existe el " + x, "ERROR", 0);
		text.requestFocus();
	}
	
		// Metodo Mostramos Tabla
	void mostramosTabla() {
		System.out.println("Mostramos tabla");

		modelo.setRowCount(0);
		
		ArrayList<Matricula> matriculas = gMatricula.leer();
		
		for (Matricula m : matriculas) {
			System.out.println(m);
			int cod = gAlumno.obtenerEstado(m.getCodAlumno());
			Object fila[] = { m.getNumMatricula(), m.getCodAlumno(), m.getCodCurso(), cod, m.getFecha(), m.getHora() };

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

	private void adicionarMatricula() {
		// TODO Auto-generated method stub
		//int idM;
		String numM, codA, codC, fecha, hora;
		// Obtener los datos de GUI
		numM = text_Matricula.getText();
		codA = text_Alumno.getText();
		codC = text_Curso.getText();
		hora = Hora();
		fecha = Fecha();
		// validar
		if (codA == null || codC == null) {
			return;
		} else {
			// crear un objeto de la clase "Usuario"
			Matricula m = new Matricula();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			m.setNumMatricula(numM);
			m.setCodAlumno(codA);
			m.setCodCurso(codC);
			m.setFecha(fecha);
			m.setHora(hora);

			// llamar al proceso actualizar
			int ok = gMatricula.registrar(m);
			// validar el resultado del proceso actualizar
			if (ok == 0) {
				mensajeError("Error en la actualización ");
			} else {
				mensajeExitoso("Usuario actualizado");
				text_Matricula.setText(gMatricula.obtenerCodigoCo());
				mostramosTabla();
			}
		}
		
		
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj);
		
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}
}
