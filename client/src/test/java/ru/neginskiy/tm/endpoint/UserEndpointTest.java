package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Test;

import static ru.neginskiy.tm.endpoint.UserEndpointService.*;

public class UserEndpointTest {

    @Test
    public void testMergeUser() {
        final UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
        final User expectedUser = new User();
        final String id = "testJUnitId";
        expectedUser.setId(id);
        final String login = "testJUnitLogin";
        expectedUser.setLogin(login);
        final String password = "testJUnitPasswordHash";
        final String passwordHash = String.valueOf(password.hashCode());
        expectedUser.setPasswordHash(passwordHash);
        userEndpoint.userMerge(expectedUser);
        final User actualUser = userEndpoint.findUser(login,passwordHash);
        Assert.assertEquals(expectedUser, actualUser);
    }

}