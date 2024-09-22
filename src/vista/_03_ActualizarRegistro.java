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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Modelo;

public class _03_ActualizarRegistro extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblVolver;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JButton btnConfirmar;
	private boolean botonActivado = false;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _03_ActualizarRegistro() {

		getContentPane().setBackground(new Color(141, 141, 141));
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

		ImageIcon imagenFondoActualizarRegistro = new ImageIcon(".\\img\\fondoActualizarRegistro.jpg");

		lblVolver = new JLabel("");
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.setBackground(new Color(0, 0, 0));
		lblVolver.setBounds(785, 23, 50, 50);
		getContentPane().add(lblVolver);
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

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(177, 480, 254, 38);
		txtNombre.setBorder(null);
		txtNombre.setBorder(BorderFactory.createCompoundBorder(txtNombre.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtNombre);
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

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Minecraft", Font.PLAIN, 20));
		lblNombre.setBounds(333, 486, 91, 26);
		getContentPane().add(lblNombre);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Minecraft", Font.PLAIN, 20));
		lblCorreo.setBounds(598, 486, 91, 26);
		getContentPane().add(lblCorreo);
		
		JLabel lblTitulo = new JLabel("Actualizar Usuarios");
		lblTitulo.setFont(new Font("Minecraft", Font.PLAIN, 30));
		lblTitulo.setBounds(358, 23, 373, 55);
		getContentPane().add(lblTitulo);

		String[] opciones = { "1", "2", "3", "4" };
		JComboBox<String> comboBoxId = new JComboBox<>(opciones);
		comboBoxId.setFont(new Font("Minecraft", Font.PLAIN, 20));
		comboBoxId.setBounds(52, 480, 115, 39);
		comboBoxId.setBorder(null);
		comboBoxId.setBackground(new Color(255, 255, 255));
		comboBoxId.setOpaque(true);
		getContentPane().add(comboBoxId);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 480, 40, 39);
		getContentPane().add(panel);

		JLabel lblId = new JLabel("ID");
		panel.add(lblId);
		lblId.setFont(new Font("Minecraft", Font.PLAIN, 20));

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
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(441, 481, 254, 38);
		txtCorreo.setBorder(BorderFactory.createCompoundBorder(txtCorreo.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtCorreo);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Minecraft", Font.PLAIN, 20));
		btnConfirmar.setBounds(721, 480, 141, 39);
		btnConfirmar.setBorder(null);
		btnConfirmar.setEnabled(false);
		getContentPane().add(btnConfirmar);
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (botonActivado) {
					btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnConfirmar.setBackground(new Color(200, 200, 200));
				}
			}
		});

		JLabel lblImagenFondo = new JLabel();
		lblImagenFondo.setBounds(-46, 0, 1067, 600);
		getContentPane().add(lblImagenFondo);
		lblImagenFondo.setIcon(imagenFondoActualizarRegistro);

	}

	public void comprobarCampos() {

		if (txtNombre.getText().isBlank() || txtCorreo.getText().isBlank()) {
			btnConfirmar.setEnabled(false);
			botonActivado = false;
		} else {
			btnConfirmar.setEnabled(true);
			botonActivado = true;
		}

	}

}
