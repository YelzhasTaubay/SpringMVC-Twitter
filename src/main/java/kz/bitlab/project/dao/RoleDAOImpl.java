package kz.bitlab.project.dao;

import kz.bitlab.project.entities.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Roles getRole(String role) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Roles> query = builder.createQuery(Roles.class);
        Root<Roles> root = query.from(Roles.class);
        Predicate predicate = builder.equal(root.get("role"), role);
        Roles role2 = session.createQuery(query.where(predicate)).uniqueResult();
        session.close();
        return role2;
    }

    @Override
    public List<Roles> getAllRoles(){
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Roles> query=builder.createQuery(Roles.class);
        query.from(Roles.class);
        List<Roles> allRoles=session.createQuery(query).list();
        session.close();
        return  allRoles;

    }











}
