package brg.bbrg.controller;

import brg.bbrg.model.PostModel;
import brg.bbrg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/post")
public class AdminPostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public String manageAccount(Model model) {
        List<PostModel> postModelList = postService.getAllPost();
        model.addAttribute("postModelList", postModelList);

        return "adminpost-manage";
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        PostModel postModel = new PostModel();
        model.addAttribute("postModel", postModel);

        return "adminpost-addpost";
    }
}
