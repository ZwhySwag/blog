package org.zwhy.swag.blog.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zwhy.swag.blog.dao.BlogDao;
import org.zwhy.swag.blog.expections.NotFoundException;
import org.zwhy.swag.blog.mapper.BlogMapper;
import org.zwhy.swag.blog.po.Blog;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\1 0001 16:03
 */

@Repository
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlog(id);
    }

    @Override
    public PageInfo<Blog> listBlog(Blog blog, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        //查询语句必须紧跟startPage方法
        List<Blog> blogs = blogMapper.listBlog(blog);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public boolean saveBlog(Blog blog) {
        int row = blogMapper.saveBlog(blog);
        return row == 1 ? true : false;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        Blog existBlog = getBlog(blog.getId());
        if(existBlog == null) {
            throw new NotFoundException("该博客记录不存在");
        }
        BeanUtils.copyProperties(blog, existBlog);
        int row = blogMapper.updateBlog(existBlog);
        return row == 1? true : false;
    }

    @Override
    public boolean deleteBlog(Long id) {
        return blogMapper.deleteBlog(id) == 1? true : false;
    }

    @Override
    public Blog getBlogByTitle(String title) {
        return blogMapper.getBlogByTitle(title);
    }
}
