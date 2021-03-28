package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoviesGet {

    private Movie firstMovie;

    private Movie secondyMovie;
}
