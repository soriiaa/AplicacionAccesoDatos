package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controlador.Controlador;
import vista.Vista;

public class Modelo {

	private Vista[] misVistas;
	private Controlador miControlador;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public ArrayList<String> devolverArrayListId() {

		ArrayList<String> listaId = new ArrayList<>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader("archivo.txt"));
			String linea;
			String[] categorias;
			while ((linea = lector.readLine()) != null) {
				categorias = linea.split(";");
				listaId.add(categorias[0]);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaId;

	}

	public boolean insertarUsuario(String registro) {

		try {
			FileWriter writer = new FileWriter("archivo.txt", true);
			writer.write(registro + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<String> leerArchivo() {

		ArrayList<String> listaRegistros = new ArrayList<>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader("archivo.txt"));
			String linea;
			String[] categorias;
			while ((linea = lector.readLine()) != null) {
				categorias = linea.split(";");
				listaRegistros.add(categorias[0]);
				listaRegistros.add(categorias[1]);
				listaRegistros.add(categorias[2]);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaRegistros;

	}

}
