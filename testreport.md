# Test Specification: Stuff Lending System

## Test Cases

### 5.1 Member Data

- **Requirement**: 5  
  1. Check that there are at least 3 members.
  2. Check that one member (Joe) has 100 credits. Joe has one item for lending, Pot with a cost of 60.
  3. Check that one member (Sara) has 200 credits and two items for lending, Ball with a cost of 5 and "Harry Potter" with a cost of 10.
  4. Check that one member (Benny) has 0 credits and no items.
  5. Check that Joe has an active lending contract for Ball that starts on day 7 and ends on day 10.

### 1.1 Create Member

- **Requirements**: 1.1, 1.1.1, 1.4  
  1. Create a member with name: "Allan Turing", email: "allan@enigma.com", phone: "123456".
  2. Check that the member is created correctly with an ID according to the requirement by checking the member's full information.
  3. Quit the application.

### 1.2 Create Member - Duplicate Email and Phone

- **Requirements**: 1.1, 1.1.1, 1.1.2, 1.4  
  1. Create a member with name: "Allan", email: "allan@enigma.com", phone: "123456".
  2. Check that the member is created correctly with an ID according to the requirement.
  3. Create a member with name: "Turing", email: "allan@enigma.com", phone: "123".
  4. Check that the member is not created (duplicate email).
  5. Create a member with name: "Turing", email: "turing@enigma.com", phone: "123456".
  6. Check that the member is not created (duplicate phone).
  7. Create a member with name: "Turing", email: "turing@enigma.com", phone: "123".
  8. Check that the member is created correctly.
  9. Quit the application.

### 1.3 Delete Member

- **Requirements**: 1.1, 1.1.1, 1.1.2, 1.2, 1.4  
  1. Create a member with name: "Allan", email: "allan@enigma.com", phone: "123456".
  2. Check that the member is created correctly with an ID according to the requirement.
  3. Delete the member.
  4. Check that the member is deleted by listing all members.
  5. Create a member with name: "Allan", email: "allan@enigma.com", phone: "123456".
  6. Check that the member is created correctly with an ID according to the requirement.
  7. Quit the application.

### 2.1 Create Item

1. Create an item for a member.
2. Check that the item is created and part of the member's items by inspecting the member's details.
3. Check that the owner member has increased their credits by 100.

### 2.2 Delete Item

1. Select a member with one or several items.
2. Delete one of the member's items that is not involved in any contract.
3. Check that the item was deleted from the member's owned items.

### 2.3 Delete Item

1. Select a member with one or several items.
2. Delete one of the member's items that is booked (i.e., a future contract).
3. Check that the item was deleted from the member's owned items.
4. Check that the contract was canceled.

### 3.1 Create Contract

1. Create a contract for I2 lending to M2, 3 days of lending, from day 1 to and including day 3.
2. Check that the contract was created.

### 3.2 Create Contract - Not Enough Funds

1. Create a contract for I1 lending to M2, 3 days of lending, from day 1 to and including day 3.
2. Check that the contract was not created due to lack of funds.

### 3.3 Create Contract - Conflicting Time

1. Create a contract for I2 lending to M2, 3 days of lending, from day 4 to and including day 6.
2. Check that the contract was not created due to conflicting time.

### 3.4 Create Contract - Conflicting Time

1. Create a contract for I2 lending to M2, 3 days of lending, from day 6 to and including day 9.
2. Check that the contract was not created due to conflicting time.

### 3.5 Create Contract - Conflicting Time

1. Create a contract for I2 lending to M2, 3 days of lending, from day 4 to and including day 9.
2. Check that the contract was not created due to conflicting time.

### 3.6 Create Contract - Conflicting Time

1. Create a contract for I2 lending to M2, 3 days of lending, from day 6 to and including day 6.
2. Check that the contract was not created due to conflicting time.

### 4.1 Advance Time

1. Advance the time by 8 days.
2. Check that the contract has been fulfilled and that funds have been deducted from M3, who now has 70 credits.

### Test Report

Version 1
Date: 2024.10.10  
Environment: Windows, Java version 18.  
Performed by: Anna Ståhlberg

| Case | Result | Note                        |
|------|--------|-----------------------------|
| 5.1  |   ok   |                             |
| 1.1  |   ok   |                             |
| 1.2  |   ok   |                             |
| 1.3  |   ok   |                             |
| 2.1  |        |                             |
| 2.2  |        |                             |
| 2.3  |        |                             |
| 3.1  |        |                             |
| 3.2  |        |                             |
| 3.3  |        |                             |
| 3.4  |        |                             |
| 3.5  |        |                             |
| 3.6  |        |                             |
| 4.1  |        |                             |