package edu.du.cs.ladwells.db.dao;

import java.sql.*;

public class HenryDAO {
	
	private String db_url = "jdbc:mysql://localhost/comp3421";
	private final String user = "root";
	private final String pass = "test";
	
	protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
	protected Statement statement = null;
    protected ResultSet resultSet = null;

    public void connect()
    {
        try{
            //Class.forName("org.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db_url,user,pass);
        }catch(SQLException e)
        {
            System.out.println("Somethings wrong! Check connection");

        }
    }

    public void dispose()
    {
        try{
            if(!resultSet.equals(null))
            {
                if(!resultSet.isClosed())
                    resultSet.close();
            }

            if(!statement.equals(null))
            {
                if(!statement.isClosed())
                    statement.close();
            }

            if(!connection.equals(null))
            {
                if(!connection.isClosed())
                    connection.close();
            }
        }catch(SQLException e)
        {
            System.out.println("Could not close");
        }
    }

}
