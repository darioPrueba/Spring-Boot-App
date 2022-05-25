package com.dariorucker.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ChangePasswordForm {

	@NotNull
	private Long id;
	
	@NotBlank(message="Current Password cant be blank")
	private String currentPassword;
	
	@NotBlank(message="New Password cant be blank")
	private String newPassword;
	
	@NotBlank(message="Confirm Password cant be blank")
	private String confirmPassword;
	
	public ChangePasswordForm() {
		
	}
	public ChangePasswordForm(Long id) {
		this.id = id;
		}



}
