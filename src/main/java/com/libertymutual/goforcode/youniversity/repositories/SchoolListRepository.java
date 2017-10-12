package com.libertymutual.goforcode.youniversity.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libertymutual.goforcode.youniversity.models.SchoolList;
import com.libertymutual.goforcode.youniversity.models.User;

@Repository
public interface SchoolListRepository extends JpaRepository<SchoolList, Long> {

    public List<SchoolList> findAllByUser(User user);
}