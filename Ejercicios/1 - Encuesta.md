# Ejercicio: Encuesta en JSON

## Objetivo
Diseñar una estructura de clases en Java que represente una encuesta institucional. La encuesta debe contener un título, una fecha y una lista de preguntas. Cada pregunta debe incluir un texto, una lista de opciones de respuesta y un indicador de si es obligatoria.

---

## Actividades a realizar

1. Crear las clases `Encuesta`, `Pregunta` y `Opciones` con sus respectivas propiedades.
2. Instanciar una encuesta con al menos dos preguntas.
3. Serializar el objeto `Encuesta` a formato JSON.
4. Guardar el JSON generado en un archivo físico llamado `encuesta.json`.
5. Leer el archivo `encuesta.json` y deserializarlo en un objeto `Encuesta`.
6. Imprimir en consola el contenido de la encuesta deserializada, mostrando:
   - Título y fecha
   - Texto de cada pregunta
   - Opciones disponibles
   - Si la pregunta es obligatoria o no

---

## Resultado esperado en archivo `encuesta.json` (estructura con clase `Opcion`)

```json
{
  "id": 100,
  "titulo": "Encuesta de Satisfacción al Cliente",
  "fecha": "2025-09-03",
  "preguntas": [
    {
      "id": 1,
      "texto": "¿Cómo calificaría la atención recibida?",
      "esObligatoria": true,
      "opciones": [
        { "id": 1, "texto": "Excelente", "seleccionada": false },
        { "id": 2, "texto": "Buena", "seleccionada": false },
        { "id": 3, "texto": "Regular", "seleccionada": false },
        { "id": 4, "texto": "Mala", "seleccionada": false }
      ]
    },
    {
      "id": 2,
      "texto": "¿Recomendaría nuestros servicios a otras personas?",
      "esObligatoria": true,
      "opciones": [
        { "id": 1, "texto": "Sí", "seleccionada": false },
        { "id": 2, "texto": "No", "seleccionada": false },
        { "id": 3, "texto": "Tal vez", "seleccionada": false }
      ]
    },
    {
      "id": 3,
      "texto": "¿Qué aspecto considera que debemos mejorar?",
      "esObligatoria": false,
      "opciones": [
        { "id": 1, "texto": "Tiempo de respuesta", "seleccionada": false },
        { "id": 2, "texto": "Amabilidad", "seleccionada": false },
        { "id": 3, "texto": "Claridad en la información", "seleccionada": false },
        { "id": 4, "texto": "Otro", "seleccionada": false }
      ]
    }
  ]
}
```



## Propósito pedagógico

Esta práctica permite comprender cómo modelar estructuras anidadas en Java, trabajar con listas, aplicar serialización/deserialización con Jackson y manipular archivos JSON. Es útil para simular formularios, encuestas académicas o recolección de datos institucionales.


