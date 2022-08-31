package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import io.jooby.StatusCode;
import java.io.IOException;

public class SubtracaoTest {


  static OkHttpClient client = new OkHttpClient();

  @Test
  public void subtrair(int serverPort) throws IOException {
    Request requeste = new Request.Builder()
    .url("http://localhost:" + serverPort + "/subtracao/20/10")
    .build();

    try (Response response = client.newCall(requeste).execute()) {
      assertEquals("10.0", response.body().string());
      assertEquals(StatusCode.OK.value(), response.code());
    }
  }
}