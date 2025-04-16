package com.ageofwar.utility;

import com.ageofwar.entity.child.CavalryArcher;
import com.ageofwar.entity.child.FootArcher;
import com.ageofwar.entity.child.HeavyCavalry;
import com.ageofwar.entity.child.LightCavalry;
import com.ageofwar.entity.child.Militia;
import com.ageofwar.entity.child.Spearmen;
import com.ageofwar.entity.parent.Platoon;

/**
 * This is the utility class used to calculate weight or get instance.
 *
 * @author [Nishal Beegamudre]
 */
public class Utility {
	
	/**
	 * Calculates the weight value being 1 if own strength is more than opponents, 0 if it is equal, -1 if it is less.
	 *
	 * @param numberOfOwnSoldiers The number of own soldiers.
	 * @param numberOfOpponentSoldiers The number of opponent soldiers.
	 * @param opponentStrengthFactor The strength factor of the opponent.
	 * @param ownStrengthFactor The strength factor of the own.
	 * @return Weight value being 1 if own strength is more than opponents, 0 if it is equal, -1 if it is less
	 */
	public static int calculateWeight(int numberOfOwnSoldiers, int numberOfOpponentSoldiers, int opponentStrengthFactor,
			Integer ownStrengthFactor) {
		
		
		if((numberOfOpponentSoldiers*opponentStrengthFactor)<(numberOfOwnSoldiers*ownStrengthFactor)) {
			return 1;
		}else if((numberOfOpponentSoldiers*opponentStrengthFactor)>(numberOfOwnSoldiers*ownStrengthFactor)) {
			return -1;
		}else {
			return 0;
		}
		
	}

	/**
	 * Get the instance of the respective soldierType and input the quantity in the instance as a constructor.
	 *
	 * @param soldierType The soldier type.
	 * @param quantity The number of soldiers.
	 * @return Instance of the soldier based on soldier type
	 */
	public static Platoon getInstanceByString(String soldierType, int quantity) {
		
		switch (soldierType) {
		
		    case "Militia": {
		        return new Militia(quantity);
		    }
		    case "Spearmen": {
		        return new Spearmen(quantity);
		    }
		    case "LightCavalry": {
		        return new LightCavalry(quantity);
		    }
		    case "HeavyCavalry": {
		        return new HeavyCavalry(quantity);
		    }
		    case "FootArcher": {
		        return new FootArcher(quantity);
		    }
		    case "CavalryArcher": {
		        return new CavalryArcher(quantity);
		    }
		    default: {
		    	return null;
		    }
		
		}
		
	}

}
