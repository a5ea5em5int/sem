package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class App
{ Logger log=Logger.getLogger("App");
    Connection con = null;
    public void getPopbyCountries(){


    }
    public void getCity(String ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode ,Population"
                            + "FROM city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.setId(rset.getString("ID"));
                city.setName( rset.getString("Name"));

                System.out.println("City Information");
                System.out.println(city);

            }
            else
                System.out.println("invalid id code");
        }
        catch (Exception e)
        {   log.info(e.getMessage());
           // System.out.println(e.getMessage());
            System.out.println("Failed to get city details id code problem");

        }
    }
    /**
     * Connection to MySQL database.
     */


    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public   ArrayList<Country> getCountriesByPopulation()
    {
        ArrayList<Country> countries=new ArrayList<Country>();
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "select code, name, population, continent ,region from country order by population desc limit 10";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while(rset.next())
            { System.out.println(rset.getString(1));
                Country ctry = new Country();
                ctry.setCode(rset.getString("code"));
                ctry.setName( rset.getString("name"));
                ctry.setContinent(rset.getString("continent"));
                ctry.setPopulation(rset.getInt("population"));
                ctry.setRegion(rset.getString("region"));
                //System.out.println("************City Information**************");

                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()+"\n"+e.getStackTrace()+"\n"+e.getLocalizedMessage());
            System.out.println("Failed to get country details");
            return countries;
        }


    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        //a.getCity("3718");
        System.out.println("Hihihhihihihih");
        ArrayList<Country> countries =new ArrayList<Country>();
        countries=a.getCountriesByPopulation();

        for (Country c:countries){

            System.out.printf("%s  %s %20d",c.getName(),c.getContinent(),c.getPopulation());
            System.out.println();


    }
       // System.out.println(countries);
        // Disconnect from database
        a.disconnect();

    }
}