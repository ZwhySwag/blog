package org.zwhy.swag.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zwhy.swag.blog.VO.common.Page;
import org.zwhy.swag.blog.VO.common.ResponseResult;
import org.zwhy.swag.blog.po.Type;
import org.zwhy.swag.blog.service.TypeService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 17:16
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;


    @GetMapping("/type/input")
    public String typeInput(Model model) {
        model.addAttribute("type", new Type());
        return "admin/type-input";
    }

    @GetMapping("/types")
    public String types(Model model,
                        @RequestParam(value = "start", defaultValue = "1") int start,
                        @RequestParam(value = "size", defaultValue = "5")int size) {
        PageInfo<Type> pageInfo = typeService.listType(start, size);
        model.addAttribute("page", pageInfo);
        return "admin/types";
    }

    @PostMapping("/type/save")
    public String saveType(@Valid Type type,
                           BindingResult bindingResult, //必须紧挨Type参数
                           RedirectAttributes attributes) {
        Type result = typeService.getTypeByName(type.getName());
        if (result != null) {
            bindingResult.rejectValue("name", "nameError", "不能添加重复的分类名称");
        }
        if (bindingResult.hasErrors()) {
            return "admin/type-input";
        }
        typeService.saveType(type);
        attributes.addFlashAttribute("message", "操作成功");
        return "redirect:/admin/types";
    }

    @GetMapping("/type/delete/{id}")
    public String deleteType(@PathVariable Long id,
                             RedirectAttributes attributes) {
        boolean result = typeService.deleteType(id);
        if (result) {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/type/edit/{id}")
    public String editType(@PathVariable Long id, Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("type", type);
        return "admin/type-input";
    }

    @PostMapping("/type/update/{id}")
    public String updateType(@Valid Type type,
                             BindingResult bindingResult,
                             @PathVariable Long id,
                             RedirectAttributes attributes) {
        Type result = typeService.getTypeByName(type.getName());
        if (result != null) {
            bindingResult.rejectValue("name", "nameError", type.getName() + "已经存在...");
        }
        if (bindingResult.hasErrors()) {
            return "admin/type-input";
        }
        attributes.addFlashAttribute("message", "修改成功");
        typeService.updateType(id, type);
        return "redirect:/admin/types";
    }

    @GetMapping("/type/{id}")
    public ResponseResult<Type> getType(@PathVariable Long id) {
        Type type = typeService.getType(id);
        boolean result = type == null ? false : true;
        return ResponseResult.getObjectResponseByResult(result, type);
    }

}
