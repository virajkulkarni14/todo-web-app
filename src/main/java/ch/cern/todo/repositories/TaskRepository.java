package ch.cern.todo.repositories;

import ch.cern.todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
//    public List<Task> findByCategoryId(Long category_id);
}
