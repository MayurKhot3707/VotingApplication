package com.example.repository;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.entity.user;

@Repository
@Transactional
public interface userRepository extends JpaRepository<user,Integer> 
{

	@Query("select u from user u where u.userid=:uid")
	user findByUid(@Param(value = "uid") int uid);
	
	@Modifying
	@Query("update user u set u.candidateid =:canid where u.userid= :uid")
	void usersvote(@Param(value="uid") int userid,@Param(value="canid") int candidateid);
	
	@Modifying
	@Query("update candidate c set c.votecount = c.votecount + 1 where c.canid= :candidateid")
	void addvote(@Param(value="candidateid") int candidateid);

	user findByUsernameAndPassword(String username, String password);
	
	@Modifying
	@Query("select u.username from user u where u.candidateid= :candidateid")
	List<String> getVoteUsers(@Param(value = "candidateid") int candidateid);
	
	
}