package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import javax.persistence.*;

@Entity
@RestController
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quiz {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Movie firstMovie;

    @ManyToOne
    private Movie secondMovie;

    @ManyToOne
    private Movie bestScoreMovie;


    public Quiz(Movie firstMovie, Movie secondMovie, Movie bestScoreMovie) {
            this.firstMovie = firstMovie;
            this.secondMovie = secondMovie;
            this.bestScoreMovie = bestScoreMovie;
    }

    public QuizDTO getDTO() {

        return new QuizDTO();
    }

}
