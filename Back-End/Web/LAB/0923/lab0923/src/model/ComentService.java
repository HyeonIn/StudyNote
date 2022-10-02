package model;

import java.util.List;

public class ComentService {
	ComentDao mgr = new ComentDao();
	public int insert(ComentDTO coment) {
		return mgr.insert(coment);
	}
	public List<ComentDTO> selectComentList(int bno){
		return mgr.selectComentList(bno);
	}
	public boolean delete(int cno) {
		if (mgr.delete(cno)==1) {
			return true;
		}
		return false;
	}
}
