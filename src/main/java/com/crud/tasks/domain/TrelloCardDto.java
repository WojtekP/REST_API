package com.crud.tasks.domain;

import lombok.Data;

@Data
public class TrelloCardDto {

    private String name;
    private String description;
    private String pos;
    private String listId;

    public TrelloCardDto(String test_task, String test_description, String top, String test_id) {
    }
}