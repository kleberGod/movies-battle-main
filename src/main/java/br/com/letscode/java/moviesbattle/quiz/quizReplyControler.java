package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.quiz.competition.UserQuiz;
import br.com.letscode.java.moviesbattle.quiz.competition.UserQuizRepository;
import br.com.letscode.java.moviesbattle.quiz.user.User;
import br.com.letscode.java.moviesbattle.quiz.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/reply")
@RestController
public class quizReplyControler {

    private final QuizService service;
    private final UserRepository repositoryUser;
    private final UserQuizRepository repositoryUserQuiz;

    @PostMapping(params = "quizReply")
    public void reply(@RequestBody QuizReply quizReply){
        Optional<User> findUser = repositoryUser.findByUsername(quizReply.getUsername());
        Optional<UserQuiz> findUserQuiz = repositoryUserQuiz.findFirstByUserAndAnsweredFalse(findUser.get());
        this.service.replyQuiz(findUserQuiz.get(),findUserQuiz.get().getQuiz(), quizReply.getReply(), findUser.get());
    }
}
