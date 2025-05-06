package com.wsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsboot.entity.Item;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer>
{

public List<Item> findAll();

public List<Item> findAllByOrderById();


}
