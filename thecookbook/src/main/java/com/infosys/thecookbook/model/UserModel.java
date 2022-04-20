package com.infosys.thecookbook.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="user_email")
    private String email;

    @Column(name ="user_password")
    private String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
