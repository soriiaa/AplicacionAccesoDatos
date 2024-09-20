package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Modelo;

public class _01_EscribirRegistro extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblTitulo;
	private JLabel lblVolver;
	private JButton btnAnadir;
	private boolean botonActivado = false;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _01_EscribirRegistro() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAnadir.setBackground(new Color(255, 255, 255));
				lblVolver.setBackground(new Color(255, 255, 255));
				comprobarCampos();
			}
		});

		getContentPane().setBackground(new Color(141, 141, 141));
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Anadir Usuario");
		lblTitulo.setFont(new Font("Minecraft", Font.PLAIN, 30));

		lblTitulo.setBounds(304, 50, 277, 38);
		getContentPane().add(lblTitulo);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtId.setBounds(108, 264, 185, 38);
		txtId.setBorder(null);
		txtId.setBorder(
				BorderFactory.createCompoundBorder(txtId.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(349, 264, 185, 38);
		txtNombre.setBorder(null);
		txtNombre.setBorder(BorderFactory.createCompoundBorder(txtNombre.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtNombre);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(592, 264, 185, 38);
		txtCorreo.setBorder(null);
		txtCorreo.setBorder(BorderFactory.createCompoundBorder(txtCorreo.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtCorreo);

		lblTitulo.setBounds(190, 38, 277, 38);
		getContentPane().add(lblTitulo);

		btnAnadir = new JButton("Anadir");

		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				if (botonActivado) {
					btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnAnadir.setBackground(new Color(200, 200, 200));
				}

			}
		});
		btnAnadir.setBackground(new Color(255, 255, 255));
		btnAnadir.setFont(new Font("Minecraft", Font.PLAIN, 20));
		btnAnadir.setBounds(378, 464, 134, 50);
		btnAnadir.setBorder(null);
		btnAnadir.setEnabled(false);
		getContentPane().add(btnAnadir);

		lblVolver = new JLabel("");
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblVolver.setBackground(new Color(200, 200, 200));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(1, 0);
			}
		});
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.setBackground(new Color(0, 0, 0));
		lblVolver.setBounds(802, 38, 50, 50);
		getContentPane().add(lblVolver);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("Minecraft", Font.PLAIN, 15));

		lblId.setBounds(190, 228, 24, 26);

		lblId.setBounds(168, 273, 24, 19);

		getContentPane().add(lblId);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Minecraft", Font.PLAIN, 15));

		lblNombre.setBounds(407, 228, 67, 26);

		lblNombre.setBounds(365, 273, 67, 19);

		getContentPane().add(lblNombre);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Minecraft", Font.PLAIN, 15));

		lblCorreo.setBounds(651, 228, 67, 26);

		lblCorreo.setBounds(700, 273, 67, 19);

		getContentPane().add(lblCorreo);

		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtId.setBounds(108, 264, 90, 38);
		txtId.setBorder(null);
		txtId.setBorder(
				BorderFactory.createCompoundBorder(txtId.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(240, 264, 197, 38);
		txtNombre.setBorder(null);
		txtNombre.setBorder(BorderFactory.createCompoundBorder(txtNombre.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtNombre);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(483, 264, 294, 38);
		txtCorreo.setBorder(null);
		txtCorreo.setBorder(BorderFactory.createCompoundBorder(txtCorreo.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtCorreo);

		ImageIcon fondoDiferentesPersonajes = new ImageIcon(".\\img\\fondoDiferentesPersonajes.jpg");
		JLabel lblImagenFondo = new JLabel();
		lblImagenFondo.setBounds(-46, 0, 1067, 600);
		getContentPane().add(lblImagenFondo);
		lblImagenFondo.setIcon(fondoDiferentesPersonajes);

	}

	public void comprobarCampos() {

		if (txtId.getText().isBlank() || txtNombre.getText().isBlank() || txtCorreo.getText().isBlank()) {
			btnAnadir.setEnabled(false);
			botonActivado = false;
		} else {
			btnAnadir.setEnabled(true);
			botonActivado = true;
		}

	}

}
