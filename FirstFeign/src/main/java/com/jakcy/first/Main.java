package com.jakcy.first;

import com.jakcy.first.client.HelloClient;
import com.jakcy.first.client.Person;
import com.jakcy.first.client.PersonClient;
import feign.Feign;
import feign.codec.StringDecoder;
import feign.gson.GsonDecoder;

/**
 * @Authror jacky
 * @create 2019-11-04
 */
public class Main {

    public static void main(String[] args) {
        //默认实现类java.net.HttpURLConnection
        HelloClient client = Feign.builder().target(HelloClient.class, "http://localhost:8080/");
        System.out.println(client.SayHello());

        //携带参数的调用
        PersonClient personService = Feign.builder()
                .decoder(new GsonDecoder())
                .target(PersonClient.class, "http://localhost:8080/");
        Person person = personService.findById(2);
        System.out.println(person);

    }
}
