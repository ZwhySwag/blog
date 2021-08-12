package org.zwhy.swag.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.po.Comment;
import org.zwhy.swag.blog.service.BlogService;
import org.zwhy.swag.blog.service.CommentService;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\11 0011 21:01
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;


    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable("blogId") Long blogId,
                           Model model) {
        List<Comment> comments = commentService.listTopCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";

    }

    @PostMapping("/comments")
    public String post(Comment comment,
                       @RequestParam("blogId") Long blogId,
                       @RequestParam("parentId") Long parentId) {
        Blog blog = blogService.getBlog(blogId);
        comment.setBlog(blog);
        comment.setAvatar(avatar);
        if (parentId != -1) {
            Comment parentComment = commentService.getComment(parentId);
            comment.setParentComment(parentComment);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}
