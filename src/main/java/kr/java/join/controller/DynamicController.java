package kr.java.join.controller;

import kr.java.join.model.domain.Post;
import kr.java.join.model.mapper.PostMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dynamic")
public class DynamicController {
    private final PostMapper postMapper;

    public DynamicController(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @GetMapping
    public String index(Model model) {
        Post p = new Post();
        p.setInfoId(1L);
        p.setTitle("제목");
        p.setContent("내용");
        postMapper.insertPostsBatch(List.of(
                p, p, p, p, p
        ));
        model.addAttribute("result1", postMapper.findByIds(1, 2, 3));
        model.addAttribute("result2", postMapper.findWithKeyword("자바"));
        model.addAttribute("result3", postMapper.findWithKeyword("마이바티스"));
        return "dynamic";
    }
}
