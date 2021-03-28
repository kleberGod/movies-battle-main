package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.Movie;
import br.com.letscode.java.moviesbattle.quiz.competition.UserQuiz;
import br.com.letscode.java.moviesbattle.quiz.competition.UserQuizRepository;
import br.com.letscode.java.moviesbattle.quiz.user.User;
import br.com.letscode.java.moviesbattle.quiz.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.management.MonitorInfo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class QuizService {


    private final QuizRepository repository;
    private final UserQuizRepository repositoryQuiz;
    private final UserQuizRepository repositoryUserQuiz;
    private final UserRepository repositoryUser;

    public Quiz nextQuiz() {
        //TODO
        return new Quiz();
    }

    public void createNewQuiz(Movie firstMovie, Movie secondMovie) {
        if(firstMovie.getRating() > secondMovie.getRating()) {
            Movie bestScoreMovie = firstMovie;
            Quiz quiz = new Quiz(firstMovie, secondMovie,bestScoreMovie);
            this.newQuiz(quiz);
        }
        else if (secondMovie.getRating() > firstMovie.getRating()){
            Movie bestScoreMovie = secondMovie;
            Quiz quiz = new Quiz(firstMovie, secondMovie,bestScoreMovie);
            this.newQuiz(quiz);
        }

    }

    public void newQuiz(Quiz quiz){
        this.repository.save(quiz);
    }


    public List<Quiz> list() {
        return this.repository.findAll();
    }

    public Quiz save(Quiz quiz){
        return this.repository.save(quiz);
    }

    public void QuizUser(User user){
        for (Quiz quiz : this.repository.findAll()){
            UserQuiz userQuiz = new UserQuiz(user,quiz);
            this.newQuizUser(userQuiz);
        }
    }
    public void newQuizUser(UserQuiz userQuiz){
        this.repositoryQuiz.save(userQuiz);
    }


    public void replyQuiz(UserQuiz userQuiz,Quiz quiz,UUID id,User user) {
        int life = 0;
        life = user.getLivesAvailable();

        if (life > 0) {
            UUID idCorrect = quiz.getBestScoreMovie().getId();
            LocalDate getDate = LocalDate.now();

            if (idCorrect.equals(id)) {
                userQuiz.setAnswered(Boolean.TRUE);
                user.setCurrentHits(user.getRound()+1);
                user.setBestScore(user.getCurrentHits());
                user.setBestScoreDate(getDate);
                user.setRound(user.getRound()+1);
                this.repositoryQuiz.save(userQuiz);
                this.repositoryUser.save(user);
            } else {
                userQuiz.setAnswered(Boolean.TRUE);
                user.setCurrentMisses(user.getRound()+1);
                user.setLivesAvailable(user.getLivesAvailable() - 1);
                user.setRound(user.getRound()+1);
                this.repositoryQuiz.save(userQuiz);
                this.repositoryUser.save(user);
            }

        } else{
            throw new GameOverException();
        }
    }

}
