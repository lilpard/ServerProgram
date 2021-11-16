package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDao;
import dao.StudentDao;
import dto.Member;
import dto.Student;

public class Top1job implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		// STUDENT 테이블에서 ave순으로 TOP3 가져오기
		Member member = MemberDao.getInstance().selectTop1();
		
		// list를 파일로 만들기
		File file = new File("top.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				bw.write(member.getNo() + ",");
				bw.write(member.getId() + ",");
				bw.write(member.getName() + ",");
				bw.write(member.getGrade() + ",");
				bw.write(member.getPoint() + "\n");
			System.out.println("top3.txt 파일 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
