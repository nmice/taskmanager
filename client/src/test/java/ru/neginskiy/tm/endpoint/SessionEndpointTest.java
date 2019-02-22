package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessionEndpointTest {

    final UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    private static final User USER = new User();
    private static final String USER_ID = "testJUnitId";
    private static final String LOGIN = "testJUnitLogin";
    private static final String PASSWORD = "testJUnitPassword";
    private static final String PASSWORD_HASH = String.valueOf(PASSWORD.hashCode());

    final SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
    private Session session;

    @Before
    public void before() {
        USER.setId(USER_ID);
        USER.setLogin(LOGIN);
        USER.setPasswordHash(PASSWORD_HASH);
        userEndpoint.userMerge(USER);
    }

    @Test
    public void testGetNewSession() {
        session = sessionEndpoint.getNewSession(USER);
        final User actualUser = session.getUser();
        Assert.assertEquals(USER.getId(), actualUser.getId());
        Assert.assertEquals(USER.getLogin(), actualUser.getLogin());
        Assert.assertEquals(USER.getPasswordHash(), actualUser.getPasswordHash());
    }
}