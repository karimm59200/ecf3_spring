package com.example.ecf3springspringdata.repository;

import com.example.ecf3springspringdata.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long>{

    public User findByEmailAndPassword(String email, String password);

    public boolean findByEmailAndName(String email, String name);

    public User findByEmail(String email);

     public User findByName(String name);


   public User findByNameAndPassword(String name, String password);
}
