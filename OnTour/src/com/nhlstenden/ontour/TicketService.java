package com.nhlstenden.ontour;

import java.time.LocalDate;

public class TicketService
{
    private TourManager tourManager;

    public TicketService(TourManager tourManager)
    {
        this.setTourManager(tourManager);
    }

    public TourManager getTourManager()
    {
        return this.tourManager;
    }

    public void setTourManager(TourManager tourManager)
    {
        this.tourManager = tourManager;
    }

    public void sellTickets(String artistName, String venueName, LocalDate date, int amountOfTickets)
    {
        Ticket newTicket = new Ticket(this.getTourManager().getConcert(artistName, venueName, date));
        if (this.isExisting(this.getTourManager().getConcert(artistName, venueName, date)))
        {
            throw new IllegalArgumentException("Concerts has already occured or is sold out");
        }

        this.getTourManager().getConcert(artistName, venueName, date).addTicket(newTicket);
    }

    public int getTotalRevenueInEuro(String artistName)
    {
        return this.getTourManager().getTotalRevenueInEuros(artistName);
    }

    public boolean isSoldOut(int amountOfTickets, Concert concert)
    {
        return this.getTourManager().getConcert(concert.getArtist(), concert.getVenue(), concert.getDate())
                .getAmountOfTickets() >= amountOfTickets;
    }

    private boolean isExisting(Concert concert)
    {
        if (this.getTourManager().getConcert(concert.getArtist(), concert.getVenue(), concert.getDate()).isSoldOut() ||
                this.getTourManager().getConcert(concert.getArtist().getName(), concert.getVenue().getName(), concert.getDate()).hasOccured())
        {
            return true;
        }
        return false;
    }
}
