import java.util.Random;
import java.util.List;

public class Animal extends Item {
    int min;
    int max;
    private Random rn;
    private int lastDamage;

    public Animal(String name, List<String> type, String desc, String use, String act, int min_damage, int max_damage) {
        super(name, type, desc, use, act);
        min = min_damage;
        max = max_damage;
        rn = new Random();
    }

    public int attack() {
        int var = min + rn.nextInt((max-min) + 1);
        return var;
    }

    @Override
    public void use() {
        super.use();
        if (action.equals("drop")) {
            lastDamage = attack();  // Store the damage in lastDamage
            gameState.playerHealth -= lastDamage;  // Use lastDamage to modify health
        }
    }

    public int getLastDamage() {
        return lastDamage;
    }
}
