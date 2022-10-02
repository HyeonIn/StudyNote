package model;

import java.util.HashMap;
import java.util.Map;

//DAO가 못하는 비즈니스 로직등의 처리를 맡는 클래스
public class BoardService {
	private BoardDao dao = new BoardDao();
	private static final int COUNT_PER_PAGE = 5;
	public Map<String, Object> makePage(int page){
		Map<String, Object> pageMap = new HashMap<>();
		
		pageMap.put("currPage", page);

		int totalCount = dao.selectTotalCount();
		int totalPage = totalCount/COUNT_PER_PAGE;
		if (totalCount%COUNT_PER_PAGE > 0) {
			totalPage++;
		}
		
		int startPage = (page-1)/10*10+1;
		int endPage = startPage+9;
		if (endPage > totalPage) {
			endPage=totalPage;
		}
		pageMap.put("totalPage", totalPage);
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		int startRow = (page-1)*COUNT_PER_PAGE;
		
		pageMap.put("boardList", dao.selectList(startRow, COUNT_PER_PAGE));
		return pageMap;
	}
	public boolean write(BoardDTO board) {
		if(dao.insert(board) == 1) {
			return true;
		}
		return false;
	}
	public BoardDTO selectOne(int bno) {
		return dao.selectOne(bno);
	}
	public boolean deleteOne(int bno) {
		if (dao.deleteOne(bno) == 1) {
			return true;
		}
		return false;
	}
	public boolean UpdateOne(Board) {
		
	}
}
