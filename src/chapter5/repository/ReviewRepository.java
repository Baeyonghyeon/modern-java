package chapter5.repository;

import chapter5.object.ov.Review;

import java.util.List;

public interface ReviewRepository {

    void registerReview(Review review);

    List<Review> getAllReviews();

    List<Review> getReviewsByUserName();

    List<Review> getReviewsByShopName();
}
