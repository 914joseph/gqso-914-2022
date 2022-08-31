package com.danielfireman.ifal.calcapi;

import io.jooby.Jooby;

public class App extends Jooby {

  {
    mvc(new Index());
 
    mvc(new Multiplicacao());

    mvc(new Subtracao());

  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }
}
