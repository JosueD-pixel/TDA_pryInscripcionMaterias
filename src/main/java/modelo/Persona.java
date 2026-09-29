/*
 * Proyecto: Inscripcion de Materias (Actividad 02 - TDA en Java)
 * Autor:    Angel Josue Domingo Guillen
 * Clase base de la que hereda Alumno.
 */
package modelo;

/**
 * Clase padre: guarda los datos comunes de cualquier persona.
 *
 * @author Angel Josue Domingo Guillen
 */
public class Persona {

    //implementación oculta
    private String nombre;

    //constructor con validacion
    public Persona(String nombre) {
        if (nombre == null || nombre.equals("")) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.equals("")) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    // regresa los datos en texto (Alumno lo sobrescribe)
    public String mostrarDatos() {
        return "Nombre: " + nombre;
    }
}
