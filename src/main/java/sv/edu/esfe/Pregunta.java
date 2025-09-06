package sv.edu.esfe;

import java.util.List;

// Representa una pregunta de la encuesta
public record Pregunta(int id, String texto, boolean esObligatoria, List<Opcion> opciones) {

    // Devuelve la pregunta en texto, indicando si es obligatoria y listando sus opciones
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("")
                .append(texto)
                .append(esObligatoria ? " [Obligatoria]\n" : " [Opcional]\n");
        opciones.forEach(o -> sb.append("   - ").append(o).append("\n")); // agrega cada opción
        return sb.toString();
    }
}
