package brg.bbrg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/group-members")
public class AdminGroupMembersController {

    @GetMapping("")
    public String groupMembersManage() {
        return "admingroupmembers-manage";
    }

}
