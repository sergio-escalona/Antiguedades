/* Sergio Escalona y Kevin Rojas*/
package Modelo;

/**
 *
 * @author CASA
 */
public class Articulo {
    private int codigo, precio;
    private String descripcion, estado, restaurado, localventa;

    public Articulo(int codigo, int precio, String descripcion, String estado, String restaurado, String localventa) {
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.restaurado = restaurado;
        this.localventa = localventa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRestaurado() {
        return restaurado;
    }

    public void setRestaurado(String restaurado) {
        this.restaurado = restaurado;
    }

    public String getLocalventa() {
        return localventa;
    }

    public void setLocalventa(String localventa) {
        this.localventa = localventa;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", precio=" + precio + ", descripcion=" + descripcion + ", estado=" + estado + ", restaurado=" + restaurado + ", localventa=" + localventa + '}';
    }
    
}
