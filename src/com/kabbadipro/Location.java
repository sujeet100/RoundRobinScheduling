package com.kabbadipro;

public class Location {
    public static final Location BANGALORE = new Location("Bangalore");
    public static final Location MUMBAI = new Location("Mumbai");

    private String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        return name.equals(location.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
