package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String content;
    private LocalDateTime timeCreateBlog;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public Blog() {
    }

    public Blog(int id, String name, String image, String content, LocalDateTime timeCreateBlog) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.content = content;
        this.timeCreateBlog = timeCreateBlog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeCreateBlog() {
        return timeCreateBlog;
    }

    public void setTimeCreateBlog(LocalDateTime timeCreateBlog) {
        this.timeCreateBlog = timeCreateBlog;
    }
}
