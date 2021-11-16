package dao;

import static db.JdbcUtil.*;   
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class NoticeDelProcDao {
	private static NoticeDelProcDao noticeDelProcDao;
	   private Connection conn;

	   private NoticeDelProcDao() {}
	   public static NoticeDelProcDao getInstance() {
	   // 싱글톤 방식으로 인스턴스 낭비를 줄임
	      if (noticeDelProcDao == null)   noticeDelProcDao = new NoticeDelProcDao();
	      return noticeDelProcDao;
	   }
	   
	   public void setConnection(Connection conn) {
	      this.conn = conn;
	   }
	   
	   
	   public int noticeDelete(NoticeList notice) {
	      Statement stmt = null;
	      int result = 0;
	      
	      try {
	         stmt = conn.createStatement();
	         String sql = "delete from t_notice_list set " +
	                 " where nl_idx = " + notice.getNl_idx(); 
	         result = stmt.executeUpdate(sql);
	         
	      } catch(Exception e) {
	    	  System.out.println("NoticeDelProcDao 클래스 noticeDelete메소드 오류 발생");
	         e.printStackTrace();
	      } finally {
	         close(stmt);
	      }
	      
	      return result;
	   }
}
