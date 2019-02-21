package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class TaskEndpointTest {

    private final User user = new User();
    private final String userId = "testJUnitId";
    private final String login = "testJUnitLogin";
    private final String password = "testJUnitPasswordHash";
    private final String passwordHash = String.valueOf(password.hashCode());

    private SessionEndpoint sessionEndpoint;
    private Session session;

    private TaskEndpoint taskEndpoint;
    private final Task expectedTask = new Task();
    private final String taskId = "testJUnitId";
    private final String name = "testJUnitName";
    private final String description = "testJUnitDescription";
    private final XMLGregorianCalendar testDate1 = getGcFromStr("21-02-2019");
    private final XMLGregorianCalendar testDate2 = getGcFromStr(null);
    private final String projectId = "testJUnitProjectId";

    @Before
    public void before() {
        user.setId(userId);
        user.setLogin(login);
        user.setPasswordHash(passwordHash);

        sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
        session = sessionEndpoint.getNewSession(user);

        taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
        expectedTask.setId(taskId);
        expectedTask.setName(name);
        expectedTask.setDescription(description);
        expectedTask.setDateBegin(testDate1);
        expectedTask.setDateEnd(testDate2);
    }

    @Test
    public void testTaskMerge(){
        taskEndpoint.taskMerge(session, expectedTask);
        final Task actualTask = taskEndpoint.taskGetById(session, expectedTask.getId());

        Assert.assertEquals(expectedTask.getId(), actualTask.getId());
        Assert.assertEquals(expectedTask.getName(), actualTask.getName());
        Assert.assertEquals(expectedTask.getDescription(), actualTask.getDescription());
        Assert.assertEquals(expectedTask.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(expectedTask.getDateEnd(), actualTask.getDateEnd());
    }
}