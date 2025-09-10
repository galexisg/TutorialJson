package sv.edu.esfe.model;

import java.util.List;

public class Pedido {
    public int id;
    public Cliente cliente;
    public List<Producto> productos;
    public String fecha; // ISO yyyy-MM-dd
}
