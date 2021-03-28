package br.com.letscode.java.moviesbattle.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GameOverException extends RuntimeException {

    public GameOverException() {
        super("You have exceeded the MISS limit");
    }
}
