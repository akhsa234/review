package com.bahar.review.service;

import com.bahar.review.dto.ReviewDto;
import com.bahar.review.exception.NotFoundException;
import com.bahar.review.model.Review;
import com.bahar.review.repo.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    public ReviewDto getReviewsInfo(String productId) throws NotFoundException {

        List<Review> allReviewByProductId = reviewRepository.findByProductId(productId);


        if (allReviewByProductId.isEmpty()) {
            throw new NotFoundException("No reviews were found for this specific productId = " + productId);
        }
        ReviewDto reviewDTO = handleAllReviews(allReviewByProductId, productId);
        return reviewDTO;
    }

    private ReviewDto handleAllReviews(List<Review> allReviewByProductId, String productId) {

        if (!StringUtils.hasText(productId)) {
            throw new IllegalArgumentException(" Product ID is not accepted or defined ");
        }

        Double averageVote = allReviewByProductId.stream()
                .filter(allReviews -> productId
                          .equals(allReviews.getProductId()))
                .mapToDouble(Review::getVote)
                .average()
                .orElse(Double.valueOf(0));

        averageVote = getRound(averageVote, 3);

        long calcCount = allReviewByProductId.stream()
                .filter(reviews -> productId
                        .equals(reviews.getProductId()))
                .count();




        List<String> valueList = getThreeLastComment(allReviewByProductId, productId);


        ReviewDto reviewDTO = ReviewDto.builder()
                .productId(productId)
                .quantity(calcCount)
                .averageVote(averageVote)
                .threeLastComments(valueList)
                .build();

        return reviewDTO;


    }

    private Double getRound(Double averageVote, int i) {
        if (i < 0)
            throw new IllegalArgumentException();

        BigDecimal bigDecimal = new BigDecimal(averageVote);
        bigDecimal = bigDecimal.setScale(i, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();

    }

    private List<String> getThreeLastComment(List<Review> allReviewByProductId, String productId){

        long count = allReviewByProductId.stream().count();

        //check based on specific product id to filter all review
        List<Review> allReviews = allReviewByProductId
                .stream()
                .filter(reviews -> productId
                        .equals(reviews.getProductId()))
                .collect(Collectors.toList());

        System.out.println(allReviews);

        //check based on specific product id to filter all comments
        List<String> comments= allReviews
                .stream()
                 .map(comment ->comment.getComment())
                .collect(Collectors.toList());

        System.out.println(comments);

        //check based on specific product id to filter 3 last comment
        List<String> lastThreeComment = comments
                .stream()
                .skip(comments.size()-3)
                .collect(Collectors.toList());

        System.out.println(lastThreeComment);

        return lastThreeComment;

    }





}
