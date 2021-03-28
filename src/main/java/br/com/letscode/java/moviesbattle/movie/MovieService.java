package br.com.letscode.java.moviesbattle.movie;

import br.com.letscode.java.moviesbattle.imdbclient.MovieDetailRestRepository;
import br.com.letscode.java.moviesbattle.quiz.QuizService;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository repository;
    private final MovieDetailRestRepository movieDetailRestRepository;
    private final QuizService quizService;

    public Movie save(Movie movie) {
        final var movieDetail = this.movieDetailRestRepository.detail(movie.getImdbId());
        movie.setRating(movieDetail.getRating());
        movie.setVotes(movieDetail.getVotes());
        final var entity = this.repository.save(movie);
        this.createQuizzes(entity);
        return entity;
    }

    private void createQuizzes(Movie newMovie) {
        if (this.repository.count() < 2) {
            return;//not enough movies to create Quiz
        }
        this.repository.findMoviesByImdbIdNotIn(Collections.singletonList(newMovie.getImdbId()))
            .forEach(movie -> this.quizService.createNewQuiz(movie,  newMovie));
    }

    public List<Movie> list() {
        return this.repository.findAll();
    }

    public List<Movie> listOrderByScore() {
        return this.repository.findAll().stream()
            .sorted((o1, o2) -> o2.getScore().compareTo(o1.getScore()))
            .collect(Collectors.toList());
    }

    public void delete(String imdbId) {
        this.repository.findMovieByImdbId(imdbId)
            .ifPresent(this.repository::delete);
    }

}
