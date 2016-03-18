package com.kabbadipro;

/**
 * Created by maverick on 17/3/16.
 */
public class Match {
    private Team team1;
    private Team team2;
    private Location location;
    private String date;

    public Match(Team team1, Team tem2, Location location, String date) {
        this.team1 = team1;
        this.team2 = tem2;
        this.location = location;
        this.date = date;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Location getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (!team1.equals(match.team1)) return false;
        if (!team2.equals(match.team2)) return false;
        if (!location.equals(match.location)) return false;
        return date.equals(match.date);

    }

    @Override
    public int hashCode() {
        int result = team1.hashCode();
        result = 31 * result + team2.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.team1.getName() + " VS " + this.team2.getName() + " - " + this.location + " - " + this.date;
    }
}
