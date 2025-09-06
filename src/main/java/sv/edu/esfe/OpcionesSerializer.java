package sv.edu.esfe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class OpcionesSerializer extends JsonSerializer<List<Opcion>> {

    @Override
    public void serialize(List<Opcion> opciones, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeRaw("[\n"); // apertura con salto de línea
        for (int i = 0; i < opciones.size(); i++) {
            Opcion op = opciones.get(i);
            gen.writeRaw("    { \"id\": " + op.id + ", \"texto\": \"" + op.texto + "\", \"seleccionada\": " + op.seleccionada + " }");
            if (i < opciones.size() - 1) {
                gen.writeRaw(",\n"); // salto entre opciones
            } else {
                gen.writeRaw("\n"); // salto antes de cerrar array
            }
        }
        gen.writeRaw("]");
    }
}