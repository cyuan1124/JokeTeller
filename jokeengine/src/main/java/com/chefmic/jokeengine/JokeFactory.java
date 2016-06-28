package com.chefmic.jokeengine;

public class JokeFactory {

    static final String[] JOKES = new String[]{
            "Ordinarily, staring is creepy. But if you spread your attention across many individuals, then it's just people watching.",
            "Never play leapfrog with a unicorn.",
            "Arizona: A company called \"Guns For Hire\" stages gunfights for Western movies, etc. One day, they received a call from a 47-year-old woman, who wanted to have her husband killed. She got 4-1/2 years in jail.",
            "\"Demi Moore's new movie about the first woman in the elite Navy Seals still has no name,\" says Alex Kaseberg. \"They decided not to go with the title chosen by a test marketing group -- 'Straight to Video.'\""
    };

    public static String getJoke() {
        return JOKES[(int)(System.currentTimeMillis() % JOKES.length)];
    }

}
