package br.com.letscode.java.moviesbattle.quiz.config;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, UUID> {

    Optional<Config> findConfigByKey(String key);

}
