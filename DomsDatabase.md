# Database Tutorial
This is an overview on how to use the Database api to manage users
```java
UserDatabase database = UserDatabase.getDatabase();
User user = UserDatabase.getCurrentUser();
```
This gets the database and the current user from anywhere in the app!
```java
//Things you can do to database
database.getUserById(int); //returns a User object
database.getUserByEmail(String); //returns a User object
database.addUser(String name, String email, String password, int age, String major, int year);
//returns true if the user was added, false if user already exists.
database.removeUser(int id);
//removes a user by their ID
```
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
