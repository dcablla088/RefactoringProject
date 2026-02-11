import java.util.ArrayList;

public class Pedido {
    private static final double DESCUENTO = 0.95;
    private static final double IVA = 0.21;
    private static final double LIMITE_DESCUENTO = 3000;

    private Cliente cliente;
    private ArrayList<Producto> listaProductos = new ArrayList<>();    
    private double totalNeto;  
    
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.totalNeto = 0; 
    }
    
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getListaProductos(){  
        return listaProductos;
    }
    
    public Double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : listaProductos) {
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    public double calcularTotalNeto() {  
        double subtotal = calcularSubtotal();
        if (aplicaDescuento()) {
            totalNeto = subtotal * DESCUENTO;
        } else {
            totalNeto = subtotal;
        }
        return totalNeto;
    }

    public boolean aplicaDescuento() {
        return calcularSubtotal() > LIMITE_DESCUENTO;
    }

    public double getTotalNeto() {  
        return totalNeto;
    }

    public double aplicarSubtotalConIva() {
        double neto = calcularTotalNeto(); 
        return neto + (neto * IVA);
    }
}