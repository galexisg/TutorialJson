# Tercera Práctica: Guardar objeto `Producto` serializado en un archivo JSON

## Objetivo
Crear una instancia de la clase `Producto`, asignar valores a sus propiedades (`Id`, `Nombre`, `Categorías`, `Precio`) y **guardar el JSON generado en un archivo físico** en el sistema de archivos.

---

## Paso 1: Asegurar la clase `Producto.java`

Ubicación: `src/main/java/sv/edu/esfe/Producto.java`

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

---

## Paso 2: Crear clase `Main.java` para guardar JSON

Ubicación: `src/main/java/sv/edu/esfe/Main.java`

```java
package sv.edu.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancia del objeto Producto
            Producto producto = new Producto();
            producto.id = 303;
            producto.nombre = "Controlador de carga solar";
            producto.categorias = Arrays.asList("Energía", "Electrónica", "Sostenibilidad");
            producto.precio = 189.75;

            // Crear instancia de ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Guardar el JSON en un archivo físico
            mapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("producto_guardado.json"), producto);

            System.out.println("JSON guardado exitosamente en 'producto_guardado.json'");
        } catch (Exception e) {
            System.out.println("Error al guardar el JSON: " + e.getMessage());
        }
    }
}
```

---

## Paso 3: Verifica el archivo generado

Ubicación esperada: raíz del proyecto  
**Archivo generado:** `producto_guardado.json`

Contenido esperado:

```json
{
  "id" : 303,
  "nombre" : "Controlador de carga solar",
  "categorias" : [ "Energía", "Electrónica", "Sostenibilidad" ],
  "precio" : 189.75
}
```

---

## Reflexión técnica

- Esta práctica permite persistir datos en formato JSON para su uso posterior.
- Es útil para generar fichas técnicas, catálogos, configuraciones o respaldos de objetos.
- Puedes extenderla para guardar múltiples objetos en una lista o integrarla con una API REST.

---
