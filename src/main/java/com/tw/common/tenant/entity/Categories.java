package com.tw.common.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@SuppressWarnings("deprecation")
@Data
@Entity
@Accessors(chain = true)
@Table(name = "categories")
@Where(clause = "deleted=false") 	
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 36)
    private String color;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Lob
    private String description;

    private String featured;
    
    @Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

    @Lob
    private String name;

    @Column(name = "order_index")
    private int orderIndex;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Categories category;


}
