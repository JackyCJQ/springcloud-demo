package com.jacky.provider.controller;

import com.jacky.provider.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.MediaTray;
import javax.servlet.http.HttpServletRequest;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@RestController
public class FirstController {

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request) {
        Person person = new Person(personId, "jacky", 30);
        person.setMessage(request.getRequestURL().toString());
        return person;
    }
}
