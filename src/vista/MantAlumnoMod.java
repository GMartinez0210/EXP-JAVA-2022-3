package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import mantenimiento.GestionAlumnoDAO;

import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MantAlumnoMod extends JInternalFrame{
	
	DefaultTableModel modelo = new DefaultTableModel();
	GestionAlumnoDAO gAlum = new GestionAlumnoDAO();
	ButtonGroup grupo = new ButtonGroup();
	
	private JLabel lblNewLabel;
	private JRadioButton rdbtn_Consultar;
	private JRadioButton rdbtn_Modificar;
	private JButton btn_Eliminar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JTextField text_Codigo;
	private JTextField text_DNI;
	private JTable table;
	private JLabel lbl_Nombre;
	private JLabel lbl_Apellido;
	private JLabel lbl_Edad;
	private JLabel lbl_Celular;
	private JTextField text_Nombre;
	private JTextField text_Apellido;
	private JTextField text_Edad;
	private JTextField text_Celular;
	private JButton btn_Procesar;
	private JScrollPane scrollPane;
	private JTextField text_Estado;
	private JLabel lbl_Estado;

		//	Variables globoterráqueo
		/*	Waiting	*/

		//	Clase globoterráquea
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantAlumnoMod frame = new MantAlumnoMod();
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
	public MantAlumnoMod() {
		setTitle("Mantenimiento Alumno Consultar, Modificar y Eliminar");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Accion:");
			lblNewLabel.setBounds(40, 31, 72, 19);
			lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 15));
			getContentPane().add(lblNewLabel);
		}
		{
			rdbtn_Consultar = new JRadioButton("Consultar");
			rdbtn_Consultar.setSelected(true);
			rdbtn_Consultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Consultar(e);
				}
			});
			rdbtn_Consultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Consultar.setBounds(120, 29, 103, 21);
			getContentPane().add(rdbtn_Consultar);
		}
		{
			rdbtn_Modificar = new JRadioButton("Modificar");
			rdbtn_Modificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Modificar(e);
				}
			});
			rdbtn_Modificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Modificar.setBounds(256, 29, 103, 21);
			getContentPane().add(rdbtn_Modificar);
		}
		grupo.add(rdbtn_Consultar);
		grupo.add(rdbtn_Modificar);
		{
			btn_Eliminar = new JButton("Eliminar");
			btn_Eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtn_Eliminar(e);
				}
			});
			btn_Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btn_Eliminar.setBounds(382, 28, 85, 21);
			getContentPane().add(btn_Eliminar);
		}
		{
			lblNewLabel_1 = new JLabel("Codigo\r\n");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(40, 88, 69, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_4 = new JLabel("DNI");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(41, 126, 69, 15);
			getContentPane().add(lblNewLabel_4);
		}
		{
			text_Codigo = new JTextField();
			text_Codigo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Codigo(e);
				}
			});
			text_Codigo.setColumns(10);
			text_Codigo.setBounds(119, 88, 140, 19);
			getContentPane().add(text_Codigo);
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
			text_DNI.setBounds(119, 125, 140, 19);
			getContentPane().add(text_DNI);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 164, 534, 364);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
				// Mostramos el Default de la Tabla
				modelo.addColumn("Código Alumno");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("DNI");
				modelo.addColumn("Edad");
				modelo.addColumn("Celular");
				modelo.addColumn("Estado");
				table.setModel(modelo);
				MostramosTabla();
			}
		}
		{
			lbl_Nombre = new JLabel("Nombre");
			lbl_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbl_Nombre.setBounds(40, 165, 69, 15);
			lbl_Nombre.setVisible(false);
			getContentPane().add(lbl_Nombre);
		}
		{
			lbl_Apellido = new JLabel("Apellido");
			lbl_Apellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbl_Apellido.setBounds(354, 129, 69, 15);
			lbl_Apellido.setVisible(false);
			getContentPane().add(lbl_Apellido);
		}
		{
			lbl_Edad = new JLabel("Edad");
			lbl_Edad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbl_Edad.setBounds(354, 168, 69, 15);
			lbl_Edad.setVisible(false);
			getContentPane().add(lbl_Edad);
		}
		{
			lbl_Celular = new JLabel("Celular");
			lbl_Celular.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbl_Celular.setBounds(40, 205, 69, 15);
			lbl_Celular.setVisible(false);
			getContentPane().add(lbl_Celular);
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
			text_Nombre.setBounds(119, 166, 140, 19);
			text_Nombre.setVisible(false);
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
			text_Apellido.setBounds(433, 127, 140, 19);
			text_Apellido.setVisible(false);
			getContentPane().add(text_Apellido);
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
			text_Edad.setBounds(433, 166, 140, 19);
			text_Edad.setVisible(false);
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
			text_Celular.setBounds(119, 206, 140, 19);
			text_Celular.setVisible(false);
			getContentPane().add(text_Celular);
		}
		{
			btn_Procesar = new JButton("Consultar");
			btn_Procesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtn_Procesar(e);
				}
			});
			btn_Procesar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btn_Procesar.setBounds(489, 28, 95, 21);
			getContentPane().add(btn_Procesar);
		}
		
		{
			text_Estado = new JTextField();
			text_Estado.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Estado(e);
				}
			});
			text_Estado.setBounds(433, 204, 140, 19);
			text_Estado.setVisible(false);
			getContentPane().add(text_Estado);
			text_Estado.setColumns(10);
		}
		{
			lbl_Estado = new JLabel("Estado");
			lbl_Estado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbl_Estado.setVisible(false);
			lbl_Estado.setBounds(353, 207, 69, 15);
			getContentPane().add(lbl_Estado);
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
	
	//	Metodo Solo Numeros
	void SoloLetras (KeyEvent e) {
		char caracter = e.getKeyChar();
		if (!(Character.isLetter(caracter) || caracter == e.VK_SPACE)) {
			getToolkit();
			e.consume();
		}
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
				if (text_Codigo.getText().length() >= 9)
					e.consume();
						break;
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
	
	//	Validando Codigo
	protected void keyTypedText_Codigo(KeyEvent e) {
		BorrandoDigitos(e, 1);
	}
	
	//	Validar DNI
	protected void keyTypedText_DNI(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 3);
	}
	
	//	Validando Nombre
	protected void keyTypedText_Nombre(KeyEvent e) {
		SoloLetras(e);
	}
	
	//	Validando Celular
	protected void keyTypedText_Celular(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 4);
	}
	
	// 	Validando Apellido
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
	
	//	Metodos Ocultar Campos
	void OcultarCampos() {
		text_Codigo.setEditable(true);
		text_Nombre.setVisible(false); lbl_Nombre.setVisible(false);
		text_Apellido.setVisible(false); lbl_Apellido.setVisible(false);
		text_Edad.setVisible(false); lbl_Edad.setVisible(false);
		text_Estado.setVisible(false); lbl_Estado.setVisible(false);
	}
	
	//	Metodo Mostrar Campos
	void MostrarCampos() {
		text_Codigo.setEditable(false);
		text_Nombre.setVisible(true); lbl_Nombre.setVisible(true);
		text_Apellido.setVisible(true); lbl_Apellido.setVisible(true);
		text_Edad.setVisible(true); lbl_Edad.setVisible(true);
		text_Estado.setVisible(true); lbl_Estado.setVisible(true);
	}
	
	// No Editables
	void NoEditables () {
		text_Codigo.setEditable(false);
		text_Nombre.setEditable(false);
		text_Apellido.setEditable(false);
		text_DNI.setEditable(false);
		text_Edad.setEditable(false);
		text_Celular.setEditable(false);
		text_Estado.setEditable(false);
	}
	
	// No Editables
	void Editables () {
		text_Codigo.setEditable(true);
		text_Nombre.setEditable(true);
		text_Apellido.setEditable(true);
		text_DNI.setEditable(true);
		text_Edad.setEditable(true);
		text_Celular.setEditable(true);
		text_Estado.setEditable(true);
	}
	
	// Solo Consulta
	void SoloConsulta() {
		scrollPane.setBounds(40, 248, 534, 280);
		MostrarCampos();
		NoEditables();
	}
	
	//	Rdbtn Consultar
	protected void actionPerformedRdbtn_Consultar(ActionEvent e) {
		btn_Procesar.setText("Consultar");
		scrollPane.setBounds(40, 164, 534, 364);
		OcultarCampos();
	}
	
	//	Rdbtn Modificar
	protected void actionPerformedRdbtn_Modificar(ActionEvent e) {
		btn_Procesar.setText("Modificar");
		scrollPane.setBounds(40, 248, 534, 280);
		Editables();
		text_Codigo.setEditable(false);
		MostrarCampos();
	}
	
	//	Metodos Leer
	String LeerString(JTextField text) {
		return text.getText().trim().toString();
	}
	int LeerEntero(JTextField text) {
		return Integer.parseInt(text.getText().trim().toString());
	}
	
		
	//	Metodo Error
	void Error(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No rellenaste el campo: " + x, "ERROR", 0);
		text.setText(x);
		text.requestFocus();
	}
	
	// Metodo No Existe
	void NoExiste(String x) {
		JOptionPane.showMessageDialog(this, "No existe el " + x + " ingresado", "ERROR", 0);
	}
	
	// Metodo Mal Ingreso
	void MalIngreso(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "Ingresaste mal el " + x, "ERROR", 0);
		text.requestFocus();
	}
	
	//	Metodo No se Puede
	void NoPuede() {
		JOptionPane.showMessageDialog(this, "No se puede procesar su accion", "ERROR", 0);
	}
	
	
	
	//	Metodo Limpiar
	void Limpiar() {
		text_Codigo.setText("");
		text_Nombre.setText("");
		text_Apellido.setText("");
		text_DNI.setText("");
		text_Edad.setText("");
		text_Celular.setText("");
		text_Estado.setText("");
	}
	
	//	Metodo Mostramos Tabla
	void MostramosTabla() {
		modelo.setRowCount(0);
		ArrayList<Alumno> data = gAlum.listar();
		for (Alumno a : data) {
			Object fila[] = {a.getCodAlumno(), a.getNombres(), 
					a.getApellidos(), a.getDni(), a.getEdad(), a.getCelular(), a.getEstado()};
			modelo.addRow(fila);
		}
	}
	
	// Metodo Modificamos
	void Modificar() {
		String codAlumno, nombres, apellidos, dni;
		int edad, celular, estado;
		
		// entradas
		codAlumno = LeerString(text_Codigo);
		nombres = LeerString(text_Nombre);
		apellidos = LeerString(text_Apellido);
		dni = LeerString(text_DNI);
		edad = LeerEntero(text_Edad);
		estado = LeerEntero(text_Estado);
		
		// validar
		if(codAlumno == null || nombres == null || apellidos == null || dni == null || edad == 0 || estado == -1) {
			return;
        } else {
        	// procesos
        	Alumno a = new Alumno();
        	a.setCodAlumno(codAlumno);
			a.setNombres(nombres);
			a.setApellidos(apellidos);
			a.setDni(dni);
			a.setEdad(edad);
			a.setEstado(estado);
        	
        	// Llamar al metodo a registar
        	int ok = gAlum.actualizar(a);
        	
        	if (ok == 0) {
        		mensajeError("Error en la actualización");
        	}
        	else {
        		mensajeExitoso("Usuario Actualizado");
        	}
        }
	}
	
	//	Metodo Consultar
	void Consultar() {
		String codAlumno, dni;
        codAlumno = LeerString(text_Codigo);
        dni = LeerString(text_DNI);
        modelo.setRowCount(0);
        if(codAlumno.length() == 0 && dni.length() == 0) {
        	return;
        }else if(codAlumno.length() == 0) {
        	 Alumno alumno = gAlum.listarAlumnoDni(dni);
             text_Codigo.setText(alumno.getCodAlumno());
             text_Nombre.setText(""+ alumno.getNombres());
             text_Apellido.setText(""+ alumno.getApellidos());
             text_DNI.setText(""+ alumno.getDni());
             text_Edad.setText(""+ alumno.getEdad());
             text_Estado.setText(""+ alumno.getEstado());
        }else {
        	Alumno alumno = gAlum.listarAlumno(codAlumno);
            text_Codigo.setText(alumno.getCodAlumno());
            text_Nombre.setText(""+ alumno.getNombres());
            text_Apellido.setText(""+ alumno.getApellidos());
            text_DNI.setText(""+ alumno.getDni());
            text_Edad.setText(""+ alumno.getEdad());
            text_Estado.setText(""+ alumno.getEstado());
        }
	}

	// 	Btn Procesar
	protected void actionPerformedBtn_Procesar(ActionEvent e) {
		if (rdbtn_Consultar.isSelected()) {
			Consultar();
		}
		else {
			Modificar();
		}
		MostramosTabla();
	}
	
	// Obtiene Código
	String getCodigo() {
    	String cod = null;
    	if (text_Codigo.getText().trim().length() == 0) {
    		mensajeError("Ingrese el codigo");
    	}
    	else {
    		try {
    			cod = text_Codigo.getText();
    		}
    		catch (Exception e) {
    			mensajeError("Ingrese un código numérico");
    		}
    	}
    	return cod;
    
	}
	
	// Btn Eliminar
	protected void actionPerformedBtn_Eliminar(ActionEvent e) {
			String codAlumno;
			codAlumno = getCodigo();
		
			if (codAlumno == null) {
				mensajeError("Error");
			}else {
				// confirmación
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Eliminar Usuario?", "Sistema", JOptionPane.YES_NO_OPTION);
				if (confirmacion == 0) {
					Alumno a = new Alumno();
            	
					a.setCodAlumno(codAlumno);        	

					int ok = gAlum.eliminar(a);
            	
					if (ok == 0) {
						mensajeError("Error en la eliminacion");
					}else {
						mensajeExitoso("Usuario eliminado");
					}
				}else {
					mensajeExitoso("Cancelación exitosa");
				}
        	
			}
	}
	
	private void mensajeExitoso(String msj) {
		 JOptionPane.showMessageDialog(this, msj, "Registro bien", 1);
	}
	private void mensajeError(String msj) {
		  JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}
}
