package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Modelo;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class _04_EliminarRegistro extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblVolver;
	private JButton btnConfirmar;
	private JComboBox<String> comboBoxId;
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

	public _04_EliminarRegistro() {

		getContentPane().setBackground(new Color(141, 141, 141));
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

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
				miControlador.cambiarVentana(4, 0);
			}
		});
		
		ImageIcon fondoPantalla = new ImageIcon(".\\img\\fondoEliminarUsuarioPuestaDeSol.jpg");
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar Usuario");
		lblEliminarUsuario.setFont(new Font("Minecraft", Font.PLAIN, 30));
		lblEliminarUsuario.setBounds(578, 92, 298, 68);
		lblEliminarUsuario.setFocusable(true);
		getContentPane().add(lblEliminarUsuario);
		
		btnConfirmar = new JButton("Confirmar");
		
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Minecraft", Font.PLAIN, 20));
		btnConfirmar.setBounds(710, 480, 141, 39);
		btnConfirmar.setBorder(null);
		getContentPane().add(btnConfirmar);
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnConfirmar.setBackground(new Color(200, 200, 200));
			}
		});
		
		String[] opciones = { "a" };
		comboBoxId = new JComboBox<>(opciones);
		comboBoxId.setFont(new Font("Minecraft", Font.PLAIN, 20));
		comboBoxId.setBounds(585, 480, 115, 39);
		comboBoxId.setBorder(null);
		comboBoxId.setBackground(new Color(255, 255, 255));
		comboBoxId.setOpaque(true);
		getContentPane().add(comboBoxId);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(535, 480, 40, 39);
		getContentPane().add(panel);

		JLabel lblId = new JLabel("ID");
		panel.add(lblId);
		lblId.setFont(new Font("Minecraft", Font.PLAIN, 20));
		
		lblTick = new JLabel("");
		lblTick.setIcon(new ImageIcon(".\\img\\tickVerde.png"));
		lblTick.setBounds(756, 419, 50, 50);
		lblTick.setVisible(false);
		getContentPane().add(lblTick);
		
		lblErrorGeneral = new JLabel("Error");
		lblErrorGeneral.setForeground(new Color(255, 0, 0));
		lblErrorGeneral.setFont(new Font("Minecraft", Font.PLAIN, 15));
		lblErrorGeneral.setBounds(756, 441, 67, 29);
		lblErrorGeneral.setVisible(false);
		getContentPane().add(lblErrorGeneral);
		
		JLabel lblImagenFondo = new JLabel();
		lblImagenFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirmar.setBackground(new Color(255, 255, 255));
				lblEliminarUsuario.setFocusable(true);
			}
		});
		lblImagenFondo.setBounds(-46, 0, 1067, 600);
		getContentPane().add(lblImagenFondo);
		lblImagenFondo.setIcon(fondoPantalla);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int salidaCodigo = miControlador.eliminarRegistro(comboBoxId.getSelectedItem().toString());
				
				if (salidaCodigo == 0) {
					lblTick.setVisible(true);
				} else {
					lblErrorGeneral.setVisible(true);
				}
				
				ArrayList<String> listaId = miControlador.devolverId();
				String[] arrayId = new String[listaId.size()];
				for (int i = 0; i < listaId.size(); i++) {
					arrayId[i] = listaId.get(i);
				}
				
				comboBoxId.removeAllItems();
				for (int i = 0; i < arrayId.length; i++) {
					comboBoxId.addItem(arrayId[i]);
				}
				
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				ArrayList<String> listaId = miControlador.devolverId();
				String[] arrayId = new String[listaId.size()];
				for (int i = 0; i < listaId.size(); i++) {
					arrayId[i] = listaId.get(i);
				}
				
				comboBoxId.removeAllItems();
				for (int i = 0; i < arrayId.length; i++) {
					comboBoxId.addItem(arrayId[i]);
				}
				
				comprobarCampo();
				
			}
		});

	}
	
	public void comprobarCampo() {
		
		if (comboBoxId.getItemCount() == 0) {
			btnConfirmar.setEnabled(false);
			lblErrorGeneral.setVisible(false);
			lblTick.setVisible(false);
		} else {
			btnConfirmar.setEnabled(true);
			lblErrorGeneral.setVisible(false);
			lblTick.setVisible(false);
		}
		
	}
	
}
