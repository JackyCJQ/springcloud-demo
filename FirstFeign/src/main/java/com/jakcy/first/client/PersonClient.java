package com.jakcy.first.client;

import feign.Param;
import feign.RequestLine;
import lombok.Data;

/**
 * @Authror jacky
 * @create 2019-11-04
 */
public interface PersonClient {

    @RequestLine("GET /person/{personId}")
    Person findById(@Param("personId") Integer personId);

    @RequestLine("GET /person/{personId}")
    String findById1(@Param("personId") Integer personId);

}


