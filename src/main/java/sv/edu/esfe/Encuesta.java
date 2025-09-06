package sv.edu.esfe;

import java.util.List;

// Clase que representa una encuesta con ID, título, fecha y preguntas
public record Encuesta(int id, String titulo, String fecha, List<Pregunta> preguntas) {

    //encuesta con todas sus preguntas en un formato legible
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Encuesta: ")
                .append(titulo)
                .append(" (Fecha: ").append(fecha).append(")\n\n");
        preguntas.forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }
}
