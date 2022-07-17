package com.nourish1709.main;

import com.nourish1709.magic.annotation.EnableStringTrimming;
import com.nourish1709.main.service.GreetingsProvider;
import com.nourish1709.main.service.TrimmedGreetingsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableStringTrimming
public class ExampleApplication {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ExampleApplication.class);

        final GreetingsProvider greetingsProvider = context.getBean("greetingsProvider", GreetingsProvider.class);
        System.out.println("\nSimple greetings provider:");
        System.out.println(greetingsProvider.hello("  world  "));
        System.out.println(greetingsProvider.hello());

        final TrimmedGreetingsProvider trimmedGreetingsProvider = context.getBean(TrimmedGreetingsProvider.class);
        System.out.println("\nTrimmed greetings provider:");
        System.out.println(trimmedGreetingsProvider.hello("  world  "));
        System.out.println(trimmedGreetingsProvider.hello());
    }

    @Bean
    public TrimmedGreetingsProvider trimmedGreetingsProvider() {
        return new TrimmedGreetingsProvider();
    }

    @Bean
    public GreetingsProvider greetingsProvider() {
        return new GreetingsProvider();
    }
}
