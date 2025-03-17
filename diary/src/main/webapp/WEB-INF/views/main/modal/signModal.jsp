<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 회원가입 모달 -->
<div class="modal fade" id="signModal" tabindex="-1" aria-labelledby="signModalLabel">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="signModalLabel">회원가입</h5>
                <button id="btnClose" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="signForm">
                	<div class="row m-b-10">
                		<label for="memberId" class="form-label">아이디<span class="required-value">*</span></label>
					    <div class="input-group">
					        <input type="text" class="form-control" id="memberId" name="memberId" required minlength="6" maxlength="14">
					        <button class="btn btn-outline-secondary" type="button" id="isMemberBtn">중복 확인</button>
					    </div>
					    <span id="memberIdError" style="color: red; font-size: 12px;"></span>
	                </div>
	                <div class="row m-b-10">
	                    <div class="mb-3">
	                        <label for="pw" class="form-label">비밀번호<span class="required-value">*</span></label>
	                        <input type="password" class="form-control" id="pw" name="pw" required minlength="6" maxlength="10">
		                    <span id="pwError" style="color: red; font-size: 12px;"></span>
	                    </div>
                    </div>
	                <div class="row m-b-10">
	                    <div class="mb-3">
	                        <label for="rePw" class="form-label">비밀번호 확인<span class="required-value">*</span></label>
	                        <input type="password" class="form-control" id="rePw" name="rePw" required minlength="6" maxlength="10">
		                    <span id="rePwError" style="color: red; font-size: 12px;"></span>
	                    </div>
                    </div>
                    <div class="row m-b-10">
					    <div class="col-md-6">
					        <label for="phone" class="form-label">휴대전화<span class="required-value">*</span></label>
							<div class="input-group">
						        <input type="text" class="form-control" id="phone" name="phone" maxlength="12">
						        <button class="btn btn-outline-secondary" type="button" id="btnCertification">인증받기</button>
						    </div>
						    <span id="phoneError" style="color: red; font-size: 12px;"></span>
					    </div>
					    <div class="col-md-6">
					        <label for="name" class="form-label">성명<span class="required-value">*</span></label>
					        <input type="text" class="form-control" id="name" name="name" maxlength="10">
					        <span id="nameError" style="color: red; font-size: 12px;"></span>
					    </div>
                    </div>
                    <div class="row m-b-10">
						<div class="col-md-6" id="certificationBox" style="display: none;">
						    <label for="certificationCode" class="form-label">인증번호 입력</label>
						    <div class="input-group">
						        <input type="text" class="form-control" id="certificationCode" name="certificationCode" maxlength="6" placeholder="비용 발생으로 중단" disabled>
						        <button class="btn btn-outline-secondary" type="button" id="btnVerify">확인</button>
						    </div>
						    <span id="certificationError" style="color: red; font-size: 12px;"></span>
						</div>
                    </div>
                    <div class="row m-b-10">
					    <div class="col-md-6">
					        <label for="birth" class="form-label">생년월일<span class="required-value">*</span></label>
					        <input type="date" class="form-control" id="birth" name="birth">
					    </div>
					    <div class="col-md-6">
					        <label for="email" class="form-label">이메일</label>
					        <input type="email" class="form-control" id="email" name="email">
						    <span id="emailError" style="color: red; font-size: 12px;"></span>
					    </div>
                    </div>
                   	<button type="button" class="modal-btn" id="btnSign">회원가입</button>
                </form>
            </div>
        </div>
    </div>
</div>