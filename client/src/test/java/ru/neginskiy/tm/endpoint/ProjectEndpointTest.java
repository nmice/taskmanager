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

    @Before
    public void before() {
        USER.setId(USER_ID);
        USER.setLogin(LOGIN);
        USER.setPassword(PASSWORD);
        userEndpoint.userMerge(USER);

        EXPECTED_PROJECT.setId(PROJECT_ID);
        EXPECTED_PROJECT.setName(NAME);
        EXPECTED_PROJECT.setDescription(DESCRIPTION);
        EXPECTED_PROJECT.setDateBegin(DATE_BEGIN);
        EXPECTED_PROJECT.setDateEnd(DATE_END);

        TASK.setId(TASK_ID);
        TASK.setName(NAME);
        TASK.setDescription(DESCRIPTION);
        TASK.setDateBegin(DATE_BEGIN);
        TASK.setDateEnd(DATE_END);
        TASK.setProjectId(PROJECT_ID);
    }

    @Test
    public void testProjectMerge(){
        projectEndpoint.projectMerge(EXPECTED_PROJECT);
        final Project actualProject = projectEndpoint.projectGetById(EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());
    }

    @Test
    public void testProjectDelete(){
        projectEndpoint.projectMerge(EXPECTED_PROJECT);
        taskEndpoint.taskMerge(TASK);
        final Project actualProject = projectEndpoint.projectDelete(EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());

        Assert.assertNull(projectEndpoint.projectDelete(EXPECTED_PROJECT.getId()));

        Assert.assertNull(projectEndpoint.projectGetById(EXPECTED_PROJECT.getId()));
   }

    @Test
    public void testProjectGetAll(){
        final int expected0 = 1;
        Assert.assertEquals(expected0, projectEndpoint.projectGetAll().size());

        projectEndpoint.projectMerge(EXPECTED_PROJECT);
        final int expected2 = 2;
        Assert.assertEquals(expected2, projectEndpoint.projectGetAll().size());

        projectEndpoint.projectMerge(EXPECTED_PROJECT);
        Assert.assertEquals(expected2, projectEndpoint.projectGetAll().size());
    }

    @Test
    public void testProjectGetById(){
        projectEndpoint.projectMerge(EXPECTED_PROJECT);
        final Project actualProject = projectEndpoint.projectGetById(EXPECTED_PROJECT.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getId(), actualProject.getId());
        Assert.assertEquals(EXPECTED_PROJECT.getName(), actualProject.getName());
        Assert.assertEquals(EXPECTED_PROJECT.getDescription(), actualProject.getDescription());
        Assert.assertEquals(EXPECTED_PROJECT.getDateBegin(), actualProject.getDateBegin());
        Assert.assertEquals(EXPECTED_PROJECT.getDateEnd(), actualProject.getDateEnd());

        projectEndpoint.projectDelete(EXPECTED_PROJECT.getId());
        Assert.assertNull(projectEndpoint.projectGetById(EXPECTED_PROJECT.getId()));
    }

    @After
    public void after(){
        taskEndpoint.taskDelete(TASK.getId());
        projectEndpoint.projectDelete(EXPECTED_PROJECT.getId());
    }
}