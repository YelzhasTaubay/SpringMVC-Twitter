package kz.bitlab.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tweets")
public class Tweets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String shortContent;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users author;

    private Date postDate;

    public Tweets() {
    }
    public Tweets(Long id, String title, String shortContent, String content, Users author, Date postDate) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.author = author;
        this.postDate = postDate;
    }
    public Tweets(Long id, String content, Date postDate,String shortContent, String title,  Users author) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.author = author;
        this.postDate = postDate;
    }

    public Tweets(Long aLong, String content, Date date, String short_content, String title, Long id) {
        this.id=aLong;
        this.content=content;
        this.postDate=date;
        this.shortContent=short_content;
        this.title=title;
        this.id=id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
