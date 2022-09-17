package com.bahar.review.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ReviewDto {

    private String productId;
    private Double averageVote;
    private Long quantity;
    private Integer vote;
    private List<String> threeLastComments;

}
