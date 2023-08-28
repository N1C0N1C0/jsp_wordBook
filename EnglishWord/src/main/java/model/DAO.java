package model;

import java.util.ArrayList;

import connect.Connect;

public class DAO extends Connect{
	
	public String updateJpWord(DTO dto) {
		String result = "";
		String update = "update words_jp_tbl set word=?, mean=?, pronunciation=?, k_pronunciation=? "
						+ "where seqno=?";
		try {
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, dto.getWord());
			pstmt.setString(2, dto.getMean());	
			pstmt.setString(3, dto.getPronunciation());	
			pstmt.setString(4, dto.getK_pronunciation());	
			pstmt.setInt(5, dto.getSeqno());	
			pstmt.executeUpdate();
			result = "OK";
		} catch (Exception e) {
			result = "NOK";
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public String updateEnWord(DTO dto) {
		String result = "";
		String update = "update words_en_tbl set word=?, mean=?, pronunciation=?, k_pronunciation=? "
						+ "where seqno=?";
		try {
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, dto.getWord());
			pstmt.setString(2, dto.getMean());	
			pstmt.setString(3, dto.getPronunciation());	
			pstmt.setString(4, dto.getK_pronunciation());	
			pstmt.setInt(5, dto.getSeqno());	
			pstmt.executeUpdate();
			result = "OK";
		} catch (Exception e) {
			result = "NOK";
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public String deleteJpWord(int seqno) {
		String result = "";	// 삭제 결과를 저장할 변수 선언
		String delete = "delete from words_jp_tbl where seqno=?";
		try {
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);	// 첫번째 물음표에 글번호 설정
			pstmt.executeUpdate();
			result = "OK";
		} catch (Exception e) {
			result = "NOK";
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public String deleteEnWord(int seqno) {
		String result = "";	// 삭제 결과를 저장할 변수 선언
		String delete = "delete from words_en_tbl where seqno=?";
		try {
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);	// 첫번째 물음표에 글번호 설정
			pstmt.executeUpdate();
			result = "OK";
		} catch (Exception e) {
			result = "NOK";
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public DTO getJpWord(int seqno) {
		DTO dto = null;	// 조회 결과를 저장할 변수 선언
		String select = "select seqno, word, mean, pronunciation, k_pronunciation, jp_id "
				+ "from words_jp_tbl where seqno =?";
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);	// 첫번째 물음표에 글번호 설정
			rs = pstmt.executeQuery();	// select 실행
			if(rs.next()) {
				dto = new DTO();
				dto.setSeqno(rs.getInt(1));
				dto.setWord(rs.getString(2));
				dto.setMean(rs.getString(3));
				dto.setPronunciation(rs.getString(4));
				dto.setK_pronunciation(rs.getString(5));
				dto.setId(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	public DTO getEnWord(int seqno) {
		DTO dto = null;	// 조회 결과를 저장할 변수 선언
		String select = "select seqno, word, mean, pronunciation, k_pronunciation, en_id "
				+ "from words_en_tbl where seqno =?";
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);	// 첫번째 물음표에 글번호 설정
			rs = pstmt.executeQuery();	// select 실행
			if(rs.next()) {
				dto = new DTO();
				dto.setSeqno(rs.getInt(1));
				dto.setWord(rs.getString(2));
				dto.setMean(rs.getString(3));
				dto.setPronunciation(rs.getString(4));
				dto.setK_pronunciation(rs.getString(5));
				dto.setId(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	
	
	public String insertJpWord(DTO dto) {
		String insert = "insert into words_jp_tbl values(?,?,?,?,?,?)";
		String result = "";	// 삽입과 결과를 저장할 변수 선언
			try {
					pstmt = con.prepareStatement(insert);
					pstmt.setInt(1, dto.getSeqno());
					pstmt.setString(2, dto.getWord());
					pstmt.setString(3, dto.getMean());
					pstmt.setString(4, dto.getPronunciation());
					pstmt.setString(5, dto.getK_pronunciation());
					pstmt.setString(6, dto.getId());
					pstmt.executeUpdate();
					result = "OK";
				System.out.println("단어 등록!!");
			} catch (Exception e) {
				result = "NOK";
				e.printStackTrace();
				System.out.println("단어 등록 실패!!");
			}finally {
				close();
			}
			return result;
		}
	
	public String insertEnWord(DTO dto) {
		String insert = "insert into words_en_tbl values(?,?,?,?,?,?)";
		String result = "";	// 삽입과 결과를 저장할 변수 선언
			try {
					pstmt = con.prepareStatement(insert);
					pstmt.setInt(1, dto.getSeqno());
					pstmt.setString(2, dto.getWord());
					pstmt.setString(3, dto.getMean());
					pstmt.setString(4, dto.getPronunciation());
					pstmt.setString(5, dto.getK_pronunciation());
					pstmt.setString(6, dto.getId());
					pstmt.executeUpdate();
					result = "OK";
				System.out.println("단어 등록!!");
			} catch (Exception e) {
				result = "NOK";
				e.printStackTrace();
				System.out.println("단어 등록 실패!!");
			}finally {
				close();
			}
			return result;
		}
	
	public int getJpMaxSeqno(){ // 가장 큰 글번호를 검색하는 메서드
		String select = "select max(seqno) from words_jp_tbl";
		int maxSeqno = -1;
		try {
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			// 삽입, 삭제, 변경: executeUpdate()
			// 조회: executeQuery()
			if(rs.next()) {
				maxSeqno = rs.getInt(1);	// 첫번째 조건 가져옴 max(seqno)
			}else {
				maxSeqno = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return maxSeqno;
	}
	
	public int getEnMaxSeqno(){ // 가장 큰 글번호를 검색하는 메서드
		String select = "select max(seqno) from words_en_tbl";
		int maxSeqno = -1;
		try {
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			// 삽입, 삭제, 변경: executeUpdate()
			// 조회: executeQuery()
			if(rs.next()) {
				maxSeqno = rs.getInt(1);	// 첫번째 조건 가져옴 max(seqno)
			}else {
				maxSeqno = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return maxSeqno;
	}
	
	public int getJpWordsCount(String user) {
		int count = -1;	// 조회 결과가 저장될 변수 선언
		String select = "select count(*) from words_jp_tbl where jp_id=?";
		try {
			String sameId = user;
			pstmt = con.prepareStatement(select);
			pstmt.setString(1,sameId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}else {
				count = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return count;
	}
	
	public int getMasterWordsCount() {
		int count = -1;	// 조회 결과가 저장될 변수 선언
		String select = "select count(*) from (select * from words_jp_tbl union all select * from words_en_tbl)";
		try {
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}else {
				count = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return count;
	}
	
	public int getEnWordsCount(String user) {
		int count = -1;	// 조회 결과가 저장될 변수 선언
		String select = "select count(*) from words_en_tbl where en_id=?";
		try {
			String sameId = user;
			pstmt = con.prepareStatement(select);
			pstmt.setString(1,sameId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}else {
				count = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return count;
	}
	
	public ArrayList<DTO> getMasterWords(int pageNo){
		String select = "select * from ("
				+ " select ms.*, rownum rNum from ("
				+ " select * from words_jp_tbl union all select * from words_en_tbl) ms "
				+ ") where rNum between ? and ?";
		
		int from = (pageNo-1)*5+1; 
		int to = from+5-1;
		
		ArrayList<DTO> jp = new ArrayList<>(); 
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, from);
			pstmt.setInt(2, to);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setSeqno(rs.getInt(1));	// 첫번째 조회결과를 seqno에 저장
				dto.setWord(rs.getString(2));	// 두번째 조회결과를 의미에 저장
				dto.setMean(rs.getString(3));	// 두번째 조회결과를 의미에 저장
				dto.setPronunciation(rs.getString(4));	// 네번째 조회결과를 bbs_date에 저장
				dto.setK_pronunciation(rs.getString(5));	// 네번째 조회결과를 bbs_date에 저장
				dto.setId(rs.getString(6)); // 세번째 조회결과를 id에 저장
				jp.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return jp;
	}
	
	public ArrayList<DTO> getJpWords(int pageNo,String user) {
		String select = "select * from("
				+ " select jp.*, rownum rNum from("
				+ " select * from words_jp_tbl where jp_id = ? order by seqno desc) jp "
				+ ") where rNum between ? and ?";
		
		int from = (pageNo-1)*5+1; 
		int to = from+5-1;
		
		String sameId = user;
		System.out.println(sameId);
		ArrayList<DTO> jp = new ArrayList<>(); 
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setString(1,sameId);
			pstmt.setInt(2, from);
			pstmt.setInt(3, to);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setSeqno(rs.getInt(1));	// 첫번째 조회결과를 seqno에 저장
				dto.setWord(rs.getString(2));	// 두번째 조회결과를 의미에 저장
				dto.setMean(rs.getString(3));	// 두번째 조회결과를 의미에 저장
				dto.setPronunciation(rs.getString(4));	// 네번째 조회결과를 bbs_date에 저장
				dto.setK_pronunciation(rs.getString(5));	// 네번째 조회결과를 bbs_date에 저장
				dto.setId(rs.getString(6)); // 세번째 조회결과를 id에 저장
				jp.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return jp;
	}
	
	public ArrayList<DTO> getEnWords(int pageNo,String user) {
		String select = "select * from("
				+ " select en.*, rownum rNum from("
				+ " select * from words_en_tbl where en_id = ? order by seqno desc) en "
				+ ") where rNum between ? and ?";
		
		int from = (pageNo-1)*5+1; 
		int to = from+5-1;
		
		String sameId = user;
		System.out.println(sameId);
		ArrayList<DTO> en = new ArrayList<>(); 
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setString(1,sameId);
			pstmt.setInt(2, from);
			pstmt.setInt(3, to);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setSeqno(rs.getInt(1));	// 첫번째 조회결과를 seqno에 저장
				dto.setWord(rs.getString(2));	// 두번째 조회결과를 의미에 저장
				dto.setMean(rs.getString(3));	// 두번째 조회결과를 의미에 저장
				dto.setPronunciation(rs.getString(4));	// 네번째 조회결과를 bbs_date에 저장
				dto.setK_pronunciation(rs.getString(5));	// 네번째 조회결과를 bbs_date에 저장
				dto.setId(rs.getString(6)); // 세번째 조회결과를 id에 저장
				en.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return en;
	}
	
	public String selectId(String id) {
		String result = null;	//조회결과를 저장할 변수 선언
		String select = "select id from words_users_tbl where id=?";
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	// select 실행
			if(rs.next()) {
				result = rs.getString(1);	// 조회 결과를 result에 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public String register(DTO dto) {
		String result = "";
		String insert = "insert into words_users_tbl values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.executeUpdate();	// insert 쿼리 실행
			result = "OK";
		} catch (Exception e) {
			result = "NOK";
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public String loginCheck(String id, String pwd) {
		String result = "";	// 조회 결과를 저장할 변수 선언
		String select = "select pwd from words_users_tbl where id=?";
		try {
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);		// 첫번째 물음표에 입력한 계정을 설정
			rs = pstmt.executeQuery();	// 조회 실행
			String password = "";
			if(rs.next()) {
				System.out.println(rs.getString(1));
				password = rs.getString(1);
				if(pwd.equals(password)) {
					result="OK";
				}else {
					result="NOK";
				}
			}else {
				result="NOK";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "NOK";
		}finally {
			close();
		}
		return result;
	}
}
