package com.libertymutual.goforcode.youniversity.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schoolList")
public class SchoolList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String name;
	
    @ManyToOne
    private User user;
    
    @ManyToMany(mappedBy = "schoolList", cascade = CascadeType.ALL)
    private List<SchoolList> schools;
    
	
}
