package ch.cern.todo.services;

import ch.cern.todo.exceptions.ResourceNotFoundException;
import ch.cern.todo.models.Task;
import ch.cern.todo.models.TaskCategory;
import ch.cern.todo.repositories.TaskCategoryRepository;
import ch.cern.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;
    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        List<Task> allTasks = new ArrayList<>();

        taskRepository.findAll().forEach(allTasks::add);

        return allTasks;
    }

    public Task getTask(Long id) {
        Optional<Task> result = taskRepository.findById(id);

        if (result == null) {
            throw new ResourceNotFoundException("Task with id=" + id + "does not exist.");
        }

        return result.get();
    }

    public void addTask(Task task) {
        TaskCategory taskCategory = task.getTaskCategory();
        taskCategory.setId(taskCategory.getId());
        taskCategory.setCategoryName(taskCategory.getCategoryName());
        taskCategory.setCategoryDescription(taskCategory.getCategoryDescription());

        taskCategoryRepository.save(taskCategory);
        taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskName(task.getTaskName());
            existingTask.setTaskDescription(task.getTaskDescription());
            existingTask.setTaskDeadline(task.getTaskDeadline());
            existingTask.setTaskCategory(task.getTaskCategory()); // Updated for category
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        Task existingTask = getTask(id);
        taskRepository.delete(existingTask);
    }
}
