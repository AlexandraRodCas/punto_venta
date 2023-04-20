/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "Rel_productosventas")
public class Rel_productosventas implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idrel_productoventa;
    private Float precio;
    private int cantidad;
    private Float Montototal;
    private Producto producto;
    private Venta venta;

    public Rel_productosventas() {
    }

    public Rel_productosventas(Float precio, int cantidad, Float Montototal, Producto producto, Venta venta) {

        this.precio = precio;
        this.cantidad = cantidad;
        this.Montototal = Montototal;
        this.producto = producto;
        this.venta = venta;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rel_productosventas")
    public Long getIdrel_productoventa() {
        return idrel_productoventa;
    }

    @Column(name = "Precio")
    public Float getPrecio() {
        return precio;
    }

    @Column(name = "Cantidad")
    public int getCantidad() {
        return cantidad;
    }

    @Column(name = "Monto_Total")
    public Float getMontototal() {
        return Montototal;
    }

    @ManyToOne
    @JoinColumn(name = "idproducto")
    public Producto getProducto() {
        return producto;
    }

    @ManyToOne
    @JoinColumn(name = "idventa")
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setIdrel_productoventa(Long id) {
        this.idrel_productoventa = id;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setMontototal(Float Montototal) {
        this.Montototal = Montototal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrel_productoventa != null ? idrel_productoventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rel_productosventas)) {
            return false;
        }
        Rel_productosventas other = (Rel_productosventas) object;
        if ((this.idrel_productoventa == null && other.idrel_productoventa != null) || (this.idrel_productoventa != null && !this.idrel_productoventa.equals(other.idrel_productoventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObjetoNegocio.Rel_productosventas[ id=" + idrel_productoventa + " ]";
    }

}
