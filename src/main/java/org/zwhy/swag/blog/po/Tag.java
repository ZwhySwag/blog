package org.zwhy.swag.blog.po;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\28 0028 21:05
 */
public class Tag {

    private Long id;

    @NotBlank(message = "标签名称不能为空...")
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
