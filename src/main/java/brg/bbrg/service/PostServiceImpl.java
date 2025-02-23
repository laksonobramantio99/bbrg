package brg.bbrg.service;

import brg.bbrg.model.PostModel;
import brg.bbrg.repository.PostDB;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDB postDB;

    @Override
    public List<PostModel> getAllPost() {
        return postDB.findAll();
    }

    @Override
    public PostModel savePost(PostModel postModel) {
        String cleanedText = Jsoup.parse(postModel.getContent()).text();
        String previewText = cleanedText.substring(0, Math.min(cleanedText.length(), 500)) + "...";
        postModel.setPreviewContent(previewText);
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
        Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by(Sort.Direction.DESC, "datePosted"));
        Page<PostModel> page = postDB.findAllByIsDraft(false, pageable);
        return page;
    }

    @Override
    public List<PostModel> searchPost(String keyword) {
        List<PostModel> postModelsearched = postDB.findAllByTitleContainingIgnoreCaseAndIsDraftOrContentContainingIgnoreCaseAndIsDraftOrderByDatePostedDesc(keyword, false, keyword, false);
        return postModelsearched;
    }
}
