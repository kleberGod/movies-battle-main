package br.com.letscode.java.moviesbattle.quiz.config;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/quizz-config")
@RestController
public class ConfigRestController {

    private final ConfigService configService;

    @PutMapping("{misses:\\d+}")
    public void setMissesAttempts(@PathVariable Integer misses) {
        this.configService.setMissesAttempts(misses);
    }

    @PutMapping(params = {"key", "value"})
    public void updateConfig(@RequestParam String key, @RequestParam String value) {
        this.configService.update(key, value);
    }
}
