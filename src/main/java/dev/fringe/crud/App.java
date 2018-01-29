package dev.fringe.crud;

import dev.fringe.crud.service.CrudService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App implements InitializingBean{

    @Autowired
    private CrudService crud;

    public static void main(String[] args) {
         new AnnotationConfigApplicationContext(App.class);
    }

    public void afterPropertiesSet() throws Exception {
        crud.service();
    }
}
