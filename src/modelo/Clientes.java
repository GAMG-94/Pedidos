package modelo;

public class Clientes {
    
    private int Id_Documento;
    private String Nombre;
    private String Direccion;
    private int Celular;
    private String Correo;

    public Clientes() {
    }

    public Clientes(int Id_Documento, String Nombre, String Direccion, int Celular, String Correo) {
        this.Id_Documento = Id_Documento;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Celular = Celular;
        this.Correo = Correo;
    }

    public int getId_Documento() {
        return Id_Documento;
    }

    public void setId_Documento(int id_Documento) {
        this.Id_Documento = id_Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

}
