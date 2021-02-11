package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrelloClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);
    @Autowired
    private final RestTemplate restTemplate;
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.app.username}")
    private String trelloUsername;

   private URI getUrl(){
       return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/"+trelloUsername+"/boards")
               .queryParam("fields", "name,id")
               .queryParam("lists", "all")
               .queryParam("key", trelloAppKey)
               .queryParam("token", trelloToken)
               .build().encode().toUri();
   }
   public List<TrelloBoardDto> getTrelloBoards() {


       try {
           TrelloBoardDto[] boardsResponse = restTemplate.getForObject(getUrl(), TrelloBoardDto[].class);
           return Optional.ofNullable(boardsResponse)
                   .map(Arrays::asList)
                   .orElse(Collections.emptyList())
                   .stream()
                   .filter(p -> Objects.nonNull(p.getId()) && Objects.nonNull(p.getName())) //.filter(p -> p.getName().contains("Kodilla"))
                   .collect(Collectors.toList());
       } catch (RestClientException e) {
           LOGGER.error(e.getMessage(), e);
           return Collections.emptyList();
       }

    }
}