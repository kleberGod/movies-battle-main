package br.com.letscode.java.moviesbattle.quiz.config;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConfigService {

    public static final String MISSES_ATTEMPTS = "MISSES_ATTEMPTS";
    private final ConfigRepository repository;

    @PostConstruct
    public void initConfig() {
        final var config = new Config();
        config.setKey(MISSES_ATTEMPTS);
        config.setValue("2");
        this.repository.save(config);
    }

    public void setMissesAttempts(Integer misses) {
        final var value = String.valueOf(misses);
        this.update(MISSES_ATTEMPTS, value);
    }

    public void update(String key, String value) {
        this.repository.findConfigByKey(key)
            .ifPresent(c -> update(c, value));
    }

    public void update(Config config, String value) {
        config.setValue(value);
        this.repository.save(config);
    }

    public Integer getMissesAttempts() {
        return this.repository.findConfigByKey(MISSES_ATTEMPTS)
            .map(Config::getValue)
            .map(Integer::parseInt)
            .orElseThrow();
    }
}
