package cvmaker.app.userdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity, Long> {
    Optional<UserDataEntity> findByUsername(final String email);
}
