# Javamon
 An extremely simple Pokémon game simulator written in Java language with OOP concepts.

The idea is to play a mini game where you choose one of 3 pokémons (Bulbasaur🍃, Charmander🔥 or Squirtle💧) and battle other pokémon that randomly "appear" to get experience and evolve into stronger pokémon.

Almost everything in this game is made based on OOP concepts. Pokémon species, moves used in battle and even the battles are classes with atributes and methods.

The game events happen through a loop structure. The player has 3 options: walk, heal the pokémon or finish the game. Each time the player walks he has a chance to start a battle with a random pokémon (which can be of one of the three species mentioned above), if he wins, the pokémon gains experience. When the pokémon is out of health points, the plays must choice the "heal" option to continue battling. And when the player chooses the "finish" option the game ends and shows all the pokémon status (attributes).

Current state:

For now, I've created the abstract class "Pokemon", and based on it I've created one subclass for one of the three pokémon species, the class "Bulbasaur". I'm now working on the "Move" class (which will be the move a pokémon can use in battle) and the "Challenge" class, in which we'll have the "battle" method. If it works, the next step will be to create the other 2 pokémon species and implement type effectiveness in battles.
