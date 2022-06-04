package entidad;

public class Retiro {
	private int idRetiro;
	private String numRetiro, numMatricula, fecha, hora;
	
	public Retiro(String numRetiro, String numMatricula, String fecha, String hora) {
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Retiro() {
		
	}
	
	public void setIdRetiro (int idRetiro) {
		this.idRetiro = idRetiro;
	}
	public int getIdRetiro () {
		return idRetiro;
	}
	public void setNumRetiro (String numRetiro) {
		this.numRetiro = numRetiro;
	}
	public void setNumMatricula (String numMatricula) {
		this.numMatricula = numMatricula;
	}
	public void setFecha (String fecha) {
		this.fecha = fecha;
	}
	public void setHora (String hora) {
		this.hora = hora;
	}
	public String getNumRetiro () {
		return numRetiro;
	}
	public String getNumMatricula () {
		return numMatricula;
	}
	public String getFecha () {
		return fecha;
	}
	public String getHora () {
		return hora;
	}
}
