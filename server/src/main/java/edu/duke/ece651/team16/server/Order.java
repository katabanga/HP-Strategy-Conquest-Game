package edu.duke.ece651.team16.server;

public abstract class Order {
    protected Territory from;
    protected Territory to;
    protected int numUnits;
    protected Player player;
    protected Map gameMap;

    public Order(Territory from, Territory to, int numUnits, Player player, Map gameMap) {
        this.from = from;
        this.to = to;
        this.numUnits = numUnits;
        this.player = player;
        this.gameMap = gameMap;
    }

    public boolean tryMove() {
        return true;
    }

    public Player getPlayer() {
        return player;
    };

}
