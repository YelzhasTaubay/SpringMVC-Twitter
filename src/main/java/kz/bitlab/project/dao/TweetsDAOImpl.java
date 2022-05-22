package kz.bitlab.project.dao;


import kz.bitlab.project.entities.Tweets;
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

public class TweetsDAOImpl implements  TweetsDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Tweets> getAllTweets() {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Tweets> query=builder.createQuery(Tweets.class);
        query.from(Tweets.class);
        List<Tweets> allTweets=session.createQuery(query).list();
        session.close();
        return allTweets;
    }

    public Tweets getTweetById(Long id){
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Tweets> query=builder.createQuery(Tweets.class);
        Root<Tweets> root=query.from(Tweets.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Tweets tweet=session.createQuery(query.where(predicate)).uniqueResult();
        session.close();
        return tweet;
    }

    @Override
    public void addTweet(Tweets tweet) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(tweet);
        transaction.commit();
        session.close();
    }



}
