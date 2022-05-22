package kz.bitlab.project.dao;

import kz.bitlab.project.entities.Roles;
import kz.bitlab.project.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Users getUser(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Predicate predicate = builder.equal(root.get("email"), email);
        Users user = session.createQuery(query.where(predicate)).uniqueResult();
        session.close();
        return user;
    }

    @Override
    public Users getUserById(Long id){
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Users> query=builder.createQuery(Users.class);
        Root<Users> root=query.from(Users.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Users user=session.createQuery(query.where(predicate)).uniqueResult();
        session.close();
        return user;
    }

    @Override
    public List<Users> getUserByFullName(String fullname){
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Users> query=builder.createQuery(Users.class);
        Root<Users> root=query.from(Users.class);
        Predicate predicate=builder.equal(root.get("fullname"),fullname);
        List<Users> users=session.createQuery(query.where(predicate)).list();
        session.close();
        return users;
    }




    @Override
    public void addUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(Users user){
      //  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(Users user){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
        System.out.println("deleted successfully");
    }

    @Override
    public List<Users> getAllUsers(){
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Users> query=builder.createQuery(Users.class);
        query.from(Users.class);
        List<Users> allUsers=session.createQuery(query).list();
        session.close();
        return  allUsers;

    }








}
