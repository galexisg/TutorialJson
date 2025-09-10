package sv.edu.esfe;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        /*
        try{
             // Creacion del Objeto
            Producto producto = new Producto();
            producto.id = 1;
            producto.nombre = "Zapatos";
            producto.categorias = Arrays.asList("Vestir", "Tennis");
            producto.precio = 299.99;

            // Serializar
            ObjectMapper mapper = new ObjectMapper();

            String json = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(producto);

            System.out.println("JSON generado:");
            System.out.println(json);

            // Deserializar Lectura de archivo JSON
            Producto productoJSON = mapper.readValue(new File("producto2.json"), Producto.class);
            System.out.println("Archivo JSON: Producto deserializado");
            System.out.println("ID: " + productoJSON.id);
            System.out.println("Nombre: " + productoJSON.nombre);
            System.out.println("Categoria: " + productoJSON.categorias);
            System.out.println("Precio: $ " + productoJSON.precio);

            // Crear el JSON en un archivo físico
            mapper.writerWithDefaultPrettyPrinter().
                    writeValue(new File("producto.json"), producto);
            System.out.println("Archivo JSON creado exitosamente: producto.json");

        } catch (Exception e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
             */

        try {
            // Crear instancia del cliente
            Cliente cliente = new Cliente();
            cliente.id = 1;
            cliente.nombre = "Ana Martinez";
            cliente.correo = "ana.martinez@gmail.com";

            // Crear lista de productos
            Producto p1 = new Producto();
            p1.id = 1;
            p1.nombre = "Laptops";
            p1.categorias = Arrays.asList("Lenovo", "PHP");
            p1.precio = 599.99;

            Producto p2 = new Producto();
            p2.id = 2;
            p2.nombre = "Mouse";
            p2.categorias = Arrays.asList("Gamer", "Oficina");
            p2.precio = 25.00;

            Producto p3 = new Producto();
            p3.id = 3;
            p3.nombre = "Audifonos";
            p3.categorias = Arrays.asList("Con cable", "Inalambricos");
            p3.precio = 19.99;

            // Crear pedido
            Pedido pedido = new Pedido();
            pedido.id = 1;
            pedido.fecha = "2025-07-09";
            pedido.cliente = cliente;
            pedido.productos = Arrays.asList(p1, p2, p3);

            // Crear instancia de Object Mapper
            ObjectMapper mapper = new ObjectMapper();

            // Serielizar y guardar en archivo fisico
            mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File("pedido.json"), pedido);
            System.out.println("Pedido guardado como: pedido.json");

            // Leer y deserializar desde el archivo
            Pedido pedidoLeido = mapper.readValue(new File("pedido.json"), Pedido.class);

            // Mostrar propiedades del pedido deserializado
            System.out.println("Pedido Numero: " + pedidoLeido.id + " - Fecha: " + pedidoLeido.fecha);
            System.out.println("Cliente: " + pedidoLeido.cliente.nombre + " (" + pedidoLeido.cliente.correo + ")");
            System.out.println("Productos: ");

            for (Producto p : pedidoLeido.productos) {
                System.out.println("- " + p.nombre + " | Categorias: " + p.categorias + " | Precio: $ " + p.precio);
            }

        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

    }
}