package com.kabbadipro;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.core.Is.is;

public class SchedulerTest {

    @Test
    public void schedulerShouldScheduleForEvenNumberOfTeams() throws ParseException {
        Scheduler scheduler = new Scheduler("10-Mar-2016");
        Schedule schedule = scheduler.schedule(6);
        Assert.assertThat(schedule.getMatches().get(0), is(new Match(new Team("Team1"), new Team("Team6"), new Location("Location1"), "10-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(1), is(new Match(new Team("Team2"), new Team("Team5"), new Location("Location2"), "10-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(2), is(new Match(new Team("Team3"), new Team("Team4"), new Location("Location3"), "11-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(3), is(new Match(new Team("Team6"), new Team("Team5"), new Location("Location6"), "11-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(4), is(new Match(new Team("Team1"), new Team("Team4"), new Location("Location1"), "12-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(5), is(new Match(new Team("Team2"), new Team("Team3"), new Location("Location2"), "12-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(6), is(new Match(new Team("Team5"), new Team("Team4"), new Location("Location5"), "13-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(7), is(new Match(new Team("Team6"), new Team("Team3"), new Location("Location6"), "13-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(8), is(new Match(new Team("Team1"), new Team("Team2"), new Location("Location1"), "14-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(9), is(new Match(new Team("Team4"), new Team("Team3"), new Location("Location4"), "14-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(10), is(new Match(new Team("Team5"), new Team("Team2"), new Location("Location5"), "15-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(11), is(new Match(new Team("Team6"), new Team("Team1"), new Location("Location6"), "15-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(12), is(new Match(new Team("Team3"), new Team("Team2"), new Location("Location3"), "16-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(13), is(new Match(new Team("Team4"), new Team("Team1"), new Location("Location4"), "16-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(14), is(new Match(new Team("Team5"), new Team("Team6"), new Location("Location5"), "17-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(15), is(new Match(new Team("Team2"), new Team("Team1"), new Location("Location2"), "17-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(16), is(new Match(new Team("Team3"), new Team("Team6"), new Location("Location3"), "18-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(17), is(new Match(new Team("Team4"), new Team("Team5"), new Location("Location4"), "18-Mar-2016")));
    }

    @Test
    public void schedulerShouldScheduleForOddNumberOfTeams() throws ParseException {
        Scheduler scheduler = new Scheduler("10-Mar-2016");
        Schedule schedule = scheduler.schedule(3);
        Assert.assertThat(schedule.getMatches().get(0), is(new Match(new Team("Team1"), new Team("Dummy"), new Location("Location1"), "10-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(1), is(new Match(new Team("Team2"), new Team("Team3"), new Location("Location2"), "10-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(2), is(new Match(new Team("Dummy"), new Team("Team3"), new Location("DummyLocation"), "12-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(3), is(new Match(new Team("Team1"), new Team("Team2"), new Location("Location1"), "12-Mar-2016")));

        Assert.assertThat(schedule.getMatches().get(4), is(new Match(new Team("Team3"), new Team("Team2"), new Location("Location3"), "14-Mar-2016")));
        Assert.assertThat(schedule.getMatches().get(5), is(new Match(new Team("Dummy"), new Team("Team1"), new Location("DummyLocation"), "14-Mar-2016")));
    }
}
