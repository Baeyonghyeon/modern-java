package chapter5.repository.impl;

import chapter5.object.ov.Review;
import chapter5.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository {

    List<Review> reviews = new ArrayList<>();

    @Override
    public void registerReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }


    // todo : 작성자 리뷰 검색
    @Override
    public List<Review> getReviewsByUserName() {
        return null;
    }

    // todo : 가게명으로 리뷰 검색
    @Override
    public List<Review> getReviewsByShopName() {
        return null;
    }
}
