package dev.rajnish.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

import dev.rajnish.BookMyShow.model.constant.AuditoriumFeatures;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {

    private String name;
    private int capacity;

    @OneToMany
    private List<Show> shows;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures> auditoriumFeatures;

    public Auditorium()
    {
        
    }

    public Auditorium(String name, int capacity,List<AuditoriumFeatures> auditoriumFeatures) {
        this.name = name;
        this.capacity = capacity;
        this.shows = new ArrayList<>();
        this.seats = new ArrayList<>();
        this.auditoriumFeatures = auditoriumFeatures;
    }    
}
