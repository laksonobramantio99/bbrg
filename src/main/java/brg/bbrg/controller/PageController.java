package brg.bbrg.controller;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.StaticPageModel;
import brg.bbrg.rest.PublicationsData;
import brg.bbrg.restservice.PublicationsRestService;
import brg.bbrg.service.PostService;
import brg.bbrg.service.StaticPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private PostService postService;

    @Autowired
    private PublicationsRestService publicationsRestService;

    @Autowired
    private StaticPageService staticPageService;

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

    @GetMapping("/post-page")
    public String postPage(@RequestParam Integer p, Model model) {
        Page<PostModel> postModelList = postService.getWithPagination10(p);
        boolean isLast = postModelList.isLast();

        model.addAttribute("postModelList", postModelList);
        model.addAttribute("isLast", isLast);
        model.addAttribute("indexNow", p);

        return "post-page";
    }

    @GetMapping("/lab-profile")
    public String profile(Model model) {
        StaticPageModel staticPageModel = staticPageService.getById(1L);
        model.addAttribute("staticPageModel", staticPageModel);
        return "about-lab-profile";
    }

    @GetMapping("/research-topics")
    public String topicOfInterest(Model model) {
        StaticPageModel staticPageModel = staticPageService.getById(2L);
        model.addAttribute("staticPageModel", staticPageModel);
        return "about-research-topics";
    }

    @GetMapping("/publications")
    public String publications(Model model) {
        PublicationsData publicationsData =  publicationsRestService.getPublicationsData();
        model.addAttribute("publicationList", publicationsData.getPublicationList());

        return "publications";
    }

    @GetMapping("/group-members")
    public String groupMembers(Model model) {
        StaticPageModel staticPageModel = staticPageService.getById(3L);
        model.addAttribute("staticPageModel", staticPageModel);
        return "group-members";
    }

    @GetMapping("/contact-location")
    public String contactLocation() {
        return "contact-location";
    }
}
