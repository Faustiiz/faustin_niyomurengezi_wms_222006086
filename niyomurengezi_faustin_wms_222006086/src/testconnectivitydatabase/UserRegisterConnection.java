package testconnectivitydatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegisterConnection {

	public static void main(String[] args) {
				Connection co=null;
				PreparedStatement stm=null;
				ResultSet rs=null;
				String sql="SELECT * FROM userregister ";
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
						String id =rs.getString("user_id");
						String fn=rs.getString("first_name");
						String ln=rs.getString("last_name");
						String un=rs.getString("user_name");
						String pa=rs.getString("password");
						String em=rs.getString("email_id");
						String mb=rs.getString("mobile_number");
						
						
						System.out.println(id+"\t"+fn+"\t"+ln+"\t"+un+"\t"+pa+"\t"+em+"\t"+mb+"\t");
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






