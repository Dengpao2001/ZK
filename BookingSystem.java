/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

import java.util.Scanner;

/**
 *
 * @author Junior
 */
public class BookingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner scanner = new Scanner(System.in);

        // Initialize concert hall with 10 seats
        ConcertHall concertHall = new ConcertHall(10);

        while (true) {
            // Display current state of reservations
            System.out.println("Current state of reservations:");
            for (Seat seat : concertHall.getSeats()) {
                System.out.println("Seat " + seat.getSeatNumber() + ": " + (seat.isBooked() ? "Booked" : "Available"));
            }

            // Book or unbook a seat based on user input
            System.out.print("Enter seat number to book/unbook (0 to exit): ");
            int seatNumber = scanner.nextInt();

            if (seatNumber == 0) {
                break; // Exit the program
            }

            if (concertHall.bookSeat(seatNumber)) {
                System.out.println("Seat " + seatNumber + " booked successfully.");
            } else if (concertHall.unbookSeat(seatNumber)) {
                System.out.println("Seat " + seatNumber + " unbooked successfully.");
            } else {
                System.out.println("Invalid seat number or seat is already booked.");
            }
        }

        scanner.close();
    }
    
}
