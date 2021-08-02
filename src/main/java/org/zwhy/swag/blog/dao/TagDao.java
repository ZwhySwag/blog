package org.zwhy.swag.blog.dao;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.po.Tag;

import java.util.List;


/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:32
 */
public interface TagDao {
    Integer saveTag(Tag tag);

    Tag getTag(Long id);

    PageInfo<Tag> listTag(Integer page, Integer pageSize);

    Integer updateTag(Long id, Tag tag);

    Integer deleteTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listAllTag();

    List<Tag> listTagByIds(List<Long> idList);
}

