package ru.neginskiy.tm.endpoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class ProjectEndpointTest {

    private static final User USER = new User();
    private static final String USER_ID = "testJUnitId";
    private static final String LOGIN = "testJUnitLogin";
    private static final String PASSWORD = "testJUnitPasswordHash";
    private static final String PASSWORD_HASH = String.valueOf(PASSWORD.hashCode());

    private SessionEndpoint sessionEndpoint;
    private Session session;

    private ProjectEndpoint projectEndpoint;
    private static final Project EXPECTED_PROJECT = new Project();
    private static final String PROJECT_ID = "testJUnitProjectId";
    private static final String NAME = "testJUnitName";
    private static final String DESCRIPTION = "testJUnitDescription";
    private static final XMLGregorianCalendar DATE_BEGIN = getGcFromStr("21-02-2019");
    private static final XMLGregorianCalendar DATE_END = getGcFromStr(null);

    private TaskEndpoint taskEndpoint;
    private static final Task EXPECTED_TASK = new Task();
    private static final String TASK_ID = "testJUnitTaskId";

    @Before
    public void before() {
        USER.setId(USER_ID);
        USER.setLogin(LOGIN);
        USER.setPasswordHash(PASSWORD_HASH);

        sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
        session = sessionEndpoint.getNewSession(USER);

        projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
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
    public void testProjectMerge(){
        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        final Project actualProject = projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
        Assert.assertEquals(EXPECTED_PROJECT.getUser().getLogin(), actualProject.getUser().getLogin());

        try {
            session.setSignature("123");
            projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
            Assert.fail("Expected UncorrectedSessionException");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void testProjectDelete(){
        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        final Project actualProject = projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
        Assert.assertEquals(EXPECTED_PROJECT.getUser().getLogin(), actualProject.getUser().getLogin());

        Assert.assertNull(projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId()));

        Assert.assertNull(taskEndpoint.taskGetById(session, EXPECTED_TASK.getId()));

        try {
            session.setSignature("abracadabra");
            projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (RuntimeException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void testProjectGetAllByUserId(){
        final int expected0 = 0;
        Assert.assertEquals(expected0, projectEndpoint.projectGetAllByUserId(session, USER.getId()).size());

        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        final int expected1 = 1;
        Assert.assertEquals(expected1, projectEndpoint.projectGetAllByUserId(session, USER.getId()).size());

        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        Assert.assertEquals(expected1, projectEndpoint.projectGetAllByUserId(session, USER.getId()).size());

        try {
            session.setSignature("abracadabra");
            projectEndpoint.projectGetAllByUserId(session, EXPECTED_PROJECT.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (RuntimeException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void testProjectGetById(){
        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        taskEndpoint.taskMerge(session, EXPECTED_TASK);
        final Project actualProject = projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
        Assert.assertEquals(EXPECTED_PROJECT.getUser().getLogin(), actualProject.getUser().getLogin());

        Assert.assertNull(projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId()));

        Assert.assertNull(taskEndpoint.taskGetById(session, EXPECTED_TASK.getId()));

        try {
            session.setSignature("abracadabra");
            projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (RuntimeException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
}