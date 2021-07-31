package org.zwhy.swag.blog.service;

import com.github.pagehelper.PageInfo;
import org.zwhy.swag.blog.VO.common.Page;
import org.zwhy.swag.blog.po.Type;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 16:27
 */
public interface TypeService {

    Boolean saveType(Type type);

    Type getType(Long id);

    PageInfo<Type> listType(Integer page, Integer pageSize);

    Boolean updateType(Long id, Type type);

    Boolean deleteType(Long id);

    Type getTypeByName(String name);
}
