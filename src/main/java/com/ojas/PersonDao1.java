package com.ojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao1 {
    Connection getConnection() {
        Connection con = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "Rayuduroyal@58");
			System.out.println("Connected");
        }
        catch (Exception e) {
           
            System.out.println(e);
        }
        return con;
       
    }
   
    public boolean addPerson(Person person) {
        boolean b=false;
        try{
            Connection con=getConnection();
            PreparedStatement pst=con.prepareStatement("insert into person"+"(ename,contactno,email,gender,address)"+"values(?,?,?,?,?)");
            pst.setString(1, person.getEname());
            pst.setString(2, person.getContactno());
            pst.setString(3, person.getEmail());
            pst.setString(4,person.getGender());
            pst.setString(5,person.getAddress());
            int res=pst.executeUpdate();
          
            if(res>0){
                b=true;
             
            }
         
        }
        catch(Exception e){
            System.out.println(e);
        }
        return b;
           
    }
    public boolean validate(String uname,String upass) {
        boolean b=false;
        try{
            Connection con = getConnection();
            PreparedStatement pst=con.prepareStatement("select * from person where ename=? and contactno=?");
            pst.setString(1, uname);
            pst.setString(2, upass);
            ResultSet res=pst.executeQuery();
            if(res.next()){
                b=true;
            }
        }
            catch(Exception e){
                System.out.println(e);
            }
            return b;
        }
    public boolean deletePerson(int num) {
        boolean b = false;
        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement("delete from person where pid=?");
            pst.setInt(1, num);
            int res = pst.executeUpdate();
            if(res > 0) {
                b = false;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return b;
    }
    
    public List<Person> listPerson() {
        List<Person> list=new ArrayList<Person>();
       try {
           Connection con = getConnection();
           PreparedStatement pst = con.prepareStatement("Select * from person");
           ResultSet res = pst.executeQuery();
           while (res.next()) {
				Person p = new Person(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6));
				list.add(p);
			}
       } catch (Exception e) {
           System.out.println(e);
       }
    return list;
    }
        }