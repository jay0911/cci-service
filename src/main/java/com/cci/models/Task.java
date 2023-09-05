package com.cci.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(
    name = "tbl_task"
)
@Where(clause = "deleted_at is null")
@Data
@EqualsAndHashCode(callSuper=false)
public class Task extends AbstractDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @OneToOne()
	private User user;
	
	@Column(name="task_description")
	private String description;
	
	@Column(name="task_name")
	private String name;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dateTime;
	
    @Column(columnDefinition = "ENUM('pending','done')")
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public enum Status {
        pending,
        done
    }
}
