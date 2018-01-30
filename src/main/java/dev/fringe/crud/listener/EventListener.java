package dev.fringe.crud.listener;

import dev.fringe.crud.event.Event;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public   class EventListener implements ApplicationListener<Event> {

    public void onApplicationEvent(Event event) {
            System.out.println("Event : " + event);
    }
}
