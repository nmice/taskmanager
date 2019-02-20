package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Test;

import static ru.neginskiy.tm.endpoint.UserEndpointService.*;

public class UserEndpointTest {

    @Test
    public void testMergeUser() {
        User expectedUser = new User();
        expectedUser.setId("testJUnitId");
        expectedUser.setLogin("testJUnitLogin");
        expectedUser.setPasswordHash("testJUnitPasswordHash");
        getUserEndpointPort().


        int[] actuals = mergeSortedArrays(new int[]{1, 2, 5}, new int[]{3, 4});
        Assert.assertArrayEquals("An error has occurred", expecteds, actuals);

    }

}