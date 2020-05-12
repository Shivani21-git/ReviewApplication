package com.example.myprojects.review_application.controller;

import com.example.myprojects.review_application.model.Product;
import com.example.myprojects.review_application.model.Review;
import com.example.myprojects.review_application.model.User;
import com.example.myprojects.review_application.repository.ProductRepo;
import com.example.myprojects.review_application.repository.ReviewRepo;
import com.example.myprojects.review_application.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
public class ReviewAppController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @GetMapping("/reviewapplication")
    public String indexpagemethod(Model model)
    {
        model.addAttribute("user_details",new User());
        return "index";

    }

    @PostMapping("/continue")
    public String continuemethod(@ModelAttribute("user_details") User user_details, Model model) throws ParseException {
        userRepo.save(user_details);
        model.addAttribute("username",user_details.getName());
        List<Product> list = new ArrayList<>();
        Iterator iterator = productRepo.findAll().iterator();
        model.addAttribute("list",getListFromIterator(iterator));
        return "mainpage";
    }
    // Function to get the List
    public static <Product> List<Product> getListFromIterator(Iterator<Product> iterator)
    {

        // Create an empty list
        List<Product> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEachRemaining(list::add);

        // Return the List
        return list;
    }

    @GetMapping("/writereview")
    public String writereview(Model model,@RequestParam(value="id") int id) {
        //model.addAttribute("productob",productRepo.findById(id));
        Product obj = new Product();
        obj.setId(id);
        model.addAttribute("review", new Review(obj));
      //  model.addAttribute("productId",id);
        //model.addAttribute("review",new Review());
        model.addAttribute("productId", id);
        return "writereviewpage";

    }

    @PostMapping("/postreview")
    public String reviewdesc(@ModelAttribute("review") Review review)
    {
        reviewRepo.save(review);
        return "reviewsavedsuccessful";
    }

    @GetMapping("/readreview")
    public String readReview(Model model,@RequestParam(value="id") int id)
    {
        List<Review> reviews = productRepo.findById(id).get().getReviews();
        model.addAttribute("reviews",reviews);
        return "readreviewpage";
    }

}
