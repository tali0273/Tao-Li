package com.example.isaia.socialbuff;

/**
 * Created by dominicdeckys on 4/26/17.
 * DO NOT MODIFY THIS FILE
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*
    DO NOT MODIFY THIS FILE PLEASE
 */

public class UserDatabase {
    private List<User> userlist;
    private File dir;
    private static UserDatabase data1;
    private static User currentUser;
    public static void initDatabase(File dir1) {data1 = new UserDatabase(dir1);}
    public static UserDatabase getDatabase() {return data1;}
    public static void setCurrentUser(User u) {currentUser = u;}
    public static User getCurrentUser() {return currentUser;}

    public UserDatabase(File dir1) {
        dir = dir1;
        userlist = new ArrayList<User>();
        parseusers();
        //for (User u: userlist) System.out.println(u.getEmail());
    }
    public boolean addUser(String name1, String email1, String password1, int age1, String major1, int year1) {
        for (User u: userlist) if (u.getEmail().equals(email1)) return false;
        userlist.add(new User(name1, email1, password1, age1, major1, year1, getFreeID()));
        save();
        return true;
    }
    public void save() {
        writeusers();
    }
    public User getUserByEmail(String email) {
        for (User u: userlist) if (u.getEmail().equals(email)) return u;
        return null;
    }
    public User getUserByID(int id) {
        for (User u: userlist) if (u.getID() == id) return u;
        return null;
    }
    public boolean removeUser(int id) {
        for (int t = 0; t < userlist.size(); ++t) {
            if(userlist.get(t).getID() == id) {
                userlist.remove(t);
                save();
                return true;
            }
        }
        return false;
    }

    private int getFreeID() {
        int newid = -1;
        Random random = new Random();
        boolean b = true;
        while (b) {
            newid = random.nextInt(10000) + 1;
            boolean temp = false;
            for (User u: userlist) if (u.getID() == newid) temp = true;
            b = temp;
        }
        return newid;
    }

    private void parseusers() {
        //File file = new File(getFilesDir(), FILENAME);
        File userl = new File(dir, "userlist");
        if (!userl.exists()) {
            userlist.add(new User("Dominic", "dominic.deckys@colorado.edu", "pass", 20, "comp sci", 2019, 420));
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(userl));
            String s;
            while ((s = br.readLine()) != null) {
                String name = s;
                String email = br.readLine();
                String password = br.readLine();
                int age = Integer.valueOf(br.readLine());
                String major = br.readLine();
                int year = Integer.valueOf(br.readLine());
                int id = Integer.valueOf(br.readLine());
                userlist.add(new User(name, email, password, age, major, year, id));
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeusers() {
        //File file = new File(getFilesDir(), FILENAME);
        File file = new File(dir, "userlist");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //fos.write(string.getBytes());
            for (User u: userlist) {
                fos.write((u.getName() + "\n").getBytes());
                fos.write((u.getEmail() + "\n").getBytes());
                fos.write((u.getPassword() + "\n").getBytes());
                fos.write((String.valueOf(u.getAge()) + "\n").getBytes());
                fos.write((u.getMajor() + "\n").getBytes());
                fos.write((String.valueOf(u.getYear()) + "\n").getBytes());
                fos.write((String.valueOf(u.getID()) + "\n").getBytes());
            }
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
