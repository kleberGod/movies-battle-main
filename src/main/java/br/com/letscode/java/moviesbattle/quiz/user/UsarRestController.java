package br.com.letscode.java.moviesbattle.quiz.user;

import br.com.letscode.java.moviesbattle.quiz.QuizRepository;
import br.com.letscode.java.moviesbattle.quiz.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UsarRestController {

    private final QuizService service;
    private final UserService serviceUser;
    private final UserRepository repositoryUser;


    @GetMapping
    public List<User> listUserOrder(){
        return this.repositoryUser.findAll(Sort.by(Sort.Direction.DESC,"bestScore"));
    }

    @PostMapping(params = "user")
    public void newUser(@RequestBody User user){
        this.serviceUser.save(user);
        this.service.QuizUser(user);
    }
}
