package vista;

import java.awt.EventQueue;

import arrays.ArrayAlumno;
import arrays.ArrayCurso;
import arrays.ArrayMatricula;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteAlumnosMatriculados extends JInternalFrame {
	private JLabel lblNewLabel;
	private JComboBox CBO_Reporte;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

		//	Arreglos Globales
	ArrayAlumno AA = new ArrayAlumno();
	ArrayCurso AC = new ArrayCurso();
	ArrayMatricula AM = new ArrayMatricula();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteAlumnosMatriculados frame = new ReporteAlumnosMatriculados();
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
	public ReporteAlumnosMatriculados() {
		setTitle("Reporte Alumnos Matriculados");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 620, 600);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Tipo de Reporte");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(104, 39, 120, 15);
			getContentPane().add(lblNewLabel);
		}
		{
			CBO_Reporte = new JComboBox();
			CBO_Reporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedComboBox(e);
				}
			});
			CBO_Reporte.setModel(new DefaultComboBoxModel(new String[] {"-Select Item-", "Matricula Pendiente", "Matricula Vigente", "Matriculados por Curso"}));
			CBO_Reporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
			CBO_Reporte.setBounds(262, 36, 150, 21);
			getContentPane().add(CBO_Reporte);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 89, 561, 447);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
		
		TablaMatriculados();
	}
	
		//	Metodo Leer String
	String LeerString(JComboBox CBO) {
		return CBO.getSelectedItem().toString();
	}
	
		//	Metodo Limpiar Tabla
	void LimpiarTabla() {
		modelo = new DefaultTableModel();
		table.setModel(modelo);
	}
	
		//	Metodo Tabla Matriculados
	void TablaMatriculados() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Estado");
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		table.setModel(modelo);
	}
	
		//	Metodo TablaCursos
	void TablaCursos() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Cod. Alumno");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apelldio");
		table.setModel(modelo);
	}
	
	
		//	Metodo Matricula Pendiente
	void MatriculaPendiente() {
		TablaMatriculados();
		int rowcount = 0;
		for (int i = 0; i < AA.tamanio(); i++) {
			Alumno alumno = AA.obtener(i);
			if (alumno.getCodAlumno().length() != 0) {
				if (alumno.getEstado() == 0) {
					modelo.setRowCount(rowcount);
					Object [] fila = {
							alumno.getEstado(),
							alumno.getCodAlumno(),
							alumno.getNombres(),
							alumno.getApellidos(),
							alumno.getDni(),
							alumno.getEdad(),
							alumno.getCelular(),
					};
					modelo.addRow(fila);
					rowcount++;
				}
			}
		}
	}
	
		//	Metodo Matricula Vigente
	void MatriculaVigente() {
		TablaMatriculados();
		int rowcount = 0;
		for (int i = 0; i < AA.tamanio(); i++) {
			Alumno alumno = AA.obtener(i);
			if (alumno.getCodAlumno().length() != 0) {
				if (alumno.getEstado() == 1) {
					modelo.setRowCount(rowcount);
					Object [] fila = {
							alumno.getEstado(),
							alumno.getCodAlumno(),
							alumno.getNombres(),
							alumno.getApellidos(),
							alumno.getDni(),
							alumno.getEdad(),
							alumno.getCelular(),
					};
					modelo.addRow(fila);
					rowcount++;
				}
			}
		}
	}
	
		//	Metodo Matriculados por Curso
	void MatriculadoCurso() {
		TablaCursos();
		int rowcount = 0;
		for (int i = 0; i < AC.tamanio(); i++) {
			Curso curso = AC.obtener(i);
			for (int j = 0; j < AM.tamanio(); j++) {
				String codCursoMatricula = AM.obtener(j).getCodCurso();
				if (curso.getCodCurso().equals(codCursoMatricula)) {
					modelo.setRowCount(rowcount);
					Object [] fila = {
							curso.getCodCurso(),
							curso.getAsignatura(),
							AM.obtener(j).getCodAlumno(),
							AA.buscarCod(AM.obtener(j).getCodAlumno()).getNombres(),
							AA.buscarCod(AM.obtener(j).getCodAlumno()).getApellidos()
					};
					modelo.addRow(fila);
					rowcount++;
				}
			}
			/*
			Matricula matricula = AM.buscar(curso.getCodCurso());
			System.out.println("worked");
			if (matricula != null) {
				String codAlumnoMatricula = matricula.getCodAlumno();
				for (int j = 0; j < AA.tamanio(); j++) {
					Alumno alumno = AA.obtener(j);
					if (codAlumnoMatricula.equals(alumno.getCodAlumno())) {
						modelo.setRowCount(rowcount);
						Object [] fila = {
								curso.getCodCurso(),
								curso.getAsignatura(),
								alumno.getCodAlumno(),
								alumno.getNombres(),
								alumno.getApellidos()
						};
						modelo.addRow(fila);
					}
				}
			}
			*/
		}
	}
	
		// CBO 
	protected void actionPerformedComboBox(ActionEvent e) {
		LimpiarTabla();
		String Reporte = LeerString(CBO_Reporte);
		switch (Reporte) {
			case "Matricula Pendiente":
				MatriculaPendiente();
					break;
			case "Matricula Vigente":
				MatriculaVigente();
					break;
			case "Matriculados por Curso":
				MatriculadoCurso();
					break;
			case "-Select Item-":
				LimpiarTabla();
					break;
		}
	}
}
