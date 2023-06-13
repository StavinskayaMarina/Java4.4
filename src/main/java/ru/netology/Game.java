package ru.netology;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public ArrayList<Player> findAll() {
        return playerList;
    }

    public Player findByName(String name) {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new NotRegisteredException(name);
    }

    public int round(String playerName1, String playerName2) {
        Player pl1 = findByName(playerName1);
        Player pl2 = findByName(playerName2);
        int result;

        if (pl1.getStrength() < pl2.getStrength()) {
            result = 2;
        } else if (pl1.getStrength() > pl2.getStrength()) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }
}
