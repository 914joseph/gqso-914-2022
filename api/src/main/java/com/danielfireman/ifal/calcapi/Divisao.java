package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/divisao/{op}/{ob}")
public class Divisao{

    @GET
    public double calculaDivisao(@PathParam String op, @PathParam String ob) {
        float operacao = (Float.parseFloat(op)/Float.parseFloat(ob));
        
        try {
          return operacao;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetro inválido: " + operacao);
        }
    }
}
