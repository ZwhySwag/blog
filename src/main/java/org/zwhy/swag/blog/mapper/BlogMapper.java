package org.zwhy.swag.blog.mapper;


import org.zwhy.swag.blog.po.Blog;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 16:04
 */
public interface BlogMapper {

    Blog getBlog(Long id);

    List<Blog> listBlog(Blog blog);

    int saveBlog(Blog blog);

    int updateBlog(Long id, Blog blog);

    int deleteBlog(Long id);
}
