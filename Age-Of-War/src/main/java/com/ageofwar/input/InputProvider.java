package com.ageofwar.input;

import com.ageofwar.business.logic.PlatoonAssigner;

public class InputProvider {

	public static void main(String[] args) {
		
		PlatoonAssigner platoonAssigner = new PlatoonAssigner();
		
		String ownPlatoons = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		/*String ownPlatoons = "Spearmen#1;Militia#1;FootArcher#1;LightCavalry#1;HeavyCavalry#1";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";*/

		/*String ownPlatoons = "Spearmen#10;Militia#10;FootArcher#10;LightCavalry#10;HeavyCavalry#10";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";*/
		
		/*String ownPlatoons = "Spearmen#10000;Militia#10000;FootArcher#10000;LightCavalry#10000;HeavyCavalry#10000";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";*/
		
		/*String ownPlatoons = "Spearmen#5;Militia#10;FootArcher#100;LightCavalry#125;HeavyCavalry#10";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";*/
		
		/*String ownPlatoons = "Spearmen#5;Militia#10;FootArcher#10;LightCavalry#121;HeavyCavalry#61";
		String opponentPlatoons = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";*/
		
		
		String output = platoonAssigner.assignPlatoons(ownPlatoons, opponentPlatoons);
		System.out.println("Output is \n"+output);
	}

}
