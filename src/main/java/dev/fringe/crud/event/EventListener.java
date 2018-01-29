package dev.fringe.crud.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
 class EventListener implements ApplicationListener<Event> {

    public void onApplicationEvent(Event event) {
            System.out.println("Event : " + event);
    }
}
