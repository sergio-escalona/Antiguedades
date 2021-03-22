/* Sergio Escalona y Kevin Rojas*/
package Controlador;

import BD.Conexion;
import Modelo.Articulo;
import java.sql.*;
import java.util.*;

public class Registro {
    public boolean agregarArticulo(Articulo art){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO articulos (codigo, descripcion, estado, restaurado, precio, localventa) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, art.getCodigo());
            stmt.setString(2, art.getDescripcion());
            stmt.setString(3, art.getEstado());
            stmt.setString(4, art.getRestaurado());
            stmt.setInt(5, art.getPrecio());
            stmt.setString(6, art.getLocalventa());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch(Exception e){
            System.out.println("Error al agregar artículo " + e.getMessage());
            return false;
        }         
    }
    
    public Articulo buscarArticulo(int cod) {
        Articulo art =  null;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM articulos WHERE codigo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, cod);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                art = new Articulo(rs.getInt("codigo"), rs.getInt("precio"), rs.getString("descripcion"), rs.getString("estado"), rs.getString("restaurado"), rs.getString("localventa"));
            stmt.close();
            cnx.close();
        } catch(Exception e) {
            System.out.println("Error al listar artículo por codigo" + e.getMessage());
        }
        return art;
    }
    
    public ArrayList<Articulo> listarArticulo() {
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM articulos order by codigo";
            PreparedStatement stmt = cnx.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Articulo art = new Articulo(rs.getInt("codigo"), rs.getInt("precio"), rs.getString("descripcion"), rs.getString("estado"), rs.getString("restaurado"), rs.getString("localventa"));
                lista.add(art);
            }
            stmt.close();
            cnx.close();
        } catch (Exception e) {
            System.out.println("Error al listar artículos " + e.getMessage());
        }
        return lista;
    }
    
    public boolean eliminarArticulo(int cod){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM articulos WHERE codigo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, cod);
            int filas = stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            if (filas==1)
                return true;
            else
                return false;
        } catch(Exception e){
            System.out.println("Error al eliminar artículo " + e.getMessage());
            return false;
        }
    }
    
    public boolean modificarArticulo(Articulo art) {
        try {
            Conexion conex = new Conexion();
            Connection cnx = conex.obtenerConexion();

            String query = "UPDATE articulos SET descripcion=?, estado=?, restaurado=?, precio=?, localventa=? WHERE CODIGO=?";
            PreparedStatement stmt = cnx.prepareStatement(query);            
            stmt.setString(1, art.getDescripcion());
            stmt.setString(2, art.getEstado());
            stmt.setString(3, art.getRestaurado());
            stmt.setInt(4, art.getPrecio());
            stmt.setString(5, art.getLocalventa());
            stmt.setInt(6, art.getCodigo());
            
            int filas = stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            if (filas == 1)
               return true;
            else 
                return false;
        } catch (Exception e) {
            System.out.println("Error al modificar artículo " + e.getMessage());
            return false;
        }
    }
}
