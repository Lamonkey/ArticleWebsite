package com.zetcode.website.repository;

import java.util.ArrayList;

import com.zetcode.website.modules.Article;

public interface CustomizedArticleRepository<T, S> {
    public ArrayList<Article> findByTitle(String title);
    
} 
