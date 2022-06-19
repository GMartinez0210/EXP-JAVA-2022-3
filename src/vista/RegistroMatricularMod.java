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

public class RegistroMatricularMod extends JInternalFrame {
	private JTable table;
	private JScrollPane scrollPane;
	
	private JLabel lblAccion;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	public static JTextField text_Codigo;
	public static JTextField text_CodAlumno;
	public static JTextField text_CodCurso;
	public static JTextField text_Hora;
	public static JTextField text_Fecha;
	
	private JButton btnLimpiar;
	private JButton btnModificar;
	private JButton btnEliminar;

	private JRadioButton rdbtn_Modificar;
	private JRadioButton rdbtn_Consultar;

	ButtonGroup btnsGrupo = new ButtonGroup();
	
	DefaultTableModel model = new DefaultTableModel();

	GestionMatriculaDAO gMatricula = new GestionMatriculaDAO();
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	GestionCursoDAO gCurso = new GestionCursoDAO();

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
			lblNewLabel = new JLabel("Num. Matricula");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(47, 94, 123, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			text_Codigo = new JTextField();
			text_Codigo.setText("Dale clic a un campo en Tabla");
			text_Codigo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedText_Codigo(e);
				}
			});
			text_Codigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			text_Codigo.setBounds(154, 91, 170, 20);
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
			text_CodAlumno.setBounds(154, 119, 170, 20);
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
			text_CodCurso.setBounds(154, 144, 170, 20);
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
			btnLimpiar = new JButton("Limpiar Curso");
			btnLimpiar.setVisible(false);
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnLimpiar(e);
				}
			});
			btnLimpiar.setBounds(214, 194, 135, 23);
			getContentPane().add(btnLimpiar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEliminar(e);
				}
			});
			btnEliminar.setBounds(488, 194, 89, 23);
			getContentPane().add(btnEliminar);
		}
		
			// Seteamos valoreas al tipo consultar
		text_Codigo.setEditable(false);
		text_CodAlumno.setEditable(false);
		text_CodCurso.setEditable(false);
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
		btnModificar.setVisible(false);
		btnModificar.setBounds(371, 194, 94, 23);
		getContentPane().add(btnModificar);
		MostramosTabla();
	}	
	
		//	Radious Button Consultar
	protected void actionPerformedRdbtn_Consultar(ActionEvent e) {
		btnModificar.setVisible(false);
		btnLimpiar.setVisible(false);
		text_CodCurso.setEditable(false);
	}
	
		//	Radious Button Modificar
	protected void actionPerformedRdbtn_Modificar(ActionEvent e) {
		btnModificar.setVisible(true);
		btnLimpiar.setVisible(true);
		text_CodCurso.setEditable(true);
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

	/////////////////////////////////////////////////////////////////////////////////
	//////////////// BOTONES
	/////////////////////////////////////////////////////////////////////////////////
	
	// Boton Limpiar
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		LimpiarCurso();
	}
	
	// boton Modificar
	protected void actionPerformedBtnModificar(ActionEvent e) {
		ModificarCurso();
	}
	

	// Boton Eliminar
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarMatricula();
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
				gAlumno.actualizarEstadoAlumno(2, text_CodAlumno.getText());
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
	
	//	Validando Numero Matricula  	
	protected void keyTypedText_Codigo(KeyEvent e) {
		
	}
	
		//	Validando Codigo de Alumno
	protected void keyTypedText_CodAlumno(KeyEvent e) {
		
	}
	
		//	Validando Codigo de Curso
	protected void keyTypedText_CodCurso(KeyEvent e) {
		
	}
}
