package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class TaskEndpointTest {

    private static final User USER = new User();
    private static final String USER_ID = "testJUnitId";
    private static final String LOGIN = "testJUnitLogin";
    private static final String PASSWORD = "testJUnitPasswordHash";
    private static final String PASSWORD_HASH = String.valueOf(PASSWORD.hashCode());

    private SessionEndpoint sessionEndpoint;
    private Session session;

    private TaskEndpoint taskEndpoint;
    private static final Task EXPECTED_TASK = new Task();
    private static final String TASK_ID = "testJUnitTaskId";
    private static final String NAME = "testJUnitName";
    private static final String DESCRIPTION = "testJUnitDescription";
    private static final XMLGregorianCalendar DATE_BEGIN = getGcFromStr("21-02-2019");
    private static final XMLGregorianCalendar DATE_END = getGcFromStr(null);

    private static final Project EXPECTED_PROJECT = new Project();
    private static final String PROJECT_ID = "testJUnitProjectId";

    @Before
    public void before() {
        USER.setId(USER_ID);
        USER.setLogin(LOGIN);
        USER.setPasswordHash(PASSWORD_HASH);

        sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
        session = sessionEndpoint.getNewSession(USER);

        EXPECTED_PROJECT.setId(PROJECT_ID);
        EXPECTED_PROJECT.setName(NAME);
        EXPECTED_PROJECT.setDescription(DESCRIPTION);
        EXPECTED_PROJECT.setDateBegin(DATE_BEGIN);
        EXPECTED_PROJECT.setDateEnd(DATE_END);
        EXPECTED_PROJECT.setUser(USER);

        taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
        EXPECTED_TASK.setId(TASK_ID);
        EXPECTED_TASK.setName(NAME);
        EXPECTED_TASK.setDescription(DESCRIPTION);
        EXPECTED_TASK.setDateBegin(DATE_BEGIN);
        EXPECTED_TASK.setDateEnd(DATE_END);
        EXPECTED_TASK.setProject(EXPECTED_PROJECT);
        EXPECTED_TASK.setUser(USER);
    }

    @Test
    public void testTaskMerge() throws UncorrectSessionException_Exception {
        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        final Task actualTask = taskEndpoint.taskGetById(session, EXPECTED_TASK.getId());
        Assert.assertEquals(EXPECTED_TASK.getId(), actualTask.getId());
        Assert.assertEquals(EXPECTED_TASK.getName(), actualTask.getName());
        Assert.assertEquals(EXPECTED_TASK.getDescription(), actualTask.getDescription());
        Assert.assertEquals(EXPECTED_TASK.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(EXPECTED_TASK.getDateEnd(), actualTask.getDateEnd());
        Assert.assertEquals(EXPECTED_TASK.getProject().getId(), actualTask.getProject().getId());
        Assert.assertEquals(EXPECTED_TASK.getUser().getLogin(), actualTask.getUser().getLogin());

        try {
            session.setSignature("abracadabra");
            taskEndpoint.taskMerge(session, EXPECTED_TASK);
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void testTaskDelete() throws UncorrectSessionException_Exception {
        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        final Task actualTask = taskEndpoint.taskDelete(session, EXPECTED_TASK.getId());
        Assert.assertEquals(EXPECTED_TASK.getId(), actualTask.getId());
        Assert.assertEquals(EXPECTED_TASK.getName(), actualTask.getName());
        Assert.assertEquals(EXPECTED_TASK.getDescription(), actualTask.getDescription());
        Assert.assertEquals(EXPECTED_TASK.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(EXPECTED_TASK.getDateEnd(), actualTask.getDateEnd());
        Assert.assertEquals(EXPECTED_TASK.getProject().getId(), actualTask.getProject().getId());
        Assert.assertEquals(EXPECTED_TASK.getUser().getLogin(), actualTask.getUser().getLogin());

        Assert.assertNull(taskEndpoint.taskDelete(session, EXPECTED_TASK.getId()));

        Assert.assertNull(taskEndpoint.taskGetById(session, EXPECTED_TASK.getId()));

        try {
            session.setSignature("abracadabra");
            taskEndpoint.taskDelete(session, EXPECTED_TASK.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertEquals("Session is uncorrect", ex.getMessage());
        }
    }

    @Test
    public void testTaskGetAllByUserId() throws UncorrectSessionException_Exception {
        final int expected0 = 0;
        Assert.assertEquals(expected0, taskEndpoint.taskGetAllByUserId(session, USER.getId()).size());

        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        final int expected1 = 1;
        Assert.assertEquals(expected1, taskEndpoint.taskGetAllByUserId(session, USER.getId()).size());

        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        Assert.assertEquals(expected1, taskEndpoint.taskGetAllByUserId(session, USER.getId()).size());

        try {
            session.setSignature("abracadabra");
            taskEndpoint.taskGetAllByUserId(session, USER.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void testTaskGetById() throws UncorrectSessionException_Exception {
        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        final Task actualTask = taskEndpoint.taskGetById(session, EXPECTED_TASK.getId());
        Assert.assertEquals(EXPECTED_TASK.getId(), actualTask.getId());
        Assert.assertEquals(EXPECTED_TASK.getName(), actualTask.getName());
        Assert.assertEquals(EXPECTED_TASK.getDescription(), actualTask.getDescription());
        Assert.assertEquals(EXPECTED_TASK.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(EXPECTED_TASK.getDateEnd(), actualTask.getDateEnd());
        Assert.assertEquals(EXPECTED_TASK.getUser().getLogin(), actualTask.getUser().getLogin());

        taskEndpoint.taskDelete(session, EXPECTED_TASK.getId());
        Assert.assertNull(taskEndpoint.taskGetById(session, EXPECTED_TASK.getId()));

        try {
            session.setSignature("abracadabra");
            taskEndpoint.taskDelete(session, EXPECTED_PROJECT.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
}