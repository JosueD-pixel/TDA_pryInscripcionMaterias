/*
 * Proyecto: Inscripcion de Materias (Actividad 02 - TDA en Java)
 * Autor:    Angel Josue Domingo Guillen
 * TDA Materia: nombre y costo.
 */
package modelo;

/**
 * Representa una materia que un alumno puede inscribir.
 *
 * @author Angel Josue Domingo Guillen
 */
public class Materia {

    //implementación oculta
    private String nombre;
    private double costo;

    // constructor: única forma de crear el dato
    public Materia(String nombre, double costo) {
        if (nombre == null || nombre.equals("")) {
            throw new IllegalArgumentException("El nombre de la materia no puede estar vacio");
        }
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }
        this.nombre = nombre;
        this.costo = costo;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    //opeeracciones del TDA

    /** Cambia el costo de la materia (no se permiten costos de 0 o negativos). */
    public void cambiarCosto(double nuevoCosto) {
        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }
        costo = nuevoCosto;
    }

    /** Aplica un descuento en porcentaje al costo*/
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje <= 0 || porcentaje >= 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 1 y 99 %");
        }
        costo = costo - (costo * porcentaje / 100);
    }

    /** Regresa los datos de la materia en texto. */
    public String mostrarDatos() {
        return "Materia: " + nombre + "  |  Costo: $" + String.format("%.2f", costo);
    }

    // Lo que se ve en los JComboBox de la ventana
    @Override
    public String toString() {
        return nombre + " ($" + String.format("%.2f", costo) + ")";
    }
}
