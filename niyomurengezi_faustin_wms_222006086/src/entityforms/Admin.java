package entityforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

	public class Admin { 
		private int admin_id;
		private String name;
		private String Email;
		private String Address;
		private String phone_number;
		public Admin() {}
		public Admin(int id,String name,String Email,String Address,String  phone) {
			this. admin_id =id;
			this.name= name;
			this.Email=Email;
			this.Address=Address;
			this.phone_number =phone;
		}
		public Admin( String name, String Email, String Address,String phone) {
			this.name = name;
			this.Email =Email;
			this.Address= Address;
			this.phone_number=phone;
		}
		
		public int getadmin_id() {
			return admin_id;
		}
		public void setadmin_id(int admin_id) {
			this.admin_id = admin_id;
		}
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
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
		public void setAddress(String address) {
			this.Address = address;
		}
		public String getphone_number() {
			return phone_number;
		}
		public void setphone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		public void makeconnection() {
		}

		public void insertData() {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
		    String user = "root";
		    String password = "";

		    // SQL query to insert data
		    String sql = "INSERT INTO admin (Names,Email,Address,Phone_number) VALUES ( ?,?,?,?)";

		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.name);
		        preparedStatement.setString(2, this.Email);
		        preparedStatement.setObject(3, this.Address);
		        preparedStatement.setString(4, this.phone_number);
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
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
		    String user = "root";
		    String password = "";

		    // SQL query to select all columns from student where id = ?
		    String sql = "SELECT * FROM admin WHERE Admin_id = ?";

		    try (
		        // Establish the connection
		        Connection connection = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    ) {
		        // Set the value for the parameterized query
		        //int studentId = 1; // Replace with the desired student id
		        //if()
		    	preparedStatement.setInt(1, inputid);

		        // Execute the query and get the result set
		        ResultSet resultSet = preparedStatement.executeQuery();

		        // Process the result set
		        while (resultSet.next()) {
		        	this.setadmin_id(resultSet.getInt("Admin_id"));
		           this.setname(resultSet.getString("Names"));
		           this.setEmail(resultSet.getString("Email"));
		           this.setAddress(resultSet.getString("Address"));
		           this.setphone_number(resultSet.getString("Phone_number"));
		            }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		public void update(int inputadmin_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
		    String user = "root";
		    String password = "";

		    // SQL query to update data
		    String sql = "UPDATE admin SET  names= ? ,Address= ?,Email = ? ,Phone_number= ? WHERE Admin_id=?";
		    		try (
		        // Establish the co
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  pl.setString(1, this.getname());
		    	  pl.setObject(2, this.getAddress());
		    	  pl.setString(3, this.getEmail());  
		          pl.setObject(4, this.getphone_number());// Assuming there is a column named 'id' for the WHERE clause
		          pl.setInt(5, inputadmin_id);
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
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
		    String user = "root";
		    String password = "";

		    // SQL query to delete data
		    String sql = "DELETE FROM admin WHERE Admin_id = ?";

		    try (
		        // Establish the 
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

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