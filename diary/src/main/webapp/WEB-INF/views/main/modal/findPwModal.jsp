<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 비밀번호 변경 모달 -->
<div class="modal fade" id="findPwModal" tabindex="-1" aria-labelledby="findPwModalLabel">
    <div class="modal-dialog modal-dialog-centered modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="signModalLabel">아이디 찾기</h5>
                <button id="btnClose" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="findPwForm">
                	<div class="row m-b-10">
                		<div class="col-12">
	                		<label for="findName" class="form-label">성명</label>
					        <input type="text" class="form-control" id="findName" name="findName" required  maxlength="10">
				        </div>
	                </div>
                	<div class="row m-b-10">
                		<div class="col-12">
	                		<label for="findName" class="form-label">성명</label>
					        <input type="text" class="form-control" id="findName" name="findName" required  maxlength="10">
				        </div>
	                </div>
                   	<button type="button" class="modal-btn" id="btnfindPw">아이디 찾기</button>
                </form>
            </div>
        </div>
    </div>
</div>