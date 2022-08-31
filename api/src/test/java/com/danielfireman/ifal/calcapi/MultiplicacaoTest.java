package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

//import io.jooby.MockRouter;
import io.jooby.StatusCode;
//import io.jooby.exception.BadRequestException;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;
//import io.jooby.JoobyTest; 

public class MultiplicacaoTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void multiplicacao (int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:" + serverPort + "/multiplicacao/5/5")
      .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("25.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
}

