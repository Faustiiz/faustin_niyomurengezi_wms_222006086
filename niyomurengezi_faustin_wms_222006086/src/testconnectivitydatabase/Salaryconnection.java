package testconnectivitydatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Salaryconnection {
		public static void main(String[] args) {
						Connection co=null;
						PreparedStatement stm=null;
						ResultSet rs=null;
						String sql="SELECT * FROM Salary ";
						String host="jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
						String user="root";
						String pass="";
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							co=DriverManager.getConnection(host,user,pass);
							stm=co.prepareStatement(sql);
							rs=stm.executeQuery();
							while(rs.next()) {
								//int id =rs.getInt(0);
								String id =rs.getString("Salary_id");
								String jb=rs.getString("Job_id");
								String am=rs.getString("Amount");
								String mo=rs.getString("Monthly");
								String ex=rs.getString("Extra");
								String jt=rs.getString("job_title");
								
								System.out.println(id+"\t"+jb+"\t"+am+"\t"+mo+"\t"+ex+"\t"+jt+"\t");
							}}
							catch (ClassNotFoundException e) {
							System.out.println("An error occurred while loading the JDBC driver");
						} catch (SQLException e) {
							System.out.println("There was an error accessing the database.");
						}finally {
							try {
								if (co != null) {
									co.close();
								}
							} catch (SQLException e) {
								System.out.println("There was an error accessing the database.");
							}}}}






