package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/subtracao/{op}/{ob}")
public class Subtracao {

    @GET
    public double calculaSubtracao(@PathParam String op, @PathParam String ob) {
        float operacao = (Float.parseFloat(op) - Float.parseFloat(ob));
        
        try {
          return operacao;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetro inválido: " + operacao);
        }
    }
}
