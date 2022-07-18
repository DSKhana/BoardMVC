package kg.groupc.project.util;

import org.springframework.data.domain.Page;

/*
 * 
 * 페이징 처리 유틸
 * 페이지블록 (한번에 출력할 페이지 갯수)과 Page 객체를 입력 받아, 페이징처리에 필요한 변수 계산
 * 
 */

public class PagingUtil {

    public int pageNumber; //현재 페이지번호
    public int totalPages;  //총 페이지 수
    public int startBlockPage; //시작 페이지 번호
    public int endBlockPage; //마지막 페이지 번호

    public PagingUtil(int pageBlock, Page page) {
        this.pageNumber = page.getPageable().getPageNumber();
        this.totalPages = page.getTotalPages();
        this.startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
        this.endBlockPage = (pageNumber / pageBlock == totalPages / pageBlock) 
        		? totalPages : startBlockPage + pageBlock - 1; 
        //현재페이지가 마지막 블록이면 마지막페이지 = 전체 페이지 수
    }

}
