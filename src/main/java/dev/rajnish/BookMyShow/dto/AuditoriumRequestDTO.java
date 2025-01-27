package dev.rajnish.BookMyShow.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriumRequestDTO {
    
    private int theaterId;
    private String name;
    private int capacity;
    private ArrayList<String> auditoriumFeatures; 
}
