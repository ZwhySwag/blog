package org.zwhy.swag.blog.dao;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.po.Type;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:32
 */
public interface TypeDao {
    Integer saveType(Type type);

    Type getType(Long id);

    PageInfo<Type> listType(Integer page, Integer pageSize);

    Integer updateType(Long id, Type type);

    Integer deleteType(Long id);

    Type getTypeByName(String name);
}
