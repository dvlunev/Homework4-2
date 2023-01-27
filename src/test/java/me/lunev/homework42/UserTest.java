package me.lunev.homework42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user5;
    private User user6;
    private User user7;

    @Test
    public void createUserCorrectNameTest() {
        User user1 = new User("testlogin", "test@email.ru");
        assertEquals("testlogin", user1.getLogin());
        assertEquals("test@email.ru", user1.getEmail());
    }

    @Test
    public void createUserNotNullTest() {
        User user2 = new User(null, "test@email.ru");
        assertNotNull(user2);
        assertEquals("user", user2.getLogin());
    }

    @Test
    public void createUserNotEmptyTest() {
        User user3 = new User("", "test@email.ru");
        assertEquals("user", user3.getLogin());
    }

    @Test
    public void createUserNotBlankTest() {
        User user4 = new User(" ", "test@email.ru");
        assertEquals("user", user4.getLogin());
    }

    @Test
    public void createUserWhithoutParametrsTest() {
        assertThrows(IllegalArgumentException.class, () -> user5 = new User(null, null));
        assertThrows(IllegalArgumentException.class, () -> user5 = new User("", ""));
        assertThrows(IllegalArgumentException.class, () -> user5 = new User(" ", " "));
        assertThrows(IllegalArgumentException.class, () -> user5 = new User());
    }

    @Test
    public void createUserWithWrongEmail() {
        assertThrows(IllegalArgumentException.class, () -> user6 = new User("login", "fdgfgfggfgdfru"));
        assertThrows(IllegalArgumentException.class, () -> user6 = new User("login", "fdgfgfgg@fgdfru"));
        assertThrows(IllegalArgumentException.class, () -> user6 = new User("login", "fdgfgfggfg.dfru"));
    }

    @Test
    public void createUserWithSameLoginAndEmail() {
        assertThrows(IllegalArgumentException.class, () -> user7 = new User("login@email.com", "login@email.com"));
    }
}
