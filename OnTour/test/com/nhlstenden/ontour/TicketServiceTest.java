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

    @BeforeEach
    void setup()
    {
        venue = new Venue("a", 1, "a");
        artist = new Artist("a", "a");
        List<Artist> artists = new ArrayList<>();

        concert = new Concert(artist, venue, LocalDate.now());
        List<Concert> concerts = new ArrayList<>();

        List<Venue> venues = new ArrayList<>();
        venues.add(venue);

        artists.add(artist);
        concerts.add(concert);

        tourManager = new TourManager(artists, concerts, 1, "a", venues);
        ticketService = new TicketService(tourManager);
    }

    @Test
    void testGetTotalRevenue_()
    {
        venue = new Venue("a", 1, "a");
        artist = new Artist("a", "a");
        List<Artist> artists = new ArrayList<>();

        concert = new Concert(artist, venue, LocalDate.now());
        List<Concert> concerts = new ArrayList<>();

        List<Venue> venues = new ArrayList<>();

        LocalDate today = LocalDate.now();

        venues.add(venue);
        artists.add(artist);
        concerts.add(concert);

        this.ticketService.getTourManager().getConcert(artist, venue, today).setPriceInEuros(10);

        tourManager = new TourManager(artists, concerts, 1, "a", venues);
        ticketService = new TicketService(tourManager);


        assertEquals(51, ticketService.getTotalRevenueInEuro("a"));
    }
}