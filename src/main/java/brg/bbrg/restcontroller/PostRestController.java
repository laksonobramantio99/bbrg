package brg.bbrg.restcontroller;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.ReplyModel;
import brg.bbrg.service.PostService;
import brg.bbrg.service.ReplyService;
import brg.bbrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    @PostMapping("/createPost")
    public Map<String, Object> createPost(@ModelAttribute PostModel postModel) {
        LocalDateTime now = LocalDateTime.now();
        postModel.setDatePosted(now);
        postModel.setDraft(false);
        postModel.setUser(userService.getCurrentUser());
        postService.savePost(postModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/createPostAsDraft")
    public Map<String, Object> createPostAsDraft(@ModelAttribute PostModel postModel) {
        LocalDateTime now = LocalDateTime.now();
        postModel.setDatePosted(now);
        postModel.setDraft(true);
        postModel.setUser(userService.getCurrentUser());
        postService.savePost(postModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/editPost")
    public Map<String, Object> editPost(@ModelAttribute PostModel postModel) {
        PostModel postEdited = postService.getById(postModel.getId());
        postEdited.setTitle(postModel.getTitle());
        postEdited.setContent(postModel.getContent());

        LocalDateTime now = LocalDateTime.now();
        postEdited.setDateLastEdit(now);
        postEdited.setDraft(false);
        postService.savePost(postEdited);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/editPostAsDraft")
    public Map<String, Object> editPostAsDraft(@ModelAttribute PostModel postModel) {
        PostModel postEdited = postService.getById(postModel.getId());
        postEdited.setTitle(postModel.getTitle());
        postEdited.setContent(postModel.getContent());

        LocalDateTime now = LocalDateTime.now();
        postEdited.setDateLastEdit(now);
        postEdited.setDraft(true);
        postService.savePost(postEdited);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/delete/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        PostModel postModel = postService.getById(id);
        postService.deletePost(postModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/reply")
    public Map<String, Object> deleteUser(HttpServletRequest req) {
        String comment = req.getParameter("comment");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String idpost = req.getParameter("idpost");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(comment);
        System.out.println(name);

        PostModel postModel = postService.getById(Long.valueOf(idpost));
        ReplyModel replyModel = new ReplyModel();
        replyModel.setComment(comment);
        replyModel.setName(name);
        replyModel.setEmail(email);
        replyModel.setDatePosted(now);
        replyModel.setPost(postModel);
        replyService.addReply(replyModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }
}
