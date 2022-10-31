<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
      <div class="row justify-content-center">
        <div class="col-lg-10 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">에러발생!!!</mark>
          </h2>
        </div>
          <div class="col-lg-10 col-md-10 col-sm-12 card text-center bg-light">
            <h2 class="fw-bold text-danger pt-3">처리 중 에러 발생 T.T</h2>
            <div class="card-body">
              <p class="card-text">
                ${msg}
              </p>
              <button type="button" id="btn-index" class="btn btn-outline-danger">
                메인 페이지 이동...
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
      document.querySelector("#btn-index").addEventListener("click", function () {
        location.href = "${root}";
      });
    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
