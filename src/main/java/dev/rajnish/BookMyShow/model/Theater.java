package dev.rajnish.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theater extends BaseModel {

    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;

    public Theater()
    {
        
    }

    public Theater(String name, String address) {
        this.name = name;
        this.address = address;
        this.auditoriums = new ArrayList<>();
    }        
}
