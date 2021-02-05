package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    Task save(Task task);
    @Override
    Optional<Task> findById(Long id);
    @Override
    void deleteById(Long id);

}