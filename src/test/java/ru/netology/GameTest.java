package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void registerAdd() {
        Game games = new Game();
        Player players1 = new Player(111, "Вася", 12);
        Player players2 = new Player(222, "Игорь", 6);
        Player players3 = new Player(333, "Антон", 10);
        games.register(players1);
        games.register(players2);
        games.register(players3);

        Player[] expected = {players1,players2,players3};

        Assertions.assertArrayEquals (expected, games.findAll().toArray());
    }

    @Test
    public void searchByName() {
        Game games = new Game();
        Player players1 = new Player(111, "Вася", 12);
        Player players2 = new Player(222, "Игорь", 6);
        Player players3 = new Player(333, "Антон", 10);
        games.register(players1);
        games.register(players2);
        games.register(players3);

        Player expected = players1;
        Player actual = games.findByName("Вася");

        Assertions.assertEquals (expected, actual);
    }

    @Test
    public void errorSearchByName() {
        Game games = new Game();
        Player players1 = new Player(111, "Вася", 12);
        Player players2 = new Player(222, "Игорь", 6);
        Player players3 = new Player(333, "Антон", 10);
        games.register(players1);
        games.register(players2);
        games.register(players3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.findByName("Алеша");
        });
    }

    @Test
    public void roundFirstStronger() {
        Game games = new Game();
        Player players1 = new Player(111, "Вася", 12);
        Player players2 = new Player(222, "Игорь", 6);
        games.register(players1);
        games.register(players2);

        int expected = 1;
        int actual = games.round("Вася","Игорь");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundSecondStronger() {
        Game games = new Game();
        Player players1 = new Player(111, "Вася", 10);
        Player players2 = new Player(222, "Игорь", 14);
        games.register(players1);
        games.register(players2);

        int expected = 2;
        int actual = games.round("Вася","Игорь");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundDraw() {
        Game games = new Game();
        Player players1 = new Player(111, "Вася", 10);
        Player players2 = new Player(222, "Игорь", 10);
        games.register(players1);
        games.register(players2);

        int expected = 0;
        int actual = games.round("Вася","Игорь");

        Assertions.assertEquals(expected, actual);
    }



}
