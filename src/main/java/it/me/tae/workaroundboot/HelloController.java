package it.me.tae.workaroundboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = {"/hello"})
    public String sayHello() {
        logger.info("Invoke sayHello()");
        return "Hello!!!";
    }
}
