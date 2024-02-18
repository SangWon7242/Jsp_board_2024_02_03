<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.jsp.board.article.dto.ArticleDto" %>

<%@ include file="../common/head.jspf" %>

<section class="article-detail-wrap">
  <div class="container px-3 mx-auto">
    <h1 class="font-bold text-lg">게시물 상세보기</h1>
    <div>
      <div>
        ID : ${article.id}
      </div>
      <div>
        TITLE : ${article.title}
      </div>
      <div>
        BODY : ${article.body}
      </div>
    </div>
  </div>
</section>

<%@ include file="../common/foot.jspf" %>