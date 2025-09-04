# Primera Práctica: Serialización de objeto `Producto` en Java usando Jackson

## Objetivo
Crear una instancia de la clase `Producto`, asignar valores a sus propiedades (`Id`, `Nombre`, `Categorías`, `Precio`) y serializarla a formato JSON utilizando la biblioteca **Jackson**. Mostrar el resultado en consola con formato identado.

---

## Paso 1: Crear el proyecto en IntelliJ IDEA

1. Abrir IntelliJ IDEA → `File → New → Project`
2. Seleccionar `Java` como tipo de proyecto.
3. Elegir `Maven` como sistema de construcción.
4. Asignar nombre: `PracticaJSON`
5. Ubicación sugerida: `Desktop\Ejemplos ciclo 2-2025\MOD17-APIs`
6. Activar la opción `Create Git repository` si deseas control de versiones.
7. En `Advanced Settings`:
   - **GroupId**: `sv.edu.esfe`
   - **ArtifactId**: `PracticaJSON`
8. Clic en `Create`

---

## Paso 2: Configurar el archivo `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" ...>
  <modelVersion>4.0.0</modelVersion>
  <groupId>sv.edu.esfe</groupId>
  <artifactId>PracticaJSON</artifactId>
  <version>1.0-SNAPSHOT</version>

  <properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.15.2</version>
    </dependency>
  </dependencies>
</project>
```

#### ¿Por qué debemos configurar el archivo `pom.xml`?
El archivo pom.xml (Project Object Model) es el corazón de un proyecto Maven. Su función principal es:
- **Gestionar dependencias:** Define qué bibliotecas externas necesita el proyecto (como Jackson).
- **Configurar el entorno de compilación:** Especifica la versión del JDK, codificación, y otras propiedades técnicas.
- **Organizar el ciclo de vida del proyecto:** Desde la compilación hasta la ejecución y empaquetado.

Sin esta configuración, el proyecto no sabría qué herramientas usar ni cómo compilar correctamente el código.

#### ¿Para qué sirve la referencia a Jackson?
Jackson es una biblioteca especializada en el manejo de JSON en Java. Al incluirla en el pom.xml, estamos diciendo:
“Este proyecto necesita Jackson para poder convertir objetos Java en JSON y viceversa.”
La línea que lo hace posible es:

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.15.2</version>
</dependency>
```

Esta dependencia permite:
- Serializar objetos Java a JSON (writeValueAsString)
- Deserializar JSON a objetos Java (readValue)
- Trabajar con estructuras complejas como listas, mapas, objetos anidados, etc.

---

## Paso 3: Crear la clase `Producto.java`

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

## Paso 4: Crear la clase `Main.java` para serializar

Ubicación: `src/main/java/sv/edu/esfe/Main.java`

```java
package sv.edu.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Producto producto = new Producto();
            producto.id = 101;
            producto.nombre = "Panel Solar Fotovoltaico";
            producto.categorias = Arrays.asList("Energía", "Renovable", "Tecnología");
            producto.precio = 299.99;

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(producto);

            System.out.println("JSON generado:");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }
}
```

---

## Paso 5: Resultado esperado en consola

```json
{
  "id" : 101,
  "nombre" : "Panel Solar Fotovoltaico",
  "categorias" : [ "Energía", "Renovable", "Tecnología" ],
  "precio" : 299.99
}
```

---

## Paso 6: Reflexión técnica

- Esta práctica permite comprender cómo se transforma un objeto Java en una estructura JSON legible.
- El uso de `writerWithDefaultPrettyPrinter()` mejora la presentación para validación técnica o revisión académica.
- Puedes extender esta práctica para guardar el JSON en un archivo, enviarlo por red o integrarlo en una API REST.

