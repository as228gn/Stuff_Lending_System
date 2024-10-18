# A2

Project for Assignment 2

A project template based on gradle and a gitlab pipeline. You should always build and run the application using gradle regularely.

[design.md](design.md) contains the prescribed architectural design of the application.

## Building
The build must pass by running console command:  
`./gradlew build`  
Note that you should get a report over the quality like:
```
CodeQualityTests > codeQuality() STANDARD_OUT
    0 CheckStyle Issues in controller/App.java
    0 CheckStyle Issues in controller/Simple.java
    0 CheckStyle Issues in model/Simple.java
    0 CheckStyle Issues in view/Simple.java
    0 FindBugs Issues in controller/App.java
    0 FindBugs Issues in model/Simple.java
    0 FindBugs Issues in view/Simple.java
    0 FindBugs Issues in controller/Simple.java
```

Removing or manipulating the code quality checks results in an immediate assignment **Fail**. 

## Running
The application should start by running console command:  
`./gradlew run -q --console=plain`

## Adding Your Own Code
The `Simple` classes project should likely be removed do not forget to also remove the test case associated to `model.Simple`.  

Add your own code to the packages respectively and feel free to add automatic test cases for your own code. A good process is to design a little - code a little - test a little one feature at a time and then iterate.

## Versioning

Versioning is handled with git.

## System test
Adhere to the instructions according to the assigment.

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

Before you start the application you choose what day it is in App. You send in the day in Day as an argument. If you want to change the day during runtime you choose d in the menu and send in the day you want it to be.
When a member is created it has 0 credits, when a member creates an item it gets 100 credits.  
You pay your credits in beforehand so as soon as a contract is being created the funds are deducted from the lender and paid to the owner.