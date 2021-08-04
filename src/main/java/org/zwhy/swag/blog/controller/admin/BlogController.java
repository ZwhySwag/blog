package org.zwhy.swag.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zwhy.swag.blog.po.Blog;
import org.zwhy.swag.blog.po.Tag;
import org.zwhy.swag.blog.po.Type;
import org.zwhy.swag.blog.po.User;
import org.zwhy.swag.blog.service.BlogService;
import org.zwhy.swag.blog.service.TypeService;
import org.zwhy.swag.blog.service.TagService;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private TagService tagService;

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
                        @RequestParam(value = "size", defaultValue = "5")Integer size) {
        if (blog.getTypeId() != null && blog.getTypeId() > 0) {
            Type type = typeService.getType(blog.getTypeId());
            blog.setType(type);
        }
        PageInfo<Blog> pageInfo = blogService.listBlog(blog, start, size);
        model.addAttribute("page", pageInfo);
        return "/admin/blogmanage :: blogList";
    }

    @GetMapping("/blog/input")
    public String publish(Model model) {
        Blog blog = new Blog();
        Type type = new Type();
        blog.setType(type);
        model.addAttribute("blog", blog);
        List<Type> types = typeService.listAllType();
        List<Tag> tags = tagService.listAllTag();
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);
        return "admin/publish";
    }

    @GetMapping("/blog/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       Model model) {
        model.addAttribute("types",  typeService.listAllType());
        model.addAttribute("tags", tagService.listAllTag());
        Blog blog = blogService.getBlog(id);
        blog.init();
        model.addAttribute("blog", blog);
        return "admin/publish";
    }

    @PostMapping("/blog/update")
    public String update(Blog blog,
                         HttpSession session,
                         RedirectAttributes attributes) {
        boolean success = blogService.updateBlog(blog);
        if (success) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/admin/blogs";
    }



    @GetMapping("/blog/delete/{id}")
    public String publish(@PathVariable Long id,
                          RedirectAttributes attributes) {
        boolean result = blogService.deleteBlog(id);
        if (result) {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blog/post")
    public String post(Blog blog,
                       HttpSession session,
                       RedirectAttributes attributes) {
        Blog result = blogService.getBlogByTitle(blog.getTitle());
        if (result != null) {
            attributes.addFlashAttribute("message", "新增失败,已存在同名文章");
            return "redirect:/admin/blogs";
        }
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        boolean success = blogService.saveBlog(blog);
        if (success) {
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/blogs";
    }
}
