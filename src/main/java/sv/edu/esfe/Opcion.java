
package sv.edu.esfe;

// Opción de una pregunta con ID, texto y estado de selección
public record Opcion(int id, String texto, boolean seleccionada) {

    // Devuelve la opción en texto indicando si está seleccionada
    @Override
    public String toString() {
        return id + ". " + texto + (seleccionada ? " (seleccionada)" : "");
    }
}
