package testconnectivitydatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Workerconnection {
	public static void main(String[] args) {
				Connection co=null;
				PreparedStatement stm=null;
				ResultSet rs=null;
				String sql="SELECT * FROM Worker ";
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
						String id =rs.getString("Worker_id");
						String n=rs.getString("Names");
						String ad=rs.getString("Address");
						String jt=rs.getString("Job_title");
						String ph=rs.getString("Phone_number");
						String sa=rs.getString("Salary");
						String emst=rs.getString("Employment_status");
						String mst=rs.getString("Martial_status");
						String ge =rs.getString("Gender");
						String mng=rs.getString("Manager_id");
						String acc=rs.getString("Accountant_id");
						String adm=rs.getString("Admin_id");
						
						System.out.println(id+"\t"+n+"\t"+ad+"\t"+jt+"\t"+ph+"\t"+sa+"\t"+emst+"\"\t"+mst+"\t"+ge+"\t"+mng+"\t"+acc+"\t"+adm+"\t");
					}
				}catch (ClassNotFoundException e) {
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
					}
				}
				
			}

}











