package com.kabbadipro;

public class Team {
   private String name;
   private Location homeGround;

   public Team(String name) {
      this.name = name;
   }

   public Team(String name, Location homeGround) {
      this.name = name;
      this.homeGround = homeGround;
   }

   public String getName() {
      return name;
   }

   public Location getHomeGround() {
      return homeGround;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Team team = (Team) o;

      return name.equals(team.name);

   }

   @Override
   public String toString() {
      return this.name;
   }

   @Override
   public int hashCode() {
      return name.hashCode();
   }
}
