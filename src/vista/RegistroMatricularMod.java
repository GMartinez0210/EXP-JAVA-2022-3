package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import arrays.ArrayAlumno;
import arrays.ArrayCurso;
import arrays.ArrayMatricula;
import entidad.Matricula;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroMatricularMod extends JInternalFrame {
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblAccion;
	private JRadioButton rdbtn_Modificar;
	private JRadioButton rdbtn_Consultar;
	private JRadioButton rdbtn_Eliminar;
	private DefaultTableModel modelo;
	ButtonGroup btnsGrupo = new ButtonGroup();
	private JLabel lblNewLabel;
	private JTextField text_Codigo;
	private JLabel lblNewLabel_1;
	private JTextField text_CodAlumno;
	private JLabel lblNewLabel_2;
	private JTextField text_CodCurso;
	private JLabel lblNewLabel_3;
	private JTextField text_Hora;
	private JTextField text_Fecha;
	private JLabel lblNewLabel_4;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnModificar;
	ArrayMatricula AM = new ArrayMatricula();
	ArrayAlumno AA = new ArrayAlumno();
	ArrayCurso AC = new ArrayCurso();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroMatricularMod frame = new RegistroMatricularMod();
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
	public RegistroMatricularMod() {
		setTitle("Registro Matricula Consultar, Modificar, Eliminar");
		setBounds(100, 100, 450, 300);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(47, 228, 530, 291);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			lblAccion = new JLabel("Accion");
			lblAccion.setFont(new Font("Consolas", Font.BOLD, 15));
			lblAccion.setBounds(67, 32, 83, 35);
			getContentPane().add(lblAccion);
		}
		{
			rdbtn_Modificar = new JRadioButton("Modificar");
			rdbtn_Modificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Modificar(e);
				}
			});
			btnsGrupo.add(rdbtn_Modificar);
			rdbtn_Modificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Modificar.setBounds(308, 33, 103, 21);
			getContentPane().add(rdbtn_Modificar);
		}
		{
			rdbtn_Consultar = new JRadioButton("Consultar");
			rdbtn_Consultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Consultar(e);
				}
			});
			btnsGrupo.add(rdbtn_Consultar);
			rdbtn_Consultar.setSelected(true);
			rdbtn_Consultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Consultar.setBounds(172, 33, 103, 21);
			getContentPane().add(rdbtn_Consultar);
		}
		{
			rdbtn_Eliminar = new JRadioButton("Eliminar");
			rdbtn_Eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Eliminar(e);
				}
			});
			btnsGrupo.add(rdbtn_Eliminar);
			rdbtn_Eliminar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Eliminar.setBounds(444, 32, 109, 23);
			getContentPane().add(rdbtn_Eliminar);
		}
		{
			lblNewLabel = new JLabel("Num. Matricula");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(47, 94, 123, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			text_Codigo = new JTextField();
			text_Codigo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Codigo(e);
				}
			});
			text_Codigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Codigo.setBounds(167, 91, 123, 20);
			getContentPane().add(text_Codigo);
			text_Codigo.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Cod. Alumno");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(47, 122, 103, 14);
			getContentPane().add(lblNewLabel_1);
		}
		{
			text_CodAlumno = new JTextField();
			text_CodAlumno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_CodAlumno(e);
				}
			});
			text_CodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_CodAlumno.setBounds(167, 119, 123, 20);
			getContentPane().add(text_CodAlumno);
			text_CodAlumno.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Cod Curso");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(47, 147, 103, 14);
			getContentPane().add(lblNewLabel_2);
		}
		{
			text_CodCurso = new JTextField();
			text_CodCurso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_CodCurso(e);
				}
			});
			text_CodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_CodCurso.setBounds(167, 144, 123, 20);
			getContentPane().add(text_CodCurso);
			text_CodCurso.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Hora:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(371, 94, 94, 14);
			getContentPane().add(lblNewLabel_3);
		}
		{
			text_Hora = new JTextField();
			text_Hora.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Hora.setBounds(454, 91, 123, 20);
			getContentPane().add(text_Hora);
			text_Hora.setColumns(10);
		}
		{
			text_Fecha = new JTextField();
			text_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Fecha.setBounds(454, 119, 123, 20);
			getContentPane().add(text_Fecha);
			text_Fecha.setColumns(10);
		}
		{
			lblNewLabel_4 = new JLabel("Fecha:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(371, 122, 94, 14);
			getContentPane().add(lblNewLabel_4);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnLimpiar(e);
				}
			});
			btnLimpiar.setBounds(429, 143, 89, 23);
			getContentPane().add(btnLimpiar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEliminar(e);
				}
			});
			btnEliminar.setBounds(444, 188, 89, 23);
			getContentPane().add(btnEliminar);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnConsultar(e);
				}
			});
			btnConsultar.setBounds(94, 188, 89, 23);
			getContentPane().add(btnConsultar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnModificar(e);
				}
			});
			btnModificar.setBounds(267, 188, 89, 23);
			getContentPane().add(btnModificar);
		}
		
			// Seteamos valoreas al tipo consultar
		text_Codigo.setEditable(true);
		text_CodAlumno.setEditable(false);
		text_CodCurso.setEditable(false);
		text_Fecha.setEditable(false);
		text_Hora.setEditable(false);
		btnConsultar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(false);
		
			// Hacemos el Default de la Tabla
		modelo = new DefaultTableModel();
		modelo.addColumn("Matricula");
		modelo.addColumn("Cod. Alumno");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Fecha Add");
		modelo.addColumn("Hora Add");
		table.setModel(modelo);
		MostramosTabla();
	}	
	
		//	Radious Button Consultar
	protected void actionPerformedRdbtn_Consultar(ActionEvent e) {
		text_Codigo.setEditable(true);
		text_CodAlumno.setEditable(false);
		text_CodCurso.setEditable(false);
		text_Fecha.setEditable(false);
		text_Hora.setEditable(false);
		btnConsultar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(false);
	}
	
		//	Radious Button Modificar
	protected void actionPerformedRdbtn_Modificar(ActionEvent e) {
		text_Codigo.setEditable(true);
		text_CodAlumno.setEditable(false);
		text_CodCurso.setEditable(true);
		text_Fecha.setEditable(false);
		text_Hora.setEditable(false);
		btnConsultar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(true);
	}
		
		//  Radious Button Eliminar
	protected void actionPerformedRdbtn_Eliminar(ActionEvent e) {
		text_Codigo.setEditable(true);
		text_CodAlumno.setEditable(false);
		text_CodCurso.setEditable(false);
		text_Fecha.setEditable(false);
		text_Hora.setEditable(false);
		btnConsultar.setEnabled(false);
		btnEliminar.setEnabled(true);
		btnModificar.setEnabled(false);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	//////////////// METODOS COMPLEMENTARIOS
	/////////////////////////////////////////////////////////////////////////////////
	
	// Mostrar tabla
	void MostramosTabla() {
		int rowCount = 0;
		for (int i  = 0; i < AM.tamanio(); i++) {
			int est = AA.buscarCod(AM.obtener(i).getCodAlumno()).getEstado();
			if (est != 2) {
				modelo.setRowCount(rowCount);
				Object [] fila = {
						AM.obtener(i).getNumMatricula(),
						AM.obtener(i).getCodAlumno(),
						AM.obtener(i).getCodCurso(),
						AM.obtener(i).getFecha(),
						AM.obtener(i).getHora(),
				};
				modelo.addRow(fila);
				rowCount++;
			}
		}
	}
	// Error
	void Error(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, x, "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
	// Preguntar 
	boolean Pregunta (String x) {
		int salida = JOptionPane.showConfirmDialog(this, x, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (salida == 1) {
			return false;
		} else {
			return true;
		}
	}
	// Metodo leer 
	String LeerCampo (JTextField x) {
		return x.getText().trim();
	}
	// Metodo Limpiar Campos
	void Limpiar() {
		text_Codigo.setText("");
		text_CodAlumno.setText("");
		text_CodCurso.setText("");
		text_Fecha.setText("");
		text_Hora.setText("");
	}
	// Metodo obtener alumno
	Matricula ObtenerMatricula() {
		for (int i = 0; i < AM.tamanio(); i++) {
			if (AM.obtener(i).getNumMatricula().equals(LeerCampo(text_Codigo))) {
				return AM.obtener(i);
			}
		}
		return null;
	}
	boolean ExisteCurso () {
		for (int i = 0; i < AC.tamanio(); i++) {
			if (AC.obtener(i).getCodCurso().equals(LeerCampo(text_CodCurso))) {
				return true;
			}
		}
		return false;
	}

	/////////////////////////////////////////////////////////////////////////////////
	//////////////// BOTONES
	/////////////////////////////////////////////////////////////////////////////////
	
	// Boton Limpiar
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		Limpiar();
	}
	
	// Boton Eliminar
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		String cod = LeerCampo(text_Codigo);
		Matricula m = ObtenerMatricula();
		if(cod.length() != 0) {
			if (m != null) {
				int estado = AA.buscarCod(m.getCodAlumno()).getEstado();
					if (estado != 2) {
						Boolean pg = Pregunta("¿Seguro que quieres CANCELAR matricula?");
						if (pg) {
							AM.eliminar(m);
							MostramosTabla();
							Limpiar();
						}						
						Error("Se cancelo Matricula", text_Codigo);
					} else {						
						Error("El alumno figura como RETIRADO, \nNo se puede Retirar denuevo", text_Codigo);
					}
			} else {				
				Error("El codigo no existe", text_Codigo);
			}
		} else {
			Error("El campo de la Matricula no puede estar vacio", text_Codigo);
		}
	}
	
	// Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		String cod = LeerCampo(text_Codigo);;
		Matricula m = ObtenerMatricula();
		if(cod.length() != 0) {
			if (m != null) {
				text_CodAlumno.setText(m.getCodAlumno());
				text_CodCurso.setText(m.getCodCurso());
				text_Fecha.setText(m.getFecha());
				text_Hora.setText(m.getHora());
			} else {				
				Error("El codigo no existe", text_Codigo);
			}
		} else {
			Error("El campo de la Matricula no puede estar vacio", text_Codigo);
		}
	}
	
	// Boton Modificar
	protected void actionPerformedBtnModificar(ActionEvent e) {
		String cod = LeerCampo(text_Codigo);
		Matricula m = ObtenerMatricula();
		if(cod.length() != 0) {
			if (m != null) {
				String codCurso = LeerCampo(text_CodCurso);
				if (codCurso.length() != 0) {
					if (ExisteCurso()) {
						m.setCodCurso(codCurso);
						AM.actualizarArchivo();
						MostramosTabla();
						Limpiar();
					} else {					
						Error("No existe curso", text_CodCurso);
					}
				} else {					
					Error("El campo Codigo curso no puede estar vacio", text_CodCurso);
				}
			} else {				
				Error("El codigo no existe", text_Codigo);
			}
		} else {
			Error("El campo de la Matricula no puede estar vacio", text_Codigo);
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
			case 1:
				if(text_Codigo.getText().length() >= 7)
					e.consume();
						break;
			case 2: 
				if(text_CodAlumno.getText().length() >= 9)
			        e.consume();
						break;
			case 3: 
				if(text_CodCurso.getText().length() >= 6)
			        e.consume();
						break;
		}
	}
	
		//	Validando Numero Matricula  	
	protected void keyTypedText_Codigo(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 1);
	}
	
		//	Validando Codigo de Alumno
	protected void keyTypedText_CodAlumno(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 2);
	}
	
		//	Validando Codigo de Curso
	protected void keyTypedText_CodCurso(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 3);
	}
}
