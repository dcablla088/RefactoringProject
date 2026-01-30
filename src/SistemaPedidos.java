import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class SistemaPedidos {
 // Variables globales mal ubicadas y poco descriptivas
    public static double TASA_IVA = 0.21; // Esto es el IVA
    public static String ARCHIVO_SALIDA = "reporte_pedidos.txt"; // Archivo de salida
    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE PEDIDOS v1.0...");
        // --- CLIENTE 1: Datos dispersos ---
        String nombreCliente = "TechSolutions SL";
        String numeroPedido = "B12345678";
        String nombreDireccion = "Calle Industria 55, Madrid";

        // --- CLIENTE 1: Lista de productos (Arrays paralelos, mala práctica) ---
        ArrayList<String> nombreProductos = new ArrayList<>(); // Nombres productos
        nombreProductos.add("Servidor Dell PowerEdge");
        nombreProductos.add("Licencia Windows Server");
        nombreProductos.add("Cableado Estructurado");

        ArrayList<Double> preciosProductos = new ArrayList<>(); // Precios productos
        preciosProductos.add(2500.00);
        preciosProductos.add(800.00);
        preciosProductos.add(250.50);
        // --- CLIENTE 1: CÁLCULOS (Mezclados con impresión) ---
        double total = 0; // total
        System.out.println("Procesando pedido para: " + nombreCliente);
        System.out.println("ID Cliente: " + numeroPedido);

        for (int i = 0; i < nombreProductos.size(); i++) {
        total = total + preciosProductos.get(i);
        System.out.println("Item " + (i+1) + ": " + nombreProductos.get(i) + " - " +
        preciosProductos.get(i) + " EUR");
        }
        // Lógica de descuento "hardcodeada"
 if (total > 3000) {
 System.out.println("Aplica descuento por gran volumen (5%)");
 total = total * 0.95;
 }
 double totalIva = total + (total * TASA_IVA);
    System.out.println("Total Neto: " + total);
    System.out.println("Total con IVA (" + (TASA_IVA*100) + "%): " + totalIva);
    System.out.println("--------------------------------------------------");
    // --- CLIENTE 1: GUARDADO EN ARCHIVO (Responsabilidad mezclada) ---
    try {
    FileWriter myWriter = new FileWriter("pedido_" + numeroPedido + ".txt");
    myWriter.write("FACTURA\n");
    myWriter.write("Cliente: " + nombreCliente + "\n");
    myWriter.write("Direccion: " + nombreDireccion + "\n");
    myWriter.write("Total a pagar: " + totalIva + "\n");
    myWriter.close();
    System.out.println("Archivo guardado correctamente.");
    } catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
 }
    System.out.println("\n\n"); // Espacios feos
 // ====================================================================
 // --- CLIENTE 2: COPY-PASTE DEL CÓDIGO ANTERIOR (El horror) ---
 // ====================================================================

    String nombreCliente2 = "Libreria Moderna";
    String numeroPedido2 = "A98765432"; 
    String nombreDireccion2 = "Av. Diagonal 200, Barcelona";

    ArrayList<String> nombreProductos2 = new ArrayList<>();
    nombreProductos2.add("Pack Libros Escolares");
    nombreProductos2.add("Estantería Metálica");

    ArrayList<Double> preciosProductos2 = new ArrayList<>();
    preciosProductos2.add(1200.00);
    preciosProductos2.add(300.00);
    double total2 = 0;
    System.out.println("Procesando pedido para: " + nombreCliente2);
     System.out.println("ID Cliente: " + numeroPedido2);

    for (int i = 0; i < nombreProductos2.size(); i++) {
        total2 = total2 + preciosProductos2.get(i);
    System.out.println("Item " + (i+1) + ": " + nombreProductos2.get(i) + " - " +
    preciosProductos2.get(i) + " EUR");
 }
    // Lógica de descuento repetida (y si cambiamos una, la otra se queda desactualizada
    if (total2 > 3000) {
    System.out.println("Aplica descuento por gran volumen (5%)");
    total2 = total2 * 0.95;
}
    double total2_iva = total2 + (total2 * TASA_IVA);
    System.out.println("Total Neto: " + total2);
    System.out.println("Total con IVA (" + (TASA_IVA*100) + "%): " + total2_iva);
    System.out.println("--------------------------------------------------");
try {
    FileWriter myWriter = new FileWriter("pedido_" + numeroPedido2 + ".txt");
    myWriter.write("FACTURA\n");
        myWriter.write("Cliente: " + nombreCliente2 + "\n");
    myWriter.write("Direccion: " + nombreDireccion2 + "\n");
    myWriter.write("Total a pagar: " + total2_iva + "\n");
    myWriter.close();
    System.out.println("Archivo guardado correctamente.");
    } catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
}
}
}
