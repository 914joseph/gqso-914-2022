package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import io.jooby.StatusCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import io.jooby.MockRouter;

public class SomaTest {

  public void calculaSoma () {
    Soma soma = new Soma();
    assertEquals(12, soma.calculaSoma("10", "2"));
  }

  @Test
  public void soma () {
    MockRouter router = new MockRouter(new App());
    router.get("/soma/9/1", rsp -> {
      assertEquals(10.0, rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }

  @Test
  public void soma_opString() {
    MockRouter router = new MockRouter(new App());
    assertThrows(NumberFormatException.class,
    ()->{
      router.get("/soma/aa/13", rsp -> {});
    });
  }

}

