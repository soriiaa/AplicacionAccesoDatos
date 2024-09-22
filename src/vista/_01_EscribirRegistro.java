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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

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
	private JLabel lblErrorIdNumero;
	private JLabel lblErrorPuntoComa;
	private JPanel panelErrorPuntoComa;
	private JPanel panelErrorId;
	private JLabel lblImagenFondo;
	private JPanel panelErrorIdRepetido;
	private JLabel lblErrorIdRepetido;
	private JLabel lblTick;
	private JLabel lblErrorGeneral;

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
		lblTitulo.setBounds(190, 38, 277, 38);
		getContentPane().add(lblTitulo);

		

		lblVolver = new JLabel("");
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblVolver.setBackground(new Color(200, 200, 200));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				reiniciarPagina();
				miControlador.cambiarVentana(1, 0);
			}
		});
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.setBackground(new Color(0, 0, 0));
		lblVolver.setBounds(802, 38, 50, 50);
		getContentPane().add(lblVolver);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblId.setBounds(168, 273, 24, 19);
		getContentPane().add(lblId);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblNombre.setBounds(365, 273, 67, 19);
		getContentPane().add(lblNombre);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Minecraft", Font.PLAIN, 15));
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
		txtId.setBorder(BorderFactory.createCompoundBorder(txtId.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtId.setColumns(10);
		getContentPane().add(txtId);
		
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
		txtNombre.setBorder(BorderFactory.createCompoundBorder(txtNombre.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
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
		txtCorreo.setBorder(BorderFactory.createCompoundBorder(txtCorreo.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		getContentPane().add(txtCorreo);
		
		ImageIcon fondoDiferentesPersonajes = new ImageIcon(".\\img\\fondoDiferentesPersonajes.jpg");
		
		panelErrorId = new JPanel();
		panelErrorId.setBounds(302, 356, 282, 29);
		panelErrorId.setVisible(false);
		getContentPane().add(panelErrorId);
		
		lblErrorIdNumero = new JLabel("El ID debe ser numerico");
		lblErrorIdNumero.setForeground(new Color(255, 0, 0));
		lblErrorIdNumero.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblErrorIdNumero.setVisible(false);
		panelErrorId.add(lblErrorIdNumero);
		
		panelErrorPuntoComa = new JPanel();
		panelErrorPuntoComa.setBounds(302, 395, 282, 29);
		panelErrorPuntoComa.setVisible(false);
		getContentPane().add(panelErrorPuntoComa);
		
		lblErrorPuntoComa = new JLabel("No se permite introducir \";\"");
		lblErrorPuntoComa.setForeground(new Color(255, 0, 0));
		lblErrorPuntoComa.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblErrorPuntoComa.setVisible(false);
		panelErrorPuntoComa.add(lblErrorPuntoComa);
		
		btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean pelar = false;
				if (txtId.getText().matches("\\d+") && (!txtNombre.getText().matches(".*;.*")) && (!txtCorreo.getText().matches(".*;.*"))) {
					panelErrorId.setVisible(false);
					panelErrorPuntoComa.setVisible(false);
					panelErrorIdRepetido.setVisible(false);
					lblErrorIdNumero.setVisible(false);
					lblErrorPuntoComa.setVisible(false);
					lblErrorIdRepetido.setVisible(false);
					lblErrorGeneral.setVisible(false);
					
					boolean repetido;
					repetido = miControlador.comprobarIdExistente(txtId.getText());
					if (repetido) {
						panelErrorIdRepetido.setVisible(true);
						lblErrorIdRepetido.setVisible(true);
					} else {
						boolean introducidoCorrectamente;
						introducidoCorrectamente = miControlador.insertarUsuario(txtId.getText(), txtNombre.getText(), txtCorreo.getText());
						if (!introducidoCorrectamente) {
							reiniciarPagina();
							lblErrorGeneral.setVisible(true);
						} else {
							reiniciarPagina();
							lblTick.setVisible(true);
							pelar = true;
						}
					}
				}
				
				if ((!txtId.getText().matches("\\d+")) && (pelar == false)) {
					panelErrorId.setVisible(true);
					lblErrorIdNumero.setVisible(true);
				}
				
				if ((txtNombre.getText().matches(".*;.*")) || (txtCorreo.getText().matches(".*;.*"))) {
					panelErrorPuntoComa.setVisible(true);
					lblErrorPuntoComa.setVisible(true);
				}
			}
		});
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
		btnAnadir.setBounds(379, 473, 134, 50);
		btnAnadir.setBorder(null);
		btnAnadir.setEnabled(false);
		btnAnadir.setVisible(true);
		getContentPane().add(btnAnadir);
		
		panelErrorIdRepetido = new JPanel();
		panelErrorIdRepetido.setBounds(302, 434, 282, 29);
		panelErrorIdRepetido.setVisible(false);
		getContentPane().add(panelErrorIdRepetido);
		
		lblErrorIdRepetido = new JLabel("El ID escrito ya existe");
		panelErrorIdRepetido.add(lblErrorIdRepetido);
		lblErrorIdRepetido.setForeground(new Color(255, 0, 0));
		lblErrorIdRepetido.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblErrorIdRepetido.setVisible(false);
		
		lblTick = new JLabel("");
		lblTick.setIcon(new ImageIcon(".\\img\\tickVerde.png"));
		lblTick.setBounds(533, 473, 50, 50);
		lblTick.setVisible(false);
		getContentPane().add(lblTick);
		
		lblErrorGeneral = new JLabel("Error");
		lblErrorGeneral.setForeground(new Color(255, 0, 0));
		lblErrorGeneral.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblErrorGeneral.setBounds(533, 486, 67, 29);
		lblErrorGeneral.setVisible(false);
		getContentPane().add(lblErrorGeneral);
		
		lblImagenFondo = new JLabel();
		lblImagenFondo.setBounds(-46, 0, 1067, 600);
		lblImagenFondo.setIcon(fondoDiferentesPersonajes);
		getContentPane().add(lblImagenFondo);

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
	
	public void reiniciarPagina() {
		txtId.setText("");
		txtNombre.setText("");
		txtCorreo.setText("");
		lblErrorIdNumero.setVisible(false);
		lblErrorPuntoComa.setVisible(false);
		lblErrorIdRepetido.setVisible(false);
		panelErrorId.setVisible(false);
		panelErrorPuntoComa.setVisible(false);
		panelErrorIdRepetido.setVisible(false);
		lblTick.setVisible(false);
		lblErrorGeneral.setVisible(false);
	}
}
