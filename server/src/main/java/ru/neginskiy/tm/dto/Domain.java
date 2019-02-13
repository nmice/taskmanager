package ru.neginskiy.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Domain implements Serializable {

    private List<Project> projectList;
    private List<Task> taskList;
}
