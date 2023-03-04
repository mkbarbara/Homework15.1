import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {

    Player player1 = new Player(1, "Anya", 100);
    Player player2 = new Player(2, "Vadim", 80);
    Player player3 = new Player(3, "Anton", 150);
    Player player4 = new Player(4, "Varya", 80);

    @Test
    public void shouldReturnError() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Varya", "Anya");
        });
    }

    @Test
    public void shouldReturn1() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Anya", "Vadim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn2() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Anya", "Anton");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0() {
        Game game = new Game();

        game.register(player4);
        game.register(player2);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Vadim", "Varya");

        Assertions.assertEquals(expected, actual);
    }
}
