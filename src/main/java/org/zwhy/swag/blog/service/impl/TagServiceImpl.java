package org.zwhy.swag.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zwhy.swag.blog.dao.TagDao;
import org.zwhy.swag.blog.po.Tag;
import org.zwhy.swag.blog.service.TagService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:31
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Transactional
    @Override
    public Boolean saveTag(Tag tag) {
        Boolean result = tagDao.saveTag(tag) == 1 ? true : false;
        return result;
    }

    @Override
    public Tag getTag(Long id) {
        return tagDao.getTag(id);
    }

    @Transactional
    @Override
    public PageInfo<Tag> listTag(Integer page, Integer pageSize) {
        return tagDao.listTag(page, pageSize);
    }

    @Override
    public List<Tag> listTag(String ids) {
        List<Long> idList = new ArrayList<>();
        if (ids != null && !"".equals(ids.trim())) {
            Arrays.stream(ids.split(",")).forEach(id -> {
                idList.add(Long.valueOf(id));
            });
        }
        if (idList.size() > 0) {
            return tagDao.listTagByIds(idList);
        }
        return new ArrayList<Tag>();
    }

    @Transactional
    @Override
    public Boolean updateTag(Long id, Tag tag) {
        Boolean result = tagDao.updateTag(id, tag) == 1 ? true : false;
        return result;
    }

    @Transactional
    @Override
    public Boolean deleteTag(Long id) {
        Boolean result = tagDao.deleteTag(id) == 1 ? true : false;
        return result;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.getTagByName(name);
    }

    @Override
    public List<Tag> listAllTag() {
        return tagDao.listAllTag();
    }

    @Override
    public List<Map> getFixedList(Integer size) {
        return tagDao.getFixedList(size);
    }
}
