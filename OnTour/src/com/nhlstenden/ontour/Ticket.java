package com.nhlstenden.ontour;

public class Ticket
{
    private String ticket;

    public Ticket(Concert concert)
    {
        concert = new Concert(concert.getArtist(), concert.getVenue(), concert.getDate());
    }

    public String getTicket()
    {
        return this.ticket;
    }
}
