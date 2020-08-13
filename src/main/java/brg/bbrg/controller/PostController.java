package brg.bbrg.controller;

import brg.bbrg.model.PostModel;
import brg.bbrg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public String postDetail(@RequestParam Long id,  Model model) {
        PostModel postModel = postService.getById(id);
        model.addAttribute("post", postModel);

        return "post-detail";
    }
}
