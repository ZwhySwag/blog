package org.zwhy.swag.blog.service;

import org.zwhy.swag.blog.po.Comment;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\11 0011 21:06
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Boolean saveComment(Comment comment);

    List<Comment> listReplyComment(Long parentId);

    Comment getComment(Long id);
}
