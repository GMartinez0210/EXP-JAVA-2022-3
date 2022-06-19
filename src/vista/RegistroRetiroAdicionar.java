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
import arrays.ArrayRetiro;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import entidad.Retiro;
import mantenimiento.GestionMatriculaDAO;
import mantenimiento.GestionRetiroDAO;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegistroRetiroAdicionar extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblAdicionarMatricula;
	private JLabel lbl_Imagen;
	private JLabel lblCodAlum;
	private JLabel lblNewLabel_7;
	
	public static JTextField text_Retiro;
	public static JTextField text_Matricula;
	public static JTextField text_Alumno;
	public static JTextField text_Nombre;
	public static JTextField text_Curso;
	public static JTextField text_Estado;
	public static JTextField text_Hora;
	public static JTextField text_Fecha;
	
	private JScrollPane scrollPane;
	private JTable table;

	private JButton btn_Procesar;
	private JButton btn_Matricula;

	private JRadioButton rdbtn_Consultar;
	private JRadioButton rdbtn_Adicionar;

	DefaultTableModel model = new DefaultTableModel();
	
		// Button Group
	ButtonGroup grupo = new ButtonGroup();

		// GestionDAO
	GestionMatriculaDAO gMatricula = new GestionMatriculaDAO();
	GestionRetiroDAO gRetiro = new GestionRetiroDAO();
	
		//	Arrays Globoterraqueos
	ArrayMatricula AM = new ArrayMatricula();
	ArrayAlumno AA = new ArrayAlumno();
	ArrayCurso AC = new ArrayCurso();
	ArrayRetiro AR = new ArrayRetiro();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroRetiroAdicionar frame = new RegistroRetiroAdicionar();
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
	public RegistroRetiroAdicionar() {
		setTitle("Refistro Retiro Adicionar");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			text_Nombre = new JTextField();
			text_Nombre.setDisabledTextColor(new Color(255, 255, 255));
			text_Nombre.setBackground(new Color(255, 255, 255));
			text_Nombre.setEditable(false);
			text_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Nombre.setColumns(10);
			text_Nombre.setBounds(432, 188, 140, 19);
			getContentPane().add(text_Nombre);
		}
		{
			text_Hora = new JTextField();
			text_Hora.setDisabledTextColor(new Color(255, 255, 255));
			text_Hora.setBackground(new Color(255, 255, 255));
			text_Hora.setEditable(false);
			text_Hora.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Hora.setColumns(10);
			text_Hora.setBounds(432, 149, 140, 19);
			getContentPane().add(text_Hora);
		}
		{
			text_Fecha = new JTextField();
			text_Fecha.setDisabledTextColor(new Color(255, 255, 255));
			text_Fecha.setBackground(new Color(255, 255, 255));
			text_Fecha.setEditable(false);
			text_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Fecha.setColumns(10);
			text_Fecha.setBounds(432, 112, 140, 19);
			getContentPane().add(text_Fecha);
		}
		{
			text_Matricula = new JTextField();
			text_Matricula.setDisabledTextColor(new Color(255, 255, 255));
			text_Matricula.setBackground(new Color(255, 255, 255));
			text_Matricula.setEditable(false);
			text_Matricula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Matricula(e);
				}
			});
			text_Matricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Matricula.setColumns(10);
			text_Matricula.setBounds(153, 149, 85, 19);
			getContentPane().add(text_Matricula);
		}
		{
			text_Curso = new JTextField();
			text_Curso.setDisabledTextColor(new Color(255, 255, 255));
			text_Curso.setBackground(new Color(255, 255, 255));
			text_Curso.setEditable(false);
			text_Curso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Curso.setColumns(10);
			text_Curso.setBounds(153, 225, 140, 19);
			getContentPane().add(text_Curso);
		}
		{
			lblNewLabel = new JLabel("Cod. Curso");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(50, 227, 93, 15);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Num. Retiro");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(50, 114, 93, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Num. Matricula");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(50, 151, 93, 15);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Fecha");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(365, 113, 69, 15);
			getContentPane().add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Hora");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(365, 151, 69, 15);
			getContentPane().add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Nombre");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(365, 190, 69, 15);
			getContentPane().add(lblNewLabel_5);
		}
		{
			lblAdicionarMatricula = new JLabel("Adicionar Retiro");
			lblAdicionarMatricula.setFont(new Font("Consolas", Font.BOLD, 15));
			lblAdicionarMatricula.setBounds(115, 40, 180, 26);
			getContentPane().add(lblAdicionarMatricula);
		}
		{
			lbl_Imagen = new JLabel("");
			lbl_Imagen.setIcon(new ImageIcon(RegistroRetiroAdicionar.class.getResource("/imagenes/door_icon_126434 (1).png")));
			lbl_Imagen.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Imagen.setBounds(347, 23, 150, 58);
			getContentPane().add(lbl_Imagen);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 315, 577, 213);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
		{
			btn_Procesar = new JButton("Procesar");
			btn_Procesar.setBackground(new Color(255, 255, 255));
			btn_Procesar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btn_Procesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtn_Adicionar(e);
				}
			});
			btn_Procesar.setBounds(365, 275, 100, 21);
			getContentPane().add(btn_Procesar);
		}
		{
			text_Retiro = new JTextField();
			text_Retiro.setDisabledTextColor(new Color(255, 255, 255));
			text_Retiro.setBackground(new Color(255, 255, 255));
			text_Retiro.setEditable(false);
			text_Retiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Retiro.setColumns(10);
			text_Retiro.setBounds(153, 113, 140, 19);
			getContentPane().add(text_Retiro);
			text_Retiro.setText(AR.codigoCorrelativo());
		}
		{
			text_Estado = new JTextField();
			text_Estado.setDisabledTextColor(new Color(255, 255, 255));
			text_Estado.setBackground(new Color(255, 255, 255));
			text_Estado.setEditable(false);
			text_Estado.setBounds(432, 225, 140, 19);
			getContentPane().add(text_Estado);
			text_Estado.setColumns(10);
		}
		{
			text_Alumno = new JTextField();
			text_Alumno.setDisabledTextColor(new Color(255, 255, 255));
			text_Alumno.setBackground(new Color(255, 255, 255));
			text_Alumno.setEditable(false);
			text_Alumno.setColumns(10);
			text_Alumno.setBounds(153, 189, 140, 19);
			getContentPane().add(text_Alumno);
		}
		{
			lblCodAlum = new JLabel("Cod. Alum");
			lblCodAlum.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCodAlum.setBounds(50, 192, 93, 15);
			getContentPane().add(lblCodAlum);
		}
		{
			lblNewLabel_7 = new JLabel("Estado");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_7.setBounds(365, 227, 69, 15);
			getContentPane().add(lblNewLabel_7);
		}
		{
			rdbtn_Consultar = new JRadioButton("Consultar");
			rdbtn_Consultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Consultar(e);
				}
			});
			rdbtn_Consultar.setSelected(true);
			rdbtn_Consultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rdbtn_Consultar.setBounds(66, 275, 103, 21);
			getContentPane().add(rdbtn_Consultar);
		}
		{
			rdbtn_Adicionar = new JRadioButton("Adicionar");
			rdbtn_Adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Adicionar(e);
				}
			});
			rdbtn_Adicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rdbtn_Adicionar.setBounds(190, 275, 103, 21);
			getContentPane().add(rdbtn_Adicionar);
		}
		
			//	Grupo de Rdbtn 
		grupo.add(rdbtn_Adicionar);
		grupo.add(rdbtn_Consultar);
		
			//	Mostramos la tabla
		model = new DefaultTableModel();
		model.addColumn("Num. Retiro");
		model.addColumn("Num. Matricula");
		model.addColumn("Cod. Alumno");
		model.addColumn("Cod. Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		table.setModel(model);
		{
			btn_Matricula = new JButton("...");
			btn_Matricula.setBackground(new Color(255, 255, 255));
			btn_Matricula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtn_Matricula(e);
				}
			});
			btn_Matricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btn_Matricula.setBounds(248, 147, 45, 23);
			getContentPane().add(btn_Matricula);
		}
		MostramosTabla();
	}
	
		//	Metodo Leer String
	String LeerString(JTextField text) {
		String string = text.getText().trim().toString();
		if(string.length() == 0) return string = null;
		return string;
	}
	
		//	Metodo Leer Entero
	int LeerEntero(JTextField text) {
		return Integer.parseInt(text.getText().trim().toString());
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
		JOptionPane.showMessageDialog(this, "No relleno el campo " + x, "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
	
		//	Metodo No Existe
	void NoExiste(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No existe el " + x, "ERROR", 0);
		text.requestFocus();
	}
	
		//	Metodo No Se Puede
	void NoPuede() {
		JOptionPane.showMessageDialog(this, "No se puede procesar su accion", "ERROR", 0);
	}
	
		// Metodo Mostramos Tabla
	void MostramosTabla() {
		model.setRowCount(0);
		
		ArrayList<Retiro> retiros = gRetiro.leer();
		for (Retiro retiro : retiros) {
			Object [] row = {
					retiro.getNumRetiro(),
					retiro.getNumMatricula(),
					retiro.getCodAlumno(),
					retiro.getCodCurso(),
					retiro.getFecha(),
					retiro.getHora()
			};
			model.addRow(row);
		}
	}

	
		//	Metodo Fecha
	String Fecha() {
		return LocalDate.now() + "";
	}
	
		//	Metodo Hora
	String Hora() {
		return LocalTime.now().getHour() +":"+ LocalTime.now().getMinute() + ":"+ LocalTime.now().getSecond();
	}
	
		//	Rdbtn Consultar
	protected void actionPerformedRdbtn_Consultar(ActionEvent e) {
		btn_Procesar.setText("Consultar");
	}
	
		// Rdbtn Adicionar
	protected void actionPerformedRdbtn_Adicionar(ActionEvent e) {
		btn_Procesar.setText("Adicionar");
	}
	
		//	Metodo Limpiar
	void Limpiar() {
		text_Retiro.setText(gRetiro.generarCodigo());
		text_Matricula.setText("");
		text_Alumno.setText("");
		text_Curso.setText("");
		text_Nombre.setText("");
		text_Fecha.setText(Fecha());
		text_Hora.setText(Hora());
		text_Estado.setText("");
	}
	
		//	Metodo Adicionamos Retiro
	void AdicionamosRetiro(String Matricula) {
		AA.buscarCod(AM.buscar(Matricula).getCodAlumno()).setEstado(2);
		AA.actulizarArchivos();
		Retiro nuevo = new Retiro(AR.codigoCorrelativo(), Matricula, Fecha(), Hora());
		AR.adicionar(nuevo);
		MostramosTabla();
		Limpiar();
	}
	
		//	Metodo Retiro
	void Retiro(String Matricula) {
		if (Matricula.length() != 0) {
			if (AM.buscar(Matricula) != null) {
				if (AA.buscarCod(AM.buscar(Matricula).getCodAlumno()).getEstado() != 2) {
					AdicionamosRetiro(Matricula);
				}
				else {
					NoPuede();
				}
			}
			else {
				NoExiste("MATRICULA", text_Matricula);
			}
		}
		else {
			Error("MATRICULA", text_Matricula);
		}
	}
	
		//	Btn Procesar
	protected void actionPerformedBtn_Adicionar(ActionEvent e) {
		if (rdbtn_Consultar.isSelected()) {
			String numMatricula = LeerString(text_Matricula);
			if(numMatricula.length() == 0) {
				Error("MATRICULA", text_Matricula);
				return;
			}
			
			Matricula matricula = gMatricula.leer(numMatricula);
			if (matricula == null) {
				Error("ERROR EN EL RETIRO");
				return;
			}
			
			text_Matricula.setText(matricula.getNumMatricula());
			text_Alumno.setText(matricula.getCodAlumno());
			text_Curso.setText(matricula.getCodCurso());
			text_Fecha.setText(matricula.getFecha());
			text_Hora.setText(matricula.getHora());
			text_Estado.setText("" + matricula.getEstado());
			text_Nombre.setText(matricula.getNombre());
		}
		else {
			String numRetiro = LeerString(text_Retiro);
			String numMatricula = LeerString(text_Matricula);
			String fecha = Fecha();
			String hora = Hora();
			
			if (numRetiro == null 
				|| numMatricula == null
				|| fecha == null
				|| hora == null) {
				return;
			}
			
			Retiro retiro = new Retiro();
			retiro.setNumRetiro(numRetiro);
			retiro.setNumMatricula(numMatricula);
			retiro.setFecha(fecha);
			retiro.setHora(hora);
			int addicionar = gRetiro.registrar(retiro);
			
			if (addicionar == 0) {
				Error("NO SE PUDO ADICIONAR");
				return;
			}
			
			Exito("REGISTRO EXITOSO");
		}
		
		MostramosTabla();
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
				if(text_Matricula.getText().length() >= 7)
			        e.consume();
						break;
		}
	}
	
		//	
	protected void keyTypedText_Matricula(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 1);
	}
	
	// Button Matricula
	protected void actionPerformedBtn_Matricula(ActionEvent e) {
		DlgMatricula matricula = new DlgMatricula();
		matricula.setVisible(true);
	}
}
