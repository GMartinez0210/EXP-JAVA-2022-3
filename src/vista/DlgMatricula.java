package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Matricula;
import entidad.Retiro;

import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionMatriculaDAO;
import mantenimiento.GestionRetiroDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgMatricula extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	GestionRetiroDAO gRetiro = new GestionRetiroDAO();
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	GestionMatriculaDAO gMatricula = new GestionMatriculaDAO();
	
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMatricula dialog = new DlgMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMatricula() {
		setTitle("Retiro");
		setBounds(100, 100, 538, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 504, 218);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_Aceptar = new JButton("Aceptar");
				btn_Aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtn_Aceptar(e);
					}
				});
				btn_Aceptar.setActionCommand("OK");
				buttonPane.add(btn_Aceptar);
				getRootPane().setDefaultButton(btn_Aceptar);
			}
			{
				JButton btn_Cancelar = new JButton("Cancelar");
				btn_Cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtn_Cancelar(e);
					}
				});
				btn_Cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_Cancelar);
			}
		}
		
		// Hacemos el Default de la Tabla
		model.addColumn("Matricula");
		model.addColumn("Cod. Alumno");
		model.addColumn("Cod. Curso");
		model.addColumn("Fecha Add");
		model.addColumn("Hora Add");
		table.setModel(model);
		
		MostramosTabla();
	}
	
	//	Método Mostrar Tabla
	void MostramosTabla() {
		model.setRowCount(0);
		
		ArrayList<Matricula> matriculas = gMatricula.leerSoloAlumnMatriculados();
		
		if (matriculas.size() == 0) {
			return;
		}
		
		for (Matricula m : matriculas) {
			Object fila[] = { 
					m.getNumMatricula(),
					m.getCodAlumno(), 
					m.getCodCurso(), 
					m.getFecha(), 
					m.getHora() 
				};

			model.addRow(fila);
		}
	}
	
	// Button Aceptar
	protected void actionPerformedBtn_Aceptar(ActionEvent e) {
		int rowSelected = table.getSelectedRow();
	
		if (rowSelected == -1) {
			JOptionPane.showMessageDialog(this, "No ha seleccionado un retiro", "ERROR", 0);
			return;
		}
		
		String numMatricula = table.getValueAt(rowSelected, 0).toString();
		String codAlumno = table.getValueAt(rowSelected, 1).toString();
		String codCurso = table.getValueAt(rowSelected, 2).toString();
		String hora = table.getValueAt(rowSelected, 3).toString();
		String fecha = table.getValueAt(rowSelected, 4).toString();
		
		RegistroRetiroAdicionar.text_Matricula.setText(numMatricula);
		RegistroRetiroAdicionar.text_Alumno.setText(codAlumno);
		RegistroRetiroAdicionar.text_Curso.setText(codCurso); 
		RegistroRetiroAdicionar.text_Hora.setText(hora);     
		RegistroRetiroAdicionar.text_Fecha.setText(fecha);    
		
		dispose();
	}
	
	// Button Cancelar
	protected void actionPerformedBtn_Cancelar(ActionEvent e) {
		dispose();
	}
}
