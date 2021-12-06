package com.usa.divinacomedia.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "hairproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairProduct {
    @Id
    @JsonProperty("reference")
    private String id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("category")
    private String category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    @JsonProperty("photography")
    private String photography;
}
