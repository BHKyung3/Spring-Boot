package com.example.firstproject.entity;

// DB 반영 용도로 사용, 테이블 작성

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 엔티티 선언, JPA에서 자공하는 어노테이션(테이블로 생성 // 무조건 기본키가 적용되어 있어야 함(기본키 없으면 클래스 오류 발생))
// @Table(name = article) //테이블 이름(설정하지 않을 경우 클래스 이름 Article이 기본적으로 테이블 이름이 됨)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {
    
    @Id // 기본키 설정(필수)
    @GeneratedValue(strategy = GenerationType.AUTO) // 대푯값 자동 생성, 자동생성 기능 추가(숫자가 자동 증가)ㄴ
    private Long id; //기본키 적용

    @Column() // 타이틀 필드 선언, DB 테이블의 테이블 열과 연결됨, nullable = false : not null
    private String title;

    @Column
    private String content;
}
