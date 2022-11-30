package modelo;

public class Ventas {
    
    private int Id;
    private String Cliente;
    private String Vendedor;
    private float Total;    
    private String Fecha;
    
    public Ventas (){        
        
    }

    public Ventas(int Id,String Cliente, String Vendedor, float Total, String Fecha) {
        this.Cliente = Cliente;
        this.Vendedor = Vendedor;
        this.Total = Total;
        this.Fecha = Fecha;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    
}
