package brg.bbrg.repository;

import brg.bbrg.model.PostModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostDB extends JpaRepository<PostModel, Long> {
    Page<PostModel> findAllByIsDraft(Boolean isDraft, Pageable pageable);
    Optional<PostModel> findById(Long id);
    List<PostModel> findAllByTitleContainingIgnoreCaseAndIsDraftOrContentContainingIgnoreCaseAndIsDraftOrderByDatePostedDesc(String keyword1, Boolean isDraft1, String keyword2, Boolean isDraft2);
}
