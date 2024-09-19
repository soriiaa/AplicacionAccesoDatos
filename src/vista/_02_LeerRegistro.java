package vista;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.Modelo;

public class _02_LeerRegistro extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

}
