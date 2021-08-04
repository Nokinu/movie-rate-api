package com.jzhang.movie.movierateapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document(collection = "movies")
@ApiModel(description = "Movie Data Model")
public class Movie {
    @ApiModelProperty(value = "Movie ID")
    @Id
    private String id;

    @ApiModelProperty(value = "Movie Plot")
    @JsonProperty("plot")
    private String plot;

    @ApiModelProperty(value = "Movie Genres")
    @JsonProperty("genres")
    private List<String> genres = new ArrayList<>();

    @ApiModelProperty(value = "Movie runtime")
    @JsonProperty("runtime")
    private Integer runtime;

    @ApiModelProperty(value = "Movie Casts")
    @JsonProperty("cast")
    private List<String> cast = new ArrayList<>();

    @ApiModelProperty(value = "Movie Comments")
    @JsonProperty("num_mflix_comments")
    private Integer numMflixComments;

    @ApiModelProperty(value = "Movie Title")
    @JsonProperty("title")
    private String title;

    @ApiModelProperty(value = "Movie Full Plot")
    @JsonProperty("fullplot")
    private String fullplot;

    @ApiModelProperty(value = "Movie Countires")
    @JsonProperty("countries")
    private List<String> countries = new ArrayList<>();

    @ApiModelProperty(value = "Movie Release Date")
    @JsonProperty("released")
    private Date released;

    @ApiModelProperty(value = "Movie Directors")
    @JsonProperty("directors")
    private List<String> directors = new ArrayList<>();

    @ApiModelProperty(value = "Movie Rate")
    @JsonProperty("rated")
    private String rated;

    @ApiModelProperty(value = "Movie Awards")
    @JsonProperty("awards")
    private Awards awards;

    @ApiModelProperty(value = "Movie Last Updated")
    @JsonProperty("lastupdated")
    private String lastupdated;

    @ApiModelProperty(value = "Movie Year")
    @JsonProperty("year")
    private String year;

    @ApiModelProperty(value = "Movie IMDB")
    @JsonProperty("imdb")
    private Imdb imdb;

    @ApiModelProperty(value = "Movie Type")
    @JsonProperty("type")
    private String type;

    @ApiModelProperty(value = "Movie Tomatoes Score")
    @JsonProperty("tomatoes")
    private Tomatoes tomatoes;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
