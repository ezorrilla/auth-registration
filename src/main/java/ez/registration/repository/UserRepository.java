package ez.registration.repository;

import ez.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT u FROM User u WHERE u.email = :vEmail")
    Optional<User> findByEmail(@Param("vEmail") String vEmail);

/*
    @Query(value = "SELECT u FROM user u WHERE u.token = :vToken")
    User findUserByToken(@Param("vToken") String vToken);

    @Modifying
    @Query(value = "UPDATE user u SET u.token = :vTokenUpdate WHERE u.token = :vTokenSearch")
    int revocateToken(@Param("vTokenSearch") String vTokenSearch, @Param("vTokenUpdate") String vTokenUpdate);*/
}
