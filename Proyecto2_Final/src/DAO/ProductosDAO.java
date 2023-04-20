/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetoNegocio.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Luis
 */
public class ProductosDAO extends BaseDAO<Producto> {

    @Override
    public void Guardar(Producto entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void Eliminar(long idproducto) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, idproducto);
        if (producto != null) {
            entityManager.remove(producto);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Actualizar(Producto entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Producto productoGuardado = entityManager.find(Producto.class, entidad.getIdproducto());
        if (productoGuardado != null) {
            productoGuardado.setNombre(entidad.getNombre());
            productoGuardado.setPrecioActual(entidad.getPrecioActual());
            productoGuardado.setStock(entidad.getStock());

            entityManager.merge(productoGuardado);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Producto buscarPorId(long idproducto) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, idproducto);
        entityManager.getTransaction().commit();
        return producto;

    }

    @Override
    public ArrayList<Producto> consultar() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Producto.class));
        Query query = entityManager.createQuery(criteria);
        List<Producto> productos = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(productos);
    }

}
