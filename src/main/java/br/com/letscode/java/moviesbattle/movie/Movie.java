package br.com.letscode.java.moviesbattle.movie;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Include;
import org.springframework.web.bind.annotation.GetMapping;

//@formatter:off
@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
//@formatter:on
public class Movie {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private Integer year;
    private String imdbId;
    private String type;
    private Double rating;
    private Long votes;

    @Include
    public Double getScore() {
        return this.rating * this.votes;
    }

    public MovieDTO getDTO() {
        return MovieDTO.builder()
            .imdbId(this.imdbId)
            .title(this.title)
            .year(this.year)
            .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return imdbId.equals(movie.imdbId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imdbId);
    }

}
