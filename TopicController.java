package com.springboot.namedquery;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController

public class TopicController {
	
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private TopicRepository topicRepository;
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable int id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable int id)
	{
		topicService.updateTopic(topic,id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable int id)
	{
		 topicService.deleteTopic(id);
	}
	
	@RequestMapping("/getTopicByName")
	public List<Topic> findTopicByName(@RequestParam String name)
	{
		return topicRepository.findByName(name);
		
	}
	
	//using named query
	@RequestMapping("/getTopicByDescriptionSortedByTicketPrice")
	public List<Topic> findTopicByDescriptionSorted(@RequestParam String description)
	{
		return topicRepository.findByDescriptionSorted(description);
	}
	
	//using native query
	@RequestMapping("/getTopicByDescriptionSortedById")
	public List<Topic> findTopicByDescription(@RequestParam String description)
	{
		return topicRepository.findTopicByDescription(description);
	}
	
	//using @NamedNative
	@RequestMapping("/getTopicByNameSortedById")
	public List<Topic> findByNameSortedById(@RequestParam String name)
	{
		return topicRepository.findTopicByNameSortedById(name);
	}
	
	@GetMapping(value="/getTopicsUsingEntityManager/{name}/{description}")
	public List<Topic> getTopicsUsingEntityManager(@PathVariable("name") String name,
													@PathVariable("description") String description)
	{
		List<Topic> demoList= topicService.getTopicsUsingEntityManager(name, description);
		return demoList;
	}
	
}
