package com.example.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

// Creamos la anotación de tipo calificador
// @SimpleHello para poder calificar
// la implementación calificada con este calificador
// y poder inyectarla como servicio bajo este calificador

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, 
			ElementType.FIELD, ElementType.PARAMETER })
public @interface SimpleHello {

}
