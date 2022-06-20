package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import mantenimiento.GestionAlumnoDAO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MantAlumnoAdicionar extends JInternalFrame {
	
	GestionAlumnoDAO gAlum = new GestionAlumnoDAO();
	DefaultTableModel modelo = new DefaultTableModel();
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField text_Codigo;
	private JTextField text_Nombre;
	private JTextField text_Apellido;
	private JTextField text_DNI;
	private JTextField text_Edad;
	private JTextField text_Celular;
	private JButton btn_Adicionar;
	private JLabel lblNewLabel_8;
	private JTextField text_Estado;
	
	// 	Variables globoterráqueos
	/*	None	*/
	
	//	Arreglo terráqueo
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	//	Clase terráquea
	/*	Waiting	*/
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantAlumnoAdicionar frame = new MantAlumnoAdicionar();
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
	public MantAlumnoAdicionar() {
		setTitle("Mantenimiento Alumno Adicionar");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Adicionar Alumno");
			lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 15));
			lblNewLabel.setBounds(107, 40, 150, 26);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Codigo\r\n");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(44, 107, 69, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Nombre");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(44, 141, 69, 15);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Apellido");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(359, 142, 69, 15);
			getContentPane().add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("DNI");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(44, 180, 69, 15);
			getContentPane().add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Edad");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(359, 181, 69, 15);
			getContentPane().add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Celular");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(44, 217, 69, 15);
			getContentPane().add(lblNewLabel_6);
		}
		{
			text_Codigo = new JTextField();
			text_Codigo.setEditable(false);
			text_Codigo.setText(gAlum.leerCodigoAlumno());
			text_Codigo.setBounds(123, 108, 140, 19);
			getContentPane().add(text_Codigo);
			text_Codigo.setColumns(10);
		}		
		{
			text_Nombre = new JTextField();
			text_Nombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Nombre(e);
				}
			});
			text_Nombre.setColumns(10);
			text_Nombre.setBounds(123, 142, 140, 19);
			getContentPane().add(text_Nombre);
		}
		{
			text_Apellido = new JTextField();
			text_Apellido.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Apellido(e);
				}
			});
			text_Apellido.setColumns(10);
			text_Apellido.setBounds(426, 143, 140, 19);
			getContentPane().add(text_Apellido);
		}
		{
			text_DNI = new JTextField();
			text_DNI.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_DNI(e);
				}
			});
			text_DNI.setColumns(10);
			text_DNI.setBounds(123, 181, 140, 19);
			getContentPane().add(text_DNI);
		}
		{
			text_Edad = new JTextField();
			text_Edad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Edad(e);
				}
			});
			text_Edad.setColumns(10);
			text_Edad.setBounds(426, 182, 140, 19);
			getContentPane().add(text_Edad);
		}
		{
			text_Celular = new JTextField();
			text_Celular.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Celular(e);
				}
			});
			text_Celular.setColumns(10);
			text_Celular.setBounds(123, 218, 140, 19);
			getContentPane().add(text_Celular);
		}
		{
			btn_Adicionar = new JButton("Adicionar");
			btn_Adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtn_Adicionar(e);
				}
			});
			btn_Adicionar.setBounds(255, 267, 100, 21);
			getContentPane().add(btn_Adicionar);
		}
		{
			lblNewLabel_8 = new JLabel("Estado");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_8.setBounds(359, 219, 69, 15);
			getContentPane().add(lblNewLabel_8);
		}
		{
			text_Estado = new JTextField();
			text_Estado.setEditable(false);
			text_Estado.setText("0");
			text_Estado.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Estado(e);
				}
			});
			text_Estado.setColumns(10);
			text_Estado.setBounds(426, 216, 140, 19);
			getContentPane().add(text_Estado);
		}
		{
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon(MantAlumnoAdicionar.class.getResource("/imagenes/132womanstudent2_100407.png")));
			lblNewLabel_9.setBounds(380, 22, 48, 82);
			getContentPane().add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("");
			lblNewLabel_10.setIcon(new ImageIcon(MantAlumnoAdicionar.class.getResource("/imagenes/130manstudent2_100617.png")));
			lblNewLabel_10.setBounds(465, 22, 48, 82);
			getContentPane().add(lblNewLabel_10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 300, 600, 251);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setFillsViewportHeight(true);
			scrollPane.setViewportView(table);
		}
		modelo.addColumn("Código Alumno");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		
		cargarDataUsuarios();
	}
	
	void registrarSac(){
		String codAlumno, nombres, apellidos, dni;
		int edad, celular, estado;
		
		codAlumno = gAlum.leerCodigoAlumno();
		nombres = LeerString(text_Nombre);
		apellidos = LeerString(text_Apellido);
		dni = LeerString(text_DNI);
		edad = LeerEntero(text_Edad);
		celular = LeerEntero(text_Celular);
		estado = 0;
		
		if(codAlumno == null || nombres == null || apellidos == null || dni == null || edad == 0 || celular == 0 || estado == -1) {
			return;
		} else {
			Alumno a = new Alumno();
			a.setCodAlumno(codAlumno);
			a.setNombres(nombres);
			a.setApellidos(apellidos);
			a.setDni(dni);
			a.setEdad(edad);
			a.setCelular(celular);
			a.setEstado(estado);
			
			int res = gAlum.registrar(a);
			
			if(res == 0) {
				mensajeError("Error en el registro de la SAC");
				text_Nombre.requestFocus();
			} 
			else {
				Limpiar();
				cargarDataUsuarios();
				mensajeExitoso("Registro exitoso");
			}
		}
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
			case 3: 
				if(text_DNI.getText().length() >= 8)
			        e.consume();
						break;
			case 4: 
				if(text_Celular.getText().length() >= 9)
			        e.consume();
						break;
			case 7: 
				if(text_Edad.getText().length() >= 2)
			        e.consume();
						break;
			case 8: 
				if(text_Estado.getText().length() >= 1)
			        e.consume();
						break;
		}
	}
	
	//	Validando Nombre
	protected void keyTypedText_Nombre(KeyEvent e) {
		SoloLetras(e);
	}
	
	// Validando DNI
	protected void keyTypedText_DNI(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 3);
	}
	
	//	Validando Celular
	protected void keyTypedText_Celular(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 4);
	}
	
	//	Validando Apellido
	protected void keyTypedText_Apellido(KeyEvent e) {
		SoloLetras(e);
	}
	
	//	Validando Edad
	protected void keyTypedText_Edad(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 7);
	}

	//	Validando Estado
	protected void keyTypedText_Estado(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 8);
	}
	
	//	Metodos Leer
	String LeerString(JTextField text) {
		return text.getText().trim();
	}
	
	int LeerEntero(JTextField text) {
		return Integer.parseInt(text.getText().trim());
	}
	
	// Metodo Limpiar
	void Limpiar() {
		text_Codigo.setText(gAlum.leerCodigoAlumno());
		text_Nombre.setText("");
		text_Apellido.setText("");
		text_DNI.setText("");
		text_Edad.setText("");
		text_Celular.setText("");
	}
	
	// Metodo Mostramos el Alumno en la Tabla
	public void cargarDataUsuarios() {
		modelo.setRowCount(0);
		ArrayList<Alumno> data = gAlum.listar();
		for (Alumno a : data) {
			Object fila[] = {a.getCodAlumno(), a.getNombres(), 
					a.getApellidos(), a.getDni(), a.getEdad(), a.getCelular(), a.getEstado()};
			modelo.addRow(fila);
		}
	}
	
	//	Btn Adicionar
	protected void actionPerformedBtn_Adicionar(ActionEvent e) {
		registrarSac();
	}
	
	private void mensajeExitoso(String msj) {
		 JOptionPane.showMessageDialog(this, msj, "Correcto", 1);
	}
	
	private void mensajeError(String msj) {
		  JOptionPane.showMessageDialog(this, msj, "Error", 0);		
	}
}
