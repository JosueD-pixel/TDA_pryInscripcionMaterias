/*
 * Proyecto: Inscripcion de Materias (Actividad 02 - TDA en Java)
 * Autor:    Angel Josue Domingo Guillen
 * Clase principal: solo abre la ventana.
 */
package inscripcionmaterias;

import vista.VentanaPrincipal;

/**
 * @author Angel Josue Domingo Guillen
 */
public class InscripcionMaterias {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
