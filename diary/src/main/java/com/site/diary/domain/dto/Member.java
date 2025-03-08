package com.site.diary.domain.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@Id
	private String Id;
	private String pw;
	private String rePw;
	private String name;
	private String phone;
	private String birth;
	private String email;
}
