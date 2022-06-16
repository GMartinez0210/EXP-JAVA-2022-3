package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import arrays.ArrayAlumno;
import arrays.ArrayCurso;
import arrays.ArrayMatricula;
import entidad.Curso;
import mantenimiento.GestionCursoDAO;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;

public class MantCursoMod extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonGroup grupo = new ButtonGroup();
	private JLabel lblAccin;
	private JLabel lblNewLabel;
	private JTextField text_Codigo;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTextField text_Asignatura;
	private JTextField text_Horas;
	private JTextField text_Creditos;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox<?> CBO_Ciclo;
	private JRadioButton rdbtn_Consultar;
	private JRadioButton rdbtn_Modificar;
	private JButton btn_Eliminar;
	private JButton btn_Procesar;
	private DefaultTableModel modelo;
	private JTable table;

	GestionCursoDAO gCurso = new GestionCursoDAO();	
		//	Array Globoterráqueo
	ArrayCurso AC = new ArrayCurso();
	ArrayAlumno AA = new ArrayAlumno();
	ArrayMatricula AM = new ArrayMatricula();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantCursoMod frame = new MantCursoMod();
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
	public MantCursoMod() {
		setTitle("Mantenimiento Curso Consultar, Modificar, Eliminar");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblAccin = new JLabel("Accion:");
			lblAccin.setFont(new Font("Consolas", Font.BOLD, 15));
			lblAccin.setBounds(73, 53, 85, 26);
			getContentPane().add(lblAccin);
		}
		{
			lblNewLabel = new JLabel("Codigo\r\n");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(52, 133, 69, 15);
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
			text_Codigo.setColumns(10);
			text_Codigo.setBounds(131, 134, 140, 19);
			getContentPane().add(text_Codigo);
		}
		{
			lblNewLabel_1 = new JLabel("Asignatura");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(342, 161, 69, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(52, 275, 524, 251);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
		{
			text_Asignatura = new JTextField();
			text_Asignatura.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Asignatura(e);
				}
			});
			text_Asignatura.setEditable(false);
			text_Asignatura.setColumns(10);
			text_Asignatura.setBounds(434, 161, 140, 19);
			getContentPane().add(text_Asignatura);
		}
		{
			text_Horas = new JTextField();
			text_Horas.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Horas(e);
				}
			});
			text_Horas.setEditable(false);
			text_Horas.setColumns(10);
			text_Horas.setBounds(131, 163, 140, 19);
			getContentPane().add(text_Horas);
		}
		{
			text_Creditos = new JTextField();
			text_Creditos.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Creditos(e);
				}
			});
			text_Creditos.setEditable(false);
			text_Creditos.setColumns(10);
			text_Creditos.setBounds(434, 191, 140, 19);
			getContentPane().add(text_Creditos);
		}
		{
			lblNewLabel_2 = new JLabel("Creditos");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(342, 194, 69, 15);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Horas");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(52, 164, 69, 15);
			getContentPane().add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Ciclo");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(52, 195, 69, 15);
			getContentPane().add(lblNewLabel_4);
		}
		{
			CBO_Ciclo = new JComboBox();
			CBO_Ciclo.setEnabled(false);
			CBO_Ciclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			CBO_Ciclo.setModel(new DefaultComboBoxModel(new String[] {"-Select Item-", "1", "2", "3", "4", "5", "6"}));
			CBO_Ciclo.setBounds(131, 193, 140, 19);
			getContentPane().add(CBO_Ciclo);
		}
		{
			rdbtn_Consultar = new JRadioButton("Consultar");
			rdbtn_Consultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Consultar(e);
					
				}
			});
			rdbtn_Consultar.setSelected(true);
			rdbtn_Consultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Consultar.setBounds(164, 55, 103, 21);
			getContentPane().add(rdbtn_Consultar);
		}
		{
			rdbtn_Modificar = new JRadioButton("Modificar ");
			rdbtn_Modificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedRdbtn_Modificar(e);
				}
			});
			rdbtn_Modificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtn_Modificar.setBounds(300, 55, 103, 21);
			getContentPane().add(rdbtn_Modificar);
		}
		{
			btn_Eliminar = new JButton("Eliminar");
			btn_Eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				eliminarDatos();
				leerDatos();
				}
			});
			btn_Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btn_Eliminar.setBounds(452, 54, 85, 21);
			getContentPane().add(btn_Eliminar);
		}
		{
			btn_Procesar = new JButton("Consultar");
			btn_Procesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn_ProcesarActionPerformed(e);
				}
			});
			btn_Procesar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btn_Procesar.setBounds(452, 104, 90, 21);
			getContentPane().add(btn_Procesar);
		}
		
		
		grupo.add(rdbtn_Consultar);
		grupo.add(rdbtn_Modificar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codgio");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Creditos");
		modelo.addColumn("Horas");
		table.setModel(modelo);
		leerDatos();
	}
	void consultar() {
		String codCurso;
		codCurso = LeerString(text_Codigo);
        modelo.setRowCount(0);
        if(codCurso == null) {
            return;
        }else {
            	Curso curso = gCurso.listarCurso(codCurso);
            	text_Codigo.setText(curso.getCodCurso());
            	text_Horas.setText(""+ curso.getHoras());
            	CBO_Ciclo.setSelectedIndex(curso.getCiclo());
            	text_Asignatura.setText(curso.getAsignatura());
            	text_Creditos.setText(""+ curso.getCreditos());
            	
//            	modelo.setRowCount(0);
//            	Object[] row = {
//    					curso.getCodCurso(),
//    					curso.getAsignatura(),
//    					curso.getCiclo(),
//    					curso.getCreditos(),
//    					curso.getHoras(),
//    			};
//    			modelo.addRow(row);  	
        }
		
	}
	void actualizarDatos() {
		String codCurso, asignatura;
		int ciclo,creditos, horas ;
		// entradas
		codCurso = getCodigo();
		asignatura = getAsignatura();
		ciclo = getCiclo();
		creditos = getCreditos();
		horas = getHoras();
		
		// validar
		if(codCurso == null||  asignatura == null || ciclo == 0 || creditos == 0|| horas ==0 ) {
			return;
        } else {
        	// procesos
        	Curso c = new Curso();
			c.setCodCurso(codCurso);
			c.setAsignaturas(asignatura);
			c.setCiclo(ciclo);
			c.setCreditos(creditos);
			c.setHoras(horas);
			
        	
        	// Llamar al metodo a registar
        	int ok = gCurso.actualizar(c);
        	
        	if (ok == 0) {
        		mensajeError("Error en la actualización");
        	}
        	else {
        		mensajeExitoso("Usuario Actualizado");
        	}
        }
	}
	
	void eliminarDatos() {
		String codCurso;
		codCurso = getCodigo();
		
		if (codCurso == null) {
			mensajeError("Error ");
        } 
		else {
			// confirmación
        	int confirmacion = JOptionPane.showConfirmDialog(null, "¿Eliminar Usuario?", "Sistema", JOptionPane.YES_NO_OPTION);
        	
        	if (confirmacion == 0) {
        		// procesos
            	Curso c = new Curso();
            	
            	c.setCodCurso(codCurso);        	
            	
            	// Llamar al metodo a registar
            	int ok = gCurso.eliminar(c);
            	
            	if (ok == 0) {
            		mensajeError("Error en la eliminacion");
            	}
            	else {
            		mensajeExitoso("Usuario eliminado");
            	}
        	}
        	else {
        		mensajeExitoso("Cancelación exitosa");
        	}
        	
        }
	}

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
	
	private String getAsignatura() {
		String asignatura = null;
		try {
			asignatura = text_Asignatura.getText(); 
			if(asignatura == null) mensajeError("Selecciona un ciclo");
			
		}catch (Exception e) {
			mensajeError("No ha seleccionado ningun ciclo");
		}
    	return asignatura;
	}

	int getCiclo() {
		int ciclo = 0;
		try {
			ciclo = CBO_Ciclo.getSelectedIndex(); 
			if(ciclo == 0) mensajeError("Selecciona un ciclo");
			
		}catch (Exception e) {
			mensajeError("No ha seleccionado ningun ciclo");
		}
    	return ciclo;
	}
	
	int getCreditos() {

    	int creditos = 0;

		try {
			creditos = Integer.parseInt(text_Creditos.getText()); 
			if(creditos == 0) mensajeError("Selecciona un ciclo");
			
		}catch (Exception e) {
			mensajeError("No ha seleccionado ningun ciclo");
		}

    	return creditos;
    
	}
	
	int getHoras() {
    	int horas = 0;
		try {
			horas = Integer.parseInt(text_Horas.getText()); 
			if(horas == 0) mensajeError("Selecciona un ciclo");
			
		}catch (Exception e) {
			mensajeError("No ha seleccionado ningun ciclo");
		}

    	return horas;
    
	}
	
	void leerDatos() {
		modelo.setRowCount(0);
		
		for ( Curso curso : gCurso.leer()) {
			Object[] row = {
					curso.getCodCurso(),
					curso.getAsignatura(),
					curso.getCiclo(),
					curso.getCreditos(),
					curso.getHoras(),
			};
			modelo.addRow(row);
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
				if(text_Codigo.getText().length() >= 6)
			        e.consume();
						break;
			case 3: 
				if(text_Creditos.getText().length() >= 2)
			        e.consume();
						break;
			case 4: 
				if(text_Horas.getText().length() >= 1)
			        e.consume();
						break;
		}
	}

	
		// Validando Codigo
	protected void keyTypedText_Codigo(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 1);
	}
	
		//	Validando Horas
	protected void keyTypedText_Horas(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 4);
	}
	
		//	Validando Asignatura
	protected void keyTypedText_Asignatura(KeyEvent e) {
		SoloLetras(e);
	}
	
		//	Validando Creditos
	protected void keyTypedText_Creditos(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 3);
	}
	
		//	Metodo Leer
	String LeerString(JTextField text) {
		return text.getText().trim().toString();
	}
	
	int LeerEntero(JTextField text) {
		return Integer.parseInt(text.getText().trim().toString());
	}
	
		// Metodo Error
	void Error(String x, JTextField text) {
		JOptionPane.showInternalMessageDialog(this, "No relleno el campo \"" + x + "\"", "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
	
		//	Metodo NoExiste
	void NoExiste(String x) {
		JOptionPane.showMessageDialog(this, "El " + x +" no existe", "ERROR", 0);
	}
	
		//	Editable
	void TextEditable(JTextField text) {
		text.setEditable(true);
	}
	
		//	NoEditable
	void TextNoEditable(JTextField text) {
		text.setEditable(false);
	}
		//	Rdbtn Consultar
	protected void actionPerformedRdbtn_Consultar(ActionEvent e) {
		btn_Procesar.setText("Consultar");
		TextEditable(text_Codigo);
		TextNoEditable(text_Asignatura);
		CBO_Ciclo.setEnabled(false);
		TextNoEditable(text_Creditos);
		TextNoEditable(text_Horas);
	}
	
		//	Rdbtn Modificar
	protected void actionPerformedRdbtn_Modificar(ActionEvent e) {
		btn_Procesar.setText("Modificar");
		TextNoEditable(text_Codigo);
		TextEditable(text_Asignatura);
		CBO_Ciclo.setEnabled(true);
		TextEditable(text_Creditos);
		TextEditable(text_Horas);
	}
	
		//	Limpiar
	void Limpiar() {
		text_Codigo.setText("" + AC.codigoCorrelativo());
		text_Asignatura.setText("");
		CBO_Ciclo.setSelectedIndex(0);
		text_Creditos.setText("");
		text_Horas.setText("");
	}

	private void mensajeExitoso(String msj) {
		 JOptionPane.showMessageDialog(this, msj, "Registro bien", 1);
		
	}
	private void mensajeError(String msj) {
		  JOptionPane.showMessageDialog(this, msj, "Error", 0);
		// TODO Auto-generated method stub
		
	}
	
//btn consultar
	protected void btn_ProcesarActionPerformed(ActionEvent e) {
		if(rdbtn_Modificar.isSelected()) {
					actualizarDatos();
		} else {
			consultar();
		}
		leerDatos();
	}
}
