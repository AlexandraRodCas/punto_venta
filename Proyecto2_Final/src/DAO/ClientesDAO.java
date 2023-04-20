/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetoNegocio.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Luis
 */
public class ClientesDAO extends BaseDAO<Cliente> {

    @Override
    public void Guardar(Cliente entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void Eliminar(long idcliente) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente clientes = entityManager.find(Cliente.class, idcliente);
        if (clientes != null) {
            entityManager.remove(clientes);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Actualizar(Cliente entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente clienteGuardado = entityManager.find(Cliente.class, entidad.getIdcliente());
        if (clienteGuardado != null) {
            clienteGuardado.setNombre(entidad.getNombre());
            clienteGuardado.setRfc(entidad.getRfc());
            clienteGuardado.setDireccion(entidad.getDireccion());
            clienteGuardado.setTelefono1(entidad.getTelefono1());
            clienteGuardado.setTelefono2(entidad.getTelefono2());

            entityManager.merge(clienteGuardado);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Cliente buscarPorId(long idcliente) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente clientes = entityManager.find(Cliente.class, idcliente);
        entityManager.getTransaction().commit();
        return clientes;
    }

    @Override
    public ArrayList<Cliente> consultar() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Cliente.class));
        Query query = entityManager.createQuery(criteria);
        List<Cliente> clientes = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(clientes);
    }

}
