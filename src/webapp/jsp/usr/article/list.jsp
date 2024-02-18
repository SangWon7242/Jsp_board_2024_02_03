<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sbs.jsp.board.article.dto.ArticleDto" %>

<%
List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

<!-- 테일윈드 불러오기 -->
<script src="https://cdn.tailwindcss.com"></script>

<!-- 보통 구혁은 섹션으로 나눈다. -->
<section class="article-list-wrap">
  <!-- container(max-width) : 너비가 너무 넓게 퍼니느 것을 막는다. + 반응형 잃지 않는다. -->
  <div class="container mx-auto">
    <h1 class="font-bold text-lg">게시물 리스트</h1>

    <ul class="mt-5">
      <% for(ArticleDto article : articles ) { %>
        <!-- li가 flex 컨테이너가 된다. -->
        <!-- li 자식들은 flex-item이 된다. -->
        <li class="flex">
          <a class="w-[40px] text-center hover:underline hover:text-[red]" href="/usr/article/detail/free/<%=article.getId()%>">
            <%=article.getId()%>
          </a>
          <!-- flex-grow : 성장성, 1 -->
          <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/free/<%=article.getId()%>">
            <%=article.getTitle()%>
          </a>
          <a class="w-[100px] text-center hover:underline hover:text-[red]" href="/usr/article/delete/free/<%=article.getId()%>">
            삭제
          </a>
        </li>
      <% } %>
    </ul>
  </div>
</section>
