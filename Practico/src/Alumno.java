
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;

public class Alumno extends Persona {

    //Atributos
    private String legajo;
    private List<Cursos> cursosInscritos;
    private boolean accesoDescuento;

    //Constructor
    public Alumno(String nombre, String apellido, String dni, Date crearFecha, int edad) {
        super(nombre, apellido, dni, crearFecha, edad);
        this.cursosInscritos = new ArrayList<>();
    }

    public Alumno(String legajo) {
        this.legajo = legajo;
    }

    //Getter y Setter

    public String getLegajo() {
        return legajo;
    }

    public void setAccesoDescuento(boolean accesoDescuento) {
        this.accesoDescuento = accesoDescuento;
    }

    public List<Cursos> getCursosInscritos() {
        return cursosInscritos;
    }

    public void agregarCursoInscrito(Cursos curso) {
        cursosInscritos.add(curso);
    }

    //Metodos

    public String toString() {
        return "Alumno Nombre = " + this.getNombre() +
                "\nAlumno Apellido = " + this.getApellido() +
                "\nAlumno Dni = " + this.getDni() +
                "\nAlumno Fecha = " + this.getFechaNacimiento() +
                "\nAlumno Edad = " + this.getEdad() +
                "\nAlumno Legajo = " + this.getLegajo();
    }

    //CrearLegajo
    public String generarLegajo(String dni) {
        String ultimoDigito = getDni().substring(getDni().length() - 3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy"); // Obtener los dos primeros dígitos del año actual
        String anio = dateFormat.format(new Date());
        legajo = ultimoDigito + "." + anio;
        return legajo;
    }

    //Descuento
    public boolean tieneAccesoDescuento() {
        System.out.println("Evaluando descuento para " + getNombre() + ": " + (getCursosInscritos().size() > 1));
        return getCursosInscritos().size() > 1;
    }

    public static int cantidadAlumnosConDescuento(List<Alumno> alumnos) {
        int count = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.tieneAccesoDescuento()) {
                count++;
            }
        }
        return count;
    }

}


