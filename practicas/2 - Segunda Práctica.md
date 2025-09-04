# Segunda Práctica: Deserialización de objeto `Producto` desde archivo JSON

## Objetivo
Leer un archivo JSON desde una ubicación en el sistema de archivos y deserializarlo en un objeto de tipo `Producto`. Luego, imprimir las propiedades de este objeto en la consola.

---

## Paso 1: Crear el archivo JSON

Ubica este archivo en la raíz del proyecto o dentro de una carpeta como `data/`.

**Archivo:** `producto.json`

```json
{
  "id": 202,
  "nombre": "Inversor Solar",
  "categorias": ["Energía", "Electrónica", "Renovable"],
  "precio": 499.50
}
```

---

## Paso 2: Asegurar que la clase `Producto.java` esté definida

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

## Paso 3: Crear clase `Main.java` para deserializar

Ubicación: `src/main/java/sv/edu/esfe/Main.java`

```java
package sv.edu.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancia de ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Leer y deserializar el archivo JSON
            Producto producto = mapper.readValue(new File("producto.json"), Producto.class);

            // Imprimir propiedades del objeto deserializado
            System.out.println("Producto deserializado:");
            System.out.println("ID: " + producto.id);
            System.out.println("Nombre: " + producto.nombre);
            System.out.println("Categorías: " + producto.categorias);
            System.out.println("Precio: $" + producto.precio);
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
        }
    }
}
```

---

## Paso 4: Resultado esperado en consola

```plaintext
Producto deserializado:
ID: 202
Nombre: Inversor Solar
Categorías: [Energía, Electrónica, Renovable]
Precio: $499.5
```

---

## Reflexión técnica

- Esta práctica demuestra cómo leer datos estructurados desde un archivo externo.
- La deserialización permite transformar JSON en objetos Java listos para manipulación.
- Es útil para cargar configuraciones, catálogos, encuestas o fichas técnicas desde archivos.

---
