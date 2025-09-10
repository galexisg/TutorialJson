package sv.edu.es.ejercicio;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({ "id", "texto", "seleccionada" })
public class Encuesta {
    public int id;
    public String titulo;
    public String fecha;
    public List<Pregunta> preguntas;
}
