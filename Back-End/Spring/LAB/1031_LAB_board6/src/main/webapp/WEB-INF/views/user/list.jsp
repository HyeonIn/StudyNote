<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%-- <c:if test="${articles eq null}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/board/list?pgno=1&key=&word=";
	</script>
</c:if> --%>
      <div class="row justify-content-center">
        <div class="col-lg-10 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="purple">회원목록</mark>
          </h2>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-12">
          <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
              <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#registerModal">
							  회원 등록
							</button>
            </div>
            <div class="col-md-5 offset-5">
              <form class="d-flex" id="form-search" action="">
                <input type="hidden" name="pgno" value="1"/>
                <select
                  class="form-select form-select-sm ms-5 me-1 w-50"
                  id="skey"
                  name="key"
                  aria-label="검색조건"
                >
                  <option value="" selected>검색조건</option>
                  <option value="userid">아이디</option>
                  <option value="username">이름</option>
                  <option value="emaildomain">이메일도메인</option>
                </select>
                <div class="input-group input-group-sm">
                  <input type="text" class="form-control" id="sword" name="word" placeholder="검색어..." />
                  <button id="btn-search" class="btn btn-dark" type="button">검색</button>
                </div>
              </form>
            </div>
          </div>
          <table class="table table-hover">
          	<colgroup>
		            <col width="120">
		            <col width="120">
		            <col width="120">
		            <col width="*">
		            <!-- <col width="*"> -->
		            <col width="180">
		            <col width="130">
		        </colgroup>
            <thead>
			      	<tr>
			        	<th class="text-center">아이디</th>
			        	<th class="text-center">비밀번호</th>
			        	<th class="text-center">이름</th>
			        	<th class="text-center">이메일</th>
			        	<!-- <th class="text-center">주소</th> -->
			        	<th class="text-center">가입일</th>
			        	<th class="text-center">수정/삭제</th>
			      	</tr>
		    		</thead>
		    		<tbody id="userlist"></tbody>
          </table>
        </div>
        <div class="m-3 row">${navigation.navigator}</div>
      </div>
    </div>
    <!-- 회원 등록 Modal -->
    <div class="modal fade" id="registerModal" data-bs-backdrop="static" tabindex="-1">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title"><mark class="purple">회원 등록</mark></h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
            <div class="mb-3">
              <label for="username" class="form-label">이름 : </label>
              <input
                type="text"
                class="form-control"
                id="username"
                name="userName"
                placeholder="이름..."
              />
            </div>
            <div class="mb-3">
              <label for="userid" class="form-label">아이디 : </label>
              <input
                type="text"
                class="form-control"
                id="userid"
                name="userId"
                placeholder="아이디..."
              />
            </div>
            <div id="idcheck-result"></div>
            <div class="mb-3">
              <label for="userpwd" class="form-label">비밀번호 : </label>
              <input
                type="password"
                class="form-control"
                id="userpwd"
                name="userPwd"
                placeholder="비밀번호..."
              />
            </div>
            <div class="mb-3">
              <label for="pwdcheck" class="form-label">비밀번호확인 : </label>
              <input type="password" class="form-control" id="pwdcheck" placeholder="비밀번호확인..." />
            </div>
            <div class="mb-3">
              <label for="emailid" class="form-label">이메일 : </label>
              <div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="emailid"
                  name="emailId"
                  placeholder="이메일아이디"
                />
                <span class="input-group-text">@</span>
                <select
                  class="form-select"
                  id="emaildomain"
                  name="emailDomain"
                  aria-label="이메일 도메인 선택"
                >
                  <option selected>선택</option>
                  <option value="ssafy.com">싸피</option>
                  <option value="google.com">구글</option>
                  <option value="naver.com">네이버</option>
                  <option value="kakao.com">카카오</option>
                </select>
              </div>
            </div>
		      </div>
		      <div class="modal-footer">
		      	<button type="button" id="btn-join" class="btn btn-outline-primary">
               회원가입
            </button>
		        <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">닫기</button>
		      </div>
		    </div>
		  </div>
		</div>
    
    <form id="form-param" method="get" action="">
      <input type="hidden" id="pgno" name="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
    </form>
    <form id="form-no-param" method="get" action="${root}/board/view">
      <input type="hidden" name="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
      <input type="hidden" id="articleno" name="articleno" value="">
    </form>
    <script>
	    var sel = document.getElementById("skey");
			for(var i=0; i<sel.length; i++){
				if(sel[i].value == "${key}"){
					sel[i].selected = true;
				}
			}
			
			if("${word}" != "")
				document.getElementById("sword").value = "${word}";
	
			// 회원 목록
			fetch("${root}/admin/user")
				.then(response => response.json())
				.then(data => makeList(data));
			
			// 회워 정보 수정 보기.
			function viewModify(userid) {
				console.log(`${userid}`);
				document.querySelector(`#view_${userid}`).setAttribute("style", "display: none;");
				document.querySelector(`#mview_${userid}`).setAttribute("style", "display: ;");
			}
			/* let modifyViewBtns = document.querySelectorAll(".modifyViewBtn");
			modifyViewBtns.forEach(function(btn) {
				btn.addEventListener("click", function() {
					console.log(btn.parent.parent);
				});
			}); */
			/* $(document).on("click", ".modiBtn", function() {
				let mid = $(this).parents("tr").attr("data-id");
				$("#view_" + mid).css("display", "none");
				$("#mview_" + mid).css("display", "");
			}); */
			
			// 회원 목록 tbody
			function makeList(users) {
				let tbody = ``;
				users.forEach(function(user) {
					tbody += `
						<tr id="view_\${user.userId}" class="view" data-id="\${user.userId}">
							<td class="text-center">\${user.userId}</td>
							<td class="text-center">\${user.userPwd}</td>
							<td class="text-center">\${user.userName}</td>
							<td class="text-center">\${user.emailId}@\${user.emailDomain}</td>
							<td class="text-center">\${user.joinDate}</td>
							<td class="text-center">
								<button type="button" class="modifyViewBtn btn btn-outline-primary btn-sm" onclick="viewModify('\${user.userId}');">수정</button>
								<button type="button" class="deleteBtn btn btn-outline-danger btn-sm">삭제</button>
							</td>
						</tr>
						<tr id="mview_\${user.userId}" data-id="\${user.userId}" style="display: none;">
							<td>${user.userId}</td>
							<td><input type="text" name="userpwd" id="userpwd\${user.userId}'" value="\${user.userPwd}"></td>
							<td>${user.userName}</td>
							<td><input type="text" name="email" id="email\${user.userId}" value="\${user.emailId}"></td>
							<td>${user.joinDate}</td>
							<td>
								<button type="button" class="modifyBtn btn btn-primary btn-sm">수정</button>
								<button type="button" class="cancelBtn btn btn-danger btn-sm">취소</button>
							</td>
						</tr>
					`;
				});
				document.querySelector("#userlist").innerHTML = tbody;
			}
			
				/*
      let titles = document.querySelectorAll(".article-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
          document.querySelector("#articleno").value = this.getAttribute("data-no");
          document.querySelector("#form-no-param").submit();
        });
      });

      document.querySelector("#btn-mv-register").addEventListener("click", function () {
    	  let form = document.querySelector("#form-param");
        form.setAttribute("action", "${root}/board/write");
        form.submit();
      });
      
      document.querySelector("#btn-search").addEventListener("click", function () {
    	  let form = document.querySelector("#form-search");
        form.setAttribute("action", "${root}/board/list");
        form.submit();
      });
      
      let pages = document.querySelectorAll(".page-link");
      pages.forEach(function (page) {
        page.addEventListener("click", function () {
        	let form = document.querySelector("#form-param");
        	document.querySelector("#pgno").value = page.parentNode.getAttribute("data-pg");
          form.setAttribute("action", "${root}/board/list");
          form.submit();
        });
      });
      */
    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
