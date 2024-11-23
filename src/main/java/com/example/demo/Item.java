package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "Item")
public class Item {
    @Id
    private Long id;

    private String bodyPart;

    private String muscles;

//    private Note note;

    public Item(String bodyPart, String muscles) {
        this.bodyPart = bodyPart;
        this.muscles = muscles;
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public String getMuscles() {
        return this.muscles;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", bodyPart='" + bodyPart + '\'' +
                ", muscles='" + muscles + '\'' +
                '}';
    }
}
