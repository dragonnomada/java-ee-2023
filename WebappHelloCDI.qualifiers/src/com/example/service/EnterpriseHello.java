package com.example.service;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention( RetentionPolicy.RUNTIME )
@Documented
@Qualifier
public @interface EnterpriseHello {

}
