package kz.bitlab.project.dao;


import kz.bitlab.project.entities.Followers;
import kz.bitlab.project.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class FollowersDAOImpl implements FollowersDAO{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addFollow(Followers follow) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(follow);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Followers> getAllFollows() {
       Session session=sessionFactory.openSession();
       CriteriaBuilder builder=session.getCriteriaBuilder();
       CriteriaQuery<Followers> query=builder.createQuery(Followers.class);
       query.from(Followers.class);
       List<Followers> allFollows=session.createQuery(query).list();
       session.close();
        return allFollows;
    }


    @Override
    public Followers getFollowById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Followers> query=builder.createQuery(Followers.class);
        Root<Followers> root=query.from(Followers.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Followers follower=session.createQuery(query.where(predicate)).uniqueResult();
        session.close();
        return follower;
    }

    @Override
    public List<Followers> getFollowersByFromUserId(Long from_user_id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Followers> query=builder.createQuery(Followers.class);
        Root<Followers> root=query.from(Followers.class);
        Predicate predicate=builder.equal(root.get("from"),from_user_id);
        List<Followers> followers=session.createQuery(query.where(predicate)).list();
        session.close();
        return followers;
    }

    @Override
    public List<Followers> getFollowersByToUserId(Long to_user_id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Followers> query=builder.createQuery(Followers.class);
        Root<Followers> root=query.from(Followers.class);
        Predicate predicate=builder.equal(root.get("to"),to_user_id);
        List<Followers> followers=session.createQuery(query.where(predicate)).list();
        session.close();
        return followers;
    }

    public Followers getFollowersByToUserId2(Long to_user_id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Followers> query=builder.createQuery(Followers.class);
        Root<Followers> root=query.from(Followers.class);
        Predicate predicate=builder.equal(root.get("to"),to_user_id);
        Followers followers=session.createQuery(query.where(predicate)).uniqueResult();
        session.close();
        return followers;
    }


    public void unFollowOfUser(Followers follower){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(follower);
        transaction.commit();
        session.close();
        System.out.println("UNFOLLOWED");
    }



}
