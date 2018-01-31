package dev.fringe.crud.listener;

import dev.fringe.crud.event.Event
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component;

@Component class EventListener extends  ApplicationListener[Event[Object]] {
  override def onApplicationEvent(e: Event[Object]): Unit = System.out.println("Event : " + e)
}
