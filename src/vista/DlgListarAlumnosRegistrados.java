package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import mantenimiento.GestionAlumnoDAO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgListarAlumnosRegistrados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultTableModel model = new DefaultTableModel();
	GestionAlumnoDAO gAlumno = new GestionAlumnoDAO();
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarAlumnosRegistrados dialog = new DlgListarAlumnosRegistrados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListarAlumnosRegistrados() {
		setBounds(100, 100, 491, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Buscar por nombre:");
		lblNewLabel.setBounds(24, 25, 117, 14);
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keyReleasedTxtNombre(e);
			}
		});
		txtNombre.setBounds(156, 22, 296, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 65, 425, 176);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 265, 475, 44);
			contentPanel.add(buttonPane);
			{
				JButton btnEnviar = new JButton("Enviar");
				btnEnviar.setBounds(253, 11, 77, 23);
				btnEnviar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnEnviar(e);
					}
				});
				buttonPane.setLayout(null);
				btnEnviar.setActionCommand("OK");
				buttonPane.add(btnEnviar);
				getRootPane().setDefaultButton(btnEnviar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(360, 11, 91, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnCancelar(e);
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		
		table.setModel(model);
		
		
		cargarTodaTabla();
	}

	private void cargarTodaTabla() {
		model.setRowCount(0);
		
		ArrayList<Alumno> list = gAlumno.listarAlumnoXEstado(0);
		
		if(list.size() == 0) {
			
		}else {
			//bucle
			for (Alumno a : list) {
				Object fila[] = {a.getCodAlumno(),
						a.getNombres(),
						a.getApellidos(),
						a.getDni(),
						a.getEdad(),
						a.getCelular()						         
				};
				model.addRow(fila);
			}
		}
	}

	protected void actionPerformedBtnEnviar(ActionEvent e) {
		String cod;
		int fila;
		
		fila = table.getSelectedRow();
		
		cod = table.getValueAt(fila, 0).toString();
		
		RegistroMatriculaAdicionar.text_Alumno.setText(cod);
		
		dispose();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	protected void keyReleasedTxtNombre(KeyEvent e) {
		model.setRowCount(0);
		ArrayList<Alumno> list = gAlumno.listarAlumnoXNombre(txtNombre.getText());
	
		if(list.size() == 0) {
			
		}else {
			for (Alumno a : list) {
				Object fila[] = {a.getCodAlumno(),
						a.getNombres(),
						a.getApellidos(),
						a.getDni(),
						a.getEdad(),
						a.getCelular()						         
				};
				model.addRow(fila);
			}
		}
	}
}
