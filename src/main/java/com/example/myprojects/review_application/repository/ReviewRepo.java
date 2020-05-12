package com.example.myprojects.review_application.repository;

import com.example.myprojects.review_application.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer> {

}
