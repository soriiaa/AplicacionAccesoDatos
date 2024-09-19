package controlador;

import modelo.Modelo;
import vista.Vista;


public class Main {

	public static void main(String[] args) {
		
		Modelo miModelo = new Modelo();
		Vista[] misVistas = new Vista[19];
		Controlador miControlador = new Controlador();

		miModelo.setVista(misVistas);
		miControlador.setVista(misVistas);
		miControlador.setModelo(miModelo);
		
		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}
	}
	
}
