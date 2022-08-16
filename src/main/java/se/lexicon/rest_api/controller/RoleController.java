package se.lexicon.rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.rest_api.model.entity.Role;
import se.lexicon.rest_api.repository.RoleRepo;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        Role role = roleRepo.findById(id).orElse(null);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        System.out.println("role = " + role);
        Role responseEntity = roleRepo.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEntity);
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateRoleById(@RequestBody Role role){
        System.out.println("role = " + role);
        Role updatedRole = roleRepo.save(role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
