package com.example.sprinkclient

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


fun main(args: Array<String>) {
    val users = RestTemplate().getForObject<List<User>>("http://localhost:8080/api/users")
    users.forEach(::println)
}


data class User
@JsonCreator constructor(
        @JsonProperty("id") val id: Long,
        @JsonProperty("username") val username: String,
        @JsonProperty("fullName") val fullName: String?,
        @JsonProperty("role") val role: String
)