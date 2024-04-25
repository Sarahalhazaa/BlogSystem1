package com.example.blogsystem1.Repository;

import com.example.blogsystem1.Model.Blog;
import com.example.blogsystem1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findAllByUser(User user);

    Blog findBlogById(Integer id);

    Blog findBlogByTitle (String title);

}
