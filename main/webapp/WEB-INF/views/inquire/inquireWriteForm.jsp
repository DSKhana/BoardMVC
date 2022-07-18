<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>문의 작성</title>

<!-- include summer note css -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	<%-- 헤더 --%>
    <div>
        <jsp:include page="../header.jsp"/>
    </div>
    
	<%-- 메인 컨테이너 --%>
    <section class="common-iuContainer--main">

        <%-- 제목 --%>
        <div class="common-iuTop--title" style="color:#F4B7B4 ">
        	문의 작성
        </div>

        <%-- 글쓰기 폼 카테고리/제목/내용/ --%>
        <form id="inquire-form" modelAttribute="inquireRepository" >
            <table class="common-iContainer-writeform">
				
				<%-- 지역 : select --%>
                <tr class="common-tbl__item">
                    <td style="width: 170px">
                        <b>카테고리</b>
                    </td>
                    <td>
                        <select name="category" class="category__component">
                            <option value="숙소">숙소</option>
                            <option value="맛집">맛집</option>
                            <option value="계정">계정</option>
                            <option value="사이트이용">사이트이용</option>
                            <option value="개선사항">개선사항</option>
                            <option value="기타">기타</option>
                        </select>
                    </td>
                    <td>
                        <select name="hotelcode" class="category__hotel">
                        	<%-- 호텔코드 선택하는 메뉴 출력--%>
                        </select>
                    </td>
                </tr>

                <%-- 제목 : text --%>
                <tr class="common-tbl__item">
                    <td style="width: 170px">
                        제목
                    </td>
                    <td>
                        <input  name="title" style="width: 600px" type="text"/>
                    </td>
                </tr>

                <%-- 내용 : summer note --%>
                <tr class="common-tbl__item">
                    <td style="width: 170px">
                        내용
                    </td>
                    <td>
                        <textarea id="summernote" name="description" rows="30" cols="84"></textarea>
                        
                        <div id="reviewI-imageAppend"></div>
                        <%-- summer note 실행 --%>
                        <script>
                            $(function () {
                                $('#summernote').summernote({
                                    //summernote 속성
                                    width: 1100,
                                    height: 400,
                                    minHeight: null,
                                    maxHeight: null,
                                    focus: true,
                                    lang: "ko-KR",
                                    placeholder: '최대 1000자까지 쓸 수 있습니다'                                    
                                });
                            });
                        </script>
                    </td>
                </tr>
            </table>

            <%-- 저장 버튼 --%>
            <div id="reviewIU-container--bottom" align="center">
            	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <button type="submit" onclick="uploadCanvasData(save);" id="reviewIU-btn--submit"
                        class="button--exceptionboot"> 작성 </button>
                &nbsp&nbsp
				<button type="button" onclick="location.href='/inquire'">목록으로</button>
            </div>
        </form>
    </section>
	<%-- 푸터 --%>
    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>
</body>
</html>