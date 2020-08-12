package brg.bbrg.service;

import brg.bbrg.model.PostModel;

import java.util.List;

public interface PostService {
    List<PostModel> getAllPostOrderByDatePostedDesc();
    PostModel createNewPost(PostModel postModel);
    PostModel getById(Long id);
    void deletePost(PostModel postModel);
}
