package br.com.letscode.java.moviesbattle.quiz.user;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String username;

    @Column
    private LocalDate bestScoreDate;

    @Column
    private Long bestScore;

    @Column
    private Long currentHits;

    @Column
    private Long currentMisses;

    @Column
    private int livesAvailable;

    @Column
    private Long round;

}
