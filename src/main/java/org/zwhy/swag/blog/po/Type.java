package org.zwhy.swag.blog.po;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\28 0028 21:04
 */
public class Type {

    private Long id;

    @NotBlank(message = "分类名称不能为空")
    private String name;

    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
