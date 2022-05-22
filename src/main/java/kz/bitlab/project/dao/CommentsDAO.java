package kz.bitlab.project.dao;

import kz.bitlab.project.entities.Comments;

import java.util.List;

public interface CommentsDAO {

    List<Comments> getAllComments();

    void addComment(Comments comment);
}
