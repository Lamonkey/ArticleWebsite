package com.zetcode.website.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.zetcode.website.modules.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer>{
    Iterable<Article> getByTitle(String title);
    
    @Query("select a from Article a where a.title like %:content% or a.author like %:content% or a.submiteDate like %:content% or a.publishDate like %:content%")
    //"or a.submiteDate like %:content%")
    Iterable<Article> getByTitleLike(@Param("content") String content);         
    Iterable<Article> findAllByOrderByTitle();   
    Iterable<Article> findAllByOrderBySubmiteDate();   
    Iterable<Article> findAllByOrderByPublishDate();  
    Iterable<Article> findAllByOrderByAuthor();   
    Iterable<Article> findAllByOrderByIsPublished(); 
    Iterable<Article> findAllById(Integer id); 
    Iterable<Article> findByIdNot(Integer id);  
    

   
    

 


    
}