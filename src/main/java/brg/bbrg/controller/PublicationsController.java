package brg.bbrg.controller;

import brg.bbrg.rest.Publication;
import brg.bbrg.rest.PublicationsData;
import brg.bbrg.restservice.PublicationsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PublicationsController {

    @Autowired
    private PublicationsRestService publicationsRestService;

    @GetMapping("/publications")
    public String publications(Model model) {
        PublicationsData publicationsData =  publicationsRestService.getPublicationsData();
        model.addAttribute("publicationList", publicationsData.getPublicationList());

        return "publications";
    }
}
