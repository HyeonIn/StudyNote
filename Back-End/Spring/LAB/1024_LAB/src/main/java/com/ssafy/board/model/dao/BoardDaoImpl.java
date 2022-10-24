package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class BoardDaoImpl implements BoardDao {

	private final String NAMESPACE = "com.ssafy.board.model.dao.BoardDao.";

	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		int articleNo = 0;
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert(NAMESPACE + "writeArticle", boardDto);
			List<FileInfoDto> fileInfos = boardDto.getFileInfos();
			if (fileInfos != null && !fileInfos.isEmpty()) {
				articleNo = sqlSession.insert(NAMESPACE + "registerFile", boardDto);
			}
			sqlSession.commit();
		}
		return articleNo;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, Object> map) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList(NAMESPACE + "listArticle", map);
		}
	}

	@Override
	public int getTotalArticleCount(Map<String, String> map) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "getTotalArticleCount", map);
		}
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "getArticle", articleNo);
		}
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.update(NAMESPACE + "updateHit", articleNo);
			sqlSession.commit();
		}
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.update(NAMESPACE + "modifyArticle", boardDto);
			sqlSession.commit();
		}
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.delete(NAMESPACE + "deleteFile", articleNo);
			sqlSession.delete(NAMESPACE + "deleteArticle", articleNo);
			sqlSession.commit();
		}
	}

}
