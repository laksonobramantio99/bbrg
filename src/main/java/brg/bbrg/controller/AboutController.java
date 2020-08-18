package brg.bbrg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AboutController {

    @GetMapping("/profile")
    public String profile() {
        return "about-profile";
    }

    @GetMapping("/topic-of-interest")
    public String topicOfInterest() {
        return "about-topic-of-interest";
    }
}
