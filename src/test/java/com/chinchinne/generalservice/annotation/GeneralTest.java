package com.chinchinne.generalservice.annotation;


import com.chinchinne.generalservice.GeneralServiceApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
@TestPropertySource(locations="classpath:/application.yml")
@ContextConfiguration( classes = GeneralServiceApplication.class)
//@Transactional
public @interface GeneralTest
{

}
