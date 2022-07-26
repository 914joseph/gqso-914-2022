package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/multiplicacao/{op}/{ob}")
public class Multiplicacao {

    @GET
    public double calculaMultiplicacao(@PathParam String op, @PathParam String ob) {
        float operacao = (Float.parseFloat(op) * Float.parseFloat(ob));
        
        try {
          return operacao;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetro inválido: " + operacao);
        }
    }
}
