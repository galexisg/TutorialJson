package sv.edu.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear encuesta
            Encuesta encuesta = new Encuesta();
            encuesta.id = 100;
            encuesta.titulo = "Encuesta de Satisfacción al Cliente";
            encuesta.fecha = "2025-09-03";

            // Pregunta 1
            Pregunta p1 = new Pregunta();
            p1.id = 1;
            p1.texto = "¿Cómo calificaría la atención recibida?";
            p1.esObligatoria = true;
            p1.opciones = Arrays.asList(
                    crearOpcion(1, "Excelente"),
                    crearOpcion(2, "Buena"),
                    crearOpcion(3, "Regular"),
                    crearOpcion(4, "Mala")
            );

            // Pregunta 2
            Pregunta p2 = new Pregunta();
            p2.id = 2;
            p2.texto = "¿Recomendaría nuestros servicios a otras personas?";
            p2.esObligatoria = true;
            p2.opciones = Arrays.asList(
                    crearOpcion(1, "Sí"),
                    crearOpcion(2, "No"),
                    crearOpcion(3, "Tal vez")
            );

            // Pregunta 3
            Pregunta p3 = new Pregunta();
            p3.id = 3;
            p3.texto = "¿Qué aspecto considera que debemos mejorar?";
            p3.esObligatoria = false;
            p3.opciones = Arrays.asList(
                    crearOpcion(1, "Tiempo de respuesta"),
                    crearOpcion(2, "Amabilidad"),
                    crearOpcion(3, "Claridad en la información"),
                    crearOpcion(4, "Otro")
            );

            encuesta.preguntas = Arrays.asList(p1, p2, p3);

            // Configurar ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Guardar archivo
            File archivo = new File("encuesta.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, encuesta);

            // Mostrar en consola
            System.out.println(" Archivo 'encuesta.json' generado correctamente.");
            System.out.println("\n Encuesta en formato JSON:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(encuesta));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Opciones crearOpcion(int id, String texto) {
        Opciones opcion = new Opciones();
        opcion.id = id;
        opcion.texto = texto;
        opcion.seleccionada = false;
        return opcion;
    }
}
