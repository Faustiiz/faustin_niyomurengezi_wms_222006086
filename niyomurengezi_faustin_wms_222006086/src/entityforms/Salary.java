package entityforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Salary {
	private int Salary_id;
			private String Job_id;
			private String Amount;
			private String Monthly;
			private String Extra;
			private String Job_title;
			public Salary() {}
			public Salary(int id,String Job_id,String Amount,String Monthly,String  extra,String job_title) {
				this. Salary_id=id;
				this.Job_id= Job_id;
				this.Amount=Amount;
				this.Monthly=Monthly;
				this.Extra =extra;
				this.Job_title =job_title;
			}
			public Salary( String Job_id, String Amount, String Monthly,String extra,String job_title) {
				this.Job_id = Job_id;
				this.Amount =Amount;
				this.Monthly= Monthly;
				this.Extra=extra;
				this.Job_title=job_title;
			}
			
			
			
			public int getSalary_id() {
				return Salary_id;
			}
			public void setSalary_id(int salary_id) {
				Salary_id= salary_id;
			}
			public String getJob_id() {
				return Job_id;
			}
			public void setJob_id(String job_id) {
				Job_id = job_id;
			}
			public String getAmount() {
				return Amount;
			}
			public void setAmount(String amount) {
				Amount = amount;
			}
			public String getMonthly() {
				return Monthly;
			}
			public void setMonthly(String monthly) {
				Monthly = monthly;
			}
			public String getExtra() {
				return Extra;
			}
			public void setExtra(String extra) {
				Extra = extra;
			}
			public String getJob_title() {
				return Job_title;
			}
			public void setJob_title(String job_title) {
				Job_title = job_title;
			}
			public void makeconnection() {
			}
			public void insertData() {
				// JDBC URL, userJob_id, and password of MySQL server
			    String host = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
			    String sql = "INSERT INTO salarys (Job_id,Amount,Monthly,Extra,job_title) VALUES ( ?,?,?,?,?)";

			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       preparedStatement.setString(1, this.Job_id);
			        preparedStatement.setString(2, this.Amount);
			        preparedStatement.setObject(3, this.Monthly);
			        preparedStatement.setString(4, this.Extra);
			        preparedStatement.setString(5, this.Job_title);
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

			public void readwithID(int inputSalary_id) {
				// JDBC URL, userJob_id, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to select all columns from student where id = ?
			    String sql = "SELECT * FROM Salarys WHERE salary_id = ?";

			    try (
			        // Establish the connection
			        Connection connection = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    ) {
			        // Set the value for the parameterized query
			        //int studentId = 1; // Replace with the desired student id
			        //if()
			    	preparedStatement.setInt(1, inputSalary_id);

			        // Execute the query and get the result set
			        ResultSet resultSet = preparedStatement.executeQuery();

			        // Process the result set
			        while (resultSet.next()) {
			        	this.setSalary_id(resultSet.getInt("salary_id"));
			           this.setJob_id(resultSet.getString("Job_id"));
			           this.setAmount(resultSet.getString("Amount"));
			           this.setMonthly(resultSet.getString("Monthly"));
			           this.setExtra(resultSet.getString("Extra"));
			           this.setJob_title(resultSet.getString("Job_title"));
			            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
			public void update(int inputSalary_id) {
				// JDBC URL, userJob_id, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE Salarys SET  Job_id= ?,Amount = ?,Monthly= ?,Extra= ?,job_title=? WHERE salary_id=?";
			    		try (
			        // Establish the co
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement pl = co.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  pl.setString(1, this.getJob_id());
			        pl.setString(2, this.getAmount());
			       pl.setString(3, this.getMonthly());
			       pl.setString(4, this.getExtra());
			       pl.setString(5, this.getJob_title());
			       pl.setInt(6, inputSalary_id);
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
			public void delete(int inputSalary_id) {
				// JDBC URL, userJob_id, and password of MySQL server
			    String url = "jdbc:mysql://localhost/niyomurengezi_faustin_222006086";
			    String user = "root";
			    String password = "";

			    // SQL query to delete data
			    String sql = "DELETE FROM Salarys WHERE salary_id= ?";

			    try (
			        // Establish the 
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement pl = co.prepareStatement(sql);
			    ) {
			        // Set the value for the WHERE clause
			        pl.setInt(1, inputSalary_id); // Assuming there is a column Job_idd 'id' for the WHERE clause

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

