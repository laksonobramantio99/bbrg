package brg.bbrg.controller;

import brg.bbrg.model.StaticPageModel;
import brg.bbrg.service.StaticPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StaticPageService staticPageService;

    @GetMapping(value = "")
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping(value = "/static-page")
    public String staticPage(Model model) {
        List<StaticPageModel> staticPageModelList = staticPageService.getAll();
        model.addAttribute("staticPageModelList", staticPageModelList);
        return "admin-staticpage-manage";
    }

    @GetMapping(value = "/static-page/edit")
    public String editStaticPage(@RequestParam Long id, Model model) {
        StaticPageModel staticPageModel = staticPageService.getById(id);
        model.addAttribute("staticPageModel", staticPageModel);
        return "admin-staticpage-edit";
    }
}
