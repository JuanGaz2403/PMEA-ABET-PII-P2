package udla.jgjbmp.pmeaabet;

public class Inventario {

    /**
     * Método para buscar un producto por código
     */
    public static Producto buscarProducto(String codigoProducto) {
        for (Producto p : Producto.getListaProductos()) {
            if (p.getCodigoProducto().equals(codigoProducto)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Método para buscar un producto por nombre
     * Busca coincidencias que se parezcan (no necesita ser exacto), ya que el usuario puede variar la forma
     * de digitar, asi que se cambia minusculas siempre.
     */
    public static Producto buscarProductoPorNombre(String nombreProducto) {
        // Convertir a minúsculas para búsqueda case-insensitive
        String nombreBusqueda = nombreProducto.toLowerCase();

        for (Producto p : Producto.getListaProductos()) {
            // Si el nombre del producto contiene el texto buscado
            if (p.getNombreProducto().toLowerCase().contains(nombreBusqueda)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Método para buscar y mostrar un producto por código
     */
    public static void buscarYMostrarPorCodigo(String codigoProducto) {
        Producto producto = buscarProducto(codigoProducto);

        if (producto == null) {
            System.out.println("\nError: No se encontró un producto con el código " + codigoProducto);
            return;
        }

        mostrarDetalleProducto(producto);
    }

    /**
     * Método para buscar y mostrar un producto por nombre
     */
    public static void buscarYMostrarPorNombre(String nombreProducto) {
        Producto producto = buscarProductoPorNombre(nombreProducto);

        if (producto == null) {
            System.out.println("\nError: No se encontró un producto con el nombre '" + nombreProducto + "'");
            return;
        }

        mostrarDetalleProducto(producto);
    }

    /**
     * Método para mostrar información detallada de un producto
     */
    private static void mostrarDetalleProducto(Producto producto) {
        System.out.println("\n===================================================================");
        System.out.println("                   PRODUCTO ENCONTRADO                          ");
        System.out.println("===================================================================");
        System.out.println("\n  Código: " + producto.getCodigoProducto());
        System.out.println("  Nombre: " + producto.getNombreProducto());
        System.out.println("  Precio: $" + String.format("%.2f", producto.getPrecioProducto()));
        System.out.println("  Stock: " + producto.getStockProducto() + " unidades");
        System.out.println("  Costo: $" + String.format("%.2f", producto.getCostoProducto()));
        System.out.println("  Tipo: " + producto.getTipoProducto());
        System.out.println("  Caducidad: " + producto.getCaducidadProducto());
        System.out.println("  Fecha de caducidad: " + producto.getFechaCaducidad());

        if (producto.getProveedor() != null) {
            System.out.println("  Proveedor: " + producto.getProveedor().getNombreProveedor());
        } else {
            System.out.println("  Proveedor: N/A");
        }

        System.out.println("===================================================================");
    }

    /**
     * Método para mostrar información resumida de un producto (para ventas)
     */
    public static void mostrarInfoProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("\n--- INFORMACIÓN DEL PRODUCTO ---");
        System.out.println("Código: " + producto.getCodigoProducto());
        System.out.println("Nombre: " + producto.getNombreProducto());
        System.out.println("Precio: $" + producto.getPrecioProducto());
        System.out.println("Stock disponible: " + producto.getStockProducto());
        System.out.println("--------------------------------");
    }

    /**
     * Método para ver el inventario completo
     */
    public static void verInventarioCompleto() {
        if (Producto.getListaProductos().isEmpty()) {
            System.out.println("\nNo hay productos en el inventario.");
            return;
        }

        System.out.println("\n=================================================================");
        System.out.println("                    INVENTARIO COMPLETO                         ");
        System.out.println("=================================================================");

        /**Dimensiones para que se coloque la tabla correctamente*/
        System.out.printf("\n  %-10s %-25s %-10s %-10s %-10s%n",
                "Código", "Nombre", "Precio", "Stock", "Costo");
        System.out.println("  ──────────────────────────────────────────────────────────────────");

        for (Producto p : Producto.getListaProductos()) {
            String nombreCorto = p.getNombreProducto().length() > 25 ?
                    p.getNombreProducto().substring(0, 22) + "..." :
                    p.getNombreProducto();

            System.out.printf("  %-10s %-25s $%-9.2f %-10d $%-9.2f%n",
                    p.getCodigoProducto(),
                    nombreCorto,
                    p.getPrecioProducto(),
                    p.getStockProducto(),
                    p.getCostoProducto());
        }

        System.out.println("  ──────────────────────────────────────────────────────────────────");
        System.out.println("\n  Total de productos: " + Producto.getListaProductos().size());
        System.out.println("=======================================================================\n");
    }
}
