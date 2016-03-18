package com.kabbadipro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maverick on 17/3/16.
 */
public class Schedule {
    private List<Match> matches = new ArrayList<>();

    public void scheduleMatch(Match match){
        this.matches.add(match);
    }

    public List<Match> getMatches() {
        return matches;
    }
}
