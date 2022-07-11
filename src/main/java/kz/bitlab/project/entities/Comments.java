package kz.bitlab.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tweets tweet;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users author;

    private String comment;

    private Date postDate;

    public Comments(){}
    public Comments(Long id, Tweets tweet, Users author, String comment, Date postDate) {
        this.id = id;
        this.tweet = tweet;
        this.author = author;
        this.comment = comment;
        this.postDate = postDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tweets getTweet() {
        return tweet;
    }

    public void setTweet(Tweets tweet) {
        this.tweet = tweet;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
