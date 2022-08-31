package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class DivisaoTest {

  @Test
  public void divisao() {
    MockRouter router = new MockRouter(new App());
    router.get("/divisao/9/3", rsp -> {
      assertEquals(3.0, rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }

  @Test
  public void divisao_opString() {
    MockRouter router = new MockRouter(new App());
    assertThrows(BadRequestException.class,
    ()->{
      router.get("/divisao/10/abc", rsp -> {});
    });
  }
}