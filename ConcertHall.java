/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Junior
 */
public class ConcertHall {
    private List<Seat> seats;

    public ConcertHall(int numberOfSeats) {
        seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean bookSeat(int seatNumber) {
        Seat selectedSeat = findSeat(seatNumber);

        if (selectedSeat != null && !selectedSeat.isBooked()) {
            selectedSeat.bookSeat();
            return true; // Booking successful
        } else {
            return false; // Seat is either invalid or already booked
        }
    }

    public boolean unbookSeat(int seatNumber) {
        Seat selectedSeat = findSeat(seatNumber);

        if (selectedSeat != null && selectedSeat.isBooked()) {
            selectedSeat.unbookSeat();
            return true; // Unbooking successful
        } else {
            return false; // Seat is either invalid or not booked
        }
    }

    private Seat findSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null; // Seat not found
    }
}
