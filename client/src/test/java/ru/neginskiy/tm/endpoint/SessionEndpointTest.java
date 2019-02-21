package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Test;

public class SessionEndpointTest {

    @Test
    public void testGetNewSession() {
        final User expectedUser = new User();
        final String id = "testJUnitId";
        final String login = "testJUnitLogin";
        final String password = "testJUnitPasswordHash";
        final String passwordHash = String.valueOf(password.hashCode());
        final SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
        expectedUser.setId(id);
        expectedUser.setLogin(login);
        expectedUser.setPasswordHash(passwordHash);
        Session session = sessionEndpoint.getNewSession(expectedUser);
        final User actualUser = session.getUser();
        Assert.assertEquals(expectedUser.getId(), actualUser.getId());
        Assert.assertEquals(expectedUser.getLogin(), actualUser.getLogin());
        Assert.assertEquals(expectedUser.getPasswordHash(), actualUser.getPasswordHash());
    }
}