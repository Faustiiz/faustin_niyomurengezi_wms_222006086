package entityforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class job_departments  {
	private int job_id;
			private String Job_title;
			private String Age;
			private String Phone_number;
			private String Income;
			private  String Manager_id;
			public job_departments() {}
			public job_departments(int id,String Job_title,String Age,String Phone_number,String  Income,String manager_id) {
				this. job_id =id;
				this.Job_title= Job_title;
				this.Age=Age;
				this.Phone_number=Phone_number;
				this.Income =Income;
				this.Manager_id =manager_id;
			}
			public job_departments( String Job_title, String Age, String Phone_number,String Income,String manager_id) {
				this.Job_title = Job_title;
				this.Age =Age;
				this.Phone_number= Phone_number;
				this.Income=Income;
				this.Manager_id=manager_id;
			}
			
			
			
			public int getJob_id() {
				return job_id;
			}
			public void setJob_id(int job_id) {
				this.job_id = job_id;
			}
			public String getJob_title() {
				return Job_title;
			}
			public void setJob_title(String job_title) {
				this.Job_title = job_title;
			}
			
			public String getAge() {
				return Age;
			}
			public void setAge(String age) {
				this.Age = age;
			}
			public String getPhone_number() {
				return Phone_number;
			}
			public void setPhone_number(String phone_number) {
				this.Phone_number = phone_number;
			}
			public String getIncome() {
				return Income;
			}
			public void setIncome(String income) {
				this.Income = income;
			}
			public String getManager_id() {
				return Manager_id;
			}
			public void setManager_id(String manager_id) {
				this.Manager_id = manager_id;
			}
			public void makeconnection() {
			}
		
			public void insertData() {
				// JDBC URL, userJob_id, and password of MySQL server
			    String host = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
			    String sql = "INSERT INTO job_department (Job_title,Age,Phone_number,Income,Manager_id) VALUES ( ?,?,?,?,?)";

			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       preparedStatement.setString(1, this.Job_title);
			        preparedStatement.setString(2, this.Age);
			        preparedStatement.setObject(3, this.Phone_number);
			        preparedStatement.setString(4, this.Income);
			        preparedStatement.setString(5, this.Manager_id);
			        // Execute the query
			        int rowsAffected = preparedStatement.executeUpdate();

			        
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

			public void readwithID(int inputjob_id) {
				// JDBC URL, userJob_id, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to select all columns from student where id = ?
			    String sql = "SELECT * FROM job_department WHERE Job_id = ?";

			    try (
			        // Establish the connection
			        Connection connection = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    ) {
			        // Set the value for the parameterized query
			        
			    	preparedStatement.setInt(1, inputjob_id);

			        // Execute the query and get the result set
			        ResultSet resultSet = preparedStatement.executeQuery();

			        // Process the result set
			        while (resultSet.next()) {
			        	this.setJob_id(resultSet.getInt("job_id"));
			           this.setJob_title(resultSet.getString("Job_title"));
			           this.setAge(resultSet.getString("Age"));
			           this.setPhone_number(resultSet.getString("Phone_number"));
			           this.setIncome(resultSet.getString("Income"));
			           this.setManager_id(resultSet.getString("Manager_id"));
			            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
			public void update(int inputjob_id) {
				// JDBC URL, userJob_id, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE job_department SET  Job_title= ?,Age = ?,Phone_number= ?,Income= ?,Manager_id=? WHERE Job_id = ?";
			    		try (
			        // Establish the co
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement jp = co.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  jp.setString(1, this.getJob_title());
			        jp.setString(2, this.getAge());
			       jp.setString(3, this.getPhone_number());
			       jp.setString(4, this.getIncome());
			       jp.setString(5, this.getManager_id());
			       jp.setInt(6, inputjob_id);
			        // Execute the update
			        int rowsAffected = jp.executeUpdate();

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
			public void delete(int inputjob_id) {
				// JDBC URL, userJob_id, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to delete data
			    String sql = "DELETE FROM job_department  WHERE Job_id = ?";

			    try (
			        // Establish the 
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement jp = co.prepareStatement(sql);
			    ) {
			        // Set the value for the WHERE clause
			        jp.setInt(1, inputjob_id); // Assuming there is a column Job_idd 'id' for the WHERE clause

			        // Execute the delete
			        int rowsAffected = jp.executeUpdate();

			        // Check the result
			        if (rowsAffected > 0) {
			            System.out.println("Data deleted successfully!");
			        } else {
			            System.out.println("Failed to delete data. No matching record found.");
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }}}

