<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 아이디 찾기 모달 -->
<div class="modal fade" id="findIdModal" tabindex="-1" aria-labelledby="findIdModalLabel">
    <div class="modal-dialog modal-dialog-centered modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="findIdModalLabel">아이디 찾기</h5>
                <button id="btnClose" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="findIdForm">
                	<div class="row m-b-10">
                		<div class="col-12">
	                		<label for="findName" class="form-label">성명</label>
					        <input type="text" class="form-control" id="findName" name="findName" required  maxlength="10">
				        </div>
	                </div>
                   	<button type="button" class="modal-btn" id="btnFindId">아이디 찾기</button>
                </form>
            </div>
        </div>
    </div>
</div>