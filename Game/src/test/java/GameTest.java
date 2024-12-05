import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;

public class GameTest {

    public void testYAML() {
        LoadYAML yl = new LoadYAML(new GameState("testPlayer"));
        Room room1 = yl.rooms.get("Starting Room");
        assertEquals(room1.name, "Starting Room");
    }
    
    @Test
    public void testWeaponDamage() {
        LoadYAML yl = new LoadYAML(new GameState("testPlayer"));
        Weapon sword = (Weapon) yl.items.get("excalibur");
        int initialHealth = 100;
        yl.gameState.playerHealth = initialHealth;

        sword.use();
        int damage = sword.getLastDamage();
        assertEquals(yl.gameState.playerHealth, initialHealth - damage);
    }

    @Test
    public void testAnimalDamage() {
        LoadYAML yl = new LoadYAML(new GameState("testPlayer"));
        Animal snake = (Animal) yl.items.get("poison frog");
        int initialHealth = 100;
        yl.gameState.playerHealth = initialHealth;

        snake.use();
        int damage = snake.getLastDamage();
        assertEquals(yl.gameState.playerHealth, initialHealth - damage);
    }

    @Test
    public void testHealing() {
        LoadYAML yl = new LoadYAML(new GameState("testPlayer"));
        Healing potion = (Healing) yl.items.get("spooky potion");
        int initialHealth = 50;
        yl.gameState.playerHealth = initialHealth;

        potion.use();
        int healedAmount = potion.getHealAmount();
        assertEquals(yl.gameState.playerHealth, Math.min(100, initialHealth + healedAmount));
    }
}
