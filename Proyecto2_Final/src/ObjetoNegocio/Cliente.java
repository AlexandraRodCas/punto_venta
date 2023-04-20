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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idcliente;
    private String rfc;
    private String nombre;
    private String direccion;
    private String telefono1;
    private String telefono2;
    private List<Venta> ventas;

    public Cliente() {
    }

    public Cliente(String rfc, String nombre, String direccion, String telefono1, String telefono2) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public Cliente(Long idcliente, String rfc, String nombre, String direccion, String telefono1, String telefono2) {
        this.idcliente = idcliente;
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    public Long getIdcliente() {
        return idcliente;
    }

    @Column(name = "RFC", nullable = false)
    public String getRfc() {
        return rfc;
    }

    @Column(name = "Nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    @Column(name = "Direccion", nullable = false)
    public String getDireccion() {
        return direccion;
    }

    @Column(name = "Telefono1", nullable = true)
    public String getTelefono1() {
        return telefono1;
    }

    @Column(name = "Telefono2", nullable = true)
    public String getTelefono2() {
        return telefono2;
    }

    @OneToMany(targetEntity = Venta.class, mappedBy = "Cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setIdcliente(Long id) {
        this.idcliente = id;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
