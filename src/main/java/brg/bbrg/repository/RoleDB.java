package brg.bbrg.repository;

import brg.bbrg.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDB extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findById(Integer id);
}
