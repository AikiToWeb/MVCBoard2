package dao;

import static db.JdbcUtil.*;   
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class NoticeUpProcDao {
   private static NoticeUpProcDao noticeUpProcDao;
   private Connection conn;

   private NoticeUpProcDao() {}
   public static NoticeUpProcDao getInstance() {
   // 싱글톤 방식으로 인스턴스 낭비를 줄임
      if (noticeUpProcDao == null)   noticeUpProcDao = new NoticeUpProcDao();
      return noticeUpProcDao;
   }
   
   public void setConnection(Connection conn) {
      this.conn = conn;
   }
   
   
   public int noticeUpdate(NoticeList notice) {
      Statement stmt = null;
      int result = 0;
      
      try {
         stmt = conn.createStatement();
         String sql = "update t_notice_list set " +
            " nl_kind = '"       + notice.getNl_kind()    + "', " + 
            " nl_title = '"    + notice.getNl_title()    + "', " + 
            " nl_content = '"    + notice.getNl_content() + "' " +
            " where nl_idx = "   + notice.getNl_idx();
         result = stmt.executeUpdate(sql);
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(stmt);
      }
      
      return result;
   }
}