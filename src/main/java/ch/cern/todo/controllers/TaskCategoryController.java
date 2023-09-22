package ch.cern.todo.controllers;

import ch.cern.todo.models.TaskCategory;
import ch.cern.todo.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskCategoryController {

    @Autowired
    private final TaskCategoryService taskCategoryService;

    public TaskCategoryController(TaskCategoryService taskCategoryService) {
        this.taskCategoryService = taskCategoryService;
    }

    @GetMapping("/taskCategories")
    public List<TaskCategory> getTaskCategories() {
        return taskCategoryService.getTaskCategories();
    }

    @GetMapping("/taskCategories/{id}")
    public TaskCategory getTaskCategory(@PathVariable Long id) {
        return taskCategoryService.getTaskCategory(id);
    }

    @PostMapping("/taskCategories")
    public void addTaskCategory(@RequestBody TaskCategory taskCategory) {
        taskCategoryService.addTaskCategory(taskCategory);
    }
}
