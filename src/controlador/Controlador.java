package controlador;

import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;

public class Controlador {

	private Modelo miModelo;
	private Vista[] misVistas;

	public Controlador() {
		super();
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void cambiarVentana(int desde, int hasta) {
		((JFrame) misVistas[desde]).setVisible(false);
		((JFrame) misVistas[hasta]).setVisible(true);
	}

	public boolean comprobarIdExistente(String id) {
		
		ArrayList<String> listaIdArchivo = miModelo.devolverArrayListId();
		
		if (listaIdArchivo.contains(id)) {
			return true;
		} else {
			return false;
		}
		
	}

	public boolean insertarUsuario(String id, String nombre, String correo) {
		
		String registro = (id + ";" + nombre + ";" + correo);
		return (miModelo.insertarUsuario(registro));
		
	}

}
























