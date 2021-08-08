package org.zwhy.swag.blog.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ZWHySwag
 * @date 2021\8\3 0003 21:29
 */
public interface BlogTagMapper {

    void saveBlogTagRelation(@Param("id") Long id, @Param("list") List<Long> idList);

    List<Long> getTagIdsByBlogId(Long id);

    void deleteRelationByBlogId(Long id);

    void deleteRelationByTagId(Long id);

    List<Long> getFixedTagIds(Integer size);
}
