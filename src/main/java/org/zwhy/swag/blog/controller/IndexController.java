package org.zwhy.swag.blog.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zwhy.swag.blog.expections.NotFoundException;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.po.Tag;
import org.zwhy.swag.blog.po.Type;
import org.zwhy.swag.blog.service.BlogService;
import org.zwhy.swag.blog.service.TagService;
import org.zwhy.swag.blog.service.TypeService;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(value = "start", defaultValue = "1") Integer start,
                        @RequestParam(value = "size", defaultValue = "5")Integer size) {
        PageInfo<Blog> pageInfo = blogService.listBlog(start, size);
        List<Type> types = typeService.getFixedList(6);
        List<Map> tags = tagService.getFixedList(10);
        List<Blog> blogs = blogService.getRecommendBlogs(8);
        model.addAttribute("page", pageInfo);
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);
        model.addAttribute("recommendBlogs", blogs);
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/404")
    public String u404() {
        if (true){
            throw new NotFoundException("资源未找到");
        }
        return "index";
    }

    @GetMapping("/aspect/{id}/{name}")
    public String testAspect(@PathVariable Integer id,
                             @PathVariable String name) {
        System.out.println("==========index==========");
        return "index";
    }

}
