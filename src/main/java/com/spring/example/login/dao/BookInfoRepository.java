package com.spring.example.login.dao;

import com.spring.example.login.domain.BookInformation;
import com.spring.example.login.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookInfoRepository extends JpaRepository<BookInformation, Integer>
{
  @Query(value = "select b from BookInformation b where b.owner = ?1")
  public List<BookInformation> findAllBooksByOwner(String owner);
}
