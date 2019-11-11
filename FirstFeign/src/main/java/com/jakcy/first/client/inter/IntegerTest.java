package com.jakcy.first.client.inter;

import com.jakcy.first.client.Person;
import com.jakcy.first.client.PersonClient;
import com.jakcy.first.client.myclient.MyClient;
import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * @Authror jacky
 * @create 2019-11-05
 */
public class IntegerTest {
    public static void main(String[] args) {
        PersonClient client = Feign.builder()
                .decoder(new GsonDecoder()).client(new MyClient())
                .requestInterceptor(new myInter())
                .target(PersonClient.class, "http://localhost:8080/");
        Person person = client.findById(1);
        System.out.println(person);
    }
}
