package com.sbs.jsp.board.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDto {
  private long id;
  private String title;
  private String body;

  public ArticleDto(Map<String, Object> articleMap) {
    this.id = (int) articleMap.get("id");
    this.title = (String) articleMap.get("title");
    this.body = (String) articleMap.get("body");
  }
}
