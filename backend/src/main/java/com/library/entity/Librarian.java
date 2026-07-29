package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="librarians")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Librarian {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

}