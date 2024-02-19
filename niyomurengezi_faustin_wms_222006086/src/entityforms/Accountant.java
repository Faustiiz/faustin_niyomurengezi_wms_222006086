package entityforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

           public class Accountant { 
			private int Accountant_id;
			private String First_name;
			private String Last_name;
			private String Email;
			private String Address;
			private String Salary;
			private Object Education_Level;
			private Object Gender;
			private String phone_number;
			private String Admin_id;
			
			public Accountant() {}
			public Accountant(int id,String First_name,String Last_name,String Email,String Address,String Salary, 
					String Education_Level,String Gender,String phone_number,String Admin_id) {
				this. Accountant_id =id;
				this.First_name= First_name;
				this.Last_name=Last_name;
				this.Email=Email;
				this.Address =Address;
				this.Salary=Salary;
				this. Education_Level= Education_Level;
				this.Gender=Gender;
				this.phone_number=phone_number;
				this.Admin_id=Admin_id;
			}
			public Accountant( String First_name, String Last_name, String Email,String Address,String Salary, 
					String Education_Level,String Gender,String phone_number,String Admin_id) {
				
				this.First_name = First_name;
				this.Last_name =Last_name;
				this.Email= Email;
				this.Address=Address;
				this.Salary=Salary;
				this. Education_Level= Education_Level;
				this.Gender=Gender;
				this.phone_number=phone_number;
				this.Admin_id=Admin_id;
			}
			
			public int getAccountant_id() {
				return Accountant_id;
			}
			public void setAccountant_id(int Accountant_id) {
				this.Accountant_id = Accountant_id;
			}
			public String getFirst_name() {
				return First_name;
			}
			public void setFirst_name(String fname_) {
				this.First_name = fname_;
			}
			public String getLast_name() {
				return Last_name;
			}
			public void setLast_name(String Last_name) {
				this.Last_name = Last_name;
			}
			public String getEmail() {
				return Email;
			}
			public void setEmail(String Email) {
				this.Email = Email;
			}
			public String getAddress() {
				return Address;
			}
			public void setAddress(String Address) {
				this.Address = Address;
				
			}
				
				public String getSalary() {
					return Salary;
				}
				public void setSalary(String Salary) {
					this.Salary = Salary;
				}
				public Object getEducation_level() {
					return Education_Level;
				}
				public void setEducation_level(Object Education_Level) {
					this.Education_Level = Education_Level;
				}
				public Object getGender() {
					return Gender;
				}
				public void setGender(Object Gender) {
					this.Gender = Gender;
				}
				public String getphone_number() {
					return phone_number;
				}
				public void setphone_number(String phone_number) {
					this.phone_number = phone_number;
				}
				public String getAdmin_id() {
					return Admin_id;
				}
				public void setAdmin_id(String Admin_id) {
					this.Admin_id = Admin_id;
			}
			public void makeconnection() {
			}
			public void insertData() {
				// JDBC URL, userFirst_name, and password of MySQL server
			    String host = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
			    String sql = "INSERT INTO accountants(First_name,Last_name,Email,Address,Salary,Education_Level,Gender,Phone_number,Admin_id)VALUES (?,?,?,?,?,?,?,?,?)";

			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       preparedStatement.setString(1, this.First_name);
			        preparedStatement.setString(2, this.Last_name);
			        preparedStatement.setObject(3, this.Email);
			        preparedStatement.setString(4, this.Address);
			        preparedStatement.setString(5, this.Salary);
			        preparedStatement.setObject(6, this.Education_Level);
			        preparedStatement.setObject(7, this.Gender);
			        preparedStatement.setString(8, this.phone_number);
			        preparedStatement.setString(9, this.Admin_id);
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
				// JDBC URL, userFirst_name, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    

			    String user = "root";
			    String password = "";

			    // SQL query to select all columns from student where id = ?
			    String sql = "SELECT * FROM accountants WHERE Accountant_id = ?";

			    try (
			        // Establish the connection
			        Connection connection = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    ) {
			        // Set the value for the parameterized query
			        //int AccountantId = 1; // Replace with the desired Accountant id
			        //if()
			    	preparedStatement.setInt(1, inputid);

			        // Execute the query and get the result set
			        ResultSet resultSet = preparedStatement.executeQuery();
			    
			        // Process the result set
			        while (resultSet.next()) {
			        	this.setAccountant_id(resultSet.getInt("Accountant_id"));
			           this.setFirst_name(resultSet.getString("First_name"));
			           this.setLast_name(resultSet.getString("Last_name"));
			           this.setEmail(resultSet.getString("Email"));
			           this.setAddress(resultSet.getString("Address"));
			           this.setSalary(resultSet.getString("Salary"));
			           this.setEducation_level(resultSet.getString("Education_Level"));
			           this.setGender(resultSet.getString("Gender"));
			           this.setphone_number(resultSet.getString("Phone_number"));
			           this.setAdmin_id(resultSet.getString("Admin_id"));
			            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
			public void update(int inputAccountant_id) {
				// JDBC URL, userFirst_name, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE accountants SET  First_name= ?,Last_name = ?,Email= ?,Address= ?,Salary= ?,Education_Level= ?,Gender =?,"
			    		+ "Phone_number =? ,Admin_id= ? WHERE Accountant_id = ?";
			    		try (
			        // Establish the co
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement pl = co.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  pl.setString(1, this.getFirst_name());
			        pl.setString(2, this.getLast_name());
			       pl.setObject(3, this.getEmail());
			       pl.setObject(4, this.getAddress());
			       pl.setString(5, this.getSalary());
			        pl.setObject(6, this.getEducation_level());
			       pl.setObject(7, this.getGender());
			       pl.setObject(8, this.getphone_number());
			       pl.setObject(9, this.getAdmin_id()); // Assuming there is a column First_named 'id' for the WHERE clause
			       pl.setInt(10, inputAccountant_id);
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
				// JDBC URL, userFirst_name, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to delete data
			    String sql = "DELETE FROM accountants WHERE Accountant_id = ?";

			    try (
			        // Establish the 
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement pl = co.prepareStatement(sql);
			    ) {
			        // Set the value for the WHERE clause
			        pl.setInt(1, inputid); // Assuming there is a column First_named 'id' for the WHERE clause

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

