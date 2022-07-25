package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/raiz/{op}")
public class Raiz {

    @GET
    public double calculaRaiz(@PathParam String op) {
        try {
          return Math.sqrt(Float.parseFloat(op));
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetro inválido: " + op);
        }
    }
}
