package brg.bbrg.restcontroller;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.ReplyModel;
import brg.bbrg.model.StaticPageModel;
import brg.bbrg.service.PostService;
import brg.bbrg.service.ReplyService;
import brg.bbrg.service.StaticPageService;
import brg.bbrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/static-page")
public class StaticPageRestController {

    @Autowired
    private StaticPageService staticPageService;

    @PostMapping("/edit")
    public Map<String, Object> editPageContent(@ModelAttribute StaticPageModel staticPageModel) {
        StaticPageModel pageEdited = staticPageService.getById(staticPageModel.getId());
        pageEdited.setContent(staticPageModel.getContent());

        LocalDateTime now = LocalDateTime.now();
        pageEdited.setDateLastEdit(now);
        staticPageService.savePage(pageEdited);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }
}
