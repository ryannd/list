package com.ryannd.list_api.model;
import jakarta.persistence.*;

@Entity
@Table(name="media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
