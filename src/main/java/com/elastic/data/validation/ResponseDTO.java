package com.elastic.data.validation;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {
    private String message;
    private T response;
}