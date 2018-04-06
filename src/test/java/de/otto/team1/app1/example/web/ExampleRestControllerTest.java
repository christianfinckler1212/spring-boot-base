package de.otto.team1.app1.example.web;

import static java.util.Collections.singletonList;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.otto.team1.app1.common.AbstractWebIntegrationTest;
import de.otto.team1.app1.example.domain.Example;
import de.otto.team1.app1.example.service.ExampleService;

public class ExampleRestControllerTest extends AbstractWebIntegrationTest {

  @MockBean
  private ExampleService exampleService;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void expectToGetExamples() throws Exception {
    // given
    final var example = new Example("testExample");
    final var examples = singletonList(example);
    given(exampleService.findAll()).willReturn(examples);

    // when & then
    mvc.perform(get(URI.create("/examples"))
      .accept(APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().json(objectMapper.writeValueAsString(examples)));
  }
}
