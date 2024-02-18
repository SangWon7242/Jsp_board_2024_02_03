<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.jsp.board.article.dto.ArticleDto" %>

<%
ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<%@ include file="../common/head.jspf" %>

<script>
  function ArticleSave__submitForm(form) {
    form.title.value = form.title.value.trim();

    if(form.title.value.length == 0) {
      alert('제목을 입력해주세요.');
      form.title.focus();
      return;
    }

    form.body.value = form.body.value.trim();

    if(form.body.value.length == 0) {
      alert('내용을 입력해주세요.');
      form.body.focus();
      return;
    }

    form.submit();
  }
</script>

<section class="article-modify-wrap">
  <div class="container px-3 mx-auto">
    <h1 class="font-bold text-lg">게시물 수정</h1>
    <form method="POST" onsubmit="ArticleSave__submitForm(this); return false">
      <div>
        <span>제목</span>
        <div>
          <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." value="<%=article.getTitle()%>">
        </div>
      </div>

      <div>
        <span>내용</span>
        <div>
          <input name="body" type="text" maxlength="300" placeholder="내용을 입력해주세요." value="<%=article.getBody()%>">
        </div>
      </div>

      <div>
        <div style="display:flex; gap: 0 5px; margin-top: 5px">
          <button type="submit">작성</button>
          <a href="/usr/article/list">취소</a>
        </div>
    </form>
  </div>
</section>

<%@ include file="../common/foot.jspf" %>