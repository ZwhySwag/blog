package org.zwhy.swag.blog.dao;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.po.Blog;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 16:03
 */
public interface BlogDao {

    Blog getBlog(Long id);

    PageInfo<Blog> listBlog(Blog blog, Integer page, Integer pageSize);

    boolean saveBlog(Blog blog);

    boolean updateBlog(Long id, Blog blog);

    boolean deleteBlog(Long id);
}
