package entityforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserRegister {

	
				private int user_id;
				private String first_name;
				private String last_name;
				private String username;
				private String password;
				private String email_id;
				
				private String mobile_number;
				
				
				
				public UserRegister() {}
				public UserRegister(int id,String first_name,String last_name,String username,String password,String email_id, 
						String mobile_number) {
					this. user_id =id;
					this.first_name= first_name;
					this.last_name=last_name;
					this.username=username;
					this.password =password;
					this.email_id=email_id;
					
					this.mobile_number=mobile_number;
					
				}
				public UserRegister( String first_name, String last_name, String username,String password,String email_id, 
						String mobile_number) {
					
					this.first_name = first_name;
					this.last_name =last_name;
					this.username= username;
					this.password=password;
					this.email_id=email_id;
					
					this.mobile_number=mobile_number;
					
				}
				
				public int getuser_id() {
					return user_id;
				}
				public int getUser_id() {
					return user_id;
				}
				public void setUser_id(int user_id) {
					this.user_id = user_id;
				}
				public String getFirst_name() {
					return first_name;
				}
				public void setFirst_name(String first_name) {
					this.first_name = first_name;
				}
				public String getLast_name() {
					return last_name;
				}
				public void setLast_name(String last_name) {
					this.last_name = last_name;
				}
				public String getusername() {
					return username;
				}
				public void setusername(String username) {
					this.username = username;
				}
				public String getPassword() {
					return password;
				}
				public void setPassword(String password) {
					this.password = password;
				}
				public String getEmail_id() {
					return email_id;
				}
				public void setEmail_id(String email_id) {
					this.email_id = email_id;
				}
				public String getMobile_number() {
					return mobile_number;
				}
				public void setMobile_number(String mobile_number) {
					this.mobile_number = mobile_number;
				}
				public void setuser_id(int user_id) {
					this.user_id = user_id;
				}
				public String getfirst_name() {
					return first_name;
				}
				public void setfirst_name(String fname_) {
					this.first_name = fname_;
				}
				public String getlast_name() {
					return last_name;
				}
				public void setlast_name(String last_name) {
					this.last_name = last_name;
				}
				public String getusername1() {
					return username;
				}
				public void setusername1(String username) {
					this.username = username;
				}
				public String getpassword() {
					return password;
				}
				public void setpassword(String password) {
					this.password = password;
					
				}
					
					public String getemail_id() {
						return email_id;
					}
					public void setemail_id(String email_id) {
						this.email_id = email_id;
					}
					
					
					public String getmobile_number() {
						return mobile_number;
					}
					public void setmobile_number(String mobile_number) {
						this.mobile_number = mobile_number;
					}
					
				
				public void makeconnection() {
				}
				public void insertData() {
					// JDBC URL, userfirst_name, and password of MySQL server
				    String host = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    String user = "root";
				    String password = "";

				    // SQL query to insert data
				    String sql = "INSERT INTO userregister (first_name, last_name, username, password, email_id,mobile_number)VALUES (?,?,?,?,?,?)";

				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
				    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, this.first_name);
				        preparedStatement.setString(2, this.last_name);
				        preparedStatement.setObject(3, this.username);
				        preparedStatement.setString(4, this.password);
				        preparedStatement.setString(5, this.email_id);
				        preparedStatement.setString(6, this.mobile_number);
				       
				        // Execute the query
				        int rowsAffected = preparedStatement.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				        	System.out.println("Data inserted successfully!");
				            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            System.out.println("Failed to insert data.");
				            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

				        }
				    
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }	
				}

				public void readwithID(int inputid) {
					// JDBC URL, userfirst_name, and password of MySQL server
				    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    

				    String user = "root";
				    String password = "";

				    // SQL query to select all columns from student where id = ?
				    String sql = "SELECT * FROM userregister WHERE user_id = ?";

				    try (
				        // Establish the connection
				        Connection connection = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement preparedStatement = connection.prepareStatement(sql);
				    ) {
				        // Set the value for the parameterized query
				        //int userregisterId = 1; // Replace with the desired userregister id
				        //if()
				    	preparedStatement.setInt(1, inputid);

				        // Execute the query and get the result set
				        ResultSet resultSet = preparedStatement.executeQuery();
				    
				        // Process the result set
				        while (resultSet.next()) {
				        	this.setuser_id(resultSet.getInt("user_id"));
				           this.setfirst_name(resultSet.getString("first_name"));
				           this.setlast_name(resultSet.getString("last_name"));
				           this.setusername(resultSet.getString("username"));
				           this.setpassword(resultSet.getString("password"));
				           this.setemail_id(resultSet.getString("email_id"));
				           this.setmobile_number(resultSet.getString("mobile_number"));
				          
				            }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
				public void update(int inputuser_id) {
					// JDBC URL, userfirst_name, and password of MySQL server
				    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    String user = "root";
				    String password = "";

				    // SQL query to update data
				    String sql = "UPDATE userregister SET  first_name= ?,last_name = ?,username= ?,password= ?,email_id= ?,mobile_number =? WHERE user_id=?";
				    		try (
				        // Establish the co
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement pl = co.prepareStatement(sql);
				    ) {
				        // Set the new values for the update
				    	  pl.setString(1, this.getfirst_name());
				        pl.setString(2, this.getlast_name());
				       pl.setObject(3, this.getusername());
				       pl.setObject(4, this.getpassword());
				       pl.setString(5, this.getemail_id());
				        
				       pl.setObject(6, this.getmobile_number());
				      
				       pl.setInt(7, inputuser_id);
				        // Execute the update
				        int rowsAffected = pl.executeUpdate();
				        // Check the result
				        if (rowsAffected > 0) {
				            System.out.println("Data updated successfully!");
				        } else {
				            System.out.println("Failed to update data. No matching record found.");
				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }   
				}
				public void delete(int inputid) {
					// JDBC URL, userfirst_name, and password of MySQL server
				    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    String user = "root";
				    String password = "";

				    // SQL query to delete data
				    String sql = "DELETE FROM userregister WHERE user_id = ?";

				    try (
				        // Establish the 
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement pl = co.prepareStatement(sql);
				    ) {
				        // Set the value for the WHERE clause
				        pl.setInt(1, inputid); // Assuming there is a column first_named 'id' for the WHERE clause

				        // Execute the delete
				        int rowsAffected = pl.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				            System.out.println("Data deleted successfully!");
				        } else {
				            System.out.println("Failed to delete data. No matching record found.");
				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }}}



