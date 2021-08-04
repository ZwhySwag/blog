package org.zwhy.swag.blog.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\8\3 0003 21:29
 */
public interface BlogTagMapper {

    void saveBlogTagRelation(@Param("id") Long id, @Param("list") List<Long> idList);

    List<Long> getTagIdsByBlogId(Long id);

    void deleteRelationByBlogId(Long id);
}
