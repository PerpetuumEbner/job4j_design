package ru.job4j.dip;

class Music {
    public String name;
    public Player player;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void play() {
        player.play("Rhapsody");
    }
}


class Player {
    public void play(String name) {
        System.out.println("Music is playing");
    }
}