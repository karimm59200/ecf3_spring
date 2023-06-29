package com.example.ecf3springspringdata.repository;

import com.example.ecf3springspringdata.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long>{

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String email);

     public boolean findByName(String name);

   public User findByNameAndPassword(String name, String password);
}
