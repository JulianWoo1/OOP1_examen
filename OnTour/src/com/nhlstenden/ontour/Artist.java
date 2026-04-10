package com.nhlstenden.ontour;

public class Artist
{
    private String name;
    private String genre;

    public Artist(String genre, String name)
    {
        this.setGenre(genre);
        this.setName(name);
    }

    public String getGenre()
    {
        return this.genre;
    }

    public void setGenre(String genre)
    {
        if (genre.isEmpty())
        {
            throw new IllegalArgumentException("Genre cannot be empty");
        }
        this.genre = genre;
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
