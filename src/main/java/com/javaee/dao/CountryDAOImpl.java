package com.javaee.dao;

import com.javaee.entity.Country;
import com.javaee.utils.HibernateConfig;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDAO")
public class CountryDAOImpl implements CountryDAO {

    @Override
    public List<Country> findAll(String search, int offset, int recordPerPage) {
        Session session = HibernateConfig.getSession();
        String SQL = "SELECT c FROM Country c WHERE c.name LIKE :searchName OR c.continent LIKE :searcContinent ORDER BY c.countryId ASC";
        TypedQuery<Country> query = session.createQuery(SQL, Country.class);
        String searPattern = "%" + search + "%";
        query.setParameter("searchName", searPattern);
        query.setParameter("searcContinent", searPattern);
        query.setFirstResult(offset);
        query.setMaxResults(recordPerPage);
        return query.getResultList();
    }

    @Override
    public void save(Country country) {
        Session session = HibernateConfig.getSession();
        session.getTransaction().begin();
        session.persist(country);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Country country) {
        Session session = HibernateConfig.getSession();
        session.getTransaction().begin();
        session.merge(country);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateConfig.getSession();
        Country country = session.find(Country.class, id);
        session.getTransaction().begin();
        session.remove(country);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Country findById(int id) {
        Session session = HibernateConfig.getSession();
        return session.find(Country.class, id);
    }

    @Override
    public int count(String search) {
        Session session = HibernateConfig.getSession();
        String SQL = "SELECT COUNT(c) FROM Country c WHERE c.name LIKE :search OR c.continent LIKE :search";
        TypedQuery<Long> query = session.createQuery(SQL, Long.class);
        query.setParameter("search", "%" + search + "%");
        return query.getSingleResult().intValue();
    }
}
