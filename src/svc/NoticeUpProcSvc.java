package svc;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 멤버들을 자유롭게 사용하겠다는 의미
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class NoticeUpProcSvc {
	public int noticeUpdate(NoticeList notice) {
		int result = 0;
		Connection conn = getConnection();
		NoticeUpProcDao noticeUpProcDao = NoticeUpProcDao.getInstance();
		noticeUpProcDao.setConnection(conn);
		result = noticeUpProcDao.noticeUpdate(notice);
		
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		return result;
	}
}
