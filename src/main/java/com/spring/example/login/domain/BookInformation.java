package com.spring.example.login.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="book_info")
public class BookInformation
{
  @Id
  @Column(name = "id" )
  @GeneratedValue
  private int id;
  @Column(name = "bookName")
  private String bookName;
  @Column(name = "comment", length = 512)
  private String comment;

  @Column(name = "owner")
  private String owner;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getBookName()
  {
    return bookName;
  }

  public void setBookName(String name)
  {
    this.bookName = name;
  }

  public String getComment()
  {
    return comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }
  public String getOwner()
  {
    return owner;
  }

  public void setOwner(String owner)
  {
    this.owner = owner;
  }



}
