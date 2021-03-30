package br.com.springboot.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.user;
import br.com.springboot.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/{id}")
    public user user(@PathVariable("id") Long id) {
        Optional<user> userFind = this.UserRepository.findById(id);

        if (userFind.isPresent()) {
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public user user(@RequestBody user user) {
        return this.UserRepository.save(user);
    }

    @GetMapping("/list/{id}")
    public List<user> list(@PathVariable("id") Long id) {
        return this.UserRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/")
    public List<user> list() {
        return this.UserRepository.findAll();
    }

    @GetMapping("/listname/{name}")
    public List<user> list(@PathVariable("name")String name) {
        return this.UserRepository.findByNameIgnoreCase(name);
    }
}
