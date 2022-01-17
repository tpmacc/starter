package tpmacc.starter.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController("/v1/starter")
public class GreetingController {

    @Value("${starter.variable}")
    String variable = "hardcoded";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping()
    Greeting defaultGreeting() {
        return new Greeting(counter.incrementAndGet(), "Hello again!");
    }

    @GetMapping("/param")
    Greeting greetingWithRequestParam(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", name));
    }

    @GetMapping("/variable")
    Greeting greetingWithEnvironmentVariable() {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", variable));
    }
}
