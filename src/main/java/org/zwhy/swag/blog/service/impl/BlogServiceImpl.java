package org.zwhy.swag.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zwhy.swag.blog.dao.BlogDao;
import org.zwhy.swag.blog.dao.BlogTagDao;
import org.zwhy.swag.blog.dao.TagDao;
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

    @Autowired
    private TagDao tagDao;

    @Override
    public Blog getBlogByTitle(String title) {
        return blogDao.getBlogByTitle(title);
    }

    @Override
    public Blog getBlog(Long id) {
        Blog blog = blogDao.getBlog(id);
        List<Long> tagIds = blogTagDao.getTagIdsByBlogId(id);
        List<Tag> tags = tagDao.listTagByIds(tagIds);
        blog.setTags(tags);
        return blog;
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
        initBooleanValue(blog);
        boolean success = blogDao.saveBlog(blog);
        if (!success) {
            return false;
        }
        if (blog.getTags().size() > 0) {
            blogTagDao.saveBlogTagRelation(blog.getId(), blog.getTagIds());
        }
        return true;
    }

    private void initBooleanValue(Blog blog) {
        if (blog.getAppreciation() == null) {
            blog.setAppreciation(false);
        }
        if (blog.getCommentable() == null) {
            blog.setCommentable(false);
        }
        if (blog.getPublished() == null) {
            blog.setPublished(false);
        }
        if (blog.getRecommend() == null) {
            blog.setRecommend(false);
        }
        if (blog.getShareStatement() == null) {
            blog.setShareStatement(false);
        }
    }

    @Transactional
    @Override
    public boolean updateBlog(Blog blog) {
        boolean result = blogDao.updateBlog(blog);
        blogTagDao.updateRelation(blog.getId(), blog.getTagIds());
        return result;
    }

    @Transactional
    @Override
    public boolean deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }

    @Override
    public PageInfo<Blog> listBlog(Integer start, Integer size) {
        return blogDao.listBlog(start, size);
    }

    @Override
    public List<Blog> getRecommendBlogs(Integer size) {
        return blogDao.getRecommendBlogs(size);
    }
}
