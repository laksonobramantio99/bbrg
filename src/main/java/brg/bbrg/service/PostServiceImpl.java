package brg.bbrg.service;

import brg.bbrg.model.PostModel;
import brg.bbrg.repository.PostDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDB postDB;

    @Override
    public List<PostModel> getAllPostOrderByDatePostedDesc() {
        return postDB.findAllByOrderByDatePostedDesc();
    }

    @Override
    public PostModel savePost(PostModel postModel) {
        return postDB.save(postModel);
    }

    @Override
    public PostModel getById(Long id) {
        Optional<PostModel> postModel = postDB.findById(id);
        if (postModel.isPresent())
            return postModel.get();
        else
            return null;
    }

    @Override
    public void deletePost(PostModel postModel) {
        postDB.delete(postModel);
    }

    @Override
    public Page<PostModel> getWithPagination10(int pageIndex) {
        Page<PostModel> page = postDB.findAll(
                PageRequest.of(pageIndex, 10, Sort.by(Sort.Direction.DESC, "datePosted")));
        return page;
    }

    @Override
    public List<PostModel> searchPost(String keyword) {
        List<PostModel> postModelsearched = postDB.findAllByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrderByDatePostedDesc(keyword, keyword);
        return postModelsearched;
    }
}
