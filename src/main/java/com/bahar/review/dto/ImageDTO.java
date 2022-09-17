package com.bahar.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {

    @NotBlank(message = "code may not be empty.")
    @Column(unique = true)
    private String name;//todo
    @Lob
    byte[] content;

    @NotBlank(message = "description may not be empty.")
    private String description;

    @NotBlank(message = "path may not be empty.")
    @Column(unique = true)//todo
    private String path;

    @NotBlank(message = "url may not be empty.")
    @Column(unique = true)//todo
    private String url;
}
