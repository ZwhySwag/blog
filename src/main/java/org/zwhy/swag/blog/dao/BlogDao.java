package org.zwhy.swag.blog.dao;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.po.Blog;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 16:03
 */
public interface BlogDao {

    Blog getBlog(Long id);

    PageInfo<Blog> listBlog(Blog blog, Integer page, Integer pageSize);

    boolean saveBlog(Blog blog);

    boolean updateBlog(Blog blog);

    boolean deleteBlog(Long id);

    Blog getBlogByTitle(String title);

    PageInfo<Blog> listBlog(Integer start, Integer size);

    List<Blog> getRecommendBlogs(Integer size);

    PageInfo<Blog> listBlogByContent(String query, Integer start, Integer size);
}
