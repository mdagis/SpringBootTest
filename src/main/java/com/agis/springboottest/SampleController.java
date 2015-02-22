package com.agis.springboottest;

/**
 *
 * @author agis
 */
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Person home() {
        Person p = new Person();
        p.setFirstName("Agis");
        p.setLastName("Kefalinos");
        return p;
    }
    
    @RequestMapping(value = "/who",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String who(@RequestBody Person p, @RequestParam(value = "action", required = false) String action) {
        return action + " " + p.getFirstName();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
