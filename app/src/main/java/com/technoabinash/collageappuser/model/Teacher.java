package com.technoabinash.collageappuser.model;

public class Teacher {
    private String name,email,post,faculty,image,key;

    public Teacher() {
    }

    public Teacher(String name, String email, String post, String faculty, String image, String key) {
        this.name = name;
        this.email = email;
        this.post = post;
        this.faculty = faculty;
        this.image = image;
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
