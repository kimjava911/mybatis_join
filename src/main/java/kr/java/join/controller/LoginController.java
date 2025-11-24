package kr.java.join.controller;

import jakarta.servlet.http.HttpSession;
import kr.java.join.model.dto.UserLoginDTO;
import kr.java.join.model.mapper.PostMapper;
import kr.java.join.model.mapper.UserLoginMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // ComponentScan
@RequestMapping // DispatcherServlet -> '/'
public class LoginController {
    private final UserLoginMapper userLoginMapper;
    private final PostMapper postMapper;

    // 생성자 주입
    public LoginController(UserLoginMapper userLoginMapper, PostMapper postMapper) {
        this.userLoginMapper = userLoginMapper;
        this.postMapper = postMapper;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("posts", postMapper.findAll(username));
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

    @GetMapping("/info")
    public String info(HttpSession session,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            redirectAttributes.addFlashAttribute(
                    "msg", "로그인이 필요합니다!");
            return "redirect:/";
        }
        model.addAttribute("info", userLoginMapper.findByUsernameWithInfo(username));
        model.addAttribute("recommend", postMapper.findByRecommend(username));
        return "info";
    }
}
