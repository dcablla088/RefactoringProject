import java.util.ArrayList;

public class Pedido {
    private static final double DESCUENTO = 0.95;
    private static final double IVA = 0.21;

    private Cliente cliente;
    private ArrayList<Producto> listaProductos = new ArrayList<>();    
    
    
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getlistaProductos(){
    return listaProductos;
    }
    
    public Double calcularSubtotal() {
        double subtotal = 0;
   
                for (Producto producto : listaProductos) {
                    subtotal = subtotal + producto.getPrecio();
                }
                return subtotal;
    }


    public double calcularDescuento () {
        double subtotal = calcularSubtotal();

        subtotal = subtotal * DESCUENTO;
    
        return subtotal;
    }

    public boolean aplicaDescuento (){
        double subtotal = calcularSubtotal();
        if (subtotal > 3000) {
            return true;
        }else{
            return false;
        }
    }

    public double aplicarSubtotalConIva () {
        double subtotal = calcularSubtotal();

            subtotal = subtotal + (subtotal * IVA);
    
        return subtotal;
    }

}
