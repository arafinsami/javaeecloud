package com.javaee.dao;

import com.javaee.entity.Country;
import com.javaee.utils.JpaConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDAO")
public class CountryDAOImpl implements CountryDAO {

    @Override
    public List<Country> findAll(String search, int offset, int recordPerPage) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        String SQL = "SELECT c FROM Country c WHERE c.name LIKE :search OR c.continent LIKE :search ORDER BY c.countryId ASC";
        TypedQuery<Country> query = entityManager.createQuery(SQL, Country.class);
        query.setParameter("search", "%" + search + "%");
        query.setFirstResult(offset);
        query.setMaxResults(recordPerPage);
        return query.getResultList();
    }

    @Override
    public void save(Country country) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Country country) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Country country = entityManager.find(Country.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Country findById(int id) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        return entityManager.find(Country.class, id);
    }

    @Override
    public int count(String search) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        String SQL = "SELECT COUNT(c) FROM Country c WHERE c.name LIKE :search OR c.continent LIKE :search";
        TypedQuery<Long> query = entityManager.createQuery(SQL, Long.class);
        query.setParameter("search", "%" + search + "%");
        return query.getSingleResult().intValue();
    }
}
