package kr.java.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ComponentScan
@RequestMapping // DispatcherServlet -> '/'
public class LoginController {
    @GetMapping
    public String index() {
        return "index";
    }
}
