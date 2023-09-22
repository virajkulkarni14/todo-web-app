package ch.cern.todo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TASK_CATEGORIES")
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "CATEGORY_DESCRIPTION")
    private String categoryDescription;

    @OneToMany(mappedBy = "taskCategory")
    private List<Task> tasks;

    public TaskCategory() {}

    public TaskCategory(long id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
