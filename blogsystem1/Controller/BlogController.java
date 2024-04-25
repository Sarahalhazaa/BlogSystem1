package com.example.blogsystem1.Controller;

import com.example.blogsystem1.API.ApiResponse;
import com.example.blogsystem1.Model.Blog;
import com.example.blogsystem1.Model.User;
import com.example.blogsystem1.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    Logger logger = LoggerFactory.getLogger(BlogController.class);
    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAllBlog(){
        logger.info(" get all Blog");
        return ResponseEntity.status(200).body(blogService.getAllBlog());
    }

    @PostMapping("/add")
    public ResponseEntity  addBlog(@AuthenticationPrincipal User user , @RequestBody @Valid Blog blog){
        logger.info("add Blog");
        blogService.addBlog(user.getId(),blog);
        return ResponseEntity.ok().body(" Blog added successfully");
    }

    @PutMapping("/Update/{BlogId}")
    public ResponseEntity UpdateBlog(@AuthenticationPrincipal User user , @PathVariable Integer BlogId  , @RequestBody @Valid Blog blog){
        logger.info("Update Blog");
        blogService.updateBlog(user.getId(),BlogId,blog);
        return ResponseEntity.ok().body(new ApiResponse("Blog Update"));

    }

    @DeleteMapping("/delete/{BlogId}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal User user , @PathVariable Integer BlogId ){
        logger.info("delete Blog");
        blogService.deleteBlog(user.getId(),BlogId);
        return ResponseEntity.ok().body(new ApiResponse("Blog Deleted"));

    }

    @GetMapping("/getMy")
    public ResponseEntity getMyBlog(@AuthenticationPrincipal User user){
        logger.info("get My Blog");
        return ResponseEntity.status(200).body(blogService.getMyBlogs(user.getId()));
    }

   @GetMapping("/GetBlogById/{BlogId}")
    public ResponseEntity GetBlogById(@PathVariable Integer BlogId ){
       logger.info("Get Blog By Id");
            blogService.GetBlogById(BlogId);
        return ResponseEntity.ok().body(new ApiResponse("get blog"));

    }


    @GetMapping("/GetBlogByTitle/{BlogTitle}")
    public ResponseEntity GetBlogByTitle( @PathVariable String BlogTitle){
        logger.info("Get Blog By Title");
        blogService.GetBlogByTitle(BlogTitle);
        return ResponseEntity.ok().body(new ApiResponse(" get Blog"));

    }


}