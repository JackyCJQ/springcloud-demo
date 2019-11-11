package com.jakcy.first.client.myclient;

import com.jakcy.first.client.Person;
import com.jakcy.first.client.PersonClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * @Authror jacky
 * @create 2019-11-05
 */
public class MyClientTest {
    public static void main(String[] args) {
        PersonClient client = Feign.builder()
                .decoder(new GsonDecoder()).client(new MyClient())
                .target(PersonClient.class, "http://localhost:8080/");
        Person person = client.findById(1);
        System.out.println(person);
    }
}
