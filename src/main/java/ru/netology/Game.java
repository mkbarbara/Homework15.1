package ru.netology;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> nameList = new ArrayList<>();

    public void register(Player player) {
        nameList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 != null) {
            if (player2 != null) {
                if (player1.getStrength() > player2.getStrength()) {
                    return 1;
                } else if (player1.getStrength() < player2.getStrength()) {
                    return 2;
                } else {
                    return 0;
                }
            } else {
                throw new NotRegisteredException(
                        "Player" + playerName2 + "is not registered"
                );
            }
        } else {
            throw new NotRegisteredException(
                    "Player" + playerName1 + "is not registered"
            );
        }
    }

    public Player findByName(String playerName) {
        for (Player player : nameList) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }
}
