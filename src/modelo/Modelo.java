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

	//Con este método el buffer reader lee el archivo y y lo devuelve en la tabla de leer usuarios
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

	//este método utiliza el file writer para escribir los datos del usuario en el archivo
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
	
	//En este método lo que se hace es coger el registro entero y donde se cambia remplazar el archivo con el nuevo modificado, para eso hemos utilizado el filewriter
	public int editarRegistro(String id, String nombre, String correo) {
		
		ArrayList<String> listaRegistros = leerArchivo();
		String[][] listaRegistrosArray = new String[listaRegistros.size() / 3][3];
		int contador = 0;
		
		for (int i = 0; i < listaRegistros.size() / 3; i++) {
			for (int j = 0; j < 3; j++) {
				listaRegistrosArray[i][j] = listaRegistros.get(contador);
				contador++;
			}
		}
		
		for (int i = 0; i < listaRegistrosArray.length; i++) {
			if (listaRegistrosArray[i][0].equals(id)) {
				listaRegistrosArray[i][1] = nombre;
				listaRegistrosArray[i][2] = correo;
			}
		}
		
		try {
			FileWriter writer = new FileWriter("archivo.txt");
			
			for (int i = 0; i < listaRegistrosArray.length; i++) {
				String registro = listaRegistrosArray[i][0] + ";" + listaRegistrosArray[i][1] + ";" + listaRegistrosArray[i][2] + "\n";
				writer.write(registro);
			}
			
			writer.close();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	//Con este metodo eliminamos a los usuarios, el for encuentra el id seleccionado, y con ese id se va recorriendo el archivo hasta encontrar el no deseado
	//Después se crear un nuevo archivo pero sin el usuario deseado, es decir se sobreescribe el archivo para eliminar al deasedo
	public int eliminarRegistro(String id) {
		
		ArrayList<String> listaRegistros = leerArchivo();
		String[][] listaRegistrosArray = new String[listaRegistros.size() / 3][3];
		int contador = 0;
		
		for (int i = 0; i < listaRegistros.size() / 3; i++) {
			for (int j = 0; j < 3; j++) {
				listaRegistrosArray[i][j] = listaRegistros.get(contador);
				contador++;
			}
		}
		
		for (int i = 0; i < listaRegistrosArray.length; i++) {
			if (listaRegistrosArray[i][0].equals(id)) {
				listaRegistrosArray[i][0] = "";
				listaRegistrosArray[i][1] = "";
				listaRegistrosArray[i][2] = "";
			}
		}
		
		try {
			FileWriter writer = new FileWriter("archivo.txt");
			
			for (int i = 0; i < listaRegistrosArray.length; i++) {
				if (!listaRegistrosArray[i][0].equals("")) {
					String registro = listaRegistrosArray[i][0] + ";" + listaRegistrosArray[i][1] + ";" + listaRegistrosArray[i][2] + "\n";
					writer.write(registro);
				}
			}
			
			writer.close();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
