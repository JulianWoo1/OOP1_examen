package com.nhlstenden.ontour;

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
}
