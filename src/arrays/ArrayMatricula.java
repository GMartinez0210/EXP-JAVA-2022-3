package arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Matricula;

public class ArrayMatricula {
	private ArrayList <Matricula> arrMatricula;
	
	public ArrayMatricula () {
		arrMatricula = new ArrayList <Matricula> ();
		cargarMatricula();
	}
	
	public void adicionar(Matricula x) {
		arrMatricula.add(x);
		grabarMatricula();
	}
	public int tamanio () {
		return arrMatricula.size();
	}
	public Matricula obtener(int i) {
		return arrMatricula.get(i);
	}
	public Matricula buscar(String numero) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getNumMatricula().equals(numero))
				return obtener(i);
		return null;
	}
	public void eliminar(Matricula x) {
		arrMatricula.remove(x);
		grabarMatricula();
	}
	
	public void actualizarArchivo() {
		grabarMatricula();
	}
	private void grabarMatricula() {
		try {
			PrintWriter pw;
			String line;
			Matricula x;
			pw = new PrintWriter(new FileWriter("matricula.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				line = (x.getNumMatricula() + ";" +
						x.getCodAlumno() + ";" +
						x.getCodCurso() + ";" + 
						x.getFecha() + ";" +
						x.getHora());
				pw.println(line);
			}
			pw.close();
		}
		catch (Exception e) {}
	}
	
	private void cargarMatricula() {
		try {
			BufferedReader br;
			String line;
			String Fecha, Hora;
			String numMatricula, CodCurso, CodAlumno;
			String [] s;
			
			br = new BufferedReader(new FileReader("matricula.txt"));
			while ((line = br.readLine()) != null) {
				s = line.split(";");
				numMatricula = s[0].trim().toString();
				CodAlumno = s[1].trim().toString();
				CodCurso = s[2].trim().toString();
				Fecha = s[3].trim().toString();
				Hora = s[4].trim().toString();
				adicionar(new Matricula (numMatricula, CodAlumno, CodCurso, Fecha, Hora));
			}
			br.close();
		}
		catch (Exception e) {}
	}
	public String codigoCorrelativo() {
		if (tamanio() == 0)
			return "M"+100001;
		else {
			int num = Integer.parseInt(obtener(tamanio()-1).getNumMatricula().replace("M", ""));
			//int codigoInt 
			return ("M"+(num+1));
		}
	}
	public int FijarEstado() {
		return 1;
	}
}
