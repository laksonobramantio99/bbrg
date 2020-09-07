package brg.bbrg.repository;

import brg.bbrg.model.StaticPageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaticPageDB extends JpaRepository<StaticPageModel, Long> {
    Optional<StaticPageModel> findByTitle(String title);
    Optional<StaticPageModel> findById(Long id);
}
