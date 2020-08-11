package brg.bbrg.service;

import brg.bbrg.model.PostModel;
import brg.bbrg.repository.PostDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDB postDB;

    @Override
    public List<PostModel> getAllPost() {
        return postDB.findAll();
    }

    @Override
    public PostModel createNewPost(PostModel postModel) {
        return postDB.save(postModel);
    }
}
