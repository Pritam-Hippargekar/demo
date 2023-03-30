package com.elastic.data.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD
        ,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileSizeValidator.class)
@Documented
public @interface FileSize {

    Class<? extends Payload> [] payload() default{};
    Class<?>[] groups() default {};
    long maxSizeInMB() default 512;

    String message() default "Max file size exceed.";
}
