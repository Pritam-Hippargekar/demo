package com.elastic.data.validation;
import com.elastic.data.constants.FILE_TYPE;

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
    FILE_TYPE[] allowedFileTypes();
}
