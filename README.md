
Age Of War
=====================================

This is a war strategy algorithm which takes input of home side and enemy side's soldier types and their total numbers and gives an output strategy to optimize winning the battles. There are 6 types of soldiers defined.

- Militia
- Spearmen
- Light Cavalry
- Heavy Cavalry
- Foot Archer
- Cavalry Archer

Each soldier type has its own strengths over particular other types. Based on those inputs, the strategy will be decided.

## Rules

Home side has to win at least 3 battles. If not, it needs to give an output String with value "There is no chance of winning".
Each class of soldier has an advantage over other classes of soldiers.

* **| Soldier Type  |    Has advantage over		|**

* | Militia       | Spearmen, LightCavalry		|
* | Spearmen      | LightCavalry, HeavyCavalry		|
* | LightCavalry  | FootArcher, CavalryArcher		|
* | HeavyCavalry  | Militia, FootArcher, LightCavalry	|
* | CavalryArcher | Spearmen, HeavyCavalry		|
* | FootArcher    | Militia, CavalryArcher		|<br />

The soldiers who have advantage over the opponent, will be able to handle twice the amount of opponent's soldiers
If your platoon has 100 Spearmen and your opponent's platoon has:
* 199 HeavyCavalry - You Win
* 200 HeavyCavalry - Draw
* 201 HeavyCavalry - You Lose

## Input Format

The input to the problem statement is the list of platoons that you have with their classes and number of units in the first line
The second line contains the list of platoons of the opponent (PlatoonClasses#NoOfSoldiers)

Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100

The output of the program should be to give a sequence in which you should arrange your platoons so that you win atleast 3 of the 5 battles.
There could be multiple winning arrangements, it is enough to print one of the possible arrangements
If there is no possibility to get atleast 3 out of 5 wins in any arrangement, it should intimate that with an error message that "There is no chance of winning"

## Sample Input and Output

**Input:**
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100

**Output:**
Militia#30;FootArcher#20;Spearmen#10;LightCavalry#1000;HeavyCavalry#120

There are multiple winning combinations possible.
Most optimized winning combination is,
Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120;Spearmen#10

Here, out of 5, 4 battles can be won.

* **| Own team           |    Opponent team      |     Strength of Soldier Type   |   Verdict  |**

* | Militia 30         |     Militia 10        |        Same soldier type       |   Win	   |
* | Foot Archer 20     |    Spearmen 10        |        Equal Strength          |   Win	   |
* | Light Cavalry 1000 |  Foot Archer 1000     |     Light Cavalry is stronger  |   Win	   |
* | Heavy Cavalry 120  |  Light Cavalry 120    |     Heavy Cavalry is stronger  |   Win	   |
* | Spearmen 10        |  Cavalry Archer 120   |     Cavalry Archer is stronger |   Lose   |


## Implementation

* Implementation involves OOP's inheritance concept on the modelling part. Parent class 'Platoon' has an integer variable 'numberOfSoldiers' and a Map<String,Integer> as a strength factor map. There is a method that takes input String and provides the respective integer value from that map - getStrengthFactor.

&nbsp Platoon Class - 

* This parent class has been inherited by respective soldier types Militia, Spearmen, FootArcher, LightCavalry, HeavyCavalry, CavalryArcher classes. The method 'getStrengthFactor' has been overridden in each class where it is pointing to the respective class's Map<String,Integer> value. Setting strength factor has been disabled by making the variable private and no setter is being used. Map variable takes a sample input as shown below. This is for LightCavalry which has strength over FootArcher and CavalryArcher.<br />
            &nbsp strengthFactorMap.put("Militia", 1);<br />
	    &nbsp strengthFactorMap.put("Spearmen", 1);<br />
	    &nbsp strengthFactorMap.put("LightCavalry", 1);<br />
	    &nbsp strengthFactorMap.put("HeavyCavalry", 1);<br />
	    &nbsp strengthFactorMap.put("FootArcher", 2);<br />
	    &nbsp strengthFactorMap.put("CavalryArcher", 2);<br />
As it has more strength over Foot Archer and Cavalry Archer, their integer values are being shown as '2'.<br />

<br />&emsp; Militia Class -
<br />&nbsp Spearmen Class -
<br />&nbsp LightCavalry Class -
<br />&nbsp HeavyCavalry Class -
<br />&nbsp FootArcher Class -
<br />&nbsp CavalryArcher Class -

* A utility class has been formed which has 2 static methods.
  1) getInstanceByString : It acts similar to a factory method in Factory Design Pattern which takes an input string type and provides the respective instance of the soldier type class. It also takes number of soldiers as input and adds it to the variable.
  2) calculateWeight : It takes input of number of soldiers of own team, number of soldiers of opponent team, strength factor of own team, strength factor of opponent team. It checks if own team is stronger, equal or weaker than opponent team. If own team is stronger, then it returns 1. If it is equal, then it returns 0. If opponent is stronger, it returns -1.

&nbsp Utility Class -

* Platoon Assigner: This class has the main business logic. It extensively uses Stream API, Data Structures (Collection Framework), exception handlers to optimize the readability and speed. It takes inputs and provides the output in the String format.

&nbsp Platoon Assigner Class -

* Platoon Assigner Test : This class has sample input and output test cases. As there are multiple outputs possible, test assertions have been based on whether at least 3 battles can be won or not.

&nbsp Platoon Assigner Test Class -

* Input Provider : This class has main method inside which PlatoonAssigner class will be instantiated and its method will be called along with own and opponent inputs.

&nbsp Input Provider Class -

## Assignment Logic:

* It takes input strings and converts them into a Map<String,Integer> referring Soldier Type -> number of soldiers, using Stream API.
* It traverses around all own and opponent soldier types in order to find every combination of winning that is possible. It uses getInstance method to get instances of own and opponent types, fetches the strength factor and hits calculateWeight method to find out whether a particular combination of own vs opponent soldier type can be won or lost. By traversing around all possible combinations, it creates a map of Opponent Soldier Type -> List of Own Soldier Types which can win the battle.
* Now the challenge is to map them accordingly and create an output.
  1) If a particular soldier type is used against an opponent type, then we cannot use it for another opponent type.
  2) We need to get the best possible combination so that most number of battles can be won.
  3) Edge case scenario: Imagine that there is one opponent type which can be won by using Militia and Spearmen. There is another opponent type which can be won only by Militia. In this scenario, if our logic first checks the first one which has 2 options & picks Militia, then second one will be left with nothing. So, it is important that the logic should pick the second one and assign Militia, then pick the first one and assign Spearmen.
* In order to achieve these above challenges, the logic will start traversing according to the insertion order of the opponent type given in the input. It goes through multiple iterations so that it prioritizes those opponent types which have only one possible winning combination & assigns them accordingly. Then, it picks up those opponents which cannot be won. After that, it dynamically removes already assigned own soldier types and then assigns the remaining ones accordingly to the opponent types which had more than 1 winning combination. In this way, winning combination is optimized such that most number of battles can be won.
* If in case 3 or more than 3 battles cannot be won, then it returns a String "There is no chance of winning".


## Developer

* Nishal Beegamudre

</br></br><a  href="https://www.linkedin.com/in/nishal-beegamudre/" target="_blank"><img alt="LinkedIn" src="https://img.shields.io/badge/linkedin%20-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" /></a>
