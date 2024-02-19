package entityforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Worker {
	            private int Worker_id;
				private String Names;
				private String Address;
				private String Job_title;
				private String Phone_number;
				private String Salary;
				private Object Employment_status;
				private Object Marital_status;
				private Object Gender;
				private String Manager_id;
				private String Accountant_id;
				private String Admin_id;
				
				public Worker() {}
				public Worker(int id,String names,String Address,String Job_title, String Phone_number,String salary,
						Object Employment_status,Object Marital_status,Object gender,String Manager_id,String Accountant_id,String Admin_id) {
					this. Worker_id =id;
					this.Names= names;
					this.Address=Address;
					this.Job_title=Job_title;
					this.Phone_number=Phone_number;
					this.Salary=salary;
					this. Employment_status= Employment_status;
					this.Gender=Marital_status;
					this.Marital_status=gender;
					this.Manager_id=Manager_id;
					this.Accountant_id=Accountant_id;
					this.Accountant_id=Admin_id;
				}
				
				
				public Object getEmployment_status() {
					return Employment_status;
				}
				public void setEmployment_status(Object employment_status) {
					Employment_status = employment_status;
				}
				public Object getMarital_status() {
					return Marital_status;
				}
				public void setMarital_status(Object marital_status) {
					Marital_status = marital_status;
				}
				public Object getGender() {
					return Gender;
				}
				public void setGender(Object gender) {
					Gender = gender;
				}
				public Worker(String names,String Address,String Job_title, String Phone_number,String salary,
						Object Employment_status,Object Marital_status,Object gender,String Manager_id,String Accountant_id,String Admin_id) {
					this.Names= names;
					this.Address=Address;
					this.Job_title=Job_title;
					this.Phone_number=Phone_number;
					this.Salary=salary;
					this. Employment_status= Employment_status;
					this.Gender=Marital_status;
					this.Marital_status=gender;
					this.Manager_id=Manager_id;
					this.Accountant_id=Accountant_id;
					this.Admin_id=Admin_id;
				}
				
				
				public int getWorker_id() {
					return Worker_id;
				}
				public void setWorker_id(int worker_id) {
					Worker_id = worker_id;
				}
				public String getNames() {
					return Names;
				}
				public void setNames(String names) {
					Names = names;
				}
				public String getAddress() {
					return Address;
				}
				public void setAddress(String address) {
					Address = address;
				}
				public String getJob_title() {
					return Job_title;
				}
				public void setJob_title(String job_title) {
					Job_title = job_title;
				}
				public String getPhone_number() {
					return Phone_number;
				}
				public void setPhone_number(String phone_number) {
					Phone_number = phone_number;
				}
				public String getSalary() {
					return Salary;
				}
				public void setSalary(String salary) {
					Salary = salary;
				}
				public String getManager_id() {
					return Manager_id;
				}
				public void setManager_id(String manager_id) {
					Manager_id = manager_id;
				}
				public String getAccountant_id() {
					return Accountant_id;
				}
				public void setAccountant_id(String accountant_id) {
					Accountant_id = accountant_id;
				}
				public String getAdmin_id() {
					return Admin_id;
				}
				public void setAdmin_id(String admin_id) {
					Admin_id = admin_id;
				}
				public void makeconnection() {
				}
		
				public void insertData() {
					// JDBC URL, userFirst_name, and password of MySQL server
				    String host = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    String user = "root";
				    String password = "";

				    // SQL query to insert data
				    String sql = "INSERT INTO   worker_audit (Names,Address,Job_title,Phone_number,Salary,Employment_status,Maritial_status,Gender,Manager,Accountant,Admin)"
				    		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
				    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, this.Names);
				        preparedStatement.setString(2, this.Address);
				        preparedStatement.setString(3, this.Job_title);
				        preparedStatement.setString(4, this.Phone_number);
				        preparedStatement.setString(5, this.Salary);
				        preparedStatement.setObject(6, this.Employment_status);
				        preparedStatement.setObject(7, this.Marital_status);
				        preparedStatement.setObject(8, this.Gender);
				        preparedStatement.setString(9, this.Manager_id);
				        preparedStatement.setString(10, this.Accountant_id);
				        preparedStatement.setString(11, this.Admin_id);
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

				public void readwithID(int inputWorker_id) {
					// JDBC URL, userFirst_name, and password of MySQL server
				    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    String user = "root";
				    String password = "";

				    // SQL query to select all columns from student where id = ?
				    String sql = "SELECT * FROM   worker_audit WHERE Worker_id = ?";

				    try (
				        // Establish the connection
				        Connection connection = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement preparedStatement = connection.prepareStatement(sql);
				    ) {
				        // Set the value for the parameterized query
				        //int accountantId = 1; // Replace with the desired accountant id
				        //if()
				    	preparedStatement.setInt(1, inputWorker_id);

				        // Execute the query and get the result set
				        ResultSet resultSet = preparedStatement.executeQuery();
				    
				        // Process the result set
				        while (resultSet.next()) {
				        	this.setWorker_id(resultSet.getInt("Worker_id"));
				           this.setNames(resultSet.getString("Names"));
				           this.setAddress(resultSet.getString("Address"));
				           this.setJob_title(resultSet.getString("Job_title"));
				           this.setPhone_number(resultSet.getString("Phone_number"));
				           this.setSalary(resultSet.getString("Salary"));
				           this.setEmployment_status(resultSet.getObject("Employment_status"));
				           this.setMarital_status(resultSet.getObject("Maritial_status"));
				           this.setGender(resultSet.getObject("Gender"));
				           this.setManager_id(resultSet.getString("Manager_id"));
				           this.setAccountant_id(resultSet.getString("Accountant_id"));
				           this.setAdmin_id(resultSet.getString("Admin_id"));
				            }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
				public void update(int inputworkerid) {
					// JDBC URL, userFirst_name, and password of MySQL server
				    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
				    String user = "root";
				    String password = "";

				    // SQL query to update data
				    String sql = "UPDATE   worker_audit SET  Names= ?,Address = ?,Job_title= ?,Phone_number=?, Salary= ?,Employment_status= ?,Maritial_status =?,"
				    		+ "Gender =? ,Manager =?,Accountant= ? ,Admin=? WHERE Worker_id=?";
				    		try (
				        // Establish the co
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement wr = co.prepareStatement(sql);
				    ) {
				        // Set the new values for the update
				    	  wr.setString(1, this.getNames());
				        wr.setString(2, this.getAddress());
				       wr.setString(3, this.getJob_title());
				       wr.setString(4, this.getPhone_number());
				       wr.setString(5, this.getSalary());
				        wr.setObject(6, this.getEmployment_status());
				       wr.setObject(7, this.getMarital_status());
				       wr.setObject(8, this.getGender());
				       wr.setObject(9, this.getManager_id());
				       wr.setObject(10, this.getAccountant_id());
				       wr.setObject(11, this.getAdmin_id());// Assuming there is a column First_named 'id' for the WHERE clause
				       wr.setInt(12, inputworkerid);
				        // Execute the update
				        int rowsAffected = wr.executeUpdate();

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
				    String sql = "DELETE FROM   worker_audit WHERE Worker_id= ?";

				    try (
				        // Establish the 
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement wr = co.prepareStatement(sql);
				    ) {
				        // Set the value for the WHERE clause
				        wr.setInt(1, inputid); // Assuming there is a column First_named 'id' for the WHERE clause

				        // Execute the delete
				        int rowsAffected = wr.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				            System.out.println("Data deleted successfully!");
				        } else {
				            System.out.println("Failed to delete data. No matching record found.");
				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }}}



