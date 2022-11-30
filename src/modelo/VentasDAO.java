package modelo;

import controlador.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarVentas(Ventas V) {

        String sql = "INSERT INTO ventas (Id, Cliente, Vendedor, Total, Fecha) VALUES (?,?,?,?,?)";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, V.getId());
            ps.setString(2, V.getCliente());
            ps.setString(3, V.getVendedor());
            ps.setDouble(4, V.getTotal());
            ps.setString(5, V.getFecha());
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

    public List ListarVentas() {

        List<Ventas> ListaV = new ArrayList();

        String sql = "SELECT * FROM ventas";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Ventas V = new Ventas();
                V.setId(rs.getInt("Id_Codigo"));
                V.setCliente(rs.getString("Cliente"));
                V.setVendedor(rs.getString("Vendedor"));
                V.setTotal(rs.getFloat("Total"));
                V.setFecha(rs.getString("Fecha"));
                ListaV.add(V);

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaV;
    }

    public boolean EliminarVentas(int Id_Codigo) {

        String sql = "DELETE FROM ventas WHERE Id_Codigo = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, Id_Codigo);
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
    
    public boolean ActualizarVentas(Ventas V){
        
        String sql = "UPDATE ventas SET Cantidad=?, Precio=?, Total=?, WHERE Id_Codigo=?";
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setInt(1, V.getId());
            ps.setString(2, V.getCliente());
            ps.setString(3, V.getVendedor());
            ps.setDouble(4, V.getTotal());
            ps.setString(5, V.getFecha());
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