/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetoNegocio.Rel_productosventas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Luis
 */
public class Rel_productosventasDAO extends BaseDAO<Rel_productosventas> {

    @Override
    public void Guardar(Rel_productosventas entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void Eliminar(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Rel_productosventas relacionProdcutos = entityManager.find(Rel_productosventas.class, id);
        if (relacionProdcutos != null) {
            entityManager.remove(relacionProdcutos);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Actualizar(Rel_productosventas entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Rel_productosventas relproducto = entityManager.find(Rel_productosventas.class, entidad.getIdrel_productoventa());
        if (relproducto != null) {
            relproducto.setCantidad(entidad.getCantidad());
            relproducto.setMontototal(entidad.getMontototal());
            relproducto.setPrecio(entidad.getPrecio());
            relproducto.setProducto(entidad.getProducto());
            relproducto.setVenta(entidad.getVenta());

            entityManager.merge(relproducto);
        }
        entityManager.getTransaction().commit();

    }

    @Override
    public Rel_productosventas buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Rel_productosventas rel_productosventas = entityManager.find(Rel_productosventas.class, id);
        entityManager.getTransaction().commit();
        return rel_productosventas;
    }

    @Override
    public ArrayList<Rel_productosventas> consultar() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Rel_productosventas.class));
        Query query = entityManager.createQuery(criteria);
        List<Rel_productosventas> relacionProductosVentas = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(relacionProductosVentas);
    }

}
