package com.saludo.test.Controllers;

import ch.qos.logback.classic.boolex.GEventEvaluator;
import com.saludo.test.Entities.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {
    private final AtomicInteger contador = new AtomicInteger();

    @GetMapping("/hi")
    public Greeting sayHi(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(contador.incrementAndGet(), "Hi " + name + ", how are you?", this.getClass().getSimpleName());
    }

    @GetMapping("/bye/{name}")
    public Greeting sayBye(@PathVariable() String name) {
        return new Greeting(contador.decrementAndGet(), "By " + name + ", see you later", this.getClass().getSimpleName());
    }
}