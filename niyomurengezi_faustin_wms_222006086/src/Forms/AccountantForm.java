package Forms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entityforms.Accountant;

public class AccountantForm implements ActionListener{
	JFrame frame;
					JLabel id_lb=new JLabel("Accountant_id");
					JLabel fname_lb=new JLabel("First_Name");
					JLabel lname_lb=new JLabel("Last_Name");
					JLabel email_lb=new JLabel("Email");
					JLabel Address_lb=new JLabel("Address");
					JLabel salary_lb=new JLabel("Salary");
					JLabel Education_Level_lb=new JLabel("Education_Level");
					JLabel gender_lb=new JLabel("Gender");
					JLabel telephone_lb=new JLabel("Telephone");
					JLabel adid_lb=new JLabel("Admin-ID");
					JTextField id_txf=new JTextField();
					JTextField fname_txf=new JTextField();
					JTextField lname_txf=new JTextField();
					JTextField address_txf=new JTextField();
					JTextField email_txf=new JTextField();
					JTextField salary_txf=new JTextField();
					
					String []Education_Level={"A2","A1", "A0","Master","PHD"};
					JComboBox<String> Education_LevelBox = new JComboBox<>(Education_Level);
					String []Gender={"Male","Female"};
					JComboBox<String> GenderBox = new JComboBox<>(Gender);
					JTextField telephone_txf=new JTextField();
                          JTextField adid_txField=new JTextField();
	                       //Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_btn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					public AccountantForm() {
						createForm();
	                      }
					private void ActionEvent() {
						insert_btn.addActionListener(this);
						Read_btn.addActionListener(this);
						update_btn.addActionListener(this);
						delete_btn.addActionListener(this);
					}
					private void createForm() {
					  frame=new JFrame();
						frame.setTitle("ACCOUNTANT FORM");
						frame.setBounds(10, 10, 600, 800);
						frame.getContentPane().setLayout(null);
						frame.getContentPane().setBackground(Color.yellow);
						frame.setVisible(true);
					     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setResizable(true);
						setLocationandSize();
					}


					private void setLocationandSize() {
						id_lb.setBounds(10, 10, 150, 30);
						fname_lb.setBounds(10, 50, 150, 30);
						lname_lb.setBounds(10, 90, 150, 30);
						email_lb.setBounds(10, 130, 150, 30);
						Address_lb.setBounds(10, 170, 150, 30);
						salary_lb.setBounds(10, 210, 150, 30);
						Education_Level_lb.setBounds(10, 250, 200, 30);
						gender_lb.setBounds(10, 290, 150, 30);
						telephone_lb.setBounds(10, 330, 150, 30);
						adid_lb.setBounds(10, 370, 150, 30);
						//create text
					  id_txf.setBounds(260, 10, 250, 30);
					  fname_txf.setBounds(260, 50, 250, 30);
						lname_txf.setBounds(260, 90, 250, 30);
						email_txf.setBounds(260, 130, 250, 30);
						address_txf.setBounds(260, 170, 250, 30);
						salary_txf.setBounds(260, 210, 250, 30);
						Education_LevelBox.setBounds(260, 250, 250, 30);
						GenderBox.setBounds(260, 290, 250, 30);
						telephone_txf.setBounds(260, 330, 250, 30);
						adid_txField.setBounds(260, 370, 250, 30);
						//Buttons CRUD
						insert_btn.setBounds(10,420, 120, 30);
						Read_btn.setBounds(140,420, 120, 30);
						update_btn.setBounds(270,420, 120, 30);
						delete_btn.setBounds(400,420, 120, 30);
						setFontforall();
						addcomponentforFrame();

					}
					private void setFontforall() {
						Font font = new Font("Georgia", Font.BOLD, 18);

						id_lb.setFont(font);
						fname_lb.setFont(font);
						lname_lb.setFont(font);
						Address_lb.setFont(font);
						email_lb.setFont(font);
						telephone_lb.setFont(font);
						Education_Level_lb.setFont(font);
						gender_lb.setFont(font);
					    salary_lb.setFont(font);
						adid_lb.setFont(font);
						//text
						id_txf.setFont(font);
						lname_txf.setFont(font);
						email_txf.setFont(font);
						address_txf.setFont(font);
						telephone_txf.setFont(font);
						Education_LevelBox.setFont(font);
						GenderBox.setFont(font);
						salary_txf.setFont(font);
						fname_txf.setFont(font);
						adid_txField.setFont(font);
						
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.BOLD, 15);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_btn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(fname_lb);
						frame.add(Address_lb);
						frame.add(email_lb);
						frame.add(lname_lb);
						frame.add(salary_lb);
						frame.add(Education_Level_lb);
						frame.add(gender_lb);
						frame.add(telephone_lb);
						frame.add(adid_lb);
						//text
						frame.add(id_txf);
						frame.add(fname_txf);
						frame.add(address_txf);
						frame.add(email_txf);
						frame.add(telephone_txf);
						frame.add(lname_txf);
						frame.add(salary_txf);
						frame.add(Education_LevelBox);
						frame.add(GenderBox);
						frame.add(adid_txField);
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_btn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
					public void actionPerformed(ActionEvent e) {
						Accountant acc=new Accountant();
						if(e.getSource()==insert_btn) {
							acc.setFirst_name(fname_txf.getText());
							acc.setLast_name(lname_txf.getText());
							acc.setEmail(email_txf.getText());
							acc.setAddress(address_txf.getText());
							acc.setSalary(salary_txf.getText());
							acc.setphone_number(telephone_txf.getText());
							acc.setEmail(email_txf.getText());
							acc.setEducation_level(Education_LevelBox.getSelectedItem());
							acc.setGender(GenderBox.getSelectedItem());
							acc.setAdmin_id(adid_txField.getText());
							
							
							acc.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							acc.readwithID(id);
							id_txf.setText(String.valueOf(acc.getAccountant_id()));
							fname_txf.setText(acc.getFirst_name());
							lname_txf.setText(acc.getLast_name());
							email_txf.setText(acc.getEmail());
							address_txf.setText(acc.getAddress());
							salary_txf.setText(acc.getSalary());
							Education_LevelBox.setSelectedItem(acc.getEducation_level());
							GenderBox.setSelectedItem(acc.getGender());
							telephone_txf.setText(acc.getphone_number());
							adid_txField.setText(acc.getAdmin_id());
							
						}else if (e.getSource()==update_btn) {
							int id=Integer.parseInt(id_txf.getText());
							acc.setFirst_name(fname_txf.getText());
							acc.setLast_name(lname_txf.getText());
							acc.setEmail(email_txf.getText());
							acc.setAddress(address_txf.getText());
							acc.setSalary(salary_txf.getText());
							acc.setEducation_level(Education_LevelBox.getSelectedItem());
							acc.setGender(GenderBox.getSelectedItem());
							acc.setphone_number(telephone_txf.getText());
							acc.setAdmin_id(adid_txField.getText());
							acc.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							acc.delete(id);
						}

					}
					public static void main(String[] args) {
						AccountantForm accf=new AccountantForm();
             System.out.println(accf);
					}

}
