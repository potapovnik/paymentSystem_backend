package cinimex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cinimex")
public class AppRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class);
    }
}
