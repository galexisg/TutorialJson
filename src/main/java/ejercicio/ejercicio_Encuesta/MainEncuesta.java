package ejercicio.ejercicio_Encuesta;

import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicio.model.Encuesta;
import ejercicio.model.Opcion;
import ejercicio.model.Pregunta;

import java.io.File;
import java.util.Arrays;

public class MainEncuesta {
    public static void main(String[] args) {
        try {
            // Crear instancia de Opciones
            Opcion opcion1 = new Opcion();
            opcion1.id = 1;
            opcion1.texto = "Excelente";
            opcion1.selecionada = false;

            Opcion opcion2 = new Opcion();
            opcion2.id = 2;
            opcion2.texto = "Buena";
            opcion2.selecionada = false;

            Opcion opcion3 = new Opcion();
            opcion3.id = 3;
            opcion3.texto = "Regular";
            opcion3.selecionada = false;

            Opcion opcion4 = new Opcion();
            opcion4.id = 4;
            opcion4.texto = "Mala";
            opcion4.selecionada = false;

            // Crear instancia de Pregunta 1
            Pregunta pregunta1 = new Pregunta();
            pregunta1.id = 1;
            pregunta1.texto = "¿Como calificarias la atención recibida?";
            pregunta1.esObligatoria = true;
            pregunta1.opciones = Arrays.asList(opcion1,opcion2,opcion3,opcion4);

            // Crear instancia de Opciones de pregunta 2
            Opcion opc1 = new Opcion();
            opc1.id = 1;
            opc1.texto = "Si";
            opc1.selecionada = false;

            Opcion opc2 = new Opcion();
            opc2.id = 2;
            opc2.texto = "No";
            opc2.selecionada = false;

            Opcion opc3 = new Opcion();
            opc3.id = 3;
            opc3.texto = "Talvez";
            opc3.selecionada = false;

            // Crear instancia de Pregunta 2
            Pregunta pregunta2 = new Pregunta();
            pregunta2.id = 2;
            pregunta2.texto = "¿Recomendaría nuestros servicios a otras personas?";
            pregunta2.esObligatoria = true;
            pregunta2.opciones = Arrays.asList(opc1,opc2,opc3);

            // Crear instancia de Opciones de pregunta 3
            Opcion opci1 = new Opcion();
            opci1.id = 1;
            opci1.texto = "Tiempo de Respuesta";
            opci1.selecionada = false;

            Opcion opci2 = new Opcion();
            opci2.id = 2;
            opci2.texto = "Amabilidad";
            opci2.selecionada = false;

            Opcion opci3 = new Opcion();
            opci3.id = 3;
            opci3.texto = "Claridad de la Información";
            opci3.selecionada = false;

            Opcion opci4 = new Opcion();
            opci4.id = 4;
            opci4.texto = "Otro";
            opci4.selecionada = false;

            // Crear instancia de Pregunta 2
            Pregunta pregunta3 = new Pregunta();
            pregunta3.id = 3;
            pregunta3.texto = "¿Qué aspecto considera que debemos mejorar?";
            pregunta3.esObligatoria = false;
            pregunta3.opciones = Arrays.asList(opci1,opci2,opci3, opci4);

            // Crear encuesta
            Encuesta encuesta = new Encuesta();
            encuesta.id = 100;
            encuesta.titulo = "Encuesta de Satisfacción al Cliente";
            encuesta.fecha = "2025-09-07";
            encuesta.preguntas = Arrays.asList(pregunta1, pregunta2, pregunta3);

            // Crear instancia de Object Mapper
            ObjectMapper mapper = new ObjectMapper();

            // Serielizar para guardar json fisico
            mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File("encuesta.json"), encuesta);
            System.out.println("Encuesta guardada correctamente como: encuesta.json");

            //Leer y deserializar desde el archivo json
            Encuesta encuestaPasada = mapper.readValue(new File("encuesta.json"), Encuesta.class);

            System.out.println("Archivo JSON: Encuesta deserializada");
            System.out.println("ID: " + encuestaPasada.id);
            System.out.println("Titulo: " + encuestaPasada.titulo);
            System.out.println("Fecha: " + encuestaPasada.fecha);
            System.out.println("Preguntas: ");

            for (Pregunta pregunta : encuestaPasada.preguntas) {
                System.out.println("Pregunta " + pregunta.id + ": " + pregunta.texto + " (Obligatoria: " + pregunta.esObligatoria + ")");
                for (Opcion opcion : pregunta.opciones) {
                    System.out.println("   - " + opcion.id + ". " + opcion.texto + " [Seleccionada: " + opcion.selecionada + "]");
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}

