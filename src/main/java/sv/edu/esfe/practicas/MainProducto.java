package sv.edu.esfe.practicas;

import com.fasterxml.jackson.databind.ObjectMapper;
import sv.edu.esfe.model.Producto;

import java.io.File;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainProducto {
    public static void main(String[] args) {
        try {
            //Creacion del objeto ObjectMapper
            Producto producto = new Producto();
            producto.id = 101;
            producto.nombre = "Laptop";
            producto.categorias = Arrays.asList("Electrónica", "Computadoras");
            producto.precio = 799.99;

            //Serializacion
            ObjectMapper mapper = new ObjectMapper();

            String jsonString = mapper.
                    writerWithDefaultPrettyPrinter().
                    writeValueAsString(producto);

            System.out.println("JSON generado: ");
            System.out.println(jsonString);

            //crear archivo json
            mapper.writerWithDefaultPrettyPrinter().
                    writeValue(new File("producto.json"), producto);
            System.out.println("Archivo JSON creado: producto.json");


            //Lectura de archivo json
            Producto productoJson = mapper.readValue(new File("producto2.json"), Producto.class);
            System.out.println("Producto desde JSON:");
            System.out.println("ID: " + productoJson.id);
            System.out.println("Nombre: " + productoJson.nombre);
            System.out.println("Categorías: " + productoJson.categorias);
            System.out.println("Precio: " + productoJson.precio);


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}