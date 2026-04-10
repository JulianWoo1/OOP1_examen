package com.nhlstenden.ontour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest
{
    private TicketService ticketService;
    private TourManager tourManager;
    private Artist artist;
    private Concert concert;
    private Venue venue;
    private Ticket ticket;

    @BeforeEach
    void setup()
    {
        venue = new Venue("a", 1, "a");
        artist = new Artist("a", "a");
        List<Artist> artists = new ArrayList<>();

        concert = new Concert(artist, venue, LocalDate.now());
        List<Concert> concerts = new ArrayList<>();
        ticket = new Ticket(concert);

        List<Venue> venues = new ArrayList<>();
        venues.add(venue);

        artists.add(artist);
        concerts.add(concert);

        tourManager = new TourManager(artists, concerts, 1, "a", venues);
        ticketService = new TicketService(tourManager);
    }

    @Test
    void testGetTotalRevenue_OneTicketSold_ShouldReturn51()
    {
        concert.setPriceInEuros(1);
        this.ticketService.sellTickets(artist.getName(), venue.getName(), LocalDate.now(), 1);
        assertEquals(51, concert.getAmountOfTickets());
    }

    @Test
    void testGetTotalRevenue_TwoTicketSold_ShouldReturn102()
    {
        concert.setPriceInEuros(1);
        this.ticketService.sellTickets(artist.getName(), venue.getName(), LocalDate.now(), 2);
        assertEquals(102, concert.getAmountOfTickets());
    }

    @Test
    void testGetTotalRevenue_NoTicketSold_ShouldThrow()
    {
        concert.setPriceInEuros(1);
        this.ticketService.sellTickets(artist.getName(), venue.getName(), LocalDate.now(), 0);
        assertThrows(IllegalArgumentException.class, ()-> {
            this.ticketService.getTotalRevenueInEuro(artist.getName());
        });
    }


}