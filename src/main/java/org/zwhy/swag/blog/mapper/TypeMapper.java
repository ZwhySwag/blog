package org.zwhy.swag.blog.mapper;

import org.apache.ibatis.annotations.Param;
import org.zwhy.swag.blog.po.Type;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:37
 */
public interface TypeMapper {

    Integer saveType(Type type);

    Type getTypeByName(String name);

    Type getType(Long id);

    Integer updateType(@Param("id") Long id, @Param("type") Type type);

    Integer deleteType(Long id);

    List<Type> listType(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    Long getTotalRecordCount();

    List<Type> getAllType();

    List<Type> getFixedList(Integer size);
}

