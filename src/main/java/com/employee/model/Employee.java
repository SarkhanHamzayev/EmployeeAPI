package com.employee.model;

import org.springframework.web.multipart.MultipartFile;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private int  age;
    private String jobTitle;
    private String city;
    private String  experience;
    private MultipartFile image;
    private String imagePath;


    public Employee() {
    }

    public Employee(int id, String name, String surname, int age, String jobTitle, String homeCity, String experience, MultipartFile image, String imagePath) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.jobTitle = jobTitle;
        this.city = homeCity;
        this.experience = experience;
        this.image = image;
        this.imagePath = imagePath;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String homeCity) {
        this.city = homeCity;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", jobTitle='" + jobTitle + '\'' +
                ", homeCity='" + city + '\'' +
                ", experience='" + experience + '\'' +
                ", image=" + image +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
