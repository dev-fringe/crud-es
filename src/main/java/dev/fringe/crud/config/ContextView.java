package dev.fringe.crud.config;

import com.samskivert.mustache.Mustache;
import dev.fringe.crud.view.MustacheResourceTemplateLoader;
import dev.fringe.crud.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.result.view.ViewResolver;

@Configuration
public class ContextView {
    @Bean
    public ViewResolver mustacheViewResolver() {
        String prefix = "classpath:/templates/";
        String suffix = ".html";
        Mustache.TemplateLoader loader = new MustacheResourceTemplateLoader(prefix, suffix);
        MustacheViewResolver mustacheViewResolver = new MustacheViewResolver(Mustache.compiler().withLoader(loader));
        mustacheViewResolver.setPrefix(prefix);
        mustacheViewResolver.setSuffix(suffix);
        return mustacheViewResolver;
    }
}
