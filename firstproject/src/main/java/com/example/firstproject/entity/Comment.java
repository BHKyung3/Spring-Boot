package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 클래스 필드를 바탕으로 DB에 테이블 생성 // 반드시 기본키 필요
@Getter
@ToString
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 아예 없는 기본 생성자 자동 생성
public class Comment {

    @Id // 기본키, 프라이버리 키 자동 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 번호 자동 증가
    private Long id; // 대표키
    
    @ManyToOne // Comment 엔티티와 Article 엔티티를 다대일 관계로 설정 // JPA에서 외래키 자동 생성(기본 규칙으로 article_id 생성)
    @JoinColumn(name="article_id") // 없어도 됨 > 자동 생성된 외래키 이름 변경하는 용도
    private Article article; // 해당 댓글의 부모 게시글, 외래키 설정해줌
    private String nickname; // 댓글을 단 사람
    private String body; // 댓글 본문
}
