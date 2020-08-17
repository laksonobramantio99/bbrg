package brg.bbrg.controller;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.ReplyModel;
import brg.bbrg.service.PostService;
import brg.bbrg.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    @GetMapping("")
    public String postDetail(@RequestParam Long id,  Model model) {
        PostModel postModel = postService.getById(id);
        List<ReplyModel> replyModelList = replyService.getRelpyListByPost(postModel);

        model.addAttribute("post", postModel);
        model.addAttribute("replyModelList", replyModelList);

        return "post-detail";
    }
}
