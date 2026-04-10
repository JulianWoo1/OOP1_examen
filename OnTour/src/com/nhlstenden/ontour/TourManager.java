package com.nhlstenden.ontour;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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

    public void addArtist(Artist artist)
    {
        if (this.artists.size() >= this.getMaxAmountOfTickets())
        {
            throw new IllegalArgumentException("max amount of tickets reached");
        }
        this.artists.add(artist);
    }

    public void addVenue(Venue venue)
    {
        this.venues.add(venue);
    }

    public void addConcert(Concert concert)
    {
        this.concerts.add(concert);
    }

    public Concert getConcert(Artist artist, Venue venue, LocalDate date)
    {
        if (!this.getConcertByArtist(this.concerts, artist).isEmpty()
                && !this.getConcertByVenue(this.concerts, venue).isEmpty()
                && !this.getConcertByDate(this.concerts, date).isEmpty())
        {
            return concerts.getFirst();
        }

        return null;
    }

    public Concert getConcert(String artistName, String venueName, LocalDate date)
    {
        if (!this.getConcertByArtist(this.concerts, this.getArtistByName(artistName)).isEmpty()
                && !this.getConcertByDate(this.concerts, date).isEmpty())
        {
            return concerts.getFirst();
        }

        return null;
    }

    public List<Concert> getConcertByArtist(List<Concert> concerts, Artist artist)
    {
        concerts = new ArrayList<>();
        for (Concert concert : this.concerts)
        {
            if (this.getArtistByName(name).equals(concert.getArtist()))
            {
                concerts.add(concert);
            }
        }

        return concerts;
    }

    private List<Concert> getConcertByDate(List<Concert> concerts, LocalDate date)
    {
        concerts = new ArrayList<>();

        for (Concert concert : this.concerts)
        {
            if (concert.getDate().equals(date))
            {
                concerts.add(concert);
            }
        }

        return concerts;
    }

    private List<Concert> getConcertByVenue(List<Concert> concerts, Venue venue)
    {
        concerts = new ArrayList<>();
        for (Concert concert : this.concerts)
        {
            if (this.getVenueByName(venue.getName()).equals(concert.getVenue()))
            {
                concerts.add(concert);
            }
        }

        return concerts;
    }

    public Artist getArtistByName(String name)
    {
        for (Artist artist : this.artists)
        {
            if (artist.getName().equals(name))
            {
                return artist;
            }
        }

        return null;
    }

    public Venue getVenueByName(String name)
    {
        for (Venue venue : this.venues)
        {
            if (venue.getName().equals(name))
            {
                return venue;
            }
        }

        return null;
    }

    public void scheduleConcert(String artistName, String venueName, LocalDate date)
    {
        Concert newConcert = new Concert(this.getArtistByName(artistName), this.getVenueByName(venueName), date);
        if (venueName.isEmpty() || artistName.isEmpty())
        {
            throw new IllegalArgumentException("Venue or artist don't exist");
        }

        if (!hasShowOnDate(this.getArtistByName(artistName), date))
        {
            this.addConcert(newConcert);
        }
    }

    public boolean hasShowOnDate(Artist artist, LocalDate date)
    {
        for (Concert artistConcert : this.getConcertByArtist(this.concerts, artist))
        {
            if (artistConcert.getDate().equals(date))
            {
                return true;
            }
        }

        return false;
    }

    public void removeCancelledConcerts()
    {
        Iterator<Concert> iterator = this.concerts.iterator();

        while (iterator.hasNext())
        {
            Concert concert = iterator.next();

            if (concert.getAmountOfTickets() <= 0)
            {
                iterator.remove();
            }
        }
    }

    public List<Concert> getConcertWithZeroTicketsSold(List<Concert> concerts)
    {
        concerts = new ArrayList<>();
        for (Concert concert : this.concerts)
        {
            if (concert.getAmountOfTickets() <= 0)
            {
                concerts.add(concert);
            }
        }

        return concerts;
    }

    public int getTotalRevenueInEuros(String artistName)
    {
        int totalRevenue = 0;

        for (Concert concert : this.getConcertByArtist(this.concerts, this.getArtistByName(artistName)))
        {
            totalRevenue += concert.getRevenueInEuro();
        }

        return totalRevenue;
    }
}
