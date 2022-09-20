package model;

import java.util.List;

public class bookService {
	private IBookDaoImpl mgr = new IBookDaoImpl();
	
	public boolean insert(Book book) {
		if (mgr.insert(book) == 1) {
			return true;
		}
		return false;
	}
	public boolean delete(int no) {
		if (mgr.delete(no) == 1) {
			return true;
		}
		return false;
	}
	public Book selectOne(int no) {
		return mgr.selectOne(no);
	}
	public List<Book> selectAll(){
		return mgr.selectAll();
	}
}
