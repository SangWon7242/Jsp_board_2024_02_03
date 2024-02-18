<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.jsp.board.article.dto.ArticleDto" %>

<%
ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<%@ include file="../common/head.jspf" %>

<section class="article-detail-wrap">
  <div class="container px-3 mx-auto">
    <h1 class="font-bold text-lg">게시물 상세보기</h1>
    <div>
      <% if(article != null) { %>
      <div>
        ID : <%=article.getId()%>
      </div>
      <div>
        TITLE : <%=article.getTitle()%>
      </div>
      <div>
        BODY : <%=article.getBody()%>
      </div>
      <% } %>
    </div>
  </div>
</section>

<%@ include file="../common/foot.jspf" %>