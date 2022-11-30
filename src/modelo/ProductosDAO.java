package modelo;

import java.sql.PreparedStatement;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import java.sql.ResultSet;

public class ProductosDAO {
    
    Connection con;
    Conexion cn = new Conexion ();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Productos pro){
        
        String sql = "INSERT INTO productos (Id_Producto, Nombre, Proveedor, Precio, Cantidad) VALUES (?,?,?,?,?)";
        
        try {            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId_Producto());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setDouble(4, pro.getPrecio());
            ps.setInt(5, pro.getCantidad());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }       
    }  
    
    public void ConsultarProveedor(JComboBox proveedores){
        
        String sql = "SELECT Razon_Social FROM proveedores";
        
        try{
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                proveedores.addItem(rs.getString("Razon_Social"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());            
        }       
    }
    
    public List ListarProductos(){
        
        List<Productos> ListaPr = new ArrayList();

        String sql = "SELECT * FROM productos";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Productos pro = new Productos();
                pro.setId_Producto(rs.getInt("Id_Producto"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setProveedor(rs.getString("Proveedor"));
                pro.setPrecio(rs.getDouble("Precio"));
                pro.setCantidad(rs.getInt("Cantidad"));
                ListaPr.add(pro);

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPr;        
    }
    
    public boolean EliminarProductos(int Id_Producto){
        
        String sql = "DELETE FROM productos WHERE Id_Producto = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, Id_Producto);
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
    
    public boolean AtcualizarProductos(Productos pr){
        
        String sql = "UPDATE productos SET Nombre=?, Proveedor=?, Precio=?, Cantidad=? WHERE Id_Producto=?";
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getProveedor());
            ps.setDouble(3, pr.getPrecio());
            ps.setInt(4, pr.getCantidad());
            ps.setInt(5, pr.getId_Producto());
            ps.executeUpdate();
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
    
    public Productos BuscarProd (String producto){
        
        Productos pro = new Productos ();
        String sql = "SELECT * FROM productos WHERE Id_Codigo=?";
        
        try{
            
            String Id_Producto = null;
            con = cn.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1, Id_Producto);      
            String Nombre = null;
            ps.setString(2, Nombre);
            rs = ps.executeQuery();
            if (rs.next()){
                pro.setPrecio(rs.getDouble("Precio"));                                
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        return pro;
        }        
        return null;
    }
}
