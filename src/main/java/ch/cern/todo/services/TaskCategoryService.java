package ch.cern.todo.services;

import ch.cern.todo.exceptions.ResourceNotFoundException;
import ch.cern.todo.models.TaskCategory;
import ch.cern.todo.repositories.TaskCategoryRepository;
import ch.cern.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskCategoryService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategoryService(TaskCategoryRepository taskCategoryRepository) {
        this.taskCategoryRepository = taskCategoryRepository;
    }

    public List<TaskCategory> getTaskCategories() {
        List<TaskCategory> allTaskCategories = new ArrayList<>();

        return allTaskCategories;
    }

    public TaskCategory getTaskCategory(long id) {
        Optional<TaskCategory> result = taskCategoryRepository.findById(id);

        if (result == null) {
            throw new ResourceNotFoundException("Task Category with id=" + id + "does not exist.");
        }

        return result.get();
    }

    public void addTaskCategory(TaskCategory taskCategory) {
        taskCategoryRepository.save(taskCategory);
    }
}
