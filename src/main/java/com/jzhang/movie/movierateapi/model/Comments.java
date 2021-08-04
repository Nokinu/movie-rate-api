package com.jzhang.movie.movierateapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "comments")
public class Comments {

    @Id
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;

    @JsonProperty("movie_id")
    @Field(name = "movie_id")
    private ObjectId movie_id;

    @JsonProperty("text")
    private String text;
    @JsonProperty("date")
    private Date date;
}
