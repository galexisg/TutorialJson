package sv.edu.esfe;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "id", "fecha", "cliente", "productos" })
public class Pedido {
    public int id;
    public Cliente cliente;
    public List<Producto> productos;
    public String fecha;
}
