package vista;

import java.awt.EventQueue;

import arrays.ArrayCurso;
import entidad.Curso;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class MantCursoAdicionar extends JInternalFrame {
	private JLabel lblAdicionarCurso;
	private JLabel lblNewLabel_1;
	private JTextField text_Codigo;
	private JLabel lblNewLabel_7;
	private JScrollPane scrollPane;
	private JButton btn_Adicionar;
	private JLabel lbl_Imagen;
	private JTextField text_Asignatura;
	private JTextField text_Horas;
	private JTextField text_Creditos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox CBO_Ciclo;
	private JTable table;
	private DefaultTableModel modelo;

		//	Array Gobloterr�queo
	ArrayCurso AC = new ArrayCurso();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantCursoAdicionar frame = new MantCursoAdicionar();
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
	public MantCursoAdicionar() {
		setTitle("Mantenimiento Curso Adicionar");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblAdicionarCurso = new JLabel("Adicionar Curso");
			lblAdicionarCurso.setFont(new Font("Consolas", Font.BOLD, 15));
			lblAdicionarCurso.setBounds(111, 42, 150, 26);
			getContentPane().add(lblAdicionarCurso);
		}
		{
			lblNewLabel_1 = new JLabel("Codigo\r\n");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(46, 111, 69, 15);
			getContentPane().add(lblNewLabel_1);
		}
		{
			text_Codigo = new JTextField();
			text_Codigo.setEditable(false);
			text_Codigo.setColumns(10);
			text_Codigo.setBounds(125, 112, 140, 19);
			getContentPane().add(text_Codigo);
				
				//	Agregamos el codigo correlativo por deault
			text_Codigo.setText("" + AC.codigoCorrelativo());

		}
		{
			lblNewLabel_7 = new JLabel("Asignatura");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_7.setBounds(46, 142, 69, 15);
			getContentPane().add(lblNewLabel_7);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(46, 282, 524, 241);
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
			btn_Adicionar.setBounds(247, 227, 100, 21);
			getContentPane().add(btn_Adicionar);
		}
		{
			lbl_Imagen = new JLabel("");
			lbl_Imagen.setIcon(new ImageIcon(MantCursoAdicionar.class.getResource("/imagenes/1492531743-icon-sets-school-outline-hand-drawn-iconfinder02_83203 (1).png")));
			lbl_Imagen.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Imagen.setBounds(379, 25, 150, 87);
			getContentPane().add(lbl_Imagen);
		}
		{
			text_Asignatura = new JTextField();
			text_Asignatura.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Asignatura(e);
				}
			});
			text_Asignatura.setColumns(10);
			text_Asignatura.setBounds(125, 141, 140, 19);
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
			text_Horas.setColumns(10);
			text_Horas.setBounds(428, 169, 140, 19);
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
			text_Creditos.setColumns(10);
			text_Creditos.setBounds(428, 138, 140, 19);
			getContentPane().add(text_Creditos);
		}
		{
			lblNewLabel = new JLabel("Creditos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(336, 141, 69, 15);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_2 = new JLabel("Horas");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(336, 170, 69, 15);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Ciclo");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(46, 173, 69, 15);
			getContentPane().add(lblNewLabel_3);
		}
		{
			CBO_Ciclo = new JComboBox();
			CBO_Ciclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			CBO_Ciclo.setModel(new DefaultComboBoxModel(new String[] {"-Selecionar-", "1", "2", "3", "4", "5", "6"}));
			CBO_Ciclo.setBounds(125, 171, 140, 19);
			getContentPane().add(CBO_Ciclo);
		}
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codgio");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Creditos");
		modelo.addColumn("Horas");
		table.setModel(modelo);
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
	
		//	Validando Asignatura
	protected void keyTypedText_Asignatura(KeyEvent e) {
		SoloLetras(e);
	}
	
		//	Validando Creditos
	protected void keyTypedText_Creditos(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 3);
	}
	
		//	Validando Horas
	protected void keyTypedText_Horas(KeyEvent e) {
		SoloNumeros(e);
		BorrandoDigitos(e, 4);
	}
	
		// Metodos de Lectura
	String LeerString(JTextField text) {
		return text.getText().toString();
	}
	
	int LeerEntero(JTextField text) {
		return Integer.parseInt(text.getText());
	}
	
	
		//	Metodo Error
	void Error (String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No relleno el campo: " + x, "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
		
		//	Metodo Mal
	void Mal(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, "No relleno CORRECTAMENTE el campo: " + x, "ALERTA", 1);
		text.requestFocus();
	}
	
		//	Metodo Limpiar
	void Limpiar() {
		text_Codigo.setText("" + AC.codigoCorrelativo());
		text_Asignatura.setText("");
		CBO_Ciclo.setSelectedIndex(0);
		text_Creditos.setText("");
		text_Horas.setText("");
	}
	
	
		//	Mostrar Tabla
	void MostramosTabla() {
		modelo.setRowCount(0);
		for (int i = 0; i < AC.tamanio(); i++) {
			Object [] fila = {
					AC.obtener(i).getCodCurso(),
					AC.obtener(i).getAsignatura(),
					AC.obtener(i).getCiclo(),
					AC.obtener(i).getCreditos(),
					AC.obtener(i).getHoras()
			};
			modelo.addRow(fila);
		}
	}
	
		//	Metodo Adicionamos Curso
	void AdicionamosCurso(String Asignatura, int Ciclo, int Creditos, int Horas) {
		Curso nuevo = new Curso(AC.codigoCorrelativo(), Asignatura, Ciclo, Creditos, Horas);
		AC.adicionar(nuevo);
		MostramosTabla();
		Limpiar();
	}
	
		//	Metodo Leer Datos Completos
	void LeerDatosCompletos() {
		String Asignatura = LeerString(text_Asignatura);
		if (Asignatura.length() != 0) {
			try {
				int Ciclo = Integer.parseInt(CBO_Ciclo.getSelectedItem().toString());
				if (Ciclo >= 1 && Ciclo <= 6){
					try {
						int Creditos = LeerEntero(text_Creditos);
						if (Creditos > 0) {
							try {
								int Horas = LeerEntero(text_Horas);
								if (Horas >= 1 && Horas <= 5) {
									AdicionamosCurso(Asignatura, Ciclo, Creditos, Horas);
								}
								else {
									Mal("HORAS", text_Horas);
								}
							}
							catch (Exception e1) {
								Error("HORAS", text_Horas);
							}
						}
						else {
							Mal("CREDITO", text_Creditos);
						}
					}
					catch (Exception e1) {
						Error("CREDITO", text_Creditos);
					}
				}
				else {
					Mal("CICLO", null);
					CBO_Ciclo.requestFocus();
				}
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "No ha seleccionado el CICLO", "ERROR", 0);
				CBO_Ciclo.setSelectedIndex(0);
			}
		}
		else {
			Error("ASIGNATURA", text_Asignatura);
		}
	}
	
		//	Metodo Procesar
	void ProcesarAdicionar() {
		LeerDatosCompletos();
	}
	
		// Btn Adicionar
	protected void actionPerformedBtn_Adicionar(ActionEvent e) {
		ProcesarAdicionar();
	}
}