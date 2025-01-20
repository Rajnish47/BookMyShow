package dev.rajnish.BookMyShow.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {

    private String name;

    @Column(unique = true)
    private Long mobileNo;

    private String password;

    @OneToMany
    private List<Ticket> bookings;
    
}
