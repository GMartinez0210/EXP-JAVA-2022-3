package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import entidad.Curso;
import mantenimiento.GestionCursoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgListarCursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	GestionCursoDAO gCursos = new GestionCursoDAO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarCursos dialog = new DlgListarCursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListarCursos() {
		setBounds(100, 100, 490, 326);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 241, 474, 46);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnEnviar = new JButton("Enviar");
				btnEnviar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnEnviar(e);
					}
				});
				btnEnviar.setBounds(264, 11, 75, 23);
				btnEnviar.setActionCommand("OK");
				buttonPane.add(btnEnviar);
				getRootPane().setDefaultButton(btnEnviar);
			}
			{
				JButton btnCancelar = new JButton("Cancel");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnCancelar(e);
					}
				});
				btnCancelar.setBounds(362, 11, 75, 23);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Buscar por nombre de curso:");
			lblNewLabel.setBounds(23, 22, 194, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			txtBuscar = new JTextField();
			txtBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					keyReleasedTxtBuscar(e);
				}
			});
			txtBuscar.setBounds(204, 20, 246, 20);
			contentPanel.add(txtBuscar);
			txtBuscar.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 70, 425, 157);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		
		model.addColumn("Codigo");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("Credito");
		model.addColumn("Horas");
		
		table.setModel(model);
		
		cargarTodaTabla();
		
	}

	private void cargarTodaTabla() {
		model.setRowCount(0);

		ArrayList<Curso> list = gCursos.leer();
		
		if(list.size() == 0) {
			
		}else {
			//bucle
			for (Curso c : list) {
				Object fila[] = {c.getCodCurso(),
						c.getAsignatura(),
						c.getCiclo(),
						c.getCreditos(),
						c.getHoras(),    
				};
				model.addRow(fila);
			}
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		String cod;
		int fila;
		
		fila = table.getSelectedRow();
		
		cod = table.getValueAt(fila, 0).toString();
		
		if (RegistroMatriculaAdicionar.text_Curso != null)
			RegistroMatriculaAdicionar.text_Curso.setText(cod);
		else {
			RegistroMatricularMod.text_CodCurso.setText(cod);
		}
		dispose();
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		model.setRowCount(0);
		ArrayList<Curso> list = gCursos.leerXNombre(txtBuscar.getText());
	
		if(list.size() == 0) {
			
		}else {
			for (Curso c: list) {
				Object fila[] = {c.getCodCurso(),
						c.getAsignatura(),
						c.getCiclo(),
						c.getCreditos(),
						c.getHoras()					         
				};
				model.addRow(fila);
			}
		}
	}
}
