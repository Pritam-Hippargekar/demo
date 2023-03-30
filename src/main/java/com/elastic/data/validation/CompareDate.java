package com.elastic.data.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CompareDateValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface CompareDate {
    String message() default "{com.elastic.data.validation.CompareDate.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String before();
    String after();
}



//@Unfinished(
//        value="Class scope",
//        priority=Unfinished.Priority.LOW
//)
//public class UnfinishedDemo {
//    @Unfinished("Constructor scope")
//    public UnfinishedDemo() { }
//    @Unfinished(owner="Jason", value="Method scope")
//    public void foo() { }
//}

//// package-info.java
//@Unfinished("Package scope")
//package com.servlets;


//    Annotation Parameters
//    To provide your @Unfinished annotation type with its description, owner, and priority you'll need to add parameters to the annotation declaration. Annotation parameters follow certain strict rules:
//        Parameters may only be typed as a primitive, String, Class, enum, annotation, or an array of any of these.
//        Parameter values may never be null!
//        Each parameter may declare a default value.
//        A single parameter named "value" can be set in a shorthand style.
//        Parameters are written as simple methods (no arguments, no throws clauses, etc).


//@Target
//Now where do you want your annotation to be placed? You have eight options listed in the ElementType enumeration:
//        ElementType.TYPE (class, interface, enum)
//        ElementType.FIELD (instance variable)
//        ElementType.METHOD
//        ElementType.PARAMETER
//        ElementType.CONSTRUCTOR
//        ElementType.LOCAL_VARIABLE
//        ElementType.ANNOTATION_TYPE (on another annotation)
//        ElementType.PACKAGE (remember package-info.java)
