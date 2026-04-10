package com.nhlstenden.ontour;

import java.util.ArrayList;
import java.util.List;

public class TourManager
{
    private String name;
    private int maxAmountOfTickets;
    private List<Artist> artists;
    private List<Venue> venues;
    private List<Concert> concerts;

    public TourManager(List<Artist> artists, List<Concert> concerts, int maxAmountOfTickets, String name, List<Venue> venues)
    {
        this.setMaxAmountOfTickets(maxAmountOfTickets);
        this.setName(name);
        this.artists = new ArrayList<>();
        this.venues = new ArrayList<>();
        this.concerts = new ArrayList<>();
    }

    public List<Artist> getArtists()
    {
        return this.artists;
    }

    public void setArtists(List<Artist> artists)
    {
        if (this.artists.isEmpty())
        {
            throw new IllegalArgumentException("Artists must be one or higher");
        }
        this.artists = artists;
    }

    public List<Concert> getConcerts()
    {
        return this.concerts;
    }

    public void setConcerts(List<Concert> concerts)
    {
        this.concerts = concerts;
    }

    public int getMaxAmountOfTickets()
    {
        return this.maxAmountOfTickets;
    }

    public void setMaxAmountOfTickets(int maxAmountOfTickets)
    {
        this.maxAmountOfTickets = maxAmountOfTickets;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public List<Venue> getVenues()
    {
        return this.venues;
    }

    public void setVenues(List<Venue> venues)
    {
        this.venues = venues;
    }
}
