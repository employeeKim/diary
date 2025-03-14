package com.site.diary.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long Id;
	
    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    @Size(min = 4, max = 20, message = "아이디는 4 ~ 20자로 입력해야 합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "아이디는 영어와 숫자만 입력 가능합니다.")
    @Column(nullable = false, unique = true)
	private String memberId;
    
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
	private String pw;
    
    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    @Pattern(regexp = "^[ㄱ-힣]+$", message = "이름은 한글만 입력 가능합니다.")
    @Column(nullable = false)
    private String name;
    
    @Pattern(
	    regexp = "^(010|011|016|017|018|019)[0-9]{7,8}$|^(02|0[3-9][0-9])[0-9]{7,8}$",
	    message = "올바른 전화번호 형식이 아닙니다. (예: 01012345678 또는 021234567)"
	)
	@Column(nullable = false)
	private String phone;

    @Column(nullable = false)
	private String birth;
    
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", 
    message = "유효한 이메일 주소를 입력하세요.")
    @Column(nullable = false, unique = true)
    private String email;
}
