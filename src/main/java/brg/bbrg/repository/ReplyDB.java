package brg.bbrg.repository;

import brg.bbrg.model.PostModel;
import brg.bbrg.model.ReplyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReplyDB extends JpaRepository<ReplyModel, Long> {
    List<ReplyModel> findAllByPost(PostModel postModel);
}
