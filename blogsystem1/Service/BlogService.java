package com.example.blogsystem1.Service;

import com.example.blogsystem1.API.ApiException;
import com.example.blogsystem1.Model.Blog;
import com.example.blogsystem1.Model.User;
import com.example.blogsystem1.Repository.AuthRepository;
import com.example.blogsystem1.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {


    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }


    public void addBlog(Integer userId, Blog blog) {
        User user1 = authRepository.findUserById(userId);

        blog.setUser(user1);
        blogRepository.save(blog);
    }

    public void updateBlog(Integer userId, Integer blogId, Blog blog) {
        Blog blog1 = blogRepository.findBlogById(blogId);
        if (blog1 == null) {
            throw new ApiException("not found");
        }

        if (blog1.getUser().getId() != userId) {
            throw new ApiException("not equal user id");
        }

        if (blog1.getTitle().equals(blog.getTitle())) {
            throw new ApiException("title already exist");
        }

        blog1.setTitle(blog.getTitle());
        blogRepository.save(blog1);

    }

    public void deleteBlog(Integer userId, Integer blogId) {
        Blog blog1 = blogRepository.findBlogById(blogId);
        if (blog1 == null) {
            throw new ApiException("not found");
        }
        blogRepository.delete(blog1);
    }


    public List<Blog> getMyBlogs(Integer id) {
        User user1 = authRepository.findUserById(id);


        return blogRepository.findAllByUser(user1);

    }

    public Blog GetBlogById(Integer blogId) {
        Blog blog1 = blogRepository.findBlogById(blogId);
        if (blog1 == null) {
            throw new ApiException("not found");
        }
        return blog1;
    }

    public Blog GetBlogByTitle(String blogTitle) {
        Blog blog1 = blogRepository.findBlogByTitle( blogTitle );
        if (blog1 == null) {
            throw new ApiException("not found");
        }
        return blog1;
    }

}
