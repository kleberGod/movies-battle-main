package br.com.letscode.java.moviesbattle.quiz;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.letscode.java.moviesbattle.movie.Movie;
import br.com.letscode.java.moviesbattle.quiz.user.User;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {

}
