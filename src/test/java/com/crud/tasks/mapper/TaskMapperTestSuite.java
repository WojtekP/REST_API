package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.ArrayList;
import java.util.List;

@ExtendWith({SpringExtension.class})
public class TaskMapperTestSuite {

    @Test
    public void shouldMapToTask() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //Then
        Assertions.assertEquals(task.getTitle(), mappedTask.getTitle());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);
        //Then
        Assertions.assertEquals(taskDto.getTitle(), mappedTask.getTitle());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //When
        List<TaskDto> mappedTasks = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assertions.assertEquals(taskList.get(0).getTitle(), mappedTasks.get(0).getTitle());
    }
    @Test
    public void shouldMapToBoards() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        TrelloBoard trelloBoard = new TrelloBoard("test", "test", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        List<TrelloBoard> expected = new ArrayList<>();
        expected.add(trelloBoard);
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloBoard trelloBoard = new TrelloBoard("test", "test", new ArrayList<>());
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        List<TrelloBoardDto> expected = new ArrayList<>();
        expected.add(trelloBoardDto);
        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test
    public void shouldMapToList() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList trelloList = new TrelloList("test", "test", false);
        TrelloListDto trelloListDto = new TrelloListDto("test", "test", false);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);
        List<TrelloList> expected = new ArrayList<>();
        expected.add(trelloList);
        //When
        List<TrelloList> result = trelloMapper.mapToList(trelloListsDto);
        //Then
        Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test
    public void shouldMapToListDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList trelloList = new TrelloList("test", "test", false);
        TrelloListDto trelloListDto = new TrelloListDto("test", "test", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        List<TrelloListDto> expected = new ArrayList<>();
        expected.add(trelloListDto);
        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);
        //Then
        Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test
    public void shouldMapToCard() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCard card = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assertions.assertEquals(card.getName(), trelloCard.getName());
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCardDto card = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assertions.assertEquals(trelloCardDto.getName(), card.getName());
    }
}
