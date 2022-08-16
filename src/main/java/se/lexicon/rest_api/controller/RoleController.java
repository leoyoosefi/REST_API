package se.lexicon.rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.rest_api.model.entity.Role;
import se.lexicon.rest_api.repository.RoleRepo;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    RoleRepo roleRepo;

    @Autowired
    public RoleController(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles(){

        List<Role> roleList = roleRepo.findAll();
        return ResponseEntity.ok(roleList);
    }
}
