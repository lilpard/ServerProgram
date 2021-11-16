package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;
import session.MemberLogin;

public class MemberDao {
	private SqlSessionFactory factory;
	
	private static MemberDao instance;
	private MemberDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	public List<Member> selectList(){
		SqlSession ss = factory.openSession();
		List<Member> list = ss.selectList("dao.members.selectList");
		ss.close();
		return list;
	}
	public int selectMember(String id){
		SqlSession ss = factory.openSession();
		int result = ss.selectOne("dao.members.selectMember", id);
		return result;
	}
	public Member memberInfo(String id) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne("dao.members.memberInfo", id);
		ss.close();
		return member;
	}
	
	public int updateMember(Member member) {
		SqlSession ss = factory.openSession();
		int result = ss.update("dao.members.updateMember", member);
		ss.commit();
		ss.close();
		return result;
	}
	
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession();
		int result = ss.insert("dao.members.insertMember", member);
		ss.commit();
		ss.close();
		return result;
	}
	
	public int deleteMember(long no) {
		SqlSession ss =factory.openSession();
		int result = ss.delete("dao.members.deleteMember", no);
		ss.commit();
		ss.close();
		return result;
	
	}
}
