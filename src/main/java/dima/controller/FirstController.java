package dima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstController {

        @RequestMapping(value = "/api/first")
        public String sayHello() {
            return "HelloWorld";
        }

}
