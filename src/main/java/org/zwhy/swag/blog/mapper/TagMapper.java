package org.zwhy.swag.blog.mapper;

import org.apache.ibatis.annotations.Param;
import org.zwhy.swag.blog.po.Tag;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:37
 */
public interface TagMapper {

    Integer saveTag(Tag tag);

    Tag getTagByName(String name);

    Tag getTag(Long id);

    Integer updateTag(@Param("id") Long id, @Param("tag") Tag tag);

    Integer deleteTag(Long id);

    List<Tag> listTag(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    Long getTotalRecordCount();

    List<Tag> getAllTag();

    List<Tag> listTagByIds(List<Long> idList);
}

