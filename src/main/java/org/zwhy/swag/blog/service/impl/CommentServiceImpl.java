package org.zwhy.swag.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwhy.swag.blog.dao.CommentDao;
import org.zwhy.swag.blog.po.Comment;
import org.zwhy.swag.blog.service.CommentService;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\11 0011 21:08
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        return commentDao.listCommentByBlogId(blogId);
    }

    @Override
    public List<Comment> listReplyComment(Long parentId) {
        return commentDao.listReplyComment(parentId);
    }

    @Override
    public Comment getComment(Long id) {
        return commentDao.getComment(id);
    }

    @Override
    public Boolean saveComment(Comment comment) {
        return commentDao.saveComment(comment);
    }
}
