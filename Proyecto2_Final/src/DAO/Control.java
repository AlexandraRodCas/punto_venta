/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Luis
 */
public class Control {


    private ProductosDAO productosRepository;
    private ClientesDAO clientesRepository;
    private VentasDAO ventasRepository;
    private Rel_productosventasDAO rel_productosventasrepository;

    public Rel_productosventasDAO getRel_productosventasrepository() {
        if (this.rel_productosventasrepository != null) {
            return rel_productosventasrepository;
        } else {
            this.rel_productosventasrepository = new Rel_productosventasDAO();
            return rel_productosventasrepository;
        }

    }

    public ProductosDAO getProductosRepository() {
        if (this.productosRepository != null) {
            return this.productosRepository;
        } else {
            this.productosRepository = new ProductosDAO();
            return this.productosRepository;
        }
    }

    public ClientesDAO getClientesRepository() {
        if (this.clientesRepository != null) {
            return this.clientesRepository;
        } else {
            this.clientesRepository = new ClientesDAO();
            return this.clientesRepository;
        }
    }

    public VentasDAO getVentasRepository() {
        if (this.ventasRepository != null) {
            return this.ventasRepository;
        } else {
            this.ventasRepository = new VentasDAO();
            return this.ventasRepository;
        }
    }

}
