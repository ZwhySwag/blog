package org.zwhy.swag.blog.service;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.po.Blog;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 15:59
 */
public interface BlogService {

    Blog getBlogByTitle(String title);

    Blog getBlog(Long id);

    PageInfo<Blog> listBlog(Blog blog, Integer page, Integer pageSize);

    boolean saveBlog(Blog blog);

    boolean updateBlog(Blog blog);

    boolean deleteBlog(Long id);
}
