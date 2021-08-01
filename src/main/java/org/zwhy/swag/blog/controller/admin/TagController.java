package org.zwhy.swag.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zwhy.swag.blog.VO.common.ResponseResult;
import org.zwhy.swag.blog.po.Tag;
import org.zwhy.swag.blog.service.TagService;

import javax.validation.Valid;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 17:16
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;


    @GetMapping("/tag/input")
    public String tagInput(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tag-input";
    }

    @GetMapping("/tags")
    public String tags(Model model,
                        @RequestParam(value = "start", defaultValue = "1") int start,
                        @RequestParam(value = "size", defaultValue = "5")int size) {
        PageInfo<Tag> pageInfo = tagService.listTag(start, size);
        model.addAttribute("page", pageInfo);
        return "admin/tags";
    }

    @PostMapping("/tag/save")
    public String saveTag(@Valid Tag tag,
                           BindingResult bindingResult, //必须紧挨Tag参数
                           RedirectAttributes attributes) {
        Tag result = tagService.getTagByName(tag.getName());
        if (result != null) {
            bindingResult.rejectValue("name", "nameError", "不能添加重复的分类名称");
        }
        if (bindingResult.hasErrors()) {
            return "admin/tag-input";
        }
        tagService.saveTag(tag);
        attributes.addFlashAttribute("message", "操作成功");
        return "redirect:/admin/tags";
    }

    @GetMapping("/tag/delete/{id}")
    public String deleteTag(@PathVariable Long id,
                             RedirectAttributes attributes) {
        boolean result = tagService.deleteTag(id);
        if (result) {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tag/edit/{id}")
    public String editTag(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag", tag);
        return "admin/tag-input";
    }

    @PostMapping("/tag/update/{id}")
    public String updateTag(@Valid Tag tag,
                             BindingResult bindingResult,
                             @PathVariable Long id,
                             RedirectAttributes attributes) {
        Tag result = tagService.getTagByName(tag.getName());
        if (result != null) {
            bindingResult.rejectValue("name", "nameError", tag.getName() + "已经存在...");
        }
        if (bindingResult.hasErrors()) {
            return "admin/tag-input";
        }
        attributes.addFlashAttribute("message", "修改成功");
        tagService.updateTag(id, tag);
        return "redirect:/admin/tags";
    }

    @GetMapping("/tag/{id}")
    public ResponseResult<Tag> getTag(@PathVariable Long id) {
        Tag tag = tagService.getTag(id);
        boolean result = tag == null ? false : true;
        return ResponseResult.getObjectResponseByResult(result, tag);
    }

}
