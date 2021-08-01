package org.zwhy.swag.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwhy.swag.blog.dao.BlogDao;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.service.BlogService;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 16:02
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    @Override
    public PageInfo<Blog> listBlog(Blog blog, Integer page, Integer pageSize) {
        PageInfo<Blog> blogPage = blogDao.listBlog(blog, page, pageSize);
        return blogPage;
    }

    @Override
    public boolean saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }

    @Override
    public boolean updateBlog(Long id, Blog blog) {
        return blogDao.updateBlog(id, blog);
    }

    @Override
    public boolean deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }
}
