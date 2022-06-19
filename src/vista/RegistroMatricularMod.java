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
import javax.swing.table.DefaultTableModel;

import entidad.Curso;
import entidad.Matricula;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionCursoDAO;
import mantenimiento.GestionMatriculaDAO;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class RegistroMatricularMod extends JInternalFrame {
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JLabel lblNewLabel;
	private JTextField text_Codigo;
	private JLabel lblNewLabel_1;
	private JTextField text_CodAlumno;
	private JLabel lblNewLabel_2;
	public static JTextField text_CodCurso;
	private JLabel lblNewLabel_3;
	private JTextField text_Hora;
	private JTextField text_Fecha;
	private JLabel lblNewLabel_4;
	private JButton btnEliminar;
	
	DefaultTableModel model = new DefaultTableModel();

	GestionMatriculaDAO gMatricula = new GestionMatriculaDAO();
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	GestionCursoDAO gCurso = new GestionCursoDAO();
	private JButton btnModificar;
	private JButton btnDlgListarCurso;

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
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						mouseClickedTable(e);
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			lblNewLabel = new JLabel("Num. Matricula");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(47, 43, 123, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			text_Codigo = new JTextField();
			text_Codigo.setText("Dale clic a un campo en Tabla");
			text_Codigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Codigo.setBounds(154, 40, 170, 20);
			getContentPane().add(text_Codigo);
			text_Codigo.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Cod. Alumno");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(47, 86, 103, 14);
			getContentPane().add(lblNewLabel_1);
		}
		{
			text_CodAlumno = new JTextField();
			text_CodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_CodAlumno.setBounds(154, 83, 170, 20);
			getContentPane().add(text_CodAlumno);
			text_CodAlumno.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Cod Curso");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(47, 131, 103, 14);
			getContentPane().add(lblNewLabel_2);
		}
		{
			text_CodCurso = new JTextField();
			text_CodCurso.setEditable(false);
			text_CodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_CodCurso.setBounds(154, 128, 145, 20);
			getContentPane().add(text_CodCurso);
			text_CodCurso.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Hora:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(371, 43, 94, 14);
			getContentPane().add(lblNewLabel_3);
		}
		{
			text_Hora = new JTextField();
			text_Hora.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Hora.setBounds(454, 40, 123, 20);
			getContentPane().add(text_Hora);
			text_Hora.setColumns(10);
		}
		{
			text_Fecha = new JTextField();
			text_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Fecha.setBounds(454, 83, 123, 20);
			getContentPane().add(text_Fecha);
			text_Fecha.setColumns(10);
		}
		{
			lblNewLabel_4 = new JLabel("Fecha:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(371, 86, 94, 14);
			getContentPane().add(lblNewLabel_4);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEliminar(e);
				}
			});
			btnEliminar.setBounds(488, 178, 89, 23);
			getContentPane().add(btnEliminar);
		}
		
			// Seteamos valoreas al tipo consultar
		text_Codigo.setEditable(false);
		text_CodAlumno.setEditable(false);
		text_Fecha.setEditable(false);
		text_Hora.setEditable(false);
		
			// Hacemos el Default de la Tabla
		model.addColumn("Matricula");
		model.addColumn("Cod. Alumno");
		model.addColumn("Cod. Curso");
		model.addColumn("Fecha Add");
		model.addColumn("Hora Add");
		table.setModel(model);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		btnModificar.setVisible(true);
		btnModificar.setBounds(371, 178, 94, 23);
		getContentPane().add(btnModificar);
		{
			btnDlgListarCurso = new JButton("");
			btnDlgListarCurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnDlgListarCurso(e);
				}
			});
			btnDlgListarCurso.setIcon(new ImageIcon(RegistroMatricularMod.class.getResource("/imagenes/open-book (1).png")));
			btnDlgListarCurso.setBounds(298, 128, 26, 23);
			getContentPane().add(btnDlgListarCurso);
		}
		MostramosTabla();
	}	
	
	/////////////////////////////////////////////////////////////////////////////////
	//////////////// METODOS COMPLEMENTARIOS
	/////////////////////////////////////////////////////////////////////////////////
	
	// Mostrar tabla
	void MostramosTabla() {
		model.setRowCount(0);
		
		ArrayList<Matricula> matriculas = gMatricula.leerSoloAlumnMatriculados();
		
		for (Matricula m : matriculas) {
			Object fila[] = { m.getNumMatricula(), m.getCodAlumno(), m.getCodCurso(), m.getFecha(), m.getHora() };

			model.addRow(fila);
		}
	}
	// Metodo leer 
	String LeerCampo (JTextField x) {
		return x.getText().trim();
	}
	// Metodo Limpiar Campos
	void LimpiarCurso() {
		text_CodCurso.setText("");
	}
	
	// boton Modificar
	protected void actionPerformedBtnModificar(ActionEvent e) {
		ModificarCurso();
	}
	

	// Boton Eliminar
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarMatricula();
	}
	
	// Mostrar dialogo curso
	protected void actionPerformedBtnDlgListarCurso(ActionEvent e) {
		mostrarDialogCursos();
	}
	
	private void mostrarDialogCursos() {
		DlgListarCursos aRegistrados = new DlgListarCursos();
		aRegistrados.setVisible(true);
		aRegistrados.setLocationRelativeTo(this);
	}

	private void eliminarMatricula() {
		String codCurso = text_CodCurso.getText();
		Curso curso = gCurso.listarCurso(text_CodCurso.getText());
		int estado = gAlumno.obtenerEstado(text_CodAlumno.getText());
		
		if (codCurso.length() == 0) {
			mensajeError("El codigo no puede estar vacio");
		} else if (curso == null){
			mensajeError("El curso no existe");
		} else if (estado == 2) {
			mensajeError("El alumno esta retirado");
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Eliminar Matricula?", "Sistema", JOptionPane.YES_NO_OPTION);
			
			if (confirmacion == 0) {	    	
				gAlumno.actualizarEstadoAlumno(0, text_CodAlumno.getText());
				Limpiar();
				mensajeExitoso("Usuario eliminado");
				MostramosTabla();
			} else {
				mensajeExitoso("Cancelacion exitosa");
			}
		}
			
	}
	
	private void Limpiar() {
		text_Codigo.setText("Dale clic a un campo en Tabla");
		text_CodAlumno.setText("");
		text_CodCurso.setText("");
		text_Fecha.setText("");
		text_Hora.setText("");
	}

	private void ModificarCurso() {
		String numMatr = text_Codigo.getText();
		String codCurso = text_CodCurso.getText();
		int estado = gAlumno.obtenerEstado(text_CodAlumno.getText());
		
		if(codCurso.length() == 0) {
			mensajeError("El campo curo no puede estar vacio");
		} else if (estado == 2) {
			mensajeError("Alumno retirado");
		} else {
			int ok = gMatricula.actualizar(numMatr, codCurso);
			
			
			if (ok == 0) {
				mensajeError("Error al actualizar");
			} else {
				mensajeExitoso("Matricula actualizada");
				MostramosTabla();
			}		
		}
		
	}

	
	// mostrar datos de tabla seleccionada
	protected void mouseClickedTable(MouseEvent e) {
		String nMatri, cAlumno, cCurso, fecha, hora;
		int fila;

		fila = table.getSelectedRow();
		
		nMatri = table.getValueAt(fila, 0).toString();
		cAlumno = table.getValueAt(fila, 1).toString();
		cCurso = table.getValueAt(fila, 2).toString();
		fecha = table.getValueAt(fila, 3).toString();
		hora = table.getValueAt(fila, 4).toString();
		
		text_Codigo.setText(nMatri);
		text_CodAlumno.setText(cAlumno);
		text_CodCurso.setText(cCurso);
		text_Fecha.setText(fecha);
		text_Hora.setText(hora);
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}
	
	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Registro bien", 1);
	}
}
