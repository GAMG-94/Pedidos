package modelo;

public class Proveedores {

    private int NIT;
    private String Razon_Social;
    private int Telefono;
    private String Direccion;
    private String Correo;

    public Proveedores() {       

    }

    public Proveedores(int NIT, String Razon_Social, int Telefono, String Direccion, String Correo) {
        this.NIT = NIT;
        this.Razon_Social = Razon_Social;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Correo = Correo;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }   

}
