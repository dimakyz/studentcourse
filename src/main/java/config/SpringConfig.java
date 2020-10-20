package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("service")
@ComponentScan("model")
@ComponentScan("dao")
public class SpringConfig {
}
