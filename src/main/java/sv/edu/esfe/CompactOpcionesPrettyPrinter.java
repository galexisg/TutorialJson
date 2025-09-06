package sv.edu.esfe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import java.io.IOException;

/**
 * PrettyPrinter personalizado:
 * - Compacta SOLO los arrays llamados "opciones".
 * - Mantiene indentación normal para el resto.
 */
public class CompactOpcionesPrettyPrinter extends DefaultPrettyPrinter {

    private boolean dentroDeOpciones = false;

    public CompactOpcionesPrettyPrinter() {
        super();
    }

    @Override
    public DefaultPrettyPrinter createInstance() {
        return new CompactOpcionesPrettyPrinter();
    }

    @Override
    public void writeObjectFieldValueSeparator(JsonGenerator g) throws IOException {
        g.writeRaw(": ");
        if ("\"opciones\"".equals(g.getOutputContext().getCurrentName())) {
            dentroDeOpciones = true;
        } else {
            dentroDeOpciones = false;
        }
    }

    @Override
    public void writeStartArray(JsonGenerator g) throws IOException {
        if (dentroDeOpciones) {
            g.writeRaw(" [ "); // compactar
        } else {
            super.writeStartArray(g);
        }
    }

    @Override
    public void writeEndArray(JsonGenerator g, int nrOfValues) throws IOException {
        if (dentroDeOpciones) {
            g.writeRaw(" ]"); // cerrar compacto
            dentroDeOpciones = false;
        } else {
            super.writeEndArray(g, nrOfValues);
        }
    }
}