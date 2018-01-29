package dev.fringe.crud.event;

import org.springframework.context.ApplicationEvent;

public class Event<T> extends ApplicationEvent {

    private T t;

    public Event(Object source, Object o) {
        super(source);
        t = (T) o;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String toString() {
        return "Event{" +
                "t=" + t +
                '}';
    }
}