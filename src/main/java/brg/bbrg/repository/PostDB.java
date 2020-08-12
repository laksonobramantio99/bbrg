package brg.bbrg.repository;

import brg.bbrg.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostDB extends JpaRepository<PostModel, Long> {
    List<PostModel> findAllByOrderByDatePostedDesc();
    Optional<PostModel> findById(Long id);
}
