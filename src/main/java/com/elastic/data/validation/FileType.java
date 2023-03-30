package com.elastic.data.validation;
import com.elastic.data.constants.FILE_TYPE;

//import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.ElementType.TYPE;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
//https://www.springjavatutorial.com/2022/10/spring-rest-api-validate-file-type-using-annotation.html
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileTypeValidator.class)
@Documented
public @interface FileType {
    Class<? extends Payload> [] payload() default{};
    Class<?>[] groups() default {};
    String message() default "Invalid file type.";
//  String message() default "{com.tericcabrel.hotel.constraints.BirthDate.message}";
    FILE_TYPE[] allowedFileTypes();
}
