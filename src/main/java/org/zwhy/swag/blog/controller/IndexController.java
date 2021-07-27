package org.zwhy.swag.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zwhy.swag.blog.expections.NotFoundException;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
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
