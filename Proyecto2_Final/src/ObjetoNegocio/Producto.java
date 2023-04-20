/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idproducto;
    private String nombre;
    private Float precioActual;
    private int stock;
    private List<Rel_productosventas> relacionproductos;

    public Producto() {
    }

    public Producto(Long idproducto, String nombre, Float precioActual, int stock) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precioActual = precioActual;
        this.stock = stock;
    }

    public Producto(String nombre, Float precioActual, int stock) {

        this.nombre = nombre;
        this.precioActual = precioActual;
        this.stock = stock;
    }

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    public Long getIdproducto() {
        return idproducto;
    }

    @Column(name = "Nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    @Column(name = "Precio_actual", nullable = false)
    public Float getPrecioActual() {
        return precioActual;
    }

    @Column(name = "Stock", nullable = false)
    public int getStock() {
        return stock;
    }


    @OneToMany(targetEntity = Rel_productosventas.class, mappedBy = "Producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Rel_productosventas> getRel() {
        return relacionproductos;
    }

    public void setRel(List<Rel_productosventas> rel) {
        this.relacionproductos = rel;
    }

    public void setIdproducto(Long id) {
        this.idproducto = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioActual(Float precioActual) {
        this.precioActual = precioActual;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObjetoNegocio.Producto[ id=" + idproducto + " ]";
    }

}
