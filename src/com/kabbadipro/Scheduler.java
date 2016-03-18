package com.kabbadipro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class Scheduler {

    private final Date startDate;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    private final int slotsInADay = 2;

    public Scheduler(String startDate) throws ParseException {
        this.startDate = dateFormat.parse(startDate);
    }

    public Schedule schedule(int numberOfTeams) {
        Schedule schedule = new Schedule();
        java.util.Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(startDate);
        Deque<Team> teams = new LinkedList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            teams.add(new Team("Team" + (i + 1), new Location("Location" + (i + 1))));
        }

        if (numberOfTeams % 2 == 1) {
            teams.add(new Team("Dummy", new Location("DummyLocation")));
            numberOfTeams++;
        }

        int matchesInADay = 0;
        for (int i = 0; i < numberOfTeams; i++) {
            Iterator<Team> firstTeamIterator = teams.iterator();
            Iterator<Team> secondTeamIterator = teams.descendingIterator();
            for (int j = 0; j < numberOfTeams / 2; j++) {
                Team firstTeam = firstTeamIterator.next();
                Team secondTeam = secondTeamIterator.next();
                schedule.scheduleMatch(new Match(firstTeam, secondTeam, firstTeam.getHomeGround(), dateFormat.format(calendar.getTime())));
                matchesInADay++;
                if (matchesInADay % slotsInADay == 0) {
                    if(numberOfTeams < 5) {
                        calendar.add(Calendar.DAY_OF_MONTH, 2);
                    } else {
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                    }
                }
            }
            rotate(teams);
        }

        return schedule;
    }

    private void rotate(Deque<Team> teams) {
        Team last = teams.pollLast();
        teams.addFirst(last);
    }
}
