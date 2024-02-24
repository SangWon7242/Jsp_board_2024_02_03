<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf" %>

<!-- 보통 구혁은 섹션으로 나눈다. -->
<section class="article-list-wrap">
  <!-- container(max-width) : 너비가 너무 넓게 퍼니느 것을 막는다. + 반응형 잃지 않는다. -->
  <div class="container px-3 mx-auto">
    <h1 class="font-bold text-lg">게시물 리스트</h1>

    <ul class="mt-5">
      <c:forEach items="${articles}" var="article">
        <!-- li가 flex 컨테이너가 된다. -->
        <!-- li 자식들은 flex-item이 된다. -->
        <li class="flex">
          <a class="w-[40px] text-center hover:underline hover:text-[red]" href="/usr/article/detail/free/${article.id}">
            ${article.id}
          </a>
          <!-- flex-grow : 성장성, 1 -->
          <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/free/${article.id}">
            ${article.title}
          </a>
          <div class="btn-group flex gap-x-2">
            <a onClick="if(!confirm('정말 삭제하시겠습니까?')) return false;" class="text-center hover:underline hover:text-[red]" href="/usr/article/delete/free/${article.id}?_method=DELETE">
              삭제
            </a>
            <a class="text-center hover:underline hover:text-[red]" href="/usr/article/modify/free/${article.id}">
              수정
            </a>
          </div>
        </li>
      </c:forEach>
    </ul>
  </div>
</section>

<%@ include file="../common/foot.jspf" %>