package br.com.letscode.java.moviesbattle.quiz.competition;

import br.com.letscode.java.moviesbattle.quiz.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizRepository extends JpaRepository<UserQuiz, UUID> {

    Optional<UserQuiz> findFirstByUserAndAnsweredFalse(User user);

    UserQuiz findByUserAndQuizId(User user, UUID quizId);

}
