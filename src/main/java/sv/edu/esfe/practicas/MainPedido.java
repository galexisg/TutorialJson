package sv.edu.esfe.practicas;

import com.fasterxml.jackson.databind.ObjectMapper;
import sv.edu.esfe.model.Cliente;
import sv.edu.esfe.model.Pedido;
import sv.edu.esfe.model.Producto;

import java.io.File;
import java.util.Arrays;

public class MainPedido {
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.id = 501;
            cliente.nombre = "Ana Martínez";
            cliente.correo = "ana.martinez@esfe.edu.sv";

            Producto p1 = new Producto();
            p1.id = 101; p1.nombre = "Panel Solar";
            p1.categorias = Arrays.asList("Energía", "Renovable");
            p1.precio = 299.99;

            Producto p2 = new Producto();
            p2.id = 102; p2.nombre = "Inversor Solar";
            p2.categorias = Arrays.asList("Electrónica", "Energía");
            p2.precio = 499.50;

            Pedido pedido = new Pedido();
            pedido.id = 1001;
            pedido.fecha = "2025-09-03";
            pedido.cliente = cliente;
            pedido.productos = Arrays.asList(p1, p2);

            ObjectMapper mapper = new ObjectMapper();
            File archivo = new File("pedido_guardado.json");

            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, pedido);
            System.out.println("Pedido guardado en '" + archivo.getName() + "'");

            Pedido pedidoLeido = mapper.readValue(archivo, Pedido.class);
            System.out.println("Pedido #" + pedidoLeido.id + " - Fecha: " + pedidoLeido.fecha);
            System.out.println("Cliente: " + pedidoLeido.cliente.nombre + " (" + pedidoLeido.cliente.correo + ")");
            System.out.println("Productos:");
            for (Producto p : pedidoLeido.productos) {
                System.out.println("- " + p.nombre + " | Categorías: " + p.categorias + " | Precio: $" + p.precio);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
