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
        .url("http://localhost:" + serverPort + "/subtracao/20/10")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("10.0",rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
  @Test
  public void subtracao_erro(int serverPort) throws IOException{
    Request req =new Request.Builder()
    .url("http://localhost:" + serverPort + "/subtracao/bbb/3")
    .build();

    try (Response rsp = client.newCall(req).execute()){
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }
}
