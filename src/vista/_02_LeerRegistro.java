package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class _02_LeerRegistro extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblVolver;
	private JTable table;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	
	public _02_LeerRegistro() {
		
		getContentPane().setBackground(new Color(141, 141, 141));
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);
		
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
		lblVolver.setBounds(813, 25, 50, 50);
		getContentPane().add(lblVolver);
		
		ImageIcon fondoLibreriaMinecraft = new ImageIcon(".\\img\\fondoLibreriaMinecraft.jpg");
		
		JPanel panelOcultarFondo = new JPanel();
		panelOcultarFondo.setBounds(813, 25, 50, 50);
		panelOcultarFondo.setBackground(new Color(150,150,150));
		getContentPane().add(panelOcultarFondo);
		
		JLabel lblTitulo = new JLabel("Leer Usuarios");
		lblTitulo.setFont(new Font("Minecraft", Font.PLAIN, 30));
		lblTitulo.setBounds(320, 25, 273, 70);
		getContentPane().add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 174, 326, 170);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblImagenFondo = new JLabel();
		lblImagenFondo.setBounds(-136, 0, 1151, 600);
		getContentPane().add(lblImagenFondo);
		lblImagenFondo.setIcon(fondoLibreriaMinecraft);
		
	}
}
