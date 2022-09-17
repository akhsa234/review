package com.bahar.review.util;

import com.bahar.review.dto.ResponseDto;


import java.util.Arrays;

public class HttpStatusUtil {

    public static ResponseDto buildResponseOKHttpStatus(Object data) {
        return ResponseDto.builder().status("ok").code(200).data(data).build();
    }

    public static ResponseDto buildResponseOKHttpStatus(String message) {
        return ResponseDto.builder().status("ok").code(200).messages(Arrays.asList(message)).build();
    }

    public static ResponseDto buildResponseErrorHttpStatus(Throwable t) {
        return ResponseDto.builder().status("error").code(400).messages(Arrays.asList(t.getCause().getMessage()))
                .build();
    }

    public static ResponseDto buildResponseErrorHttpStatus(Object body) {
        return ResponseDto.builder().status("error").code(400).data(body).build();
    }

    public static ResponseDto buildResponseErrorHttpStatus(String message, Object body) {
        return ResponseDto.builder().status("error").code(400).messages(Arrays.asList(message)).data(body).build();
    }

    public static ResponseDto buildResponseErrorHttpStatus(String message) {
        return ResponseDto.builder().status("error").code(400).messages(Arrays.asList(message)).build();
    }
}
