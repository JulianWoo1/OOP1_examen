package com.nhlstenden.ontour;

public class Venue
{
    private static final int MINIMUM_CAPACITY = 0;
    private String name;
    private String city;
    private int maxCapacity;

    public Venue(String city, int maxCapacity, String name)
    {
        this.setCity(city);
        this.setMaxCapacity(maxCapacity);
        this.setName(name);
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        if (city.isEmpty())
        {
            throw new IllegalArgumentException("City cannot be empty");
        }
        this.city = city;
    }

    public int getMaxCapacity()
    {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity)
    {
        if (maxCapacity <= 0)
        {
            throw new IllegalArgumentException("Max capacity cannot be zero or lower");
        }
        this.maxCapacity = maxCapacity;
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
}
