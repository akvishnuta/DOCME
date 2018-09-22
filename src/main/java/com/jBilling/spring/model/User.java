package com.jBilling.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.jBilling.spring.biz.Validators.ReTypePassword;

import lombok.Data;

@Data
@Entity
@ReTypePassword.List({
	@ReTypePassword(
			field="password",
			fieldMatch="reTypePassword",
			message="ReType Password does not match"
			)
})
public class User implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	
	@Size(min=3,max=20,message="{name_error}")
	private String name;
	private String username;
	private String password;
	
	@Transient
	private String reTypePassword;
	
	private String salt;
	private String phone;
	private String email;
	
	@Override
	public String toString() {
		return "code="+this.code+": name="+this.username;
	}
}
