package com.immu.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	// RoleEntity not owning the relationship
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> user = new ArrayList<UserEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserEntity> getUser() {
		return user;
	}

	public void setUsers(List<UserEntity> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", name=" + name + ", user=" + user + "]";
	}

	
	
	
	

}
