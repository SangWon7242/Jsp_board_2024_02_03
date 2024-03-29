package com.sbs.jsp.board;

import com.sbs.jsp.board.article.dto.ArticleDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Rq {
  private final HttpServletRequest req;
  private final HttpServletResponse resp;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;

    try {
      req.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=utf-8");
  }

  public int getIntParam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);

    if(value == null) {
      return  defaultValue;
    }

    try {
      return Integer.parseInt(value);
    }
    catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {
    String value = req.getParameter(paramName);

    if(value == null || value.trim().length() == 0) {
      return  defaultValue;
    }

    return value;
  }

  public void print(String str) {
    try {
      resp.getWriter().append(str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void println(String str) {
    print(str + "\n");
  }

  public void replace(String url, String msg) {
    if(msg != null && msg.trim().length() > 0) {
      println("""
              <script>
              alert("%s");
              </script>
              """.formatted(msg));
    }

    println("""
            <script>
            location.replace("%s");
            </script>
            """.formatted(url));
  }

  public void historyBack(String msg) {
    if(msg != null && msg.trim().length() > 0) {
      println("""
              <script>
              alert("%s");
              </script>
              """.formatted(msg));
    }

    println("""
            <script>
            history.back();
            </script>
            """);
  }

  public void setAttr(String name, Object value) {
    req.setAttribute(name, value);
  }

  public void view(String path) {
    // 서블릿에서 JSP에 작업을 토스
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");

    try {
      requestDispatcher.forward(req, resp);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getPath() {
    return req.getRequestURI();
  }

  public String getMethod() {
    return req.getMethod();
  }

  public String getActionPath() {
    String[] bits = req.getRequestURI().split("/");

    return "/%s/%s/%s".formatted(bits[1], bits[2], bits[3]);
  }

  public String getRouteMethod() {
    String method = getParam("_method", "");

    if(method.length() > 0) {
      return method.toUpperCase();
    }

    return req.getMethod();
  }

  public long getLongPathValueByIndex(int index, int defaultValue) {
    String value = getPathValueByIndex(index, null);

    if(value == null) {
      return defaultValue;
    }

    try {
      return Long.parseLong(value);
    }
    catch (NumberFormatException e) {
      return defaultValue;
    }

  }

  private String getPathValueByIndex(int index, String defaultValue) {
    String[] bits = req.getRequestURI().split("/");

    try {
      return bits[4 + index];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return defaultValue;
    }
  }

}
