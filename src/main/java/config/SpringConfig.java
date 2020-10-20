package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("service")
@ComponentScan("config")
@ComponentScan("dao")
public class SpringConfig {
}
