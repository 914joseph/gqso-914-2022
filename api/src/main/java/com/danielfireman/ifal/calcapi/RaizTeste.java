package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class RaizTest {

  @Test
  public void chamaCalculaRaiz() {
    Divisao divisao = new Divisao();
    assertEquals(3.0, divisao.calculaRaiz("9/3"));
  }

  @Test
  public void raiz() {
    MockRouter router = new MockRouter(new App());
    router.get("/divisao/10/5", rsp -> {
      assertEquals(2.0, rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }

  @Test
  public void raiz_opString() {
    MockRouter router = new MockRouter(new App());
    assertThrows(NumberFormatException.class,
    ()->{
      router.get("/divisao/abc/9", rsp -> {});
    });
  }
}
