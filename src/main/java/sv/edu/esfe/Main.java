package sv.edu.esfe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Crear mapper indentada
        var mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        // Creacion de  preguntas
        var pregunta1 = new Pregunta(1, "¿Cómo calificaría la atención recibida?", true,
                List.of(
                        new Opcion(1, "Excelente", false),
                        new Opcion(2, "Buena", false),
                        new Opcion(3, "Regular", false),
                        new Opcion(4, "Mala", false)
                ));

        var pregunta2 = new Pregunta(2, "¿Recomendaría nuestros servicios a otras personas?", true,
                List.of(
                        new Opcion(1, "Sí", false),
                        new Opcion(2, "No", false),
                        new Opcion(3, "Tal vez", false)
                ));

        var pregunta3 = new Pregunta(3, "¿Qué aspecto considera que debemos mejorar?", false,
                List.of(
                        new Opcion(1, "Tiempo de respuesta", false),
                        new Opcion(2, "Amabilidad", false),
                        new Opcion(3, "Claridad en la información", false),
                        new Opcion(4, "Otro", false)
                ));

        // Creacion de encuesta con todas las preguntas
        var encuesta = new Encuesta(
                100,
                "Encuesta de Satisfacción al Cliente",
                "2025-09-03",
                List.of(pregunta1, pregunta2, pregunta3)
        );

        //Guardar encuesta en archivo JSON
        File archivo = new File("encuesta.json");
        mapper.writeValue(archivo, encuesta);
        System.out.println("Archivo 'encuesta.json' generado.\n");

        //Leer encuesta desde archivo y mostrar contenido
        var encuestaLeida = mapper.readValue(archivo, new TypeReference<Encuesta>() {});
        System.out.println(encuestaLeida);
    }
}
