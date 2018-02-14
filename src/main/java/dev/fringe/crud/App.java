package dev.fringe.crud;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.ipc.netty.http.server.HttpServer;

@ComponentScan
@EnableWebFlux
public class App {
    public static void main(String[] args) {
        HttpServer.create("localhost", 8090).newHandler(new ReactorHttpHandlerAdapter(WebHttpHandlerBuilder.applicationContext(new AnnotationConfigApplicationContext(App.class)).build())).block();
    }
}
