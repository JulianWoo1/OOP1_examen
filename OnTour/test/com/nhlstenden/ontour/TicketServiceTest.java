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
        venue = new Venue("a", 1, "a");
        artist = new Artist("a", "a");
        concert = new Concert(artist, venue, LocalDate.now());
        ticket = new Ticket(concert);
        List<Ticket> soldTickets = new ArrayList<>();

        soldTickets.add(ticket);

        concert.setPriceInEuros(10);
        concert.setSoldTickets(soldTickets);

        List<Artist> artists = new ArrayList<>();
        List<Concert> concerts = new ArrayList<>();
        List<Venue> venues = new ArrayList<>();

        artists.add(artist);
        concerts.add(concert);
        venues.add(venue);

        tourManager = new TourManager(artists, concerts, 1, "a", venues);

        ticketService = new TicketService(tourManager);

        assertEquals(51, concert.getAmountOfTickets());
    }


}