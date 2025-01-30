package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class GameTest {
    @Test

    public void TheFirstPlayerIsStronger() {
        Player eva = new Player(453, "Eva", 154);
        Player oskar = new Player(349, "Oskar", 112);
        Game game = new Game();

        game.register(eva);
        game.register(oskar);
        int actual = game.round("Eva", "Oskar");
        int expacted = 1;
        Assertions.assertEquals(expacted, actual);
    }

    @Test

    public void TheSecondPlayerIsStronger() {
        Player eva = new Player(453, "Eva", 154);
        Player oskar = new Player(346, "Dasha", 202);
        Game game = new Game();

        game.register(eva);
        game.register(oskar);
        int actual = game.round("Eva", "Dasha");
        int expacted = 2;
        Assertions.assertEquals(expacted, actual);
    }

    @Test

    public void ForcesAreEqual() {
        Player eva = new Player(453, "Eva", 105);
        Player oskar = new Player(349, "Oskar", 105);
        Game game = new Game();

        game.register(eva);
        game.register(oskar);
        int actual = game.round("Eva", "Oskar");
        int expacted = 0;
        Assertions.assertEquals(expacted, actual);
    }

    @Test

    public void UnregisteredPlayer1() {
        Player eva = new Player(57, "Eva", 105);
        Game game = new Game();

        game.register(eva);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Max", "Eva"));
    }

    @Test

    public void UnregisteredPlayer2() {
        Player eva = new Player(57, "Eva", 105);
        Game game = new Game();

        game.register(eva);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Eva", "Denis"));
    }


}
