package util;

public class Validaciones {
    public static final String CODIGO_PRODUCTO = "[Pp]\b{4}";//P0001 p0001 
    public static final String DNI = "\\d{8}"; // 47853206
    public static final String CODIGO = "[a-zA-ZАИМСЗаимсзяЯ\\n]{1,7}"; // 47853206
    public static final String SUELDO = "\\d{1,100}"; 
    public static final String ASIGNATURA = "[a-zA-ZАИМСЗаимсзяЯ\\n]{1,10}";
    public static final String TEXT = "[a-zA-ZАИМСЗаимсзяЯ\n]{3,15}";
    public static final String NOMBRE = "[a-zA-ZАИМСЗаимсзяЯ\n]{8,40}";
    public static final String APELLIDO = "[a-zA-ZАИМСЗаимсзяЯ\n]{8,40}";
	
}
