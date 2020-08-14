package brg.bbrg.service;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.ReplyModel;

import java.util.List;

public interface ReplyService {
    List<ReplyModel> getRelpyListByPost(PostModel postModel);
}
