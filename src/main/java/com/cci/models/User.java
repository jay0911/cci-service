package com.cci.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.*;

@Entity
@Table(
    name = "tbl_user"
)
@Where(clause = "deleted_at is null")
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends AbstractDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Task> tasks = new ArrayList<>();
}