package udla.jgjbmp.pmeaabet;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    // Atributos
    private String codigoProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String direccionProveedor;
    
    // Lista estática para almacenar todos los proveedores
    private static final List<Proveedor> listaProveedores = new ArrayList<>();
    
    // Constructor vacío
    public Proveedor() {
    }
    
    // Constructor con parámetros
    public Proveedor(String codigoProveedor, String nombreProveedor, String telefonoProveedor, String direccionProveedor) {
        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.direccionProveedor = direccionProveedor;
    }
    
    // Getters y Setters
    public String getCodigoProveedor() {
        return codigoProveedor;
    }
    
    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }
    
    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
    
    public String getDireccionProveedor() {
        return direccionProveedor;
    }
    
    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    
    public static List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }
    
    // Métodos de gestión
    
    /**
     * Metodo para agregar un nuevo proveedor
     * El proveedor a agregar
     */
    public static void addProveedor(Proveedor proveedor) {
        if (proveedor == null) {
            System.out.println("Error: El proveedor no puede ser nulo");
            return;
        }
        
        // Verificar si ya existe un proveedor con el mismo código
        for (Proveedor p : listaProveedores) {
            if (p.getCodigoProveedor().equals(proveedor.getCodigoProveedor())) {
                System.out.println("Error: Ya existe un proveedor con ese código");
                return;
            }
        }
        
        listaProveedores.add(proveedor);
        System.out.println("Proveedor agregado: " + proveedor.getNombreProveedor());
    }
    
    /**
     * Buscar proveedor por código
     * El código del proveedor
     */
    public static Proveedor buscarPorCodigo(String codigoProveedor) {
        for (Proveedor p : listaProveedores) {
            if (p.getCodigoProveedor().equals(codigoProveedor)) {
                return p;
            }
        }
        return null;
    }
}
