package dev.rajnish.BookMyShow.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowRequestDTO {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int movieId;
    private int auditoriumId;
    private List<Integer> showSeatsIds;    
}
