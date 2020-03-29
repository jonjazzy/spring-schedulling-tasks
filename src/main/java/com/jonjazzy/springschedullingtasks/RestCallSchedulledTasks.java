package com.jonjazzy.springschedullingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestCallSchedulledTasks
{
    private static Logger LOGGER = LoggerFactory.getLogger(RestCallSchedulledTasks.class);

    @Scheduled(fixedDelay = 3000)
    public void tryToAuthenticatePostmanEcho()
    {
        String userName = "postman";
        String password = "password";

        WebClient webClient = WebClient.create("https://postman-echo.com/basic-auth");
        Mono<String> result = webClient.get()
                .headers(headers -> headers.setBasicAuth(userName, password))
                .retrieve()
                .bodyToMono(String.class);

        result.subscribe(RestCallSchedulledTasks::doSomething);
    }

    private static void doSomething(String s)
    {
        LOGGER.info("JonJazzy:Postman Login:- " + s);
    }
}
