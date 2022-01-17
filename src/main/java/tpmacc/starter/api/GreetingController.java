package tpmacc.starter.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController("/v1/starter")
public class GreetingController {

    @Value("${starter.variable}")
    String variable = "hardcoded";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/param")
    Greeting greetingWithRequestParam(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", name));
    }

    @RequestMapping("/variable")
    Greeting greetingWithEnvironmentVariable() {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", variable));
    }
}
