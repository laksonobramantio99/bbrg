package brg.bbrg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class GroupMembersController {

    @GetMapping("/group-members")
    public String groupMember() {
        return "group-members";
    }
}
