package org.zwhy.swag.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zwhy.swag.blog.dao.CommentDao;
import org.zwhy.swag.blog.po.Comment;
import org.zwhy.swag.blog.service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\11 0011 21:08
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    private List<Comment> tempReplyList = new ArrayList<>();

    @Override
    public List<Comment> listTopCommentByBlogId(Long blogId) {
        List<Comment> topComments = commentDao.listTopCommentByBlogId(blogId);
        combineReplycomments(topComments);
        return topComments;
    }

    private void combineReplycomments(List<Comment> topComments) {
        for (Comment topComment: topComments) {
            List<Comment> replys = topComment.getReplyComments();
            if (replys != null && replys.size() > 0) {
                for (Comment reply: replys) {
                    deepFindAllReply(reply);
                }
            }
            topComment.setReplyComments(tempReplyList);
            tempReplyList = new ArrayList<>();
        }
    }

    private void deepFindAllReply(Comment reply) {
        tempReplyList.add(reply);
        List<Comment> replys = reply.getReplyComments();
        if (replys != null && replys.size() > 0) {
            for (Comment reply1: replys) {
                deepFindAllReply(reply1);
            }
        }
    }

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

    @Transactional
    @Override
    public Boolean saveComment(Comment comment) {
        return commentDao.saveComment(comment);
    }
}
