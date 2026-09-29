/*
 * Proyecto: Inscripcion de Materias (Actividad 02 - TDA en Java)
 * Autor:    Angel Josue Domingo Guillen
 * TDA Alumno: hereda de Persona y agrega matricula, saldo y materias inscritas.
 */
package modelo;

/**
 * Alumno que puede depositar dinero e inscribirse a materias.
 *
 * @author Angel Josue Domingo Guillen
 */
public class Alumno extends Persona {

    public static final int MAX_MATERIAS = 8;

    //  implementación oculta 
    private String matricula;
    private double saldo;
    private Materia[] materias;   // arreglo de tamaño fijo con las materias inscritas
    private int numMaterias;      // cuantas posiciones del arreglo estan ocupadas

    // constructor: única forma de crear el dato 
    public Alumno(String nombre, String matricula, double saldoInicial) {
        super(nombre); // el nombre lo valida Persona
        if (matricula == null || matricula.equals("")) {
            throw new IllegalArgumentException("La matricula no puede estar vacia");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.matricula = matricula;
        this.saldo = saldoInicial;
        this.materias = new Materia[MAX_MATERIAS];
        this.numMaterias = 0;
    }

    //getters y setters 
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.equals("")) {
            throw new IllegalArgumentException("La matricula no puede estar vacia");
        }
        this.matricula = matricula;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public int getNumMaterias() {
        return numMaterias;
    }

    public Materia getMateria(int indice) {
        return materias[indice];
    }

    // operaciones del TDA

    /** Agrega dinero al saldo del alumno. */
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        saldo += monto;
    }

    /** Inscribe al alumno en una materia y le descuenta su costo. */
    public void inscribirse(Materia materia) {
        if (materia == null) {
            throw new IllegalArgumentException("Selecciona una materia");
        }
        if (estaInscrito(materia.getNombre(), 0)) {
            throw new IllegalStateException("Ya estas inscrito en " + materia.getNombre());
        }
        if (numMaterias == MAX_MATERIAS) {
            throw new IllegalStateException("Ya tienes el maximo de " + MAX_MATERIAS + " materias");
        }
        if (materia.getCosto() > saldo) {
            throw new IllegalStateException("Saldo insuficiente para inscribir " + materia.getNombre());
        }
        saldo -= materia.getCosto();
        materias[numMaterias] = materia;
        numMaterias++;
    }

    /**
     * METODO RECURSIVO: suma el costo de las materias inscritas.
     */
    public double calcularTotalMaterias(int indice) {
        if (indice == numMaterias) {          // caso base: ya no quedan materias
            return 0;
        }
        return materias[indice].getCosto() + calcularTotalMaterias(indice + 1); // caso recursivo
    }

    /**
     * METODO RECURSIVO: busca si el alumno ya tiene una materia con ese nombre.
     */
    public boolean estaInscrito(String nombreMateria, int indice) {
        if (indice == numMaterias) {          // caso base: se revisaron todas y no esta
            return false;
        }
        if (materias[indice].getNombre().equals(nombreMateria)) {
            return true;                      // caso base: se encontro
        }
        return estaInscrito(nombreMateria, indice + 1); // caso recursivo
    }

    /** Sobrescribe el metodo de Persona para agregar los datos del alumno. */
    @Override
    public String mostrarDatos() {
        String texto = super.mostrarDatos() + "\n"
                + "Matricula: " + matricula + "\n"
                + "Saldo: $" + String.format("%.2f", saldo) + "\n"
                + "Materias inscritas (" + numMaterias + "/" + MAX_MATERIAS + "):\n";
        for (int i = 0; i < numMaterias; i++) {
            texto += "   " + (i + 1) + ". " + materias[i].mostrarDatos() + "\n";
        }
        texto += "Total en materias: $" + String.format("%.2f", calcularTotalMaterias(0));
        return texto;
    }

    // Lo que se ve en los JComboBox de la ventana
    @Override
    public String toString() {
        return matricula + " - " + getNombre();
    }
}
