package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import io.jooby.StatusCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import io.jooby.MockRouter;

public class MultiplicacaoTest {

  public void calculaMultiplicacao () {
    Multiplicacao multiplicacao = new Multiplicacao();
    assertEquals(20, multiplicacao.calculaMultiplicacao("10", "2"));
  }

  @Test
  public void multiplicacao () {
    MockRouter router = new MockRouter(new App());
    router.get("/multiplicacao/9/1", rsp -> {
      assertEquals(9.0, rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }

  @Test
  public void multiplicacao_opString() {
    MockRouter router = new MockRouter(new App());
    assertThrows(NumberFormatException.class,
    ()->{
      router.get("/multiplicacao/aa/13", rsp -> {});
    });
  }

}

