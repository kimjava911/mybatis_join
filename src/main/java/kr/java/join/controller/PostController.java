package kr.java.join.controller;

import jakarta.servlet.http.HttpSession;
import kr.java.join.model.domain.Post;
import kr.java.join.model.dto.UserLoginDTO;
import kr.java.join.model.dto.UserLoginWithInfoDTO;
import kr.java.join.model.mapper.PostMapper;
import kr.java.join.model.mapper.UserLoginMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostMapper postMapper;
    private final UserLoginMapper loginMapper;

    public PostController(PostMapper postMapper, UserLoginMapper loginMapper) {
        this.postMapper = postMapper;
        this.loginMapper = loginMapper;
    }

    @GetMapping
    public String page(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("posts", postMapper.findByUsername(username));
        return "post";
    }

    @PostMapping
    public String post(
            @ModelAttribute Post p,
            HttpSession session) {
        String username = (String) session.getAttribute("username");
        UserLoginWithInfoDTO user = loginMapper.findByUsernameWithInfo(username);
        p.setInfoId(user.getUserInfo().getInfoId());
        postMapper.insert(p);
        return "redirect:/post";
    }
}
