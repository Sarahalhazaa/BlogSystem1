package com.example.blogsystem1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotEmpty(message = "It must not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String title;

    @NotEmpty(message = "It must not be empty")
    @Column(columnDefinition = "varchar(200) not null")
    private String body;

    @ManyToOne
    @JoinColumn(name ="user_id" ,referencedColumnName = "id")
    @JsonIgnore
    private User user;
}


