import com.sbs.jsp.board.util.MysqlUtil;
import com.sbs.jsp.board.util.SecSql;

import java.util.List;
import java.util.Map;

public class DBTest {
  public static void main(String[] args) {
    MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jspboard");

    MysqlUtil.setDevMode(true);

    // 게시물 리스트 출력
    List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(new SecSql().append("SELECT * FROM article"));
    System.out.println("articleListMap : " + articleListMap);

    // 1번 게시물 정보 출력
    Map<String, Object> articleMap = MysqlUtil.selectRow(new SecSql().append("SELECT * FROM article WHERE id = ?", 1));
    System.out.println("articleMap : " + articleMap);

    // 게시물 번호로 접근하여 id값 출력
    int id = MysqlUtil.selectRowIntValue(new SecSql().append("SELECT id FROM article WHERE id = ?", 1));
    System.out.println("articleId : " + id);

    // 게시물 유무 확인
    boolean articleIsExists = MysqlUtil.selectRowBooleanValue(new SecSql().append("SELECT id FROM article WHERE id = ?", 4));
    System.out.println("articleIsExists : " + articleIsExists);

    // 게시물 저장
    String newTitle = "새 제목";
    String newBody = "새 내용";

    SecSql sql = new SecSql();
    sql.append("INSERT INTO article");
    sql.append("SET regDate = NOW()");
    sql.append(", updateDate = NOW()");
    sql.append(", title = ?", newTitle);
    sql.append(", `body` = ?", newBody);

    MysqlUtil.insert(sql);

    MysqlUtil.closeConnection();
  }
}
