package org.zwhy.swag.blog.mapper;

import org.zwhy.swag.blog.po.Comment;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\11 0011 21:10
 */
public interface CommentMapper {

    Comment getComment(Long id);

    List<Comment> listCommentByBlogId(Long blogId);

    Integer saveComment(Comment comment);

    List<Comment> getReplyComments(Long parentId);

    List<Comment> listTopCommentByBlogId(Long blogId);
}
