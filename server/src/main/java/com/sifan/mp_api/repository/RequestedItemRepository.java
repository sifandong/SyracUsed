package com.sifan.mp_api.repository;


import com.sifan.mp_api.model.RequestedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestedItemRepository extends JpaRepository<RequestedItem, Long> {
}
