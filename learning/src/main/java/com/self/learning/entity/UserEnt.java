package com.self.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class UserEnt {

	@Id
	@GeneratedValue
	private Integer id;

	private String username;

	private String password;
}
