package arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Curso;

public class ArrayCurso {
	private ArrayList <Curso> arrCurso;
	
	public ArrayCurso () {
		arrCurso = new ArrayList <Curso> ();
		cargarCurso();
	}
	public void adicionar(Curso x) {
		arrCurso.add(x);
		grabarCurso();
	}
	public int tamanio () {
		return arrCurso.size();
	}
	public Curso obtener(int i) {
		return arrCurso.get(i);
	}
	public Curso buscar(String codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodCurso().equals(codigo))
				return obtener(i);
		return null;
	}
	public void eliminar(Curso x) {
		arrCurso.remove(x);
		grabarCurso();
	}
	
	public void actualizarArchivo() {
		grabarCurso();
	}
	private void grabarCurso() {
		try {
			PrintWriter pw;
			String line;
			Curso x;
			pw = new PrintWriter(new FileWriter("curso.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				line = (x.getCodCurso() + ";" +
						x.getAsignatura() + ";" +
						x.getCiclo() + ";" + 
						x.getCreditos() + ";" +
						x.getHoras());
				pw.println(line);
			}
			pw.close();
		}
		catch (Exception e) {}
	}
	
	private void cargarCurso() {
		try {
			BufferedReader br;
			String line;
			String codigoStr, asignatura;
			int ciclo, creditos, horas;
			String [] s;
			
			br = new BufferedReader(new FileReader("curso.txt"));
			while ((line = br.readLine()) != null) {
				s = line.split(";");
				codigoStr = s[0].trim().toString();
				asignatura = s[1].trim().toString();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				adicionar(new Curso (codigoStr, asignatura, ciclo, creditos, horas));
			}
			br.close();
		}
		catch (Exception e) {}
	}
	
	//	Codigo correlativo
	public String codigoCorrelativo() {
		if (tamanio() == 0) {
			return "C"+10001;
		}
		else {
			int codigoInt = Integer.parseInt(obtener(tamanio() - 1).getCodCurso().replace("C", ""));
			return ("C"+(codigoInt + 1));
		}
	}
}
