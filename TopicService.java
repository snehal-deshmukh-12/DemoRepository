package com.springboot.namedquery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private EntityManagerFactory em;
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	public Optional<Topic> getTopic(int id)
	{
		return topicRepository.findById(id);
	}
	@Transactional(rollbackFor= {RuntimeException.class})
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	public void updateTopic(Topic topic, int id) {

		topicRepository.save(topic);
		
		
	}
	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
	}
	
	public void findTopicByName(String name)
	{
		topicRepository.findByName(name);
	}
	
	public List<Topic> getTopicsUsingEntityManager(String name, String description) {
		// TODO Auto-generated method stub
		QueryUtil queryUtil= new QueryUtil();
		EntityManager entityManager = em.createEntityManager();
		String queryString = queryUtil.createQueryForNames(name,description);
		Query query = entityManager.createQuery(queryString);
		List<Topic> demoList =query.getResultList();
		return demoList;	
	}
	

}