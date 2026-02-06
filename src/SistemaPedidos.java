import java.util.ArrayList;

public class SistemaPedidos {
    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE PEDIDOS v1.0...");
        
        // --- CLIENTE 1 ---
        Cliente cliente1 = new Cliente("TechSolutions SL", "B12345678", "Calle Industria 55, Madrid");
        Pedido pedido1 = new Pedido(cliente1);
        
        pedido1.agregarProducto(new Producto("Servidor Dell PowerEdge", 2500.00));
        pedido1.agregarProducto(new Producto("Licencia Windows Server", 800.00));
        pedido1.agregarProducto(new Producto("Cableado Estructurado", 250.50));
        
        ServicioFacturacion servicio = new ServicioFacturacion();
        servicio.procesarPedido(pedido1);
        
        System.out.println("\n\n");
        
        // --- CLIENTE 2 ---
        Cliente cliente2 = new Cliente("Libreria Moderna", "A98765432", "Av. Diagonal 200, Barcelona");
        Pedido pedido2 = new Pedido(cliente2);
        
        pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.00));
        pedido2.agregarProducto(new Producto("Estantería Metálica", 300.00));
        
        servicio.procesarPedido(pedido2);
    }
}