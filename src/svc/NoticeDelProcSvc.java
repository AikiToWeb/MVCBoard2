package svc;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 멤버들을 자유롭게 사용하겠다는 의미
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class NoticeDelProcSvc {
	public int noticeDelete(NoticeList notice) {
		int result = 0;
		Connection conn = getConnection();
		NoticeDelProcDao noticeDelProcDao = NoticeDelProcDao.getInstance();
		noticeDelProcDao.setConnection(conn);
		result = noticeDelProcDao.noticeDelete(notice);
		
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		return result;
	}
}
