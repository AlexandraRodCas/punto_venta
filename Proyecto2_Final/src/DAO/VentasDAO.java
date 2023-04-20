/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetoNegocio.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Luis
 */
public class VentasDAO extends BaseDAO<Venta> {

    @Override
    public void Guardar(Venta entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void Eliminar(long idventa) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, idventa);
        if (venta != null) {
            entityManager.remove(venta);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Actualizar(Venta entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Venta ventaGuardada = entityManager.find(Venta.class, entidad.getIdventa());
        if (ventaGuardada != null) {
            ventaGuardada.setFecha(entidad.getFecha());
            ventaGuardada.setDescuento(entidad.getDescuento());
            ventaGuardada.setMontofinal(entidad.getMontofinal());

            entityManager.merge(ventaGuardada);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Venta buscarPorId(long idventa) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, idventa);
        entityManager.getTransaction().commit();
        return venta;
    }

    @Override
    public ArrayList<Venta> consultar() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Venta.class));
        Query query = entityManager.createQuery(criteria);
        List<Venta> ventas = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(ventas);
    }

}
