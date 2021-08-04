package org.zwhy.swag.blog.dao;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\3 0003 21:19
 */
public interface BlogTagDao {
    void saveBlogTagRelation(Long id, String tagIds);

    List<Long> getTagIdsByBlogId(Long id);

    void updateRelation(Long id, String tagIds);
}
