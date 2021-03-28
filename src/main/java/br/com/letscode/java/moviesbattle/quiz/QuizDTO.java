package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class QuizDTO {//POJO
    private UUID id;
    private Movie firstMovie;
    private Movie secondMovie;
    private Movie bestScoreMovie;
}
