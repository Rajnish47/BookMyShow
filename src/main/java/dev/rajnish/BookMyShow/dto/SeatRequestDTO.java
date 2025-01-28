package dev.rajnish.BookMyShow.dto;

import dev.rajnish.BookMyShow.model.constant.SeatStatus;
import dev.rajnish.BookMyShow.model.constant.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatRequestDTO {

    private int audiId;
    private int row;
    private int col;
    private String seatNo;
    private SeatType seatType;
    private SeatStatus seatStatus;    
}
