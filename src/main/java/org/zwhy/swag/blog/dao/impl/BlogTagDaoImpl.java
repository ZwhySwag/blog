package org.zwhy.swag.blog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zwhy.swag.blog.dao.BlogTagDao;
import org.zwhy.swag.blog.mapper.BlogTagMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\3 0003 21:18
 */
@Repository
public class BlogTagDaoImpl implements BlogTagDao {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public void saveBlogTagRelation(Long id, String tagIds) {
        List<Long> idList = new ArrayList<>();
        if (tagIds != null && !"".equals(tagIds.trim())) {
            Arrays.stream(tagIds.split(",")).forEach(tagId -> {
                idList.add(Long.valueOf(tagId));
            });
        }
        blogTagMapper.saveBlogTagRelation(id, idList);
    }

    @Override
    public List<Long> getTagIdsByBlogId(Long id) {
        return blogTagMapper.getTagIdsByBlogId(id);
    }

    @Override
    public void updateRelation(Long id, String tagIds) {
        blogTagMapper.deleteRelationByBlogId(id);
        if (tagIds != null && !"".equals(tagIds.trim())) {
            List<Long> idList = new ArrayList<>();
            Arrays.stream(tagIds.split(",")).forEach(tagId -> {
                idList.add(Long.valueOf(tagId));
            });
            blogTagMapper.saveBlogTagRelation(id, idList);
        }
    }
}
