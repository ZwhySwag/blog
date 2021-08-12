package org.zwhy.swag.blog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zwhy.swag.blog.dao.CommentDao;
import org.zwhy.swag.blog.mapper.CommentMapper;
import org.zwhy.swag.blog.po.Comment;

import java.util.Date;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\11 0011 21:09
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        List<Comment> comments = commentMapper.listCommentByBlogId(blogId);
        return comments;
    }

    @Override
    public Boolean saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int row = commentMapper.saveComment(comment);
        return null;
    }

    @Override
    public List<Comment> listReplyComment(Long parentId) {
        return commentMapper.listCommentByBlogId(parentId);
    }

    @Override
    public Comment getComment(Long id) {
        return commentMapper.getComment(id);
    }

    @Override
    public List<Comment> listTopCommentByBlogId(Long blogId) {
        return commentMapper.listTopCommentByBlogId(blogId);
    }
}
