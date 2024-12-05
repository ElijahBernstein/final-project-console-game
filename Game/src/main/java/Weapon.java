import java.util.Random;
import java.util.List;

public class Weapon extends Item {
    int min;
    int max;
    private Random rn;
    private int lastDamage;

    public Weapon(String name, List<String> types, String desc, String use, String act, int min_damage, int max_damage) {
        super(name, types, desc, use, act);
        min = min_damage;
        max = max_damage;
        rn = new Random();
    }

    // uniformly distributed random number
    public int attack() {
        int var = min + rn.nextInt((max-min) + 1);
        return var;
    }

    @Override
    public void use() {
        super.use();
        lastDamage = attack();  // Store the damage in lastDamage
        gameState.playerHealth -= lastDamage;  // Use lastDamage to modify health
    }

    public int getLastDamage() {
        return lastDamage;
    }
}