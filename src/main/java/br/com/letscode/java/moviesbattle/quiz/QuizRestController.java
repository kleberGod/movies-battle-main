package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.Movie;
import br.com.letscode.java.moviesbattle.quiz.competition.UserQuiz;
import br.com.letscode.java.moviesbattle.quiz.competition.UserQuizRepository;
import br.com.letscode.java.moviesbattle.quiz.user.User;
import br.com.letscode.java.moviesbattle.quiz.user.UserRepository;
import br.com.letscode.java.moviesbattle.quiz.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/quizs")
@RestController
public class QuizRestController {

    private final QuizService service;
    private final UserRepository repositoryUser;
    private final UserQuizRepository repositoryUserQuiz;


    @PostMapping
    public Quiz save(@RequestBody Quiz quiz) {
        return this.service.save(quiz);
    }

    @GetMapping
    public List<Quiz> list() {
        return this.service.list();
    }

    @GetMapping(params = "username")
    public MoviesGet userQuiz(String username){
        Optional<User> findUser = repositoryUser.findByUsername(username);
        Optional<UserQuiz> userQuizFin = repositoryUserQuiz.findFirstByUserAndAnsweredFalse(findUser.get());

        MoviesGet moviesGet = new MoviesGet();
        moviesGet.setFirstMovie(userQuizFin.get().getQuiz().getFirstMovie());
        moviesGet.setSecondyMovie(userQuizFin.get().getQuiz().getSecondMovie());

        if(userQuizFin.isEmpty()) {
            throw new NoQuizAvailableException();
        }else{
            return moviesGet;
        }
    }
}
