package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import modelo.Modelo;

public class _00_Inicial extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JButton btnAnadirUsuario;
	private JLabel lblTitulo;
	private JButton btnLeerUsuario;
	private JButton btnActualizarUsuario;
	private JButton btnEliminarUsuario;
	private JLabel lblActualizarUsuario;
	private JLabel lblLeerUsuario;
	private JLabel lblEliminarUsuario;
	private JLabel lblAnadirUsuario;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _00_Inicial() {

		getContentPane().setBackground(new Color(141, 141, 141));
		getContentPane().setLayout(null);

		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

		lblAnadirUsuario = new JLabel("Anadir Usuario");
		lblAnadirUsuario.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblAnadirUsuario.setBounds(219, 157, 145, 51);
		getContentPane().add(lblAnadirUsuario);

		lblLeerUsuario = new JLabel("Leer Usuario");
		lblLeerUsuario.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblLeerUsuario.setBounds(542, 160, 120, 45);
		getContentPane().add(lblLeerUsuario);

		lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblActualizarUsuario.setBounds(211, 419, 175, 45);
		getContentPane().add(lblActualizarUsuario);

		lblEliminarUsuario = new JLabel("Eliminar Usuario");
		lblEliminarUsuario.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblEliminarUsuario.setBounds(521, 419, 145, 45);
		getContentPane().add(lblEliminarUsuario);

		lblTitulo = new JLabel("Gestor de Usuarios");
		lblTitulo.setFont(new Font("Minecraft", Font.PLAIN, 36));
		lblTitulo.setBounds(230, 35, 426, 89);
		getContentPane().add(lblTitulo);

		ImageIcon iconoCartel = new ImageIcon(".\\img\\texturaCartel.jpg");

		btnLeerUsuario = new JButton(iconoCartel);
		btnLeerUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLeerUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0, 2);
			}
		});
		btnLeerUsuario.setBackground(new Color(255, 255, 255));
		btnLeerUsuario.setFont(new Font("Minecraft", Font.PLAIN, 17));
		btnLeerUsuario.setBounds(511, 199, 175, 90);
		btnLeerUsuario.setBorder(null);
		getContentPane().add(btnLeerUsuario);

		btnActualizarUsuario = new JButton(iconoCartel);
		btnActualizarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActualizarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0, 3);
			}
		});
		btnActualizarUsuario.setBackground(new Color(255, 255, 255));
		btnActualizarUsuario.setFont(new Font("Minecraft", Font.PLAIN, 17));
		btnActualizarUsuario.setBounds(201, 329, 175, 90);
		btnActualizarUsuario.setBorder(null);
		getContentPane().add(btnActualizarUsuario);

		btnEliminarUsuario = new JButton(iconoCartel);
		btnEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0, 4);
			}
		});
		btnEliminarUsuario.setBackground(new Color(255, 255, 255));
		btnEliminarUsuario.setFont(new Font("Minecraft", Font.PLAIN, 17));
		btnEliminarUsuario.setBounds(511, 330, 175, 90);
		btnEliminarUsuario.setBorder(null);
		getContentPane().add(btnEliminarUsuario);

		btnAnadirUsuario = new JButton(iconoCartel);
		btnAnadirUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAnadirUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0, 1);
			}
		});
		btnAnadirUsuario.setBackground(new Color(255, 255, 255));
		btnAnadirUsuario.setFont(new Font("Minecraft", Font.PLAIN, 17));
		btnAnadirUsuario.setBorder(null);
		btnAnadirUsuario.setBounds(201, 200, 175, 90);
		getContentPane().add(btnAnadirUsuario);

	}
}
