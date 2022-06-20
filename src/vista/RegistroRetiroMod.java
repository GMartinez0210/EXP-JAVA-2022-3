package vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import entidad.Retiro;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionRetiroDAO;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;

public class RegistroRetiroMod extends JInternalFrame {
	private JTable table;
	private JScrollPane scrollPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	
	public static JTextField text_Retiro;
	public static JTextField text_Alumno;
	public static JTextField text_Matricula;
	public static JTextField text_Fecha;
	public static JTextField text_Hora;
	public static JTextField text_Curso;

	private JButton btn_Limpiar;
	private JButton btn_Consultar;
	private JButton btn_Eliminar;
	private JButton btn_Consultar_1;
	
	private JRadioButton rdbtn_Consultar;
	private JRadioButton rdbtn_Modificar;
	
		// Button Groups
	ButtonGroup group = new ButtonGroup();
	
		// GestionDAO
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	GestionRetiroDAO gRetiro = new GestionRetiroDAO();
	
	DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroRetiroMod frame = new RegistroRetiroMod();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroRetiroMod() {
		setTitle("Registro Matricula Consultar, Modificar, Eliminar");
		setBounds(100, 100, 450, 300);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		
		rdbtn_Consultar = new JRadioButton("Consultar");
		rdbtn_Consultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedRdbtn_Consultar(e);
			}
		});
		rdbtn_Consultar.setSelected(true);
		rdbtn_Consultar.setBounds(51, 38, 103, 21);
		getContentPane().add(rdbtn_Consultar);
		
		rdbtn_Modificar = new JRadioButton("Modificar");
		rdbtn_Modificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedRdbtn_Modificar(e);
			}
		});
		rdbtn_Modificar.setBounds(156, 38, 103, 21);
		getContentPane().add(rdbtn_Modificar);

		btn_Limpiar = new JButton("");
		btn_Limpiar.setBackground(new Color(255, 255, 255));
		btn_Limpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtn_Limpiar(e);
			}
		});
		btn_Limpiar.setIcon(new ImageIcon(RegistroRetiroMod.class.getResource("/imagenes/basura.png")));
		btn_Limpiar.setBounds(393, 31, 37, 41);
		getContentPane().add(btn_Limpiar);
		
		text_Retiro = new JTextField();
		text_Retiro.setDisabledTextColor(new Color(255, 255, 255));
		text_Retiro.setBackground(new Color(255, 255, 255));
		text_Retiro.setEditable(false);
		text_Retiro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedText_Retiro(e);
			}
		});
		text_Retiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text_Retiro.setBounds(109, 110, 75, 19);
		getContentPane().add(text_Retiro);
		text_Retiro.setColumns(10);
		
		lblNewLabel = new JLabel("N\u00B0 Retiro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 113, 69, 13);
		getContentPane().add(lblNewLabel);
		
		text_Alumno = new JTextField();
		text_Alumno.setDisabledTextColor(new Color(255, 255, 255));
		text_Alumno.setBackground(new Color(255, 255, 255));
		text_Alumno.setEditable(false);
		text_Alumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text_Alumno.setBounds(109, 187, 110, 19);
		getContentPane().add(text_Alumno);
		text_Alumno.setColumns(10);
		
		lblNewLabel_1 = new JLabel("N\u00B0 Matr\u00EDcula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 151, 75, 13);
		getContentPane().add(lblNewLabel_1);
		
		text_Matricula = new JTextField();
		text_Matricula.setDisabledTextColor(new Color(255, 255, 255));
		text_Matricula.setBackground(new Color(255, 255, 255));
		text_Matricula.setEditable(false);
		text_Matricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text_Matricula.setBounds(109, 148, 110, 19);
		getContentPane().add(text_Matricula);
		text_Matricula.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Cod. Alumno");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(30, 190, 75, 13);
		getContentPane().add(lblNewLabel_2);
		
		text_Fecha = new JTextField();
		text_Fecha.setDisabledTextColor(new Color(255, 255, 255));
		text_Fecha.setBackground(new Color(255, 255, 255));
		text_Fecha.setEditable(false);
		text_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text_Fecha.setBounds(334, 110, 96, 19);
		getContentPane().add(text_Fecha);
		text_Fecha.setColumns(10);
		
		text_Hora = new JTextField();
		text_Hora.setDisabledTextColor(new Color(255, 255, 255));
		text_Hora.setBackground(new Color(255, 255, 255));
		text_Hora.setEditable(false);
		text_Hora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text_Hora.setBounds(334, 148, 96, 19);
		getContentPane().add(text_Hora);
		text_Hora.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(261, 112, 60, 13);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Hora");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(261, 151, 60, 13);
		getContentPane().add(lblNewLabel_4);
		
		btn_Consultar = new JButton("Consultar");
		btn_Consultar.setBackground(new Color(255, 255, 255));
		btn_Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtn_Consultar(e);
			}
		});
		btn_Consultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Consultar.setBounds(480, 51, 96, 21);
		getContentPane().add(btn_Consultar);
		
		btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setBackground(new Color(255, 255, 255));
		btn_Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_1(e);
			}
		});
		btn_Eliminar.setBounds(480, 82, 96, 21);
		getContentPane().add(btn_Eliminar);
		
		text_Curso = new JTextField();
		text_Curso.setDisabledTextColor(new Color(255, 255, 255));
		text_Curso.setBackground(new Color(255, 255, 255));
		text_Curso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedText_Curso(e);
			}
		});
		text_Curso.setEditable(false);
		text_Curso.setBounds(334, 188, 96, 19);
		getContentPane().add(text_Curso);
		text_Curso.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Cod. Curso");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(261, 191, 112, 13);
		getContentPane().add(lblNewLabel_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 588, 260);
		getContentPane().add(scrollPane);
		
		group.add(rdbtn_Consultar);
		group.add(rdbtn_Modificar);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		
		scrollPane.setViewportView(table);
		
		btn_Consultar_1 = new JButton("...");
		btn_Consultar_1.setBackground(new Color(255, 255, 255));
		btn_Consultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtn_Consultar_1(e);
			}
		});
		btn_Consultar_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Consultar_1.setBounds(188, 109, 31, 21);
		getContentPane().add(btn_Consultar_1);
		
		// Mostramos el Default de la Tabla
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");
		
		table.setModel(model);
	}
	
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
				if (text_Retiro.getText().length() >= 7)
					e.consume();
						break;
			case 2: 
				if(text_Curso.getText().length() >= 6)
			        e.consume();
						break;
		}
	}
	
		//	Validar Retiro
	protected void keyTypedText_Retiro(KeyEvent e) {
		BorrandoDigitos(e, 1);
		NoEspeciales(e);
		
	}
		//	Validar Curso
	protected void keyTypedText_Curso(KeyEvent e) {
		BorrandoDigitos(e, 2);
		NoEspeciales(e);
	}
	
	//	Metodo Leer String
	String LeerString(JTextField text) {
		return text.getText().trim().toString();
	}

	//	Metodo Exito
	void Exito(String x) {
		JOptionPane.showMessageDialog(this, x, "James School", 1);
	}
	
	//	Metodo Error
	void Error(String x) {
		JOptionPane.showMessageDialog(this, x, "ERROR", 0);
	}
	
	void Error(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "El campo " + x + " no ha sido llenado", "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
	
	//	Metodo No Existe
	void NoExiste(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No existe el " + x , "ERROR", 0);
		text.requestFocus();
	}
	
	//	Método Limpiar
	void Limpiar() {
		text_Retiro.setText("");
		text_Matricula.setText("");
		text_Alumno.setText("");
		text_Curso.setText("");
		text_Fecha.setText("");
		text_Hora.setText("");
	}
	
	//	Método Mostrar Tabla
	void MostramosTabla() {
		model.setRowCount(0);
		Alumno alumno = gAlumno.listarAlumno(text_Alumno.getText());
		
		if (alumno == null) {
			JOptionPane.showMessageDialog(this, "No hay alumno", "ALERTA", 2);
			return;
		}
		
		Object row[] = {
				alumno.getCodAlumno(), 
				alumno.getNombres(), 
				alumno.getApellidos(), 
				alumno.getDni(), 
				alumno.getEdad(), 
				alumno.getCelular(), 
				alumno.getEstado()
			};
		model.addRow(row);
	}
	

	//Radious button Modificar
	protected void actionPerformedRdbtn_Modificar(ActionEvent e) {
		text_Retiro.setEditable(false);
		text_Curso.setEditable(true);
	}
	
	//Radious button Consultar
	protected void actionPerformedRdbtn_Consultar(ActionEvent e) {
		text_Retiro.setEditable(true);
		text_Curso.setEditable(false);
	}
	
	// Botón limpiar
	protected void actionPerformedBtn_Limpiar(ActionEvent e) {
		Limpiar();
	}
	
	//Boton Eliminar
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		String numRetiro = LeerString(text_Retiro);
		if(numRetiro.length() != 0) {
			Retiro retiro = gRetiro.leer(numRetiro);
			if(retiro != null){
				int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el Retiro?", "James School", JOptionPane.YES_NO_OPTION);
				
				if (confirmacion == 0) {
					int eliminar = gRetiro.eliminar(numRetiro);
					if (eliminar == 0) {
						Error("No se pudo eliminar");
						return;
					}
					
					Exito("Exitosa eliminación del Retiro; " + numRetiro);
				}
				
				MostramosTabla();
				Limpiar();
			}
			else {
				NoExiste("Número de Retiro", text_Retiro);
			}
		}
		else {
			Error("N° Retiro", text_Retiro);
		}
	}
	
	//Boton Consultar
	protected void actionPerformedBtn_Consultar(ActionEvent e) {
		if (rdbtn_Consultar.isSelected()) {
			MostramosTabla();
			
		}
		else if(rdbtn_Modificar.isSelected()) {
			String numRetiro = LeerString(text_Retiro);
			String codCurso = LeerString(text_Curso);
			if(codCurso.length() != 0) {
				int actualizar = gRetiro.actualizar(numRetiro, codCurso);
				
				if(actualizar == 0) {
					Error("No se pudo actualizar");
					return;
				}
				
				Exito("Se actualizó correctamente el retiro: " + numRetiro);
			}
		}
	
		MostramosTabla();
	}	
	
	// Buscat
	protected void actionPerformedBtn_Consultar_1(ActionEvent e) {
		DlgRetiro retiro = new DlgRetiro();
		retiro.setVisible(true);
	}
}
