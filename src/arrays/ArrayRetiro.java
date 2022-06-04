package arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Retiro;;

public class ArrayRetiro {
	private ArrayList <Retiro> arrRetiro;
	
	public ArrayRetiro () {
		arrRetiro = new ArrayList <Retiro> ();
		cargarRetiro();
	}
	
	public void adicionar(Retiro x) {
		arrRetiro.add(x);
		grabarRetiro();
	}
	public int tamanio () {
		return arrRetiro.size();
	}
	public Retiro obtener(int i) {
		return arrRetiro.get(i);
	}
	public Retiro buscar(String numero) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getNumRetiro().equals(numero))
				return obtener(i);
		return null;
	}
	public void eliminar(Retiro x) {
		arrRetiro.remove(x);
		grabarRetiro();
	}
	
	public void actualizarArchivo() {
		grabarRetiro();
	}
	private void grabarRetiro() {
		try {
			PrintWriter pw;
			String line;
			Retiro x;
			pw = new PrintWriter(new FileWriter("retiro.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				line = (x.getNumRetiro() + ";" +
						x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora());
				pw.println(line);
			}
			pw.close();
		}
		catch (Exception e) {}
	}
	
	private void cargarRetiro() {
		try {
			BufferedReader br;
			String line;
			String Fecha, Hora;
			String numMatricula, numRetiro;
			String [] s;
			br = new BufferedReader(new FileReader("retiro.txt"));
			while ((line = br.readLine()) != null) {
				s = line.split(";");
				numRetiro = s[0].trim().toString();
				numMatricula = s[1].trim().toString();
				Fecha = s[2].trim().toString();
				Hora = s[3].trim().toString();
				adicionar(new Retiro(numRetiro, numMatricula, Fecha, Hora));
			}
			br.close();
		}
		catch (Exception e) {}
	}
	
	public String codigoCorrelativo() {
		if (tamanio() == 0)
			return "R"+100001;
		else {
			int num = Integer.parseInt(obtener(tamanio()-1).getNumRetiro().replace("R", ""));
			//int codigoInt 
			return ("R"+(num+1));
		}
	}
}
