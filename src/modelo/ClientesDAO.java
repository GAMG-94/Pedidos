package modelo;

import controlador.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientesDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarCliente(Clientes cl) {

        String sql = "INSERT INTO clientes (Id_Documento, Nombre, Direccion, Celular, Correo) VALUES (?,?,?,?,?)";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getId_Documento());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDireccion());
            ps.setInt(4, cl.getCelular());
            ps.setString(5, cl.getCorreo());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        } finally {
            try {

                con.close();

            } catch (SQLException e) {
                System.out.println(e.toString());

            }
        }
    }

    public List ListarClientes() {

        List<Clientes> ListaCl = new ArrayList();

        String sql = "SELECT * FROM clientes";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Clientes cl = new Clientes();
                cl.setId_Documento(rs.getInt("Id_Documento"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setCelular(rs.getInt("Celular"));
                cl.setCorreo(rs.getString("Correo"));
                ListaCl.add(cl);

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;
    }

    public boolean EliminarClientes(int Id_Documento) {

        String sql = "DELETE FROM clientes WHERE id_Documento = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, Id_Documento);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ActualizarClientes(Clientes cl){
        
        String sql = "UPDATE clientes SET Nombre=?, Direccion=?, Celular=?, Correo=? WHERE Id_Documento=?";
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getDireccion());
            ps.setInt(3, cl.getCelular());
            ps.setString(4, cl.getCorreo());
            ps.setInt(5, cl.getId_Documento());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.out.println(e.toString());
            return false;

        } finally {
            try {
                con.close();                
            } catch (SQLException e){
                System.out.println(e.toString());
            }            
        }
    }
}