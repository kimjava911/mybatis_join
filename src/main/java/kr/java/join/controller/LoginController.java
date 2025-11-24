package kr.java.join.controller;

import jakarta.servlet.http.HttpSession;
import kr.java.join.model.dto.UserLoginDTO;
import kr.java.join.model.mapper.UserLoginMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // ComponentScan
@RequestMapping // DispatcherServlet -> '/'
public class LoginController {
    private final UserLoginMapper userLoginMapper;

    // 생성자 주입
    public LoginController(UserLoginMapper userLoginMapper) {
        this.userLoginMapper = userLoginMapper;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String login(
            @ModelAttribute UserLoginDTO dto,
            RedirectAttributes redirectAttributes,
            HttpSession session) {
        UserLoginDTO user = userLoginMapper.findByUsername(dto.username());
        if (user == null || !user.password().equals(dto.password())) {
            redirectAttributes.addFlashAttribute(
                    "msg", "잘못된 계정정보/비밀번호 입니다!");
        } else {
            session.setAttribute("username", user.username());
        }
        return "redirect:/";
    }
}
