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

	//cambia las ventanas de las vistas
	public void cambiarVentana(int desde, int hasta) {
		((JFrame) misVistas[desde]).setVisible(false);
		((JFrame) misVistas[hasta]).setVisible(true);
	}

	//Este método comprueba si existen los Id en el archivo
	public boolean comprobarIdExistente(String id) {
		
		ArrayList<String> listaIdArchivo = miModelo.devolverArrayListId();
		
		if (listaIdArchivo.contains(id)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	//Este metodo inserta un usuario en le archivo, se ejecuta en la primera ventana
	public boolean insertarUsuario(String id, String nombre, String correo) {
		
		String registro = (id + ";" + nombre + ";" + correo);
		return (miModelo.insertarUsuario(registro));
		
	}
	
	//Lee y publica los registros que hay en el archivo
	public ArrayList<String> recogerRegistros() {
		
		ArrayList<String> listaRegistros = miModelo.leerArchivo();
		return listaRegistros;
		
	}
	
	public ArrayList<String> devolverId() {
		ArrayList<String> listaId = miModelo.devolverArrayListId();
		return listaId;
	}
	
	//Con este se edia el registro
	public int editarRegistro(String id, String nombre, String correo) {
		return miModelo.editarRegistro(id, nombre, correo);
	}
	
	//y con este se eliminan os registros del archivo
	public int eliminarRegistro(String id) {
		return miModelo.eliminarRegistro(id);
	}

}
























