package controlador;

import modelo.Modelo;
import vista.Vista;
import vista._00_Inicial;
import vista._01_EscribirRegistro;
import vista._02_LeerRegistro;
import vista._03_ActualizarRegistro;
import vista._04_EliminarRegistro;

public class Main {

	public static void main(String[] args) {

		Modelo miModelo = new Modelo();
		Vista[] misVistas = new Vista[5];
		Controlador miControlador = new Controlador();

		misVistas[0] = new _00_Inicial();
		misVistas[1] = new _01_EscribirRegistro();
		misVistas[2] = new _02_LeerRegistro();
		misVistas[3] = new _03_ActualizarRegistro();
		misVistas[4] = new _04_EliminarRegistro();

		miModelo.setVista(misVistas);
		miControlador.setVista(misVistas);
		miControlador.setModelo(miModelo);

		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}
	}

}
