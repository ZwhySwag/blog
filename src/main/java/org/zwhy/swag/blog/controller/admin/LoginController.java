package org.zwhy.swag.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zwhy.swag.blog.po.User;
import org.zwhy.swag.blog.service.UserService;
import org.zwhy.swag.blog.utils.MD5Utils;

import javax.servlet.http.HttpSession;

/**
 * @author ZWHySwag
 * @date 2021\7\29 0029 22:38
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @return
     */
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    /**
     *
     * @param username
     * @param password
     * @param session
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, MD5Utils.encode(password));
        if (user != null) {
            //用户放入session前屏蔽密码
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            //密码错误重定向到登录页
            redirectAttributes.addFlashAttribute("message", "用户名或者密码错误！");
            return "redirect:/admin";
        }
    }

    /**
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    private String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
