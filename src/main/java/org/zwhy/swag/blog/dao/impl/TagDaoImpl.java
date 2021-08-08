package org.zwhy.swag.blog.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zwhy.swag.blog.dao.TagDao;
import org.zwhy.swag.blog.mapper.BlogTagMapper;
import org.zwhy.swag.blog.mapper.TagMapper;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.po.Tag;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:32
 */
@Repository
public class TagDaoImpl implements TagDao {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogTagMapper blogTagMapper;


    @Override
    public Integer saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.getTag(id);
    }

    @Override
    public PageInfo<Tag> listTag(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        //查询语句必须紧跟startPage方法
        List<Tag> tags = tagMapper.getAllTag();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        return pageInfo;
    }

    @Override
    public Integer updateTag(Long id, Tag tag) {
        return tagMapper.updateTag(id, tag);
    }

    @Override
    public Integer deleteTag(Long id) {
        Integer result = tagMapper.deleteTag(id);
        blogTagMapper.deleteRelationByTagId(id);
        return result;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public List<Tag> listAllTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public List<Tag> listTagByIds(List<Long> idList) {
        return tagMapper.listTagByIds(idList);
    }

    @Override
    public List<Map> getFixedList(Integer size) {
        return tagMapper.getFixedList(size);
    }
}
