package br.com.letscode.java.moviesbattle.movie;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/movies")
@RestController
public class MovieRestController {

    private final MovieService service;

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        movie.setId(null);
        return this.service.save(movie);
    }

    @GetMapping
    public List<Movie> list() {
            return this.service.list();
    }

    @GetMapping(params = "orderByScore")
    public List<Movie> listOrderByScore() {
        return this.service.listOrderByScore();
    }

    @DeleteMapping("/{imdbId}")
    public void delete(@PathVariable String imdbId) {
        this.service.delete(imdbId);
    }
}
