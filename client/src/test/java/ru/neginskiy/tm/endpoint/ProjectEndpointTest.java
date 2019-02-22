package ru.neginskiy.tm.endpoint;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class ProjectEndpointTest {

    private UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    private static final User USER = new User();
    private static final String USER_ID = "testJUnitId";
    private static final String LOGIN = "testJUnitLogin";
    private static final String PASSWORD = "testJUnitPassword";
    private static final String PASSWORD_HASH = String.valueOf(PASSWORD.hashCode());

    private SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
    private Session session;
    private String correctSignature;

    private ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
    private static final Project EXPECTED_PROJECT = new Project();
    private static final String PROJECT_ID = "testJUnitProjectId";
    private static final String NAME = "testJUnitName";
    private static final String DESCRIPTION = "testJUnitDescription";
    private static final XMLGregorianCalendar DATE_BEGIN = getGcFromStr("21-02-2019");
    private static final XMLGregorianCalendar DATE_END = getGcFromStr(null);

    private TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
    private static final Task TASK = new Task();
    private static final String TASK_ID = "testJUnitTaskId";

    private static final String UNCORRECT_SIGNATURE = "abracadabra";
    private static final String UNCORRECT_SESSION_EXCEPTION_MSG = "Session is uncorrect";

    @Before
    public void before() {
        USER.setId(USER_ID);
        USER.setLogin(LOGIN);
        USER.setPasswordHash(PASSWORD_HASH);
        userEndpoint.userMerge(USER);

        session = sessionEndpoint.getNewSession(USER);
        correctSignature = session.getSignature();

        EXPECTED_PROJECT.setId(PROJECT_ID);
        EXPECTED_PROJECT.setName(NAME);
        EXPECTED_PROJECT.setDescription(DESCRIPTION);
        EXPECTED_PROJECT.setDateBegin(DATE_BEGIN);
        EXPECTED_PROJECT.setDateEnd(DATE_END);
        EXPECTED_PROJECT.setUser(USER);

        TASK.setId(TASK_ID);
        TASK.setName(NAME);
        TASK.setDescription(DESCRIPTION);
        TASK.setDateBegin(DATE_BEGIN);
        TASK.setDateEnd(DATE_END);
        TASK.setProject(EXPECTED_PROJECT);
        TASK.setUser(USER);
    }

    @Test
    public void testProjectMerge() throws UncorrectSessionException_Exception {
        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        final Project actualProject = projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
        Assert.assertEquals(EXPECTED_PROJECT.getUser().getLogin(), actualProject.getUser().getLogin());

        try {
            session.setSignature(UNCORRECT_SIGNATURE);
            projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertEquals(UNCORRECT_SESSION_EXCEPTION_MSG, ex.getMessage());
        }
    }

    @Test
    public void testProjectDelete() throws UncorrectSessionException_Exception {
        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        taskEndpoint.taskMerge(session, TASK);
        final Project actualProject = projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
        Assert.assertEquals(EXPECTED_PROJECT.getUser().getLogin(), actualProject.getUser().getLogin());

        Assert.assertNull(projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId()));

        Assert.assertNull(projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId()));
        Assert.assertNull(taskEndpoint.taskGetById(session, TASK.getId()));

        try {
            session.setSignature(UNCORRECT_SIGNATURE);
            projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertEquals(UNCORRECT_SESSION_EXCEPTION_MSG, ex.getMessage());
        }
    }

    @Test
    public void testProjectGetAllByUserId() throws UncorrectSessionException_Exception {
        final int expected0 = 0;
        Assert.assertEquals(expected0, projectEndpoint.projectGetAllByUserId(session, USER.getId()).size());

        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        final int expected1 = 1;
        Assert.assertEquals(expected1, projectEndpoint.projectGetAllByUserId(session, USER.getId()).size());

        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        Assert.assertEquals(expected1, projectEndpoint.projectGetAllByUserId(session, USER.getId()).size());

        try {
            session.setSignature(UNCORRECT_SIGNATURE);
            projectEndpoint.projectGetAllByUserId(session, USER.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertEquals(UNCORRECT_SESSION_EXCEPTION_MSG, ex.getMessage());
        }
    }

    @Test
    public void testProjectGetById() throws UncorrectSessionException_Exception {
        projectEndpoint.projectMerge(session, EXPECTED_PROJECT);
        final Project actualProject = projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
        Assert.assertEquals(EXPECTED_PROJECT.getUser().getLogin(), actualProject.getUser().getLogin());

        projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
        Assert.assertNull(projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId()));

        try {
            session.setSignature(UNCORRECT_SIGNATURE);
            projectEndpoint.projectGetById(session, EXPECTED_PROJECT.getId());
            Assert.fail("Expected UncorrectedSessionException");
        } catch (UncorrectSessionException_Exception ex) {
            Assert.assertEquals(UNCORRECT_SESSION_EXCEPTION_MSG, ex.getMessage());
        }
    }

    @After
    public void after() throws UncorrectSessionException_Exception {
        session.setSignature(correctSignature);
        taskEndpoint.taskDelete(session, TASK.getId());
        projectEndpoint.projectDelete(session, EXPECTED_PROJECT.getId());
    }
}