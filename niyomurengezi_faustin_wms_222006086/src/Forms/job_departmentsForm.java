package Forms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entityforms.job_departments;
public class job_departmentsForm implements ActionListener{
	JFrame frame;
				JLabel Job_id_lb=new JLabel("Job_id");
				JLabel Job_title_lb=new JLabel("Job_title");
				JLabel Age_lb=new JLabel("Age");
				JLabel Phone_number_lb=new JLabel("Phone_number");
				JLabel Income_lb=new JLabel("Income");
				JLabel Manager_id_lb=new JLabel("Manager_id");     
				JTextField Job_id_txf=new JTextField();
				JTextField Job_title_txf=new JTextField();
				JTextField Age_txf=new JTextField();
				JTextField Phone_number_txf=new JTextField();
				JTextField Income_txf=new JTextField();
				JTextField Manager_id_txf=new JTextField();
                       //Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Read_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				
				public job_departmentsForm() {
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
					frame.setTitle("job_departmentsForm");
					frame.setBounds(10, 10, 600, 400);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().setBackground(Color.green);
					frame.setVisible(true);
				     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(true);
					setLocationandSize();
				}


				private void setLocationandSize() {
					Job_id_lb.setBounds(10, 10, 150, 30);
					Job_title_lb.setBounds(10, 50, 150, 30);
					Age_lb.setBounds(10, 90, 150, 30);
					Phone_number_lb.setBounds(10, 130, 150, 30);
					Income_lb.setBounds(10, 170, 150, 30);
					Manager_id_lb.setBounds(10, 210, 150, 30);
                     
					Job_id_txf.setBounds(160, 10, 250, 30);
					Job_title_txf.setBounds(160, 50, 250, 30);
					Age_txf.setBounds(160, 90, 250, 30);
					Phone_number_txf.setBounds(160, 130, 250, 30);
					Income_txf.setBounds(160, 170, 250, 30);
					Manager_id_txf.setBounds(160, 210, 250, 30);
					//Buttons CRUD
					insert_btn.setBounds(10,250, 100, 30);
					Read_btn.setBounds(120,250, 125, 30);
					update_tbtn.setBounds(260,250, 150, 30);
					delete_btn.setBounds(420,250, 150, 30);
					setFontforall();
					addcomponentforFrame();

				}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					Job_id_lb.setFont(font);
					Job_title_lb.setFont(font);
					Age_lb.setFont(font);
					Phone_number_lb.setFont(font);
					Income_lb.setFont(font);
					Manager_id_lb.setFont(font);
					

					Job_id_txf.setFont(font);
					Job_title_txf.setFont(font);
					Age_txf.setFont(font);
					Phone_number_txf.setFont(font);
					Income_txf.setFont(font);
					Manager_id_txf.setFont(font);
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.BOLD, 15);

					insert_btn.setFont(fonti);
					Read_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(Job_id_lb);
					frame.add(Job_title_lb);
					frame.add(Age_lb);
					frame.add(Phone_number_lb);
					frame.add(Manager_id_lb);
					frame.add(Income_lb);
					
					frame.add(Job_id_txf);
					frame.add(Job_title_txf);
					frame.add(Age_txf);
					frame.add(Phone_number_txf);
					frame.add(Income_txf);
					frame.add(Manager_id_txf);
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Read_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					ActionEvent();
				}
				@Override
				public void actionPerformed(ActionEvent e) {
					job_departments JD=new job_departments();
					if(e.getSource()==insert_btn) {
						JD.setJob_title(Job_title_txf.getText());
						JD.setAge(Age_txf.getText());
						JD.setPhone_number(Phone_number_txf.getText());
						JD.setIncome(Income_txf.getText());
						JD.setManager_id(Manager_id_txf.getText());
						JD.insertData();
					}else if (e.getSource()==Read_btn) {
						int id=Integer.parseInt(Job_id_txf.getText());
						JD.readwithID(id);
						Job_id_txf.setText(String.valueOf(JD.getJob_id()));
						Job_title_txf.setText(JD.getJob_title());
						Age_txf.setText(JD.getAge());
						Phone_number_txf.setText(JD.getPhone_number());
						Income_txf.setText(JD.getIncome());
						Manager_id_txf.setText(JD.getManager_id());
					}else if (e.getSource()==update_tbtn) {
						int Job_id=Integer.parseInt(Job_id_txf.getText());
						JD.setJob_title(Job_title_txf.getText());
						JD.setAge(Age_txf.getText());
						JD.setPhone_number(Phone_number_txf.getText());
						JD.setIncome(Income_txf.getText());
						JD.setManager_id(Manager_id_txf.getText());
						JD.update(Job_id);
					}else {
						int Job_id=Integer.parseInt(Job_id_txf.getText());
						JD.delete(Job_id);
					}

				}
				public static void main(String[] args) {
				 job_departmentsForm JDF=new job_departmentsForm();
					System.out.println(JDF);

				}

}




