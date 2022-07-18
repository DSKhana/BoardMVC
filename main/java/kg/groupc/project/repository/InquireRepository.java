package kg.groupc.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.dto.InquireDto;
import kg.groupc.project.entity.Inquire;

public interface InquireRepository extends JpaRepository<Inquire, Long>{
	
	public static final InquireRepository inquireRepository = null;

	
	public static void write() {
		
		//1. 게시글 파라미터 생성
		Inquire params = Inquire.builder()
				.title("제목")
				.category("카테고리")
				.hotel(12345)
				.writer("도뎡이")
				.description("aa")
				.build();
		
		inquireRepository.save(params);
	}
	
	public static void find() {
		
		//1. 전체 게시글 수 조회
		long boardsCount = inquireRepository.count();
		
		//2. 전체 게시글 리스트 조회
		List<Inquire> inquires = inquireRepository.findAll();
	}
	
	public static int delete(InquireDto inquire) {
		//1. 게시글 조회
		Inquire entity = inquireRepository.findById((long) 1).get();
		
		//2. 게시글 삭제
		inquireRepository.delete(entity);
		return 0;
	}
}
