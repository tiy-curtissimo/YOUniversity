package com.libertymutual.goforcode.youniversity.apiControllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.youniversity.models.SchoolList;
import com.libertymutual.goforcode.youniversity.models.User;
import com.libertymutual.goforcode.youniversity.repositories.SchoolListRepository;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;

@RestController
@RequestMapping("/list")
public class SchoolListController {

    private SchoolListRepository schoolListRepo;
    private UserRepository userRepo;

    public SchoolListController(SchoolListRepository schoolListRepo, UserRepository userRepo) {
        this.schoolListRepo = schoolListRepo;
        this.userRepo = userRepo;

    }

    @GetMapping("")
    public List<SchoolList> getList(Authentication auth) {
        User user = (User) auth.getPrincipal();
        user = userRepo.findOne(user.getId());
        return schoolListRepo.findAllByUser(user);
    }
    
    @DeleteMapping("{id}")
    public SchoolList deleteList(@PathVariable long id) {
        SchoolList schoolList = schoolListRepo.findOne(id);
        schoolListRepo.delete(id);
        return schoolList;
    }
    
    @PostMapping("create")
    public SchoolList createList(@RequestBody SchoolList schoolList, Authentication auth) {
        User user = (User) auth.getPrincipal();
        user = userRepo.findOne(user.getId());
        schoolList.setUser(user);
        return schoolListRepo.save(schoolList);        
    }
    
    @PutMapping("{id}")
    public SchoolList updateList(@RequestBody SchoolList schoolList, @PathVariable long id) {
        schoolList.setId(id);
        return schoolListRepo.save(schoolList);
    }
    
    
}
