package org.zwhy.swag.blog.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zwhy.swag.blog.VO.common.Page;
import org.zwhy.swag.blog.dao.TypeDao;
import org.zwhy.swag.blog.mapper.TypeMapper;
import org.zwhy.swag.blog.po.Type;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:32
 */
@Repository
public class TypeDaoImpl implements TypeDao {

    @Autowired
    private TypeMapper typeMapper;


    @Override
    public Integer saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Override
    public PageInfo<Type> listType(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        //查询语句必须紧跟startPage方法
        List<Type> types = typeMapper.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        return pageInfo;
    }

    @Override
    public Integer updateType(Long id, Type type) {
        return typeMapper.updateType(id, type);
    }

    @Override
    public Integer deleteType(Long id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }
}
