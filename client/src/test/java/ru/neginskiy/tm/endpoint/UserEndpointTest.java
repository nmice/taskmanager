package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserEndpointTest {

    private UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    private final static User EXPECTED_USER = new User();
    private static final String ID = "testJUnitId";
    private static final String LOGIN = "testJUnitLogin";
    private static final String PASSWORD = "testJUnitPassword";

    @Before
    public void before() {
        EXPECTED_USER.setId(ID);
        EXPECTED_USER.setLogin(LOGIN);
        EXPECTED_USER.setPassword(PASSWORD);
        userEndpoint.userMerge(EXPECTED_USER);
    }

    @Test
    public void testUserMerge() {
        final User actualUser = userEndpoint.findUser(LOGIN, PASSWORD);
        Assert.assertEquals(EXPECTED_USER.getId(), actualUser.getId());
        Assert.assertEquals(EXPECTED_USER.getLogin(), actualUser.getLogin());
        Assert.assertEquals(EXPECTED_USER.getPassword(), actualUser.getPassword());
    }

    @Test
    public void testIsRegistredLogin() {
        final boolean expected1 = true;
        Assert.assertEquals(expected1, userEndpoint.isRegistredLogin("testJUnitLogin"));
        final boolean expected2 = false;
        Assert.assertEquals(expected2, userEndpoint.isRegistredLogin("testJUnitUncorrectedLogin"));
    }

    @Test
    public void testFindUser() {
        final User actualUser1 = userEndpoint.findUser(LOGIN, PASSWORD);
        Assert.assertEquals(EXPECTED_USER.getId(), actualUser1.getId());
        Assert.assertEquals(EXPECTED_USER.getLogin(), actualUser1.getLogin());
        Assert.assertEquals(EXPECTED_USER.getPassword(), actualUser1.getPassword());

        final User actualUser2 = userEndpoint.findUser(LOGIN, "abracadabra");
        Assert.assertNull(actualUser2);

        final User actualUser3 = userEndpoint.findUser("abracadabra", PASSWORD);
        Assert.assertNull(actualUser3);

        final User actualUser4 = userEndpoint.findUser("abracadabra", "abracadabra");
        Assert.assertNull(actualUser4);
    }
}