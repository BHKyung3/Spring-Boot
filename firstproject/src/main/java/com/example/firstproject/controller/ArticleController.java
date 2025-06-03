package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //컨트롤러 선언
@Slf4j //@Log4j과 동잃한 내용(사용 불가)
public class ArticleController {

    @GetMapping("/articles/new") //URL 요청 접수
    public String newArticleForm() { //메서드 생성 및 반환값 작성
        log.info("New article form");
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        log.info("New article created");
        log.info("articleForm : {}", articleForm);
        return null;
    }
}
