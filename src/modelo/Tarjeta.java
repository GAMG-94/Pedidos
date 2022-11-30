package modelo;

public class Tarjeta {

    private int Id_Tarjeta;
    private float Saldo;
    private String Nombre;
    private String Correo;
    private String Telefono;
    
    
    public Tarjeta() {
        
    }

    public int getId_Tarjeta() {
        return Id_Tarjeta;
    }

    public void setId_Tarjeta(int Id_Tarjeta) {
        this.Id_Tarjeta = Id_Tarjeta;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Tarjeta(int Id_Tarjeta, float Saldo, String Nombre, String Correo, String Telefono) {
        this.Id_Tarjeta = Id_Tarjeta;
        this.Saldo = Saldo;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }
}
