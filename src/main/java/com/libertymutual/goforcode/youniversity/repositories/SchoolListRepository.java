package com.libertymutual.goforcode.youniversity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libertymutual.goforcode.youniversity.models.SchoolList;
	
	@Repository
	public interface SchoolListRepository extends JpaRepository<SchoolList, Long> {
}