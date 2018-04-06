package de.otto.team1.app1.example.web;

import static java.util.concurrent.TimeUnit.HOURS;

import static org.springframework.http.CacheControl.maxAge;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.otto.team1.app1.example.domain.Example;
import de.otto.team1.app1.example.service.ExampleService;

@RestController
@RequestMapping("/examples")
public class ExampleRestController {

  private final ExampleService exampleService;

  @Autowired
  public ExampleRestController(final ExampleService exampleService) {
    this.exampleService = exampleService;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Example>> findExamples() {
    return ResponseEntity.ok()
      .contentType(APPLICATION_JSON)
      .cacheControl(maxAge(1, HOURS).cachePublic())
      .varyBy(ACCEPT)
      .body(exampleService.findAll());
  }
}
