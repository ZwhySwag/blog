package org.zwhy.swag.blog.mapper;


import com.github.pagehelper.PageInfo;
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

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    Blog getBlogByTitle(String title);

    List<Blog> listBlogWithoutCondition();

    List<Blog> getBlogsByTypeId(Long typeId);

    List<Blog> getRecommendBlogs(Integer size);
}

