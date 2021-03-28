package br.com.letscode.java.moviesbattle.quiz.competition;

import br.com.letscode.java.moviesbattle.quiz.Quiz;
import br.com.letscode.java.moviesbattle.quiz.user.User;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserQuiz {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Boolean answered = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public UserQuiz(User user, Quiz quiz) {
        this.user = user;
        this.quiz = quiz;
    }
}
