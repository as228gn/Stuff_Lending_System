# A2

Project for Assignment 2

[design.md](design.md) contains the prescribed architectural design of the application.

## Running
The application starts by running console command:  
`./gradlew run -q --console=plain`

## Versioning

Versioning is handled with git.

## System test
See the [TestReport](testreport.md).

## Handing In
Adhere to the instructions according to the assigment.

## Usage
The day of creation is chosed in App.java. Before you start the application you set the desired day in Day.  
When the application starts you will see a menu as follows.  

Welcome to the stuff lending system!  
Press c to create a member:  
Press dm to delete a member:  
Press um to update a member:  
Press vm to view a member:  
Press vam to view all members  
Press vami to view all members and their items:  
Press i to create an item:  
Press di to delete an item:  
Press ui to update an item:  
Press vi to view an item:  
Press l to lend an item:  
Press q to quit:  
  
There will be 3 hardcoded members in the system when you start.  
You chose from the menu what you would like to do and the system gives you instructions of what it needs to know to perfom the tasks.  

If you want to change the day during runtime you choose d in the menu and send in the day you want it to be.
When a member is created it has 0 credits, when a member creates an item it gets 100 credits.  
You pay your credits in beforehand so as soon as a contract is being created the funds are deducted from the lender and paid to the owner.