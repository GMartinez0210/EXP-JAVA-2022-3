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
		model.addColumn("Matricula");
		model.addColumn("Cod. Alumno");
		model.addColumn("Cod. Curso");
		model.addColumn("Fecha Add");
		model.addColumn("Hora Add");
		table.setModel(model);
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
		text_Codigo.setEditable(false);
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
		model.setRowCount(0);
		
		ArrayList<Matricula> matriculas = gMatricula.leer();
		
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
	void Limpiar() {
		text_Codigo.setText("");
		text_CodAlumno.setText("");
		text_CodCurso.setText("");
		text_Fecha.setText("");
		text_Hora.setText("");
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
		eliminarMatricula();
	}
	
	private void eliminarMatricula() {
		String nMtricula;
		nMtricula = text_Codigo.getText();
	
		if (nMtricula == null) {
			mensajeError("Error");
		} else {
			
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Eliminar Usuario?", "Sistema", JOptionPane.YES_NO_OPTION);
			if (confirmacion == 0) {
				
				int ok = gMatricula.eliminar(nMtricula);
	    	
				if (ok == 0) {
					mensajeError("Error en la eliminacion");
				} else {
					Limpiar();
					mensajeExitoso("Usuario eliminado");
					MostramosTabla();
				}
				
			} else {
				mensajeExitoso("Cancelación exitosa");
			}
			
		}
	}

	// Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		consultarMatricula();
	}
	
	private void consultarMatricula() {
		Matricula m = gMatricula.consultar(text_Codigo.getText());
		
		if (m.getNumMatricula() == null) {
			mensajeError("Matricula no existe");
			text_Codigo.requestFocus();
		} else {
			text_CodAlumno.setText(m.getCodAlumno());
			text_CodCurso.setText(m.getCodCurso());
			text_Fecha.setText(m.getFecha());
			text_Hora.setText(m.getHora());
		}
	}

	// Boton Modificar
	protected void actionPerformedBtnModificar(ActionEvent e) {
		actualizarMatricula();
	}
	
	private void actualizarMatricula() {
		String numMatr = text_Codigo.getText();
		String codCurso = text_CodCurso.getText();
		
		int ok = gMatricula.actualizar(numMatr, codCurso);
    	
		if (ok == 0) {
			mensajeError("Error al actualizar");
		} else {
			mensajeExitoso("Matricula actualizada");
			MostramosTabla();
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
