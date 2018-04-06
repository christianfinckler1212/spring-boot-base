package de.otto.team1.app1.example.service;

import java.util.Collections;
import java.util.List;

import de.otto.team1.app1.example.domain.Example;

public class ExampleService {

  public List<Example> findAll() {
    return Collections.singletonList(new Example("someExample"));
  }
}
