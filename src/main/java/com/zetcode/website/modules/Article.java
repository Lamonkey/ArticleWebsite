package com.zetcode.website.modules;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Columns;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     private Integer id;
     private String title;
     @Column(columnDefinition="Text")
     private String abstraction;
     private String submiteDate;
     private String publishDate;
     private String author;
     private String isPublished;

   
    
    public Article() {
    }

    public Article(String title, String abstraction, String submiteDate, String publishDate, String author, String isPublished) {
        this.title = title;
        this.abstraction = abstraction;
        this.submiteDate = submiteDate;
        this.publishDate = publishDate;
        this.author = author;
        this.isPublished = isPublished;
    }
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstraction() {
        return this.abstraction;
    }

    public void setAbstraction(String abstraction) {
        this.abstraction = abstraction;
    }

    public String getSubmiteDate() {
        return this.submiteDate;
    }

    public void setSubmiteDate(String submiteDate) {
        this.submiteDate = submiteDate;
    }

    public String getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsPublished() {
        return this.isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }

    public Article title(String title) {
        this.title = title;
        return this;
    }

    public Article abstraction(String abstraction) {
        this.abstraction = abstraction;
        return this;
    }

    public Article submiteDate(String submiteDate) {
        this.submiteDate = submiteDate;
        return this;
    }

    public Article publishDate(String publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public Article author(String author) {
        this.author = author;
        return this;
    }

    public Article isPublished(String isPublished) {
        this.isPublished = isPublished;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Article)) {
            return false;
        }
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(abstraction, article.abstraction) && Objects.equals(submiteDate, article.submiteDate) && Objects.equals(publishDate, article.publishDate) && Objects.equals(author, article.author) && Objects.equals(isPublished, article.isPublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, abstraction, submiteDate, publishDate, author, isPublished);
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", abstraction='" + getAbstraction() + "'" +
            ", submiteDate='" + getSubmiteDate() + "'" +
            ", publishDate='" + getPublishDate() + "'" +
            ", author='" + getAuthor() + "'" +
            ", isPublished='" + getIsPublished() + "'" +
            "}";
    }

}