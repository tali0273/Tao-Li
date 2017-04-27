# Database Tutorial
This is an overview on how to use our custom built Database api to manage users. There are two types of objects, UserDatabase and User. UserDatabase stores and manages everything and User just represents a single user that you can get information from.
```java
UserDatabase database = UserDatabase.getDatabase();
User user = UserDatabase.getCurrentUser();
```
This gets the database and the current user from anywhere in the app!
### Things you can do to UserDatabase
```java
//Things you can do to database
database.getUserById(int id); //returns a User object
database.getUserByEmail(String email); //returns a User object
database.addUser(String name, String email, String password, int age, String major, int year);
//returns true if the user was added, false if user already exists.
database.removeUser(int id);
//removes a user by their ID
database.addMessage(User u, String message);
//adds a message to the global message board
database.getRecentMessage(int n);
//returns a string containing the nth most recent message
database.getRecentMessage(1);
//gets the most recent message
```
### Things you can do to User objects
Remember to check if a user is null after looking them up in the database!
```java
//Things you can do to User objects
user.getName()
user.getAge()
user.getMajor()
user.getYear()
user.getID()
user.getEmail()
user.getPassword()
```
### Example usage:
```java
UserDatabase database = UserDatabase.getDatabase();
database.addUser("Dom", "dom@colorado.edu", "password", 20, "comp sci", 2019);
User userdom = database.getUserByEmail("dom@colorado.edu");
System.out.println(userdom.getMajor());
//should print "comp sci"
```
