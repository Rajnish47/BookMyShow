package dev.rajnish.BookMyShow.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketRequestDTO {

    private List<Integer> showSeatIds;
    // private int userId;    
}
