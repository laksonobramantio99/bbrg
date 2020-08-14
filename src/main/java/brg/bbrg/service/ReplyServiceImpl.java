package brg.bbrg.service;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.ReplyModel;
import brg.bbrg.repository.ReplyDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDB replyDB;

    @Override
    public List<ReplyModel> getRelpyListByPost(PostModel postModel) {
        return replyDB.findAllByPost(postModel);
    }
}
