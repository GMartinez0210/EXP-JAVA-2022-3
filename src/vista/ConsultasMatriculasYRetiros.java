package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arrays.ArrayAlumno;
import arrays.ArrayCurso;
import arrays.ArrayMatricula;
import arrays.ArrayRetiro;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import entidad.Retiro;

import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultasMatriculasYRetiros extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField text_Matricula;
	private JLabel lblNewLabel_2;
	private JTextField text_Retiro;
	private JButton btnConsultarMatricula;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_4;
	private JTable tabla_Alm;
	private JTable tabla_Cur;
	private DefaultTableModel modelo_Alumno;
	private DefaultTableModel modelo_Curso;
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
					ConsultasMatriculasYRetiros frame = new ConsultasMatriculasYRetiros();
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
	public ConsultasMatriculasYRetiros() {
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setTitle("Consulta Matricula y Retiro");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Consultar Matricula y Retiro");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel.setBounds(212, 11, 231, 28);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Numero Matricula:");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(33, 60, 146, 20);
			getContentPane().add(lblNewLabel_1);
		}
		{
			text_Matricula = new JTextField();
			text_Matricula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Matricula(e);
				}
			});
			text_Matricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			text_Matricula.setBounds(159, 62, 125, 20);
			getContentPane().add(text_Matricula);
			text_Matricula.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Numero Retiro:");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(33, 91, 131, 14);
			getContentPane().add(lblNewLabel_2);
		}
		{
			text_Retiro = new JTextField();
			text_Retiro.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Retiro(e);
				}
			});
			text_Retiro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			text_Retiro.setBounds(159, 90, 125, 20);
			getContentPane().add(text_Retiro);
			text_Retiro.setColumns(10);
		}
		{
			btnConsultarMatricula = new JButton("Consultar Matricula");
			btnConsultarMatricula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnConsultarMatricula(e);
				}
			});
			btnConsultarMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnConsultarMatricula.setBounds(400, 61, 153, 21);
			getContentPane().add(btnConsultarMatricula);
		}
		{
			btnNewButton = new JButton("Consultar Retiro");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton(e);
				}
			});
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnNewButton.setBounds(400, 89, 153, 23);
			getContentPane().add(btnNewButton);
		}
		{
			lblNewLabel_3 = new JLabel("Datos Alumno:");
			lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblNewLabel_3.setBounds(33, 128, 131, 14);
			getContentPane().add(lblNewLabel_3);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 153, 519, 160);
			getContentPane().add(scrollPane);
			{
				tabla_Alm = new JTable();
				tabla_Alm.setFillsViewportHeight(true);
				scrollPane.setViewportView(tabla_Alm);
			}
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(33, 349, 519, 160);
			getContentPane().add(scrollPane_1);
			{
				tabla_Cur = new JTable();
				tabla_Cur.setFillsViewportHeight(true);
				scrollPane_1.setViewportView(tabla_Cur);
			}
		}
		{
			lblNewLabel_4 = new JLabel("Datos Curso:");
			lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblNewLabel_4.setBounds(33, 324, 131, 14);
			getContentPane().add(lblNewLabel_4);
		}
		// Mostrar en la tabla a los alumnos matriculados
		modelo_Alumno = new DefaultTableModel();
		modelo_Alumno.addColumn("Cod. Alum");
		modelo_Alumno.addColumn("Nombre");
		modelo_Alumno.addColumn("Apellido");
		modelo_Alumno.addColumn("DNI");
		modelo_Alumno.addColumn("Edad");
		modelo_Alumno.addColumn("Celular");
		modelo_Alumno.addColumn("Estado");
		tabla_Alm.setModel(modelo_Alumno);
		
		
		// Mostrar en la tabla los cursos
		modelo_Curso = new DefaultTableModel();
		modelo_Curso.addColumn("Cod. Curso");
		modelo_Curso.addColumn("Asigntura");
		modelo_Curso.addColumn("Ciclo");
		modelo_Curso.addColumn("Creditos");
		modelo_Curso.addColumn("Horas");
		tabla_Cur.setModel(modelo_Curso);
		
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
	
	// Metodo leer 
	String LeerCampo (JTextField x) {
		return x.getText().trim();
	}
	// Limpiar
	void Limpiar () {
		text_Matricula.setText("");
	}
	// Error
	void Error(String x, JTextField text) {
		JOptionPane.showMessageDialog(this, x, "ERROR", 0);
		text.setText("");
		text.requestFocus();
	}
	// Buscar Matricula
	Matricula ObtenerMatricula() {
		for (int i = 0; i < AM.tamanio(); i++) {
			if (AM.obtener(i).getNumMatricula().equals(LeerCampo(text_Matricula))) {
				return AM.obtener(i);
			}
		}
		return null;
	}
	// Buscar Matricula por numero matricula
	Matricula ObtenerXnumMatricula(String x) {
		for (int i = 0; i < AM.tamanio(); i++) {
			if (AM.obtener(i).getNumMatricula().equals(x)) {
				return AM.obtener(i);
			}
		}
		return null;
	}
	// Buscar Retiro
	Retiro ObtenerRetiro() {
		for (int i = 0; i < AR.tamanio(); i++) {
			if (AR.obtener(i).getNumRetiro().equals(LeerCampo(text_Retiro))) {
				return AR.obtener(i);
			}
		}
		return null;
	}
	// Buscar curso 
	Curso buscarCurso(String CodCurso) {
		for (int i = 0; i < AC.tamanio(); i++) {
			if (AC.obtener(i).getCodCurso().equals(CodCurso))
				return AC.obtener(i);
		}
		return null;
	}
	
	
	///////////////////////////////////////////////////7
	/////////////// BOTONES 
	/////////////////////////////////////////////////777
	
	// Consultar Matricula
	protected void actionPerformedBtnConsultarMatricula(ActionEvent e) {
		LimpiamosTablas();
		Matricula m = ObtenerMatricula();
		if (LeerCampo(text_Matricula).length() != 0) {			
			if (m != null) {
				try {					
					Alumno alumno = AA.buscarCod(m.getCodAlumno());
					if (alumno.getEstado() == 1) {
						Curso cur = buscarCurso(m.getCodCurso());
						MostramosTablaAlumno(alumno);
						MostramosTablaCurso(cur);
					} else {
						Error("El Alumno no esta MATRICULADO", text_Matricula);
					}
				} catch (Exception e1) {
					Error("El alumno no esta MATRICULADO", text_Matricula);
					LimpiamosTablas();
				}
			} else {
				Error("No existe MATRICULA", text_Matricula);
				LimpiamosTablas();
			}
		} else {
			Error("El campo Numero MATRICULA no puede estar vacio", text_Matricula);
		}
	}
	// Consultar retiro
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		LimpiamosTablas();
		if (LeerCampo(text_Retiro).length() != 0) {			
			Retiro r = ObtenerRetiro();
			if (r != null) {
				Matricula m = ObtenerXnumMatricula(r.getNumMatricula());
				if (m != null) {
					Alumno alumno = AA.buscarCod(m.getCodAlumno());
					if (alumno.getEstado() == 2) {
						Curso cur = buscarCurso(m.getCodCurso());
						MostramosTablaAlumno(alumno);
						MostramosTablaCurso(cur);
					} else {
						Error("El alumno no esta MATRICULADO", text_Retiro);
					}
				}
			} else {
				Error("No existe Retiro", text_Retiro);
			}
		} else {
			Error("El campo Numero RETIRO no puede estar vacio", text_Retiro);
		}
	}
	///////////////////////////////////////////////////7
	/////////////// Validar Keys
	/////////////////////////////////////////////////777
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
			case 2: 
				if(text_Retiro.getText().length() >= 7)
			        e.consume();
						break;
		}
	}
	// Validar Campo Matricula
	protected void keyTypedText_Matricula(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 1);
	}
	
	// Validar Campo Retiro
	protected void keyTypedText_Retiro(KeyEvent e) {
		NoEspeciales(e);
		BorrandoDigitos(e, 2);		
	}
}