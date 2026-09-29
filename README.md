# Inscripción de Materias — Actividad 02 (TDA en Java)

**Autor:** Angel Josue Domingo Guillen

Aplicación de escritorio en Java (Swing, NetBeans) donde un alumno se registra con su
nombre, matrícula y saldo, deposita dinero y se inscribe a materias.

## Clases
| Clase | Qué hace |
|---|---|
| `modelo.Persona` | Clase padre con el nombre (validado). |
| `modelo.Alumno` | Hereda de `Persona`. Matrícula, saldo y arreglo de hasta 8 materias. |
| `modelo.Materia` | Nombre y costo. |
| `vista.VentanaPrincipal` | Ventana hecha con el diseñador de NetBeans. |
| `inscripcionmaterias.InscripcionMaterias` | Clase principal (`main`). |

## Métodos de lógica del TDA
- `Alumno.depositar(monto)`
- `Alumno.inscribirse(materia)`: valida que no esté inscrito, el límite de materias y el saldo.
- `Alumno.calcularTotalMaterias(indice)`: **recursivo**, suma el costo de las materias inscritas.
- `Alumno.estaInscrito(nombre, indice)`: **recursivo**, busca una materia en el arreglo.
- `Materia.cambiarCosto(nuevoCosto)`
- `Materia.aplicarDescuento(porcentaje)`

## Cómo ejecutarlo
Abrir la carpeta en NetBeans (**File → Open Project**) y dar **Run**. Requiere JDK 17 o superior.
