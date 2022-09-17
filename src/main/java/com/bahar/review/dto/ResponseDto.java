package com.bahar.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private String status;
    private Integer code;
    private List<String> messages;
    private Object data; //??

}
