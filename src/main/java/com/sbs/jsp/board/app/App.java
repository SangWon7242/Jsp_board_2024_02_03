package com.sbs.jsp.board.app;

import com.sbs.jsp.board.container.Container;
import com.sbs.jsp.board.util.MysqlUtil;

public class App {

  private static boolean isDevMode() {
    // 이 부분을 false로 바꾸면 production 모드 이다.
    // true는 개발자 모드이다.(개발할 때 좋다.)
    return true;
  }
  public static void init() {
    // DB 세팅
    MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jspboard");
    MysqlUtil.setDevMode(isDevMode());

    // 공용 객체 세팅
    Container.init();
  }
}
