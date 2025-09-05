package sv.edu.esfe;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;

public class Pregunta {
    public int id;
    public String texto;
    public boolean esObligatoria;

    @JsonSerialize(using = OpcionesSerializer.class)
    public List<Opciones> opciones;
}
