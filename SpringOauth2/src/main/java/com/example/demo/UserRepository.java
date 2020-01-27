package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.books.book;

//implements userdetails service
public interface UserRepository extends JpaRepository<User, Long> {// CrudRepository<User,Long>{

	User findByUsername(String userName);
	

}
