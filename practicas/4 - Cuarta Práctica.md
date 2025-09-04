# Cuarta Práctica: Serializar, guardar y deserializar un `Pedido` con `Cliente` y lista de `Producto`

## Objetivo
Modelar una estructura compuesta por las clases `Pedido`, `Cliente` y `Producto`. El objetivo es crear un pedido completo en Java, **serializarlo a formato JSON**, **guardarlo en un archivo físico** y luego **leer ese archivo para deserializarlo** y mostrar sus propiedades en consola.

---

## Paso 1: Crear las clases necesarias

### Clase `Producto.java`

```java
package sv.edu.esfe;

import java.util.List;

public class Producto {
    public int id;
    public String nombre;
    public List<String> categorias;
    public double precio;
}
```

### Clase `Cliente.java`

```java
package sv.edu.esfe;

public class Cliente {
    public int id;
    public String nombre;
    public String correo;
}
```

### Clase `Pedido.java`

```java
package sv.edu.esfe;

import java.util.List;

public class Pedido {
    public int id;
    public Cliente cliente;
    public List<Producto> productos;
    public String fecha;
}
```

---

## Paso 2: Crear clase `Main.java` para serializar, guardar y deserializar

```java
package sv.edu.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancia del cliente
            Cliente cliente = new Cliente();
            cliente.id = 501;
            cliente.nombre = "Ana Martínez";
            cliente.correo = "ana.martinez@esfe.edu.sv";

            // Crear lista de productos
            Producto p1 = new Producto();
            p1.id = 101;
            p1.nombre = "Panel Solar";
            p1.categorias = Arrays.asList("Energía", "Renovable");
            p1.precio = 299.99;

            Producto p2 = new Producto();
            p2.id = 102;
            p2.nombre = "Inversor Solar";
            p2.categorias = Arrays.asList("Electrónica", "Energía");
            p2.precio = 499.50;

            // Crear pedido
            Pedido pedido = new Pedido();
            pedido.id = 1001;
            pedido.fecha = "2025-09-03";
            pedido.cliente = cliente;
            pedido.productos = Arrays.asList(p1, p2);

            // Crear instancia de ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Serializar y guardar en archivo físico
            mapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("pedido_guardado.json"), pedido);

            System.out.println("Pedido guardado en 'pedido_guardado.json'");

            // Leer y deserializar desde el archivo
            Pedido pedidoLeido = mapper.readValue(new File("pedido_guardado.json"), Pedido.class);

            // Mostrar propiedades del pedido deserializado
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
```

---

## Paso 3: Archivo generado

**Nombre:** `pedido_guardado.json`  
**Ubicación:** raíz del proyecto

Contenido esperado:

```json
{
  "id" : 1001,
  "fecha" : "2025-09-03",
  "cliente" : {
    "id" : 501,
    "nombre" : "Ana Martínez",
    "correo" : "ana.martinez@esfe.edu.sv"
  },
  "productos" : [
    {
      "id" : 101,
      "nombre" : "Panel Solar",
      "categorias" : [ "Energía", "Renovable" ],
      "precio" : 299.99
    },
    {
      "id" : 102,
      "nombre" : "Inversor Solar",
      "categorias" : [ "Electrónica", "Energía" ],
      "precio" : 499.5
    }
  ]
}
```

---

## Reflexión técnica

- Esta práctica integra serialización, persistencia en archivo y deserialización en un solo flujo.
- Es útil para modelar pedidos, formularios, encuestas o fichas técnicas institucionales.
- Puedes extenderla para validar datos, generar reportes o integrarla en una API REST.

---
