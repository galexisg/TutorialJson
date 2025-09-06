package sv.edu.esfe;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
try {
//OPCIONES
    Opciones  op1 = new Opciones();
    op1.Id = 1;
    op1.texto = "Exelente";
    op1.Seleccionada = false;

    Opciones  op2 = new Opciones();
    op2.Id = 2;
    op2.texto = "Buena";
    op2.Seleccionada = false;


    Opciones  op3 = new Opciones();
    op3.Id = 3;
    op3.texto = "Regular";
    op3.Seleccionada = false;

    Opciones  op4 = new Opciones();
    op4.Id = 4;
    op4.texto = "Mala";
    op4.Seleccionada = false;

    Opciones op11 = new Opciones();
    op11.Id = 1;
    op11.texto = "Si ";
    op11.Seleccionada = false;

    Opciones op12 = new Opciones();
    op12.Id = 2;
    op12.texto = "No";
    op12.Seleccionada = false;

    Opciones op13 = new Opciones();
    op13.Id = 3;
    op13.texto = "Tal vez";
    op13.Seleccionada = false;

    Opciones op111 = new Opciones();
    op111.Id = 1;
    op111.texto = "Tiempo de respuesta";
    op111.Seleccionada = false;
    Opciones op112 = new Opciones();
    op112.Id = 2;
    op112.texto = "Amabilidad";
    op112.Seleccionada = false;
    Opciones op113 = new Opciones();
    op113.Id = 3;
    op113.texto = "Claridad en la informacion";
    op113.Seleccionada = false;
    Opciones op114 = new Opciones();
    op114.Id = 4;
    op114.texto = "Otro";
    op114.Seleccionada = false;

//Preguntas

  Preguntas  p1 = new Preguntas();
    p1.Id = 1;
    p1.texto = "¿Como calificaria la atencion recibida?";
    p1.EsObligatoria = true;
    p1.Opciones = Arrays.asList(op1,op2,op3,op4);
    // Opciones


   Preguntas P2 = new Preguntas();
    P2.Id = 2;
    P2.texto = "¿Recomendaría nuestros servicios a otras personas?";
    P2.EsObligatoria = true;
    P2.Opciones = Arrays.asList(op11,op12,op13);



  Preguntas  P3 = new Preguntas();
    P3.Id = 3;
    P3.texto = "¿Qué aspecto considera que debemos mejorar?";
    P3.EsObligatoria = true;
    P3.Opciones = Arrays.asList(op111,op112,op113,op114);


    //Crear Encuesta
    Encuesta encuesta = new Encuesta();
    encuesta.Id = 100;
    encuesta.Titulo = "Encuesta de satisfaccion al cliente";
    encuesta.Preguntas = Arrays.asList(p1,P2,P3);
    encuesta.Fecha = "2025-09-03";


    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(encuesta);

    // Crear instancia de ObjectMapper
    System.out.println("JSON Generado: ");
    System.out.println(json);
    System.out.println("---------------------------------");
    // Serializar y guardar en archivo físico
    mapper
            .writerWithDefaultPrettyPrinter()
            .writeValue(new File("Encuesta.json"),encuesta);
    System.out.println("Encuesta Guardada en: Encuesta.json");


}catch (Exception e){
    System.out.println("Error al serializar" + e.getMessage());


}
}}