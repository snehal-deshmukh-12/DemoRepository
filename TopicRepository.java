package com.springboot.namedquery;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends JpaRepository<Topic , Integer>, JpaSpecificationExecutor<Topic>{
	Optional<Topic> findById(int id);
	List<Topic> findByName(String name);
	List<Topic> findByIdGreaterThan(int id);
	void deleteById(int id);
	
	//using named query
	List<Topic> findByDescriptionSorted(String description);
	
	//using native query
	@Query(value="select * from Topic t where t.description= ?1 and t.id>2", nativeQuery=true )
	List<Topic> findTopicByDescription(String description);
	
	//using @NamedNative
	List<Topic> findTopicByNameSortedById(String name);
	
	
}
