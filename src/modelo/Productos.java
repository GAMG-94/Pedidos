package modelo;

public class Productos {
    
    private int Id_Producto;
    private String Nombre;
    private String Proveedor;
    private Double Precio;
    private int Cantidad;
    
    public Productos(){
        
    }    

    public Productos(int Id_Producto, String Nombre, String Proveedor, Double Precio, int Cantidad) {
        this.Id_Producto = Id_Producto;
        this.Nombre = Nombre;
        this.Proveedor = Proveedor;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}