package model;

import java.util.List;

public interface IBookDao { // Data Access Object = DAO
	public int insert(Book book);
	public int delete(int no);
	public Book selectOne(int no);
	public List<Book> selectAll();
}
