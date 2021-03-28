package br.com.letscode.java.moviesbattle.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizReply {

    private String username;

    private UUID reply;
}
