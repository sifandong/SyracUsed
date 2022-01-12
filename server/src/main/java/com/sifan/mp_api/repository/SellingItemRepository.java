package com.sifan.mp_api.repository;


import com.sifan.mp_api.model.SellingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellingItemRepository extends JpaRepository<SellingItem, Long> {


}
