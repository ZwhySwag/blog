package org.zwhy.swag.blog.service;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.po.Tag;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:27
 */
public interface TagService {

    Boolean saveTag(Tag tag);

    Tag getTag(Long id);

    PageInfo<Tag> listTag(Integer page, Integer pageSize);

    Boolean updateTag(Long id, Tag tag);

    Boolean deleteTag(Long id);

    Tag getTagByName(String name);
}