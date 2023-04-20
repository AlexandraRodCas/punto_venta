/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "Ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idventa;
    private Calendar Fecha;
    private Float Descuento;
    private Float Montofinal;
    private Cliente cliente;
    private List<Rel_productosventas> rel_productosventas;

    public Venta() {

    }

    public Venta(Calendar Fecha, Float Descuento, Float Montofinal) {
        this.Fecha = Fecha;
        this.Descuento = Descuento;
        this.Montofinal = Montofinal;
    }

    public Venta(Calendar Fecha, Float Descuento, Float Montofinal, Cliente cliente) {
        this.Fecha = Fecha;
        this.Descuento = Descuento;
        this.Montofinal = Montofinal;
        this.cliente = cliente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    public Long getIdventa() {
        return idventa;
    }

    @Column(name = "Fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    public Calendar getFecha() {
        return Fecha;
    }

    @Column(name = "Descuento", nullable = false)
    public Float getDescuento() {
        return Descuento;
    }

    @Column(name = "Monto_Final", nullable = false)
    public Float getMontofinal() {
        return Montofinal;
    }

    @ManyToOne
    @JoinColumn(name = "idCliente")
    public Cliente getCliente() {
        return cliente;
    }

    @OneToMany(targetEntity = Rel_productosventas.class, mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Rel_productosventas> getRel_productosventas() {
        return rel_productosventas;
    }

    public void setRel_productosventas(List<Rel_productosventas> rel_productosventas) {
        this.rel_productosventas = rel_productosventas;
    }

    public void setIdventa(Long id) {
        this.idventa = id;
    }

    public void setFecha(Calendar Fecha) {
        this.Fecha = Fecha;
    }

    public void setDescuento(Float Descuento) {
        this.Descuento = Descuento;
    }

    public void setMontofinal(Float Montofinal) {
        this.Montofinal = Montofinal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObjetoNegocio.Venta[ id=" + idventa + " ]";
    }

}
