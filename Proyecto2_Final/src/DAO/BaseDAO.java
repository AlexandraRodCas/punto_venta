/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis
 */
public abstract class BaseDAO<T> {

    public abstract void Guardar(T entidad);

    public abstract void Eliminar(long id);

    public abstract void Actualizar(T entidad);

    public abstract T buscarPorId(long id);

    public abstract ArrayList<T> consultar();

    public EntityManager createEntityManager() {
        EntityManagerFactory emFactory
                = Persistence.createEntityManagerFactory("Proyecto2_205817PU");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
