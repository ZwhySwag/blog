package org.zwhy.swag.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zwhy.swag.blog.dao.BlogDao;
import org.zwhy.swag.blog.dao.BlogTagDao;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.po.Tag;
import org.zwhy.swag.blog.service.BlogService;

import java.util.Date;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 16:02
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private BlogTagDao blogTagDao;

    @Override
    public Blog getBlogByTitle(String title) {
        return blogDao.getBlogByTitle(title);
    }

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    @Override
    public PageInfo<Blog> listBlog(Blog blog, Integer page, Integer pageSize) {
        PageInfo<Blog> blogPage = blogDao.listBlog(blog, page, pageSize);
        return blogPage;
    }

    @Transactional
    @Override
    public boolean saveBlog(Blog blog) {
        Date date = new Date();
        blog.setCreateTime(date);
        blog.setUpdateTime(date);
        blog.setViews(0);
        boolean success = blogDao.saveBlog(blog);
        if (!success) {
            return false;
        }
        if (blog.getTags().size() > 0) {
            blogTagDao.saveBlogTagRelation(blog.getId(), blog.getTagIds());
        }
        return true;
    }

    @Transactional
    @Override
    public boolean updateBlog(Long id, Blog blog) {
        return blogDao.updateBlog(id, blog);
    }

    @Transactional
    @Override
    public boolean deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }
}
