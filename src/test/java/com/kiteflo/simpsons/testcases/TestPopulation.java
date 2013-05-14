package com.kiteflo.simpsons.testcases;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kiteflo.simpsons.domain.Habitant;
import com.kiteflo.simpsons.domain.VoiceActor;
import com.kiteflo.simpsons.domain.Webpage;
import com.kiteflo.simpsons.repositories.HabitantRepository;
import com.kiteflo.simpsons.repositories.VoiceActorRepository;
import com.kiteflo.simpsons.repositories.WebpageRepository;
import com.kiteflo.simpsons.util.FileManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = false)
public class TestPopulation
{
	// logger
	static final Logger logger = Logger.getLogger(TestPopulation.class);
	
	@Autowired
	private HabitantRepository simpsonsRepository;
	@Autowired
	private WebpageRepository webpageRepository;
	@Autowired
	private VoiceActorRepository voiceActorRepository;

	@Test
	public void testPopulate()
		throws Exception
	{
		logger.info("Popluating graph...");
		
		// add Simspons core
		Webpage webpage = new Webpage();
		webpage.setUrl("http://en.wikipedia.org/wiki/Dan_Castellaneta");
		webpageRepository.save(webpage);
		
		VoiceActor voiceActor = new VoiceActor();
		voiceActor.setFirstname("Dan");
		voiceActor.setLastname("Castellaneta");
		voiceActor.getWeblinks().add(webpage);
		voiceActorRepository.save(voiceActor);
		
		Habitant habitant = new Habitant();
		habitant.setFirstname("Homer");
		habitant.setLastname("Simpson");
		habitant.getVoiceActors().add(voiceActor);
		habitant.setImage(FileManager.convertFileToByteArray(new File("images/01_homer.png")));
		simpsonsRepository.save(habitant);
		
	}
}
