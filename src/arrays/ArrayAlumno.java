package arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Alumno;

public class ArrayAlumno {
	private ArrayList <Alumno> arrAlumno; 
	
	public ArrayAlumno () {
		arrAlumno = new ArrayList <Alumno> ();
		cargarAlumnos();
	}
	
	public int tamanio () {
		return arrAlumno.size();
	}
	public void adicionar(Alumno x) {
		arrAlumno.add(x);
		grabarAlumnos();
	}
	public Alumno obtener (int i) {
		return arrAlumno.get(i);
	}
	public Alumno buscarCod(String codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getCodAlumno().equals(codigo))
				return obtener(i);
		}
		return null;
	}
	public Alumno buscarDNI(String DNI) {
		for (int i=0; i<tamanio(); i++) {
			String alumnoDni = obtener(i).getDni();
			if (alumnoDni.equals(DNI))
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Alumno x) {
		arrAlumno.remove(x);
		grabarAlumnos();
	}
	public void actulizarArchivos() {
		grabarAlumnos();
	}
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String line;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				line = (x.getCodAlumno() + ";" +
						x.getDni() + ";" +
						x.getNombres() + ";" + 
						x.getApellidos() + ";" +
						x.getEdad() + ";" + 
						x.getEstado() + ";" +
						x.getCelular());
				pw.println(line);
			}
			pw.close();
		}
		catch (Exception e) {}
	}
	
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String line;
			String codigoStr, dni, nombre, apellido;
			int celular, estado, edad;
			String [] s;
			
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while ((line = br.readLine()) != null) {
				s = line.split(";");
				//codigoInt = Integer.parseInt(s[0].trim().substring(1));
				codigoStr = s[0].trim().toString();
				dni = s[1].trim().toString();
				nombre = s[2].trim().toString();
				apellido = s[3].trim().toString();
				edad = Integer.parseInt(s[4].trim());
				estado = Integer.parseInt(s[5].trim());
				celular = Integer.parseInt(s[6].trim());
				adicionar(new Alumno (codigoStr, nombre, apellido, dni, edad, celular, estado));
			}
			br.close();
		}
		catch (Exception e) {}
	}
	public String codigoCorrelativo() {
		if (tamanio() == 0)
			return "A"+20210001;
		else {
			int codigoInt = Integer.parseInt(obtener(tamanio()-1).getCodAlumno().replace("A", ""));
			//int codigoInt 
			return ("A"+(codigoInt+1));
		}
	}
	public int FijamosEstado() {
		return 0;
	}
}
//nub

