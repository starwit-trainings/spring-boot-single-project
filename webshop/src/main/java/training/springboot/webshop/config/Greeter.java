package training.springboot.webshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Greeter implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(Greeter.class);

    @Value("${greeting.text}")
    private String greetingText;

    @Override
    public void run(String... args) throws Exception {
        log.info("Hello " + this.greetingText);
    }
    
}
