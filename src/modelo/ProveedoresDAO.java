package modelo;

import controlador.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProveedoresDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProveedor(Proveedores pv) {

        String sql = "INSERT INTO proveedores (NIT, Razon_Social, Telefono, Direccion, Correo) VALUES (?,?,?,?,?)";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pv.getNIT());
            ps.setString(2, pv.getRazon_Social());
            ps.setInt(3, pv.getTelefono());
            ps.setString(4, pv.getDireccion());            
            ps.setString(5, pv.getCorreo());
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

    public List ListarProveedores() {

        List<Proveedores> ListaPv = new ArrayList();

        String sql = "SELECT * FROM proveedores";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Proveedores pv = new Proveedores();
                pv.setNIT(rs.getInt("NIT"));
                pv.setRazon_Social(rs.getString("Razon_Social"));
                pv.setTelefono(rs.getInt("Telefono"));
                pv.setDireccion(rs.getString("Direccion"));                
                pv.setCorreo(rs.getString("Correo"));
                ListaPv.add(pv);

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPv;
    }

    public boolean EliminarProveedores(int NIT) {

        String sql = "DELETE FROM proveedores WHERE NIT=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, NIT);
            ps.executeUpdate();
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
    
    public boolean ActualizarProveedores(Proveedores pv){
        
        String sql = "UPDATE proveedores SET Razon_Social=?, Telefono=?, Direccion=?, Correo=? WHERE NIT=?";
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1, pv.getRazon_Social());
            ps.setInt(2, pv.getTelefono());
            ps.setString(3, pv.getDireccion());
            ps.setString(4, pv.getCorreo());
            ps.setInt(5, pv.getNIT());
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