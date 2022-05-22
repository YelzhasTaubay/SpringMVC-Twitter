package kz.bitlab.project.dao;

import kz.bitlab.project.entities.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CommentsDAOImpl implements CommentsDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Comments> getAllComments() {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Comments> query=builder.createQuery(Comments.class);
        query.from(Comments.class);
        List<Comments> allComments=session.createQuery(query).list();
        session.close();
        return allComments;
    }

    @Override
    public void addComment(Comments comment) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();
    }




}
