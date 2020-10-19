package com.zetcode.website.controller;

import java.util.Optional;

import com.zetcode.website.modules.Article;
import com.zetcode.website.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("/publish")
	public String articleForm(Model model) {
		model.addAttribute("article", new Article());
		return "addArticle";
	}

	@GetMapping("/")
	public String index() {
		return "mainPage";
	}

	@GetMapping("/display")
	public String displayArticle(Model model) {
		model.addAttribute("article", articleRepository.findAll());
		return "displayArticle";
	}

	@PostMapping("/publish")
	public String addNewArticle(@ModelAttribute Article article, Model model) {
		model.addAttribute("article", article);
		articleRepository.save(article);
		return "result";

	}
	@PostMapping("/edit/{id}")
	public String editArticle(@PathVariable("id") String id, @ModelAttribute Article article, Model model) {
		article.setId(Integer.parseInt(id));
		model.addAttribute("article", article);
		articleRepository.save(article);
		return "result";

	}

	@GetMapping(path = "/all")
	public String getAllArticles(Model model) {

		model.addAttribute("articles", articleRepository.findAll());
		return "allArticles";
	}

	@GetMapping(path = "/all/title")
	public @ResponseBody Iterable<Article> getArticleByName() {
		return articleRepository.getByTitle("liu's life");

	}

	@PostMapping(path = "/all/search")
	public String getArticleHave(@RequestParam(name = "content", required = true) String content, Model model) {
		model.addAttribute("articles", articleRepository.getByTitleLike(content));
		return "allArticles";
	}

	@GetMapping(path = "/all/sort/{component}")
	public String srotArticle(@PathVariable("component") String component, Model model) {
		Iterable<Article> result = null;
		if (component.equals("title"))
			result = articleRepository.findAllByOrderByTitle();
		else if (component.equals("submiteDate"))
			result = articleRepository.findAllByOrderBySubmiteDate();
		else if (component.equals("publishDate"))
			result = articleRepository.findAllByOrderByPublishDate();
		else if (component.equals("author"))
			result = articleRepository.findAllByOrderByAuthor();
		else if (component.equals("isPublished"))
			result = articleRepository.findAllByOrderByIsPublished();
		model.addAttribute("articles", result);
		return "allArticles";
	}

	@GetMapping(path = "/edit/{id}")
	public String editArticle(@PathVariable("id") String id, Model model) {
		Article article = articleRepository.findById(Integer.parseInt(id)).get();
		model.addAttribute("article", new Article());
		model.addAttribute("editingArticle", article);
		return "editArticle";
	}
	@GetMapping(path="/delete/{id}")
	public String leteArticle(@PathVariable("id") String id, Model model){
		articleRepository.deleteById(Integer.parseInt(id));
		model.addAttribute("articles",articleRepository.findAll());
		return "allArticles";
	}
	@GetMapping("/display/{id}")
	public String displayArticleById(@PathVariable("id") String id, Model model){
		
		model.addAttribute("article", articleRepository.findById(Integer.parseInt(id)).get());
	
		//model.addAttribute("otherArticles", articleRepository.findByIdNot(Integer.parseInt(id)));
		return "displayArticle";
	}
	@GetMapping("/test")
	public String test(){
		return "displayArticle";
	}
	
}
