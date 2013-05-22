package com.kiteflo.simpsons.testcases;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kiteflo.simpsons.domain.FavDrink;
import com.kiteflo.simpsons.domain.FavFood;
import com.kiteflo.simpsons.domain.Fear;
import com.kiteflo.simpsons.domain.Habitant;
import com.kiteflo.simpsons.domain.Hobby;
import com.kiteflo.simpsons.repositories.FavDrinkRepository;
import com.kiteflo.simpsons.repositories.FavFoodRepository;
import com.kiteflo.simpsons.repositories.FearRepository;
import com.kiteflo.simpsons.repositories.HabitantRepository;
import com.kiteflo.simpsons.repositories.HobbyRepository;
import com.kiteflo.simpsons.service.FavDrinkService;
import com.kiteflo.simpsons.service.FavFoodService;
import com.kiteflo.simpsons.service.FearService;
import com.kiteflo.simpsons.service.HobbyService;
import com.kiteflo.simpsons.testcases.util.Data;

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
	private HobbyService hobbyService;
	@Autowired
	private HobbyRepository hobbyRepository;
	@Autowired
	private FearRepository fearRepository;
	@Autowired
	private FearService fearService;
	@Autowired
	private FavFoodRepository favFoodRepository;
	@Autowired
	private FavFoodService favFoodService;
	@Autowired
	private FavDrinkRepository favDrinkRepository;
	@Autowired
	private FavDrinkService favDrinkService;
	
	@Test
	public void testPopulateSimpsonsCore()
		throws Exception
	{
		logger.info("Creating hobbies...");
		createHobbies();
		
		logger.info("Creating fears...");
		createFears();
		
		logger.info("Creating favorite foods...");
		createFavoriteFoods();
		
		logger.info("Creating favorite drinks...");
		createFavoriteDrinks();
		
		logger.info("Creating core simpsons...");
		createCoreSimpsons();
		
	}
	
	/**
	 * Create core Simpsons family (Homer, Marge, Lisa, Bart, Maggie)
	 */
	private void createCoreSimpsons()
	{
		// --------------------------------------------------------------
		// homer
		// --------------------------------------------------------------
		Habitant habitant = new Habitant();
		habitant.setFirstname("Homer");
		habitant.setLastname("Simpson");
		habitant.setAge(39);
		habitant.setImageURL(Data.IMAGE_HOMER);
		habitant.setDescription("A big oaf of a father.");
		habitant.setWeight(118.5F);
		habitant.setOccupation("Safety Inspector (Sector 7G) at Springfield Nuclear Power Plant");
		habitant.setCatchPhrase("D'oh!, Mmm..., and Woohoo!");
		
		// add hobbies...
		Page<Hobby> hobbies = hobbyService.findHobbiesLike("Watching TV", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		hobbies = hobbyService.findHobbiesLike("Drinking Beer", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		hobbies = hobbyService.findHobbiesLike("Eating", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		
		// add fears..
		Page<Fear> fears = fearService.findFearsLike("Sock Puppet", null);
		habitant.getFears().add(fears.getContent().get(0));
		
		// add favorite foods...
		Page<FavFood> favFoods = favFoodService.findFavFoodsLike("Donut", null);
		habitant.getFavFoods().add(favFoods.getContent().get(0));
		favFoods = favFoodService.findFavFoodsLike("Pork Chips", null);
		habitant.getFavFoods().add(favFoods.getContent().get(0));
		favFoods = favFoodService.findFavFoodsLike("Honey roasted peanuts", null);
		habitant.getFavFoods().add(favFoods.getContent().get(0));
		
		// add favorite drinks
		Page<FavDrink> favDrinks = favDrinkService.findFavDrinksLike("Duff Beer", null);
		habitant.getFavDrinks().add(favDrinks.getContent().get(0));
		
		simpsonsRepository.save(habitant);
		
		// --------------------------------------------------------------
		// marge
		// --------------------------------------------------------------
		habitant = new Habitant();
		habitant.setFirstname("Marge");
		habitant.setLastname("Simpson");
		habitant.setMaidenName("Bouvier");
		habitant.setAge(34);
		habitant.setImageURL(Data.IMAGE_MARGE);
		habitant.setDescription("Nagging housewife and mother - the backbone of the Simpson family.");
		habitant.setWeight(0F);
		habitant.setOccupation("Housewife/homemaker");
		habitant.setCatchPhrase("Murmur/groan/nagging");
		habitant.setOtherFacts("Has webbed toes");
		
		// add hobbies...
		hobbies = hobbyService.findHobbiesLike("Knitting", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		hobbies = hobbyService.findHobbiesLike("Loom", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		
		// add fears..
		fears = fearService.findFearsLike("Flying", null);
		habitant.getFears().add(fears.getContent().get(0));
		
		// add drinks
		favDrinks = favDrinkService.findFavDrinksLike("Coffee", null);
		habitant.getFavDrinks().add(favDrinks.getContent().get(0));
		
		simpsonsRepository.save(habitant);
		
		// --------------------------------------------------------------
		// bart
		// --------------------------------------------------------------
		habitant = new Habitant();
		habitant.setFirstname("Bart");
		habitant.setLastname("Simpson");
		habitant.setImageURL(Data.IMAGE_BART);
		habitant.setDescription("The troublemaker of the Simpson family.");
		habitant.setAge(10);
		habitant.setOccupation("school boy");
		habitant.setCatchPhrase(" Aye Carumba!, Eat my shorts, I didn't do it!");
		
		// add hobbies...
		hobbies = hobbyService.findHobbiesLike("Skateboarding", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		hobbies = hobbyService.findHobbiesLike("Causing trouble", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		hobbies = hobbyService.findHobbiesLike("Watching TV", null);
		habitant.getHobbies().add(hobbies.getContent().get(0));
		
		// add drinks
		favDrinks = favDrinkService.findFavDrinksLike("Lemonade", null);
		habitant.getFavDrinks().add(favDrinks.getContent().get(0));
		
		simpsonsRepository.save(habitant);
	}
	
	/**
	 * Create hobby nodes...
	 */
	private void createHobbies()
	{
		// watchin TV
		Hobby hobby = new Hobby();
		hobby.setName("Watching TV");
		hobby.setDescription("Sit down, watch TV, be a couch potatoe!");
		hobby.setImageURL(Data.HOBBY_TV);
		hobbyRepository.save(hobby);
		
		// eating
		hobby = new Hobby();
		hobby.setName("Eating");
		hobby.setDescription("Get some food into your stomach!");
		hobby.setImageURL(Data.HOBBY_EATING);
		hobbyRepository.save(hobby);
		
		// drink beer
		hobby = new Hobby();
		hobby.setName("Drinking Beer");
		hobby.setDescription("Get some duff beer into your stomach!");
		hobby.setImageURL(Data.HOBBY_BEER);
		hobbyRepository.save(hobby);
		
		// drink beer
		hobby = new Hobby();
		hobby.setName("Knitting");
		hobby.setDescription("Knitting stuff...");
		hobby.setImageURL(Data.HOBBY_KNITTING);
		hobbyRepository.save(hobby);
		
		// loom
		hobby = new Hobby();
		hobby.setName("Loom");
		hobby.setDescription("Looming...");
		hobby.setImageURL(Data.HOBBY_LOOMING);
		hobbyRepository.save(hobby);
		
		// loom
		hobby = new Hobby();
		hobby.setName("Causing trouble");
		hobby.setDescription("Causing troublke always and anywhere");
		hobby.setImageURL(Data.HOBBY_TROUBLE);
		hobbyRepository.save(hobby);
		
		// skateboarding
		hobby = new Hobby();
		hobby.setName("Skateboarding");
		hobby.setDescription("Riding skateboard always and everywhere");
		hobby.setImageURL(Data.hOBBY_SKATEBOARD);
		hobbyRepository.save(hobby);
	}
	
	/**
	 * Create fear nodes...
	 */
	private void createFears()
	{
		// watchin TV
		Fear fear = new Fear();
		fear.setName("Sock Puppet");
		fear.setDescription("Socks looking like puppets...");
		fear.setImageURL(Data.FEAR_SOCK_PUPET);
		fearRepository.save(fear);
		
		fear = new Fear();
		fear.setName("Flying");
		fear.setDescription("Sitting in a plane and going somewhere...");
		fear.setImageURL(Data.FEAR_PLANE);
		fearRepository.save(fear);
	}
	
	/**
	 * Create favorite food nodes...
	 */
	private void createFavoriteFoods()
	{
		// Donut
		FavFood favFood = new FavFood();
		favFood.setName("Donut");
		favFood.setDescription("Creamy pink donuts...");
		favFood.setImageURL(Data.FAVFOOD_DONUT);
		favFoodRepository.save(favFood);
		
		favFood = new FavFood();
		favFood.setName("Pork Chips");
		favFood.setDescription("Tasty little pork chips...");
		favFood.setImageURL(Data.FAVFOOD_PORKCHIPS);
		favFoodRepository.save(favFood);
		
		favFood = new FavFood();
		favFood.setName("Honey roasted peanuts");
		favFood.setDescription("Yellow, tasty nice little roasted peanuts");
		favFood.setImageURL(Data.FAVFOOD_PEANUTS);
		favFoodRepository.save(favFood);
		
	}
	
	/**
	 * Create favorite food nodes...
	 */
	private void createFavoriteDrinks()
	{
		// Duff beer
		FavDrink favDrink = new FavDrink();
		favDrink.setName("Duff Beer");
		favDrink.setDescription("Tasty cold Duff beer from Springfield!");
		favDrink.setImageURL(Data.FAVDRINK_DUFF);
		favDrinkRepository.save(favDrink);
		
		favDrink = new FavDrink();
		favDrink.setName("Lemonade");
		favDrink.setDescription("Cool lemonade");
		favDrink.setImageURL(Data.FAVDRINK_LEMONADE);
		favDrinkRepository.save(favDrink);
		
		// coffee
		favDrink = new FavDrink();
		favDrink.setName("Coffee");
		favDrink.setDescription("Hot tasty coffee");
		favDrink.setImageURL(Data.FAVDRINK_COFFEE);
		favDrinkRepository.save(favDrink);
	}
}
