package com.example.repository;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.candidate;

@Repository
@Transactional
public interface candidateRepository extends JpaRepository<candidate,Integer>
{
	
	@Modifying
	@Query("delete from candidate c where c.canid= :canid")
	void deleteById(@Param(value="canid") int canid);
	
	
	@Query("select c.canid from candidate c where c.canname= :canname")
	int getCanId(@Param(value="canname") String canname);

}
