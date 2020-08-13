package brg.bbrg.controller;

import brg.bbrg.model.PostModel;
import brg.bbrg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String home(Model model) {
        Page<PostModel> postModelList = postService.getWithPagination10(0);
        boolean isLast = postModelList.isLast();

        model.addAttribute("postModelList", postModelList);
        model.addAttribute("isLast", isLast);
        model.addAttribute("indexNow", 0);

        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/admin";
        }
        return "login";
    }
}
