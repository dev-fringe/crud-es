package dev.fringe.crud

import org.springframework.context.annotation.{AnnotationConfigApplicationContext, ComponentScan}
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.server.adapter.WebHttpHandlerBuilder
import reactor.ipc.netty.http.server.HttpServer

@ComponentScan
@EnableWebFlux
class Application {}
object Application extends App {
  HttpServer.create("localhost", 8091).newHandler(new ReactorHttpHandlerAdapter(WebHttpHandlerBuilder.applicationContext(new AnnotationConfigApplicationContext(classOf[Application])).build)).block
}

