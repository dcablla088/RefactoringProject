import java.io.FileWriter;
import java.io.IOException;

public class ServicioFacturacion {
    private static final double TASA_IVA = 0.21;
    
    public void procesarPedido(Pedido pedido) {
        // 1. Calcular total neto
        double totalNeto = 0;
        for (Producto producto : pedido.getProductos()) {
            totalNeto += producto.getPrecio();
        }
        
        // 2. Aplicar descuento si corresponde
        if (totalNeto > 3000) {
            System.out.println("Aplica descuento por gran volumen (5%)");
            totalNeto = totalNeto * 0.95;
        }
        
        // 3. Calcular total con IVA
        double totalConIva = totalNeto + (totalNeto * TASA_IVA);
        
        // 4. Mostrar en pantalla
        System.out.println("Procesando pedido para: " + pedido.getCliente().getNombre());
        System.out.println("ID Cliente: " + pedido.getCliente().getId());
        
        int contador = 1;
        for (Producto producto : pedido.getProductos()) {
            System.out.println("Item " + contador + ": " + producto.getNombre() + 
                             " - " + producto.getPrecio() + " EUR");
            contador++;
        }
        
        System.out.println(String.format("Total Neto: %.2f", totalNeto));
        System.out.println(String.format("Total con IVA (%.0f%%): %.2f", TASA_IVA * 100, totalConIva));
        System.out.println("--------------------------------------------------");
        
        // 5. Guardar en archivo
        String nombreArchivo = "pedido_" + pedido.getCliente().getId() + ".txt";
        
        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write("FACTURA\n");
            writer.write("Cliente: " + pedido.getCliente().getNombre() + "\n");
            writer.write("Direccion: " + pedido.getCliente().getDireccion() + "\n");
            writer.write(String.format("Total a pagar: %.2f\n", totalConIva));
            writer.close();
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}