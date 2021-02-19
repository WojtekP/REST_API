package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DbServiceTest {

    @InjectMocks
    DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void shouldGetAllTasks() {
        //Given
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        Task task1 = new Task();
        tasks.add(task);
        tasks.add(task1);
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);
        //When
        List<Task> taskList = dbService.getAllTasks();
        // Then
        Assertions.assertEquals(2, taskList.size());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task task = new Task(1L, "test", "test");
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        //When
        Optional<Task> optionalTask = dbService.getTask(1L);
        //Then
        Assertions.assertTrue(optionalTask.isPresent());
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(1L, "test", "test");
        Mockito.when(taskRepository.save(task)).thenReturn(task);
        //When
        Task task1 = dbService.saveTask(task);
        //Then
        Assertions.assertEquals(task.getId(), task1.getId());
    }

    @Test
    public void shouldDeleteTask() {
        taskRepository.deleteById(1L);
    }
}
