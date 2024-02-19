package Forms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entityforms.UserRegister;

	public class UserRegisterForm implements ActionListener{
		JFrame frame;
						JLabel id_lb=new JLabel("user_id");
						JLabel fname_lb=new JLabel("first_name");
						JLabel lname_lb=new JLabel("last_name");
						JLabel username_lb=new JLabel("username");
						JLabel password_lb=new JLabel("password");
						JLabel email_id_lb=new JLabel("email_id");
						JLabel Education_Level_lb=new JLabel("Education_Level");
						JLabel mobile_number_lb=new JLabel("mobile_number");
						JLabel telephone_lb=new JLabel("Telephone");
						
						
						JTextField id_txf=new JTextField();
						JTextField fname_txf=new JTextField();
						JTextField lname_txf=new JTextField();
						JTextField password_txf=new JTextField();
						JTextField username_txf=new JTextField();
						JTextField email_id_txf=new JTextField();
						JTextField mobile_number_txf=new JTextField();
						
						
						
	                          
		                       //Buttons CRUD
						JButton insert_btn=new JButton("Insert");
						JButton Read_btn=new JButton("View");
						JButton update_btn=new JButton("Update");
						JButton delete_btn=new JButton("Delete");
						public UserRegisterForm() {
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
							frame.setTitle("UserRegisterForm");
							frame.setBounds(10, 10, 800, 600);
							frame.getContentPane().setLayout(null);
							frame.getContentPane().setBackground(Color.pink);
							frame.setVisible(true);
						     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.setResizable(true);
							setLocationandSize();
						}


						private void setLocationandSize() {
							id_lb.setBounds(10, 10, 250, 30);
							fname_lb.setBounds(10, 50, 250, 30);
							lname_lb.setBounds(10, 90, 250, 30);
							username_lb.setBounds(10, 130, 250, 30);
							password_lb.setBounds(10, 170, 250, 30);
							email_id_lb.setBounds(10, 210, 250, 30);
							
							mobile_number_lb.setBounds(10, 290, 250, 30);
							
							//create text
						  id_txf.setBounds(160, 10, 250, 30);
						  fname_txf.setBounds(160, 50, 250, 30);
							lname_txf.setBounds(160, 90, 250, 30);
							username_txf.setBounds(160, 130, 250, 30);
							password_txf.setBounds(160, 170, 250, 30);
							email_id_txf.setBounds(160, 210, 250, 30);
							
							mobile_number_txf.setBounds(160, 290, 250, 30);
							
							
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
							password_lb.setFont(font);
							username_lb.setFont(font);
							
							
							mobile_number_lb.setFont(font);
						    email_id_lb.setFont(font);
							
							//text
							id_txf.setFont(font);
							lname_txf.setFont(font);
							username_txf.setFont(font);
							password_txf.setFont(font);
							
							mobile_number_txf.setFont(font);
							email_id_txf.setFont(font);
							fname_txf.setFont(font);
							
							
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
							frame.add(password_lb);
							frame.add(username_lb);
							frame.add(lname_lb);
							frame.add(email_id_lb);
							
							frame.add(mobile_number_lb);
							
							//text
							frame.add(id_txf);
							frame.add(fname_txf);
							frame.add(password_txf);
							frame.add(username_txf);
							
							frame.add(lname_txf);
							frame.add(email_id_txf);
							
							frame.add(mobile_number_txf);
							
							//Buttons CRUD
							frame.add(insert_btn);
							frame.add(Read_btn);
							frame.add(update_btn);
							frame.add(delete_btn);
							ActionEvent();
						}
						@Override
						public void actionPerformed(ActionEvent e) {
							UserRegister usr=new UserRegister ();
							if(e.getSource()==insert_btn) {
								usr.setfirst_name(fname_txf.getText());
								usr.setlast_name(lname_txf.getText());
								usr.setusername(username_txf.getText());
								usr.setpassword(password_txf.getText());
								usr.setemail_id(email_id_txf.getText());
								
								usr.setusername(username_txf.getText());


								usr.setmobile_number(mobile_number_txf.getText());
								
								
								usr.insertData();
							}else if (e.getSource()==Read_btn) {
								int id=Integer.parseInt(id_txf.getText());
								usr.readwithID(id);
								id_txf.setText(String.valueOf(usr.getuser_id()));
								fname_txf.setText(usr.getfirst_name());
								lname_txf.setText(usr.getlast_name());
								username_txf.setText(usr.getusername());
								password_txf.setText(usr.getpassword());
								email_id_txf.setText(usr.getemail_id());
								
								mobile_number_txf.setText(usr.getmobile_number());
								
								
							}else if (e.getSource()==update_btn) {
								int id=Integer.parseInt(id_txf.getText());
								usr.setfirst_name(fname_txf.getText());
								usr.setlast_name(lname_txf.getText());
								usr.setusername(username_txf.getText());
								usr.setpassword(password_txf.getText());
								usr.setemail_id(email_id_txf.getText());
								
								
								usr.setmobile_number(mobile_number_txf.getText());
								
								usr.update(id);
							}else {
								int id=Integer.parseInt(id_txf.getText());
								usr.delete(id);
							}

						}
						public static void main(String[] args) {
					UserRegisterForm usr=new UserRegisterForm();
	             System.out.println(usr);
						}

	}


