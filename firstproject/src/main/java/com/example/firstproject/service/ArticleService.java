package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 주입
@Slf4j
public class ArticleService {

    private final ArticleRepository articleRepository; // articleRepository 선언

    // 전체 조회
    public List<Article> index() {
        return articleRepository.findAll();
    }

    // 단건 조회
    public Article show(Long id) {
        return articleRepository.findById(id).get();
    }

    // create - insert sqp 실행
    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        if(article.getId() != null) { // 아이디 값을 입력하면
            return null; // null 값을 띄울것이다
        }

        return articleRepository.save(article); // articleRepository 통해 DB에 저장
    }

    // update - update sql 실행
    public Article update(Long id, ArticleForm dto) {
        // 1. DTO -> entity 변환
        Article article = dto.toEntity(); // 모든 필드가 포함된 새로은 객체 생성
        // 2. 타닛 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if (target == null || id != article.getId()) { // 잘못된 요청인지 판별
            return null;
        }
        // 4. update 및 정상 응답하기
        target.patch(article); // patch 사용 시 수정하지 않은 값을 유지하기 위해
        return articleRepository.save(target);
    }

    // delete
    public Article delete(Long id) {
        // 1. 대상 찾기 -> DB에 삭제할 대상 엔티티가 있는지 조회하고 없으면 null 값 반환, 반환받은 값은 target이라는 변수에 저장
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null) {
            return null;
        }
        // 3. 대상 삭제하기
        articleRepository.delete(target);
        return target;
    }

}
