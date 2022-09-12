package chapter5.repository.impl;

import chapter5.object.ov.Review;
import chapter5.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Review> getReviewsByUserName(String userName) {
        return reviews.stream()
                .filter(r -> r.getUsername().equals(userName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> getReviewsByShopName(String shopName) {
        return reviews.stream()
                .filter(r -> r.getShopName().equals(shopName))
                .collect(Collectors.toList());
    }
}
