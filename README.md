# VendingMachineTest
  You work for a firm which produces vending machines, currently for the UK
  market. You are responsible for the part of the software which tracks change (as in
  coins) within the vending machines.
  This component needs to provide an API which will:
  
  * Initialise the vending machine to a known state, for use when the machine is set up. This should include setting the initial float (the coins placed in the
  machine for customer change) which should be accepted as a parameter.
  * Register coins that have been deposited by a user.
  * Return the correct change to a user as coins when an order is received (a parameter for the value of a product) and remove the coins from the
    machine.
    
  Your solution should be a command line program (not a GUI) that satisfies the
  requirements and allows us to test it.
  You can implement the solution in a language of your choice that allows you to
  showcase your software abilities (Java, Python, C++, etc).
  
  * Design an API which satisfies the above requirements and justify any design decisions you have made in an accompanying README file
  * Write an implementation of the API, aiming for production-quality code
  * Write an interactive test-harness (command line) that we can use to play with your code
    
  For the purpose of this exercise, you can assume that the vending machine
  software will run continuously, so there is no need to persist any data beyond
  storing it in memory

## Dependencies ##

  * java runtime -> JDK JavaSE-14
  * testing -> Junit 4
  
## Run Application and desciption ##

  1. Start application by compiling `javac App.java` file and execute the file `java App.java`
  2. Inserted Items and Coins are set up automatically by Machine class and by VendingMachineImpl class in initialize method. Initilize method set number
    of coin and Items for Vending Machine
  3. When program start then table of all Items with price and quantities will be printed in terminal
  4. Write name of the Item that is display to make order
  5. Insert coin to make purchase. Only certain coins are accepted so, it is necessary type the name of the coin. Accepted Coins are display in terminal. Otherwise program will terminate.
  6. Question pop out asking if we want another item to buy. Character Y or y is only accepted to take another order otherwise program will be executed to the end and you can not purchase another order.
  7. Total inserted coins and cost is  display with all change.
  
  
  
