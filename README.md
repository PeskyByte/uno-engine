# **Uno Game Engine**

## Project Overview:
This project focuses on developing a customizable Uno game engine using Java and object-oriented programming principles. The game engine will serve as a foundation for building various Uno game variations, making it easy for developers to implement new rules, cards, and gameplay mechanics while retaining the core functionalities of Uno. The project will incorporate an abstract class `Game`, which will provide the base for creating different variations of the game with minimal effort.

## Objectives:
- Build an Uno game engine that adheres to the official rules of the basic Uno game while allowing for easy modification and extension.
- Provide developers with a flexible framework to create new Uno variations by extending the abstract `Game` class and customizing its features.
- Minimize development effort by offering a predefined set of game rules that can be selected and used by developers.
- Include a simulation mechanism via the `play()` method that runs the game, ensuring that the gameplay adheres to the selected set of rules.

## Key Features:
1. **Abstract `Game` Class**: 
   - The core component of the engine. Developers can extend this class to implement their own game variations. This allows for scalability and modularity, as new rules or features can be easily integrated by implementing the necessary abstract methods.
   
2. **Predefined Game Rules**: 
   - The engine will include a set of predefined rules, such as the number of cards dealt at the start, penalty mechanisms, and special card behaviors. Developers can choose from these rules to create their own versions of the game without starting from scratch.

3. **Extensibility**: 
   - The game engine is designed with future flexibility in mind. Developers can introduce new game rules, wild cards, or even different card-dealing mechanisms with minimal coding effort. The system supports easy extension of the base code to accommodate new features.

4. **Simulation through `play()` Method**: 
   - The `Game` class includes a `play()` method that simulates the entire gameplay experience. This method ensures that the game follows the defined rules and mechanics. 

5. **Game Variations**: 
   - As a proof of concept, the engine will include at least one real variation of the Uno game. This demonstrates the flexibility and extensibility of the framework and provides a template for future variations.

6. **Driver Class**: 
   - A `GameDriver` class will be included, containing the main method. This class will instantiate a game object and invoke the `play()` method, allowing for a smooth and straightforward game simulation.

