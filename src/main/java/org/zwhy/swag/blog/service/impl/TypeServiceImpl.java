package org.zwhy.swag.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zwhy.swag.blog.VO.common.Page;
import org.zwhy.swag.blog.dao.TypeDao;
import org.zwhy.swag.blog.po.Type;
import org.zwhy.swag.blog.service.TypeService;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:31
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional
    @Override
    public Boolean saveType(Type type) {
        Boolean result = typeDao.saveType(type) == 1 ? true : false;
        return result;
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    @Override
    public PageInfo<Type> listType(Integer page, Integer pageSize) {
        return typeDao.listType(page, pageSize);
    }

    @Transactional
    @Override
    public Boolean updateType(Long id, Type type) {
        Boolean result = typeDao.updateType(id, type) == 1 ? true : false;
        return result;
    }

    @Transactional
    @Override
    public Boolean deleteType(Long id) {
        Boolean result = typeDao.deleteType(id) == 1 ? true : false;
        return result;
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }
}
