package com.nhlstenden.ontour;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Concert
{
    private static final int DEFAULT_TICKET_PRICE_IN_EUROS = 50;
    private static final int MINIMUM_PRICE = 1;

    private Artist artist;
    private Venue venue;
    private LocalDate date;
    private List<Ticket> soldTickets;
    private int priceInEuros;

    public Concert(Artist artist, Venue venue, LocalDate date)
    {
        this.setArtist(artist);
        this.setDate(date);
        this.setPriceInEuros(priceInEuros);
        this.setSoldTickets(new ArrayList<>());
        this.setVenue(venue);
    }

    public Artist getArtist()
    {
        return this.artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public LocalDate getDate()
    {
        return this.date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public int getPriceInEuros()
    {
        return this.priceInEuros;
    }

    public void setPriceInEuros(int priceInEuros)
    {
        if (priceInEuros < MINIMUM_PRICE)
        {
            throw new IllegalArgumentException("price cannot be lower than one");
        }
        this.priceInEuros = priceInEuros + DEFAULT_TICKET_PRICE_IN_EUROS;
    }

    public List<Ticket> getSoldTickets()
    {
        return this.soldTickets;
    }

    public void setSoldTickets(List<Ticket> soldTickets)
    {
        this.soldTickets = soldTickets;
    }

    public Venue getVenue()
    {
        return this.venue;
    }

    public void setVenue(Venue venue)
    {
        this.venue = venue;
    }

    public boolean hasOccured()
    {
        return LocalDate.now().isAfter(this.getDate());
    }

    public void addTicket(Ticket ticket)
    {
        this.soldTickets.add(ticket);
    }

    public void removeTicket(Ticket ticket)
    {
        Iterator<Ticket> iterator = this.soldTickets.iterator();

        while (iterator.hasNext())
        {
            Ticket ticket1 = iterator.next();
            if (ticket1.equals(ticket1))
            {
                iterator.remove();
            }
        }
    }

    public int getAmountOfTickets()
    {
        return this.getSoldTickets().size();
    }

    public int getRevenueInEuro()
    {
        return this.getAmountOfTickets() * this.getPriceInEuros();
    }

    public boolean isSoldOut()
    {
        return this.getVenue().getMaxCapacity() >= this.getAmountOfTickets();
    }
}
