package com.site.diary.domain.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long Id;
	private String memberId;
	private String pw;
	private String name;
	private String phone;
	private String birth;
	private String email;
}
