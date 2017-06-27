package com.example.sprinkclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaClient {

    public static void main(String[] args) {
        List<User> users = new RestTemplate().exchange(
                "http://localhost:8080/api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        ).getBody();
        users.forEach(System.out::println);
    }
}
