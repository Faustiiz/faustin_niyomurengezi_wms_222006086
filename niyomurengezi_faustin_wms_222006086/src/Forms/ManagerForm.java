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

import entityforms.Manager;

public class ManagerForm implements ActionListener{
	JFrame frame;
					JLabel id_lb=new JLabel("Manager_id");
					JLabel fname_lb=new JLabel("First_Name");
					JLabel lname_lb=new JLabel("Last_Name");
					JLabel email_lb=new JLabel("Email");
					JLabel Address_lb=new JLabel("Address");
					JLabel salary_lb=new JLabel("Salary");
					JLabel qualification_lb=new JLabel("Qualification");
					JLabel telephone_lb=new JLabel("Telephone");
					JLabel adid_lb=new JLabel("Admin-ID");
					JTextField id_txf=new JTextField();
					JTextField fname_txf=new JTextField();
					JTextField lname_txf=new JTextField();
					JTextField address_txf=new JTextField();
					JTextField email_txf=new JTextField();
					JTextField salary_txf=new JTextField();
					
					String []qualification={"A2","A1", "A0","Master","PHD"};
					JComboBox<String> qualificationBox = new JComboBox<>(qualification);
					JTextField telephone_txf=new JTextField();
                          JTextField adid_txField=new JTextField();
	                       //Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					public ManagerForm() {
						createForm();
	                      }
					private void ActionEvent() {
						insert_btn.addActionListener(this);
						Read_btn.addActionListener(this);
						update_tbtn.addActionListener(this);
						delete_btn.addActionListener(this);
					}
					private void createForm() {
					  frame=new JFrame();
						frame.setTitle("MANAGER FORM");
						frame.setBounds(10, 10, 800, 500);
						frame.getContentPane().setLayout(null);
						frame.getContentPane().setBackground(Color.GRAY);
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
						qualification_lb.setBounds(10, 250, 150, 30);
						telephone_lb.setBounds(10, 290, 150, 30);
						adid_lb.setBounds(10, 330, 150, 30);
						//create text
					  id_txf.setBounds(160, 10, 250, 30);
					fname_txf.setBounds(160, 50, 250, 30);
						lname_txf.setBounds(160, 90, 250, 30);
						email_txf.setBounds(160, 130, 250, 30);
						address_txf.setBounds(160, 170, 250, 30);
						salary_txf.setBounds(160, 210, 250, 30);
						qualificationBox.setBounds(160, 250, 250, 30);
						telephone_txf.setBounds(160, 290, 250, 30);
						adid_txField.setBounds(160, 330, 250, 30);
						//Buttons CRUD
						insert_btn.setBounds(10,370, 95, 40);
						Read_btn.setBounds(140,370, 95, 40);
						update_tbtn.setBounds(270,370, 95, 40);
						delete_btn.setBounds(400,370, 95, 40);
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
						qualification_lb.setFont(font);
					    salary_lb.setFont(font);
						adid_lb.setFont(font);
						//text
						id_txf.setFont(font);
						lname_txf.setFont(font);
						email_txf.setFont(font);
						address_txf.setFont(font);
						telephone_txf.setFont(font);
						qualificationBox.setFont(font);
						salary_txf.setFont(font);
						fname_txf.setFont(font);
						adid_txField.setFont(font);
						
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.BOLD, 15);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(fname_lb);
						frame.add(Address_lb);
						frame.add(email_lb);
						frame.add(lname_lb);
						frame.add(salary_lb);
						frame.add(qualification_lb);
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
						frame.add(qualificationBox);
						frame.add(adid_txField);
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
					public void actionPerformed(ActionEvent e) {
						Manager mg=new Manager();
						if(e.getSource()==insert_btn) {
							mg.setFirst_name(fname_txf.getText());
							mg.setLast_name(lname_txf.getText());
							mg.setAddress(address_txf.getText());
							mg.setEmail(email_txf.getText());
							mg.setSalary(salary_txf.getText());
							mg.setQualification(qualificationBox.getSelectedItem());
							mg.setphone_number(telephone_txf.getText());
							mg.setAdmin_id(adid_txField.getText());
							mg.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							mg.readwithID(id);
							id_txf.setText(String.valueOf(mg.getManager_id()));
							fname_txf.setText(mg.getFirst_name());
							lname_txf.setText(mg.getLast_name());
							address_txf.setText(mg.getAddress());
							email_txf.setText(mg.getEmail());
							salary_txf.setText(mg.getSalary());
							qualificationBox.setSelectedItem(mg.getQualification());
							telephone_txf.setText(mg.getphone_number());
							adid_txField.setText(mg.getAdmin_id());
							Integer.parseInt(adid_txField.getText());
						}else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							mg.setFirst_name(fname_txf.getText());
							mg.setLast_name(lname_txf.getText());
							mg.setAddress(address_txf.getText());
							mg.setEmail(email_txf.getText());
							mg.setSalary(salary_txf.getText());
							mg.setQualification(qualificationBox.getSelectedItem());
							mg.setphone_number(telephone_txf.getText());
							mg.setAdmin_id(adid_txField.getText());
							mg.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							mg.delete(id);
						}
						

					}
					public static void main(String[] args) {
						ManagerForm mgf=new ManagerForm();
						System.out.println(mgf);

					}}

			


		




