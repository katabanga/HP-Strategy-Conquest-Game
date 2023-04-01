package edu.duke.ece651.team16.server;

public class AttackInputRuleChecker extends OrderRuleChecker {
    public AttackInputRuleChecker(OrderRuleChecker next) {
        super(next);
    }

    @Override
    public String checkMyRule(Territory from, Territory to, Player player, int numUnits, GameMap map, int level) {
        if (from.getOwner() != player) {
            return "You do not own the from territory";
        }
        if (to.getOwner() == player) {
            return "You can not attack your own territory";
        }
        if (from.getAliveUnitsFor(player, level).size() < numUnits) {
            // check units alive & owner is player
            return "You do not have enough alive units of this level in the from territory";
        }
        return null;
    }
}
