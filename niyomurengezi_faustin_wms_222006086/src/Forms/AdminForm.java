package Forms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entityforms.Admin;
public class AdminForm implements ActionListener{
	JFrame frame;
	
			    JLabel id_lb=new JLabel("Admin-ID");
				JLabel name_lb=new JLabel("Name");
				JLabel Address_lb=new JLabel("Address");
				JLabel email_lb=new JLabel("Email");
				JLabel telephone_lb=new JLabel("Telephone");
				JTextField id_txf=new JTextField();
				JTextField name_txf=new JTextField();
				JTextField address_txf=new JTextField();
				JTextField email_txf=new JTextField();
				JTextField telephone_txf=new JTextField();
                       //Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Read_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				public AdminForm() {
					
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
					frame.setTitle("ADMIN FORM");
					frame.setBounds(10, 10, 600, 400);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().setBackground(Color.blue);
					frame.setVisible(true);
				     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(true);
					setLocationandSize();
				}


				private void setLocationandSize() {
					id_lb.setBounds(10, 10, 100, 30);
					name_lb.setBounds(10, 50, 100, 30);
					Address_lb.setBounds(10, 90, 100, 30);
					email_lb.setBounds(10, 130, 100, 30);
					telephone_lb.setBounds(10, 170, 100, 30);
					id_txf.setBounds(160, 10, 250, 30);
					name_txf.setBounds(160, 50, 250, 30);
					address_txf.setBounds(160, 90, 250, 30);
					email_txf.setBounds(160, 130, 250, 30);
					telephone_txf.setBounds(160, 170, 250, 30);
					//Buttons CRUD
					insert_btn.setBounds(50,210, 85, 30);
					Read_btn.setBounds(150,210, 85, 30);
					update_tbtn.setBounds(250,210, 85, 30);
					delete_btn.setBounds(350,210, 85, 30);
					setFontforall();
					addcomponentforFrame();

				}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					id_lb.setFont(font);
					name_lb.setFont(font);
					Address_lb.setFont(font);
					address_txf.setFont(font);
					email_lb.setFont(font);
					telephone_lb.setFont(font);

					id_txf.setFont(font);
					name_txf.setFont(font);
					email_txf.setFont(font);
					telephone_txf.setFont(font);
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.ITALIC, 12);

					insert_btn.setFont(fonti);
					Read_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(id_lb);
					frame.add(name_lb);
					frame.add(Address_lb);
					frame.add(email_lb);
					
					frame.add(telephone_lb);
					frame.add(id_txf);
					frame.add(name_txf);
					frame.add(address_txf);
					frame.add(email_txf);
					frame.add(telephone_txf);
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Read_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					ActionEvent();
				}
				@Override
				public void actionPerformed(ActionEvent e) {
					Admin  ad=new Admin();
					if(e.getSource()==insert_btn) {
						ad.setname(name_txf.getText());
						ad.setEmail(email_txf.getText());
						ad.setAddress(address_txf.getText());
						ad.setphone_number(telephone_txf.getText());
						ad.insertData();
					}else if (e.getSource()==Read_btn) {
						int id=Integer.parseInt(id_txf.getText());
						ad.readwithID(id);
						id_txf.setText(String.valueOf(ad.getadmin_id()));
						name_txf.setText(ad.getname());
						address_txf.setText(ad.getEmail());
						email_txf.setText(ad.getAddress());
						telephone_txf.setText(ad.getphone_number());
						
					}else if (e.getSource()==update_tbtn) {
						int id=Integer.parseInt(id_txf.getText());
						ad.setname(name_txf.getText());
						ad.setAddress(address_txf.getText());
						ad.setEmail(email_txf.getText());
						ad.setphone_number(telephone_txf.getText());
						ad.update(id);

						
					}else {
						int id=Integer.parseInt(id_txf.getText());
						ad.delete(id);
					}

				}
				public static void main(String[] args) {
				AdminForm adf=new AdminForm();
					System.out.println(adf);

				}



			
			}

		


	


