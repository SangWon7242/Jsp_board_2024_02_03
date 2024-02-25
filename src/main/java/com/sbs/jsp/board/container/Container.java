package com.sbs.jsp.board.container;

import com.sbs.jsp.board.article.ArticleController;
import com.sbs.jsp.board.article.ArticleRepository;
import com.sbs.jsp.board.article.ArticleService;
import com.sbs.jsp.board.member.MemberController;

public class Container {
  public static ArticleRepository articleRepository;

  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;

  public static void init() {
    articleRepository = new ArticleRepository();

    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
