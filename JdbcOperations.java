import java.sql.*;
import java.util.*;


public class JdbcOperations
{
	//Statement st=null;
	public static void printTable(Statement st) throws SQLException
	{
		String query ="select *from studs";
		ResultSet rs = st.executeQuery(query);

		while(rs.next())
		{
		  System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
	}
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String uname=sc.nextLine();
		System.out.println("Enter password");
		String pass=sc.nextLine();
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();


				 printTable(st);

		//Statement smt=con.createStatement();
		//smt.executeUpdate("insert into studs values('rohit',45)");

			   

		int id=73;
		String name="Ronaldo";
		//st.executeUpdate("insert into studs values("+id+",'"+name+"')");

		PreparedStatement pt=con.prepareStatement("insert into studs values(?,?)");
		pt.setString(1,name);
		pt.setInt(2,id);

		   
	    System.out.println();
	    printTable(st);
		/*System.out.println();
		System.out.println();
		System.out.println();

		String query1 ="select *from studs";
		ResultSet rs1 = st.executeQuery(query1);

		while(rs1.next())
		{
		System.out.println(rs1.getString(2));
		}*/

		String queryDelete="Delete from studs where age in(20,21,11)";
		st.executeUpdate(queryDelete);
		System.out.println();
		printTable(st);
	    st.close();
		con.close();
	}
}