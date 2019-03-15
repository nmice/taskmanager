package ru.neginskiy.tm.endpoint;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class TaskEndpointTest {

    private UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    private static final User USER = new User();
    private static final String USER_ID = "testJUnitId";
    private static final String LOGIN = "testJUnitLogin";
    private static final String PASSWORD = "testJUnitPassword";
    private static final String PASSWORD_HASH = String.valueOf(PASSWORD.hashCode());

    private ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
    private static final Project PROJECT = new Project();
    private static final String PROJECT_ID = "testJUnitProjectId";
    private static final String NAME = "testJUnitName";
    private static final String DESCRIPTION = "testJUnitDescription";
    private static final XMLGregorianCalendar DATE_BEGIN = getGcFromStr("21-02-2019");
    private static final XMLGregorianCalendar DATE_END = getGcFromStr(null);

    private TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
    private static final Task EXPECTED_TASK = new Task();
    private static final String TASK_ID = "testJUnitTaskId";


    @Before
    public void before() {
        USER.setId(USER_ID);
        USER.setLogin(LOGIN);
        USER.setPassword(PASSWORD_HASH);
        userEndpoint.userMerge(USER);

        PROJECT.setId(PROJECT_ID);
        PROJECT.setName(NAME);
        PROJECT.setDescription(DESCRIPTION);
        PROJECT.setDateBegin(DATE_BEGIN);
        PROJECT.setDateEnd(DATE_END);

        EXPECTED_TASK.setId(TASK_ID);
        EXPECTED_TASK.setName(NAME);
        EXPECTED_TASK.setDescription(DESCRIPTION);
        EXPECTED_TASK.setDateBegin(DATE_BEGIN);
        EXPECTED_TASK.setDateEnd(DATE_END);
        EXPECTED_TASK.setProjectId(PROJECT_ID);
    }

    @Test
    public void testTaskMerge(){
        projectEndpoint.projectMerge(PROJECT);
        taskEndpoint.taskMerge(EXPECTED_TASK);
        final Task actualTask = taskEndpoint.taskGetById(EXPECTED_TASK.getId());
        Assert.assertEquals(EXPECTED_TASK.getId(), actualTask.getId());
        Assert.assertEquals(EXPECTED_TASK.getName(), actualTask.getName());
        Assert.assertEquals(EXPECTED_TASK.getDescription(), actualTask.getDescription());
        Assert.assertEquals(EXPECTED_TASK.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(EXPECTED_TASK.getDateEnd(), actualTask.getDateEnd());
        Assert.assertEquals(EXPECTED_TASK.getProjectId(), actualTask.getProjectId());
    }

    @Test
    public void testTaskDelete(){
        projectEndpoint.projectMerge(PROJECT);
        taskEndpoint.taskMerge(EXPECTED_TASK);
        final Task actualTask = taskEndpoint.taskDelete(EXPECTED_TASK.getId());
        Assert.assertEquals(EXPECTED_TASK.getId(), actualTask.getId());
        Assert.assertEquals(EXPECTED_TASK.getName(), actualTask.getName());
        Assert.assertEquals(EXPECTED_TASK.getDescription(), actualTask.getDescription());
        Assert.assertEquals(EXPECTED_TASK.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(EXPECTED_TASK.getDateEnd(), actualTask.getDateEnd());
        Assert.assertEquals(EXPECTED_TASK.getProjectId(), actualTask.getProjectId());

        Assert.assertNull(taskEndpoint.taskDelete(EXPECTED_TASK.getId()));

        Assert.assertNull(taskEndpoint.taskGetById(EXPECTED_TASK.getId()));
    }

    @Test
    public void testTaskGetAll(){
        final int expected1 = 1;
        Assert.assertEquals(expected1, taskEndpoint.taskGetAll().size());

        projectEndpoint.projectMerge(PROJECT);
        taskEndpoint.taskMerge(EXPECTED_TASK);
        final int expected2 = 2;
        Assert.assertEquals(expected2, taskEndpoint.taskGetAll().size());

        taskEndpoint.taskMerge(EXPECTED_TASK);
        Assert.assertEquals(expected2, taskEndpoint.taskGetAll().size());
    }

    @Test
    public void testTaskGetById(){
        projectEndpoint.projectMerge(PROJECT);
        taskEndpoint.taskMerge(EXPECTED_TASK);
        final Task actualTask = taskEndpoint.taskGetById(EXPECTED_TASK.getId());
        Assert.assertEquals(EXPECTED_TASK.getId(), actualTask.getId());
        Assert.assertEquals(EXPECTED_TASK.getName(), actualTask.getName());
        Assert.assertEquals(EXPECTED_TASK.getDescription(), actualTask.getDescription());
        Assert.assertEquals(EXPECTED_TASK.getDateBegin(), actualTask.getDateBegin());
        Assert.assertEquals(EXPECTED_TASK.getDateEnd(), actualTask.getDateEnd());

        taskEndpoint.taskDelete(EXPECTED_TASK.getId());
        Assert.assertNull(taskEndpoint.taskGetById(EXPECTED_TASK.getId()));
    }

    @After
    public void after(){
        taskEndpoint.taskDelete(EXPECTED_TASK.getId());
        projectEndpoint.projectDelete(PROJECT.getId());
    }
}