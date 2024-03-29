package com.danielfireman.ifal.calcapi;

import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class IntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void shouldSayHi(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/multiplicacao/5/5")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("25.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }

  public void multiplicacao_erro(int serverPort) throws IOException {
    Request req = new Request.Builder()
    .url("http://localhost:" + serverPort + "/multiplicacao/ttt/3")
    .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }
}
