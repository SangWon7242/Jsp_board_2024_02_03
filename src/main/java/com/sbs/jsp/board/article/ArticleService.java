package com.sbs.jsp.board.article;

import com.sbs.jsp.board.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = new ArticleRepository();
  }

  public long write(String title, String body) {
    return articleRepository.write(title, body);
  }

  public List<ArticleDto> findAll() {
    return articleRepository.findAll();
  }

  public ArticleDto findById(long id) {
    return articleRepository.findById(id);
  }

  public void delete(long id) {
    articleRepository.delete(id);
  }
}
