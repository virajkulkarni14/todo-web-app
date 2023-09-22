package ch.cern.todo.controllers;

import ch.cern.todo.models.Task;
import ch.cern.todo.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @PutMapping("/tasks/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
