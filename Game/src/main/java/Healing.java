import java.util.List;

public class Healing extends Item {
    int healAmount;

    public Healing(String name, List<String> types, String desc, String use, String act, int heal_amount) {
        super(name, types, desc, use, act);
        healAmount = heal_amount;
    }

    @Override
    public void use() {
        super.use();
        int newHealth = Math.min(100, gameState.playerHealth + healAmount);
        int actualHeal = newHealth - gameState.playerHealth; 
        gameState.playerHealth = newHealth;
    }

    public int getHealAmount() {
        return healAmount;
    }
}