package brg.bbrg.service;

import brg.bbrg.model.PostModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    List<PostModel> getAllPostOrderByDatePostedDesc();
    PostModel savePost(PostModel postModel);
    PostModel getById(Long id);
    void deletePost(PostModel postModel);
    Page<PostModel> getWithPagination10(int pageIndex);
}
