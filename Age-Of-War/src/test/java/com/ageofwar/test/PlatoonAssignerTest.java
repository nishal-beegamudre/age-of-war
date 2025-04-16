package com.ageofwar.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.ageofwar.business.logic.PlatoonAssigner;

/**
 * This is the class which tests the algorithm end to end.
 *
 * @author [Nishal Beegamudre]
 */
public class PlatoonAssignerTest {
	
	@Test
	public void assignPlatoonsTestForHappyScenario1() {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
		
		// Have not added an assert statement that matches to the output as there are multiple combination of answers possible.
		assertNotEquals("There is no chance of winning",output);
		
	}
	
	
	@Test
	public void assignPlatoonsTestForHappyScenario2() {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#5;Militia#10;FootArcher#10;LightCavalry#121;HeavyCavalry#61";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
		
		// Have not added an assert statement that matches to the output as there are multiple combination of answers possible.
		assertNotEquals("There is no chance of winning",output);
		
	}
	
	@Test
	public void assignPlatoonsTestForHappyScenario3() {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#10000;Militia#10000;FootArcher#10000;LightCavalry#10000;HeavyCavalry#10000";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
		
		// Have not added an assert statement that matches to the output as there are multiple combination of answers possible.
		assertNotEquals("There is no chance of winning",output);
		
	}
	
	@Test
	public void assignPlatoonsTestForHappyScenario4() {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#5;Militia#10;FootArcher#100;LightCavalry#125;HeavyCavalry#10";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
		
		// Have not added an assert statement that matches to the output as there are multiple combination of answers possible.
		assertNotEquals("There is no chance of winning",output);
		
	}
	
	
	@Test
	public void assignPlatoonsTestForSadScenario1() {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#10;Militia#10;FootArcher#10;LightCavalry#10;HeavyCavalry#10";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
		
		// Have not added an assert statement that matches to the output as there are multiple combination of answers possible.
		assertEquals("There is no chance of winning",output);
		
	}
	
	
	@Test
	public void assignPlatoonsTestForSadScenario2() {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#1;Militia#1;FootArcher#1;LightCavalry#1;HeavyCavalry#1";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
		
		// Have not added an assert statement that matches to the output as there are multiple combination of answers possible.
		assertEquals("There is no chance of winning",output);
		
	}
	

}

