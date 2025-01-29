Task 1.

This program simulates the operation of a pizza delivery service.
 * The principle of the "Builder" pattern is demonstrated here.
 * Enter the name of the pizza and the ingredients strictly using the case.
 * This is done specifically to focus on the operation of the program during user interaction.

Task 2.

An imitation of a mini-console game has been created.
 * 4 characters, 2 monsters and 4 locations.
 * All actions in the game are random.
 * This game demonstrates the principles of the "Factory" pattern.


1. The Builder pattern.

Description: 
The Builder pattern is used to create complex objects in stages.
It allows you to create different representations of the same type of object using the same construction process.
This pattern separates the construction of an object from its representation, which allows you to create different representations of an object using the same code.

Usage situations:

 * When an object has many parameters, and some of them are optional. The Builder pattern allows you to create an object with various combinations of parameters without having to create multiple constructors.
 * When it is necessary to create an object consisting of several parts or components that can be assembled in various configurations.
 * When the process of creating an object is complex and requires several steps that can be performed in different order.


2. The Factory pattern.

Description: 
The Factory pattern (or Factory Method) defines an interface for creating objects, but allows subclasses to change the type of objects being created.
This pattern allows you to delegate the creation of objects to subclasses, which makes the code more flexible and extensible.

Usage situations:

 * When a class cannot determine in advance which classes it needs to create. For example, if the creation of objects depends on external conditions or configuration.
 * When it is necessary to hide the details of object creation from the client, providing only the interface for creation.
 * When it is necessary to provide the ability to add new types of objects without changing the existing code, which helps to comply with the Open/Closed Principle.
