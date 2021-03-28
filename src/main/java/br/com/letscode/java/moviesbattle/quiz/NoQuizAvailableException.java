package br.com.letscode.java.moviesbattle.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoQuizAvailableException extends RuntimeException {

    public NoQuizAvailableException() {
        super("There's no Quiz available");
    }
}
