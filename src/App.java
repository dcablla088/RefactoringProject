import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static final double IVA = 0.21;
    public static String f = "reporte_pedidos.txt";        
    
    public static void main(String[] args) throws Exception {
        Cliente cliente1 = new Cliente("TechSolutions SL", "B12345678", "Calle Industria 55, Madrid");
        Pedido pedido1 = new Pedido(cliente1);
        
        pedido1.agregarProducto(new Producto("Servidor Dell PowerEdge", 2500.00));
        pedido1.agregarProducto(new Producto("Licencia Windows Server", 800.00));
        pedido1.agregarProducto(new Producto("Cableado Estructurado", 250.50));
        
        procesarPedido(pedido1);

        
        System.out.println("\n\n");
        
        // --- CLIENTE 2 ---
        Cliente cliente2 = new Cliente("Libreria Moderna", "A98765432", "Av. Diagonal 200, Barcelona");
        Pedido pedido2 = new Pedido(cliente2);
        pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.00));
        pedido2.agregarProducto(new Producto("Estantería Metálica", 300.00));
        
        procesarPedido(pedido2);

    }
    private static void procesarPedido(Pedido pedido){
        imprimirPedido(pedido);
        generarFicheroPedido(pedido);
    }

    private static void imprimirPedido(Pedido pedido) {
        System.out.println(String.format("Procesando pedido para: %s", pedido.getCliente().getNombre()));
        System.out.println(String.format("ID Cliente: %s", pedido.getCliente().getId()));
        
        for (int i = 0; i < pedido.getListaProductos().size(); i++) {
            System.out.println(String.format("Item %d: %s - %.2f EUR", 
                (i + 1), 
                pedido.getListaProductos().get(i).getNombre(), 
                pedido.getListaProductos().get(i).getPrecio()));
        }
        
        if (pedido.aplicaDescuento()) {
            System.out.println("Aplica descuento por gran volumen (5%)");
        }
        
        System.out.println(String.format("Total Neto: %.2f", pedido.getTotalNeto()));
        System.out.println(String.format("Total con IVA (%.0f%%): %.2f", 
            IVA * 100, 
            pedido.aplicarSubtotalConIva()));
        System.out.println("--------------------------------------------------");
    }
    
    private static void generarFicheroPedido(Pedido pedido) {
        String nombreArchivo = "pedido_" + pedido.getCliente().getId() + ".txt";
        
        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write("FACTURA\n");
            writer.write("Cliente: " + pedido.getCliente().getNombre() + "\n");
            writer.write("Direccion: " + pedido.getCliente().getDireccion() + "\n");
            writer.write(String.format("Total a pagar: %.2f\n", pedido.aplicarSubtotalConIva()));
            writer.close();
            System.out.println("Archivo guardado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
            e.printStackTrace();
        }
    }
}