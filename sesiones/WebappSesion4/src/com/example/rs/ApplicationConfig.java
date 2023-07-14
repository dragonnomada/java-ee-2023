package com.example.rs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// Esta clase está anotada para activar JAX-RS
// y habilitar todas las clases anotas con @Path
// La clase necesita derivar de Application
@ApplicationPath("/api")
public class ApplicationConfig extends Application {

}
