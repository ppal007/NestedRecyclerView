package com.ppal007.nestedrecyclerview.Model;

public class RVModel {

    private String teamName;
    private int teamLogo;

    public RVModel(String teamName, int teamLogo) {
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamLogo() {
        return teamLogo;
    }
}
