package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Menu extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel desk;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnAlumno;
	private JMenu mnCurso;
	private JMenuItem mntmAdicionar;
	private JMenuItem mntmConsultarModificarEliminar;
	private JMenuItem mntmAdicionar_1;
	private JMenuItem mntmConsultarModificarEliminar_1;
	private JMenu mnMatrcula;
	private JMenu mnRetiro;
	private JMenuItem mntmAdicionar_2;
	private JMenuItem mntmConsultarModificarEliminar_2;
	private JMenuItem mntmAdicionar_3;
	private JMenuItem mntmConsultarModificarEliminar_3;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/rubik.png")));
		setTitle("James' School");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 650);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mnAlumno = new JMenu("Alumno");
		mnMantenimiento.add(mnAlumno);
		
		mntmAdicionar = new JMenuItem("Adicionar");
		mntmAdicionar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mntmAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAdicionar(e);
			}
		});
		mnAlumno.add(mntmAdicionar);
		
		mntmConsultarModificarEliminar = new JMenuItem("Consultar, Modificar, Eliminar");
		mntmConsultarModificarEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
		mntmConsultarModificarEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultarModificarEliminar(e);
			}
		});
		mnAlumno.add(mntmConsultarModificarEliminar);
		
		mnCurso = new JMenu("Curso");
		mnMantenimiento.add(mnCurso);
		
		mntmAdicionar_1 = new JMenuItem("Adicionar");
		mntmAdicionar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mntmAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAdicionar_1(e);
			}
		});
		mnCurso.add(mntmAdicionar_1);
		
		mntmConsultarModificarEliminar_1 = new JMenuItem("Consultar, Modificar, Eliminar");
		mntmConsultarModificarEliminar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mntmConsultarModificarEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultarModificarEliminar_1(e);
			}
		});
		mnCurso.add(mntmConsultarModificarEliminar_1);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mnMatrcula = new JMenu("Matr\u00EDcula");
		mnRegistro.add(mnMatrcula);
		
		mntmAdicionar_2 = new JMenuItem("Adicionar");
		mntmAdicionar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		mntmAdicionar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAdicionar_2(e);
			}
		});
		mnMatrcula.add(mntmAdicionar_2);
		
		mntmConsultarModificarEliminar_2 = new JMenuItem("Consultar, Modificar, Eliminar");
		mntmConsultarModificarEliminar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK));
		mntmConsultarModificarEliminar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultarModificarEliminar_2(e);
			}
		});
		mnMatrcula.add(mntmConsultarModificarEliminar_2);
		
		mnRetiro = new JMenu("Retiro");
		mnRegistro.add(mnRetiro);
		
		mntmAdicionar_3 = new JMenuItem("Adicionar");
		mntmAdicionar_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		mntmAdicionar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAdicionar_3(e);
			}
		});
		mnRetiro.add(mntmAdicionar_3);
		
		mntmConsultarModificarEliminar_3 = new JMenuItem("Consultar, Modificar, Eliminar");
		mntmConsultarModificarEliminar_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		mntmConsultarModificarEliminar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultarModificarEliminar_3(e);
			}
		});
		mnRetiro.add(mntmConsultarModificarEliminar_3);
		desk = new JPanel();
		desk.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desk);
		desk.setLayout(new BorderLayout(0, 0));
	}
	
	//Mantenimiento Alumno Adicional
	protected void actionPerformedMntmAdicionar(ActionEvent e) {
		MantAlumnoAdicionar adicionar = new MantAlumnoAdicionar();
		desk.add(adicionar);
		adicionar.show();
	}
	
	//Mantenimiento Alumno CME
	protected void actionPerformedMntmConsultarModificarEliminar(ActionEvent e) {
		MantAlumnoMod cme = new MantAlumnoMod();
		desk.add(cme);
		cme.show();
	}
	
	//Mantenimiento Curso Adicionar
	protected void actionPerformedMntmAdicionar_1(ActionEvent e) {
		MantCursoAdicionar adicionar2 = new MantCursoAdicionar();
		desk.add(adicionar2);
		adicionar2.show();
	}
	
	//Mantenimiento Curso Modificar
	protected void actionPerformedMntmConsultarModificarEliminar_1(ActionEvent e) {
		MantCursoMod cme2 = new MantCursoMod();
		desk.add(cme2);
		cme2.show();
	}
	
	//	Registro Matricula Adicionar
	protected void actionPerformedMntmAdicionar_2(ActionEvent e) {
		RegistroMatriculaAdicionar rma = new RegistroMatriculaAdicionar();
		desk.add(rma);
		rma.show();
	}
	
	//	Registro Retiro Adicionar
	protected void actionPerformedMntmAdicionar_3(ActionEvent e) {
		RegistroRetiroAdicionar rra = new RegistroRetiroAdicionar();
		desk.add(rra);
		rra.show();
	}
	
	//	Registro Matricula Consultar Modificar Eliminar
	protected void actionPerformedMntmConsultarModificarEliminar_2(ActionEvent e) {
		RegistroMatricularMod rmcme = new RegistroMatricularMod();
		desk.add(rmcme);
		rmcme.show();
	}
	// Registro Retiro Modificar
	protected void actionPerformedMntmConsultarModificarEliminar_3(ActionEvent e) {
		RegistroRetiroMod rrm = new RegistroRetiroMod();
		desk.add(rrm);
		rrm.show();
	}
	// Salir
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		System.exit(0);
	}
}
