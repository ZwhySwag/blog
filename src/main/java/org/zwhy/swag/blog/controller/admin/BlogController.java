package org.zwhy.swag.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.po.Type;
import org.zwhy.swag.blog.service.BlogService;
import org.zwhy.swag.blog.service.TypeService;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 15:26
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(Model model,
                        Blog blog,
                        @RequestParam(value = "start", defaultValue = "1") Integer start,
                        @RequestParam(value = "size", defaultValue = "5")Integer size) {
        PageInfo<Blog> pageInfo = blogService.listBlog(blog, start, size);
        model.addAttribute("page", pageInfo);
        List<Type> types = typeService.listAllType();
        model.addAttribute("types", types);
        return "/admin/blogmanage";
    }

    /**
     *thymeleaf继承ajax,只刷新页面的blogList片段
     */
    @PostMapping("/blog/search")
    public String search(Model model,
                        Blog blog,
                        @RequestParam(value = "start", defaultValue = "1") Integer start,
                        @RequestParam(value = "size", defaultValue = "5")Integer size,
                        @RequestParam(value = "typeId", required = false) Long typeId) {
        if (typeId > 0) {
            Type type = typeService.getType(typeId);
            blog.setType(type);
        }
        PageInfo<Blog> pageInfo = blogService.listBlog(blog, start, size);
        model.addAttribute("page", pageInfo);
        return "/admin/blogmanage :: blogList";
    }
}
