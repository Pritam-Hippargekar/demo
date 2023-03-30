package com.elastic.data.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ResponseDTO<Object>> handleBindException
            (BindException bindException){

        Map<String,String> errorMap=new HashMap<>();

        bindException.getAllErrors().stream()
                .forEach(objectError -> {
                    errorMap.put(((FieldError)objectError).getField()
                            ,objectError.getDefaultMessage());
                });

        return new ResponseEntity(
                ResponseDTO.builder().
                        response(errorMap.toString())
                        .message("Object validation failed")
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
//src/main/resources/error_messages.properties
//@Configuration
//public class BeanConfiguration {
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource
//                = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:error_messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean
//    public LocalValidatorFactoryBean validator() {
//        LocalValidatorFactoryBean bean
//                = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }
//}