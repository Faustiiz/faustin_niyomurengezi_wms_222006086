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

import entityforms.Worker;

public class WorkerForm  implements ActionListener{
	JFrame frame;
					JLabel worker_lb=new JLabel("Worker-ID");
					JLabel name_lb=new JLabel("Names");
					JLabel Address_lb=new JLabel("Address");
					JLabel job_lb=new JLabel("Job_title");
					JLabel telephone_lb=new JLabel("Telephone");
					
					JLabel sal_lb=new JLabel("Salary");
					JLabel empst_lb=new JLabel("Employment_status");
					JLabel mst_lb=new JLabel("martial_status");
					JLabel gender_lb=new JLabel("Gender");
					JLabel ma_lb=new JLabel("Manager_id");
					JLabel acc_lb=new JLabel("Accountant_id");
					JLabel Ad_lb=new JLabel("Admin_id");
					JTextField workerid_txf=new JTextField();
					JTextField names_txf=new JTextField();
					JTextField address_txf=new JTextField();
					JTextField job_txf=new JTextField();
					JTextField phone_txf=new JTextField();
					JTextField sal_txf=new JTextField();
					String []Employe_status={"Fulltime","parttime", "Hours"};
					JComboBox<String> employstatusBox = new JComboBox<>(Employe_status);
					String []Marital_status={"Single","Married", "Divorced"};
					JComboBox<String> MaritalstatusBox = new JComboBox<>(Marital_status);
					String []Gender={"Male","Female"};
					JComboBox<String> GenderBox = new JComboBox<>(Gender);
					JTextField manager_txf=new JTextField();
					JTextField accountant_txf=new JTextField();
					JTextField admin_txf=new JTextField();
					
	                       //Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					public  WorkerForm() {
						
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
						frame.setTitle("WORKER FORM");
						frame.setBounds(10, 10, 900, 800);
						frame.getContentPane().setLayout(null);
						frame.getContentPane().setBackground(Color.orange);
						frame.setVisible(true);
					     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setResizable(true);
						setLocationandSize();
					}


					private void setLocationandSize() {
						worker_lb.setBounds(10, 10, 200, 30);
						name_lb.setBounds(10, 50, 200, 30);
						Address_lb.setBounds(10, 90, 200, 30);
						job_lb.setBounds(10, 130, 200, 30);
						telephone_lb.setBounds(10, 170, 200, 30);
						sal_lb.setBounds(10, 210, 200, 30);
						empst_lb.setBounds(10, 250, 200, 30);
						mst_lb.setBounds(10, 290, 200, 30);
						gender_lb.setBounds(10, 330, 200, 30);
						ma_lb.setBounds(10, 370, 200, 30);
						acc_lb.setBounds(10, 410, 200, 30);
						Ad_lb.setBounds(10, 450, 200, 30);
						//text
						workerid_txf.setBounds(200, 10, 250, 30);
						names_txf.setBounds(200, 50, 250, 30);
						address_txf.setBounds(200, 90, 250, 30);
						job_txf.setBounds(200, 130, 250, 30);
						phone_txf.setBounds(200, 170, 250, 30);
						sal_txf.setBounds(200, 210, 250, 30);
						employstatusBox.setBounds(200, 250, 250, 30);
						MaritalstatusBox.setBounds(200, 290, 250, 30);
						GenderBox.setBounds(200, 330, 250, 30);
						manager_txf.setBounds(200, 370, 250, 30);
						accountant_txf.setBounds(200, 410, 250, 30);
						admin_txf.setBounds(200, 450, 250, 30);
						//Buttons CRUD
						insert_btn.setBounds(10,490, 120, 30);
						Read_btn.setBounds(140,490, 120, 30);
						update_tbtn.setBounds(270,490, 120, 30);
						delete_btn.setBounds(400,490, 120, 30);
						setFontforall();
						addcomponentforFrame();

					}
					private void setFontforall() {
						Font font = new Font("Georgia", Font.BOLD, 18);

						worker_lb.setFont(font);
						name_lb.setFont(font);
						Address_lb.setFont(font);
						address_txf.setFont(font);
						job_lb.setFont(font);
						telephone_lb.setFont(font);
						sal_lb.setFont(font);
						empst_lb.setFont(font);
						mst_lb.setFont(font);
						gender_lb.setFont(font);
						ma_lb.setFont(font);
						acc_lb.setFont(font);
						Ad_lb.setFont(font);
                           //text
						workerid_txf.setFont(font);
						names_txf.setFont(font);
						address_txf.setFont(font);
						job_txf.setFont(font);
						phone_txf.setFont(font);
						sal_txf.setFont(font);
						employstatusBox.setFont(font);
						MaritalstatusBox.setFont(font);
						GenderBox.setFont(font);
						manager_txf.setFont(font);
						accountant_txf.setFont(font);
						admin_txf.setFont(font);
						
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.BOLD, 20);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(worker_lb);
						frame.add(name_lb);
						frame.add(Address_lb);
						frame.add(job_lb);
						frame.add(telephone_lb);
						frame.add(sal_lb);
						frame.add(empst_lb);
						frame.add(mst_lb);
						frame.add(gender_lb);
						frame.add(ma_lb);
						frame.add(acc_lb);
						frame.add(Ad_lb);
						//add text
						frame.add(workerid_txf);
						frame.add(names_txf);
						frame.add(address_txf);
						frame.add(job_txf);
						frame.add(phone_txf);
						frame.add(sal_txf);
						frame.add(employstatusBox);
						frame.add(MaritalstatusBox);
						frame.add(GenderBox);
						frame.add(manager_txf);
						frame.add(accountant_txf);
						frame.add(admin_txf);
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
					public void actionPerformed(ActionEvent e) {
						Worker wrk=new Worker();
						if(e.getSource()==insert_btn) {
							wrk.setNames(names_txf.getText());
							wrk.setAddress(address_txf.getText());
							wrk.setJob_title(job_txf.getText());
							wrk.setPhone_number(phone_txf.getText());
							wrk.setSalary(sal_txf.getText());
							wrk.setEmployment_status(employstatusBox.getSelectedItem());
							wrk.setMarital_status(MaritalstatusBox.getSelectedItem());
							wrk.setGender(GenderBox.getSelectedItem());
							wrk.setManager_id(manager_txf.getText());
							wrk.setAccountant_id(accountant_txf.getText());
							wrk.setAdmin_id(admin_txf.getText());
							wrk.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(workerid_txf.getText());
							wrk.readwithID(id);
							workerid_txf.setText(String.valueOf(wrk.getWorker_id()));
							names_txf.setText(wrk.getNames());
							address_txf.setText(wrk.getAddress());
							job_txf.setText(wrk.getJob_title());
							phone_txf.setText(wrk.getPhone_number());
							sal_txf.setText(wrk.getSalary());
							employstatusBox.setSelectedItem(wrk.getEmployment_status());
							MaritalstatusBox.setSelectedItem(wrk.getMarital_status());
							GenderBox.setSelectedItem(wrk.getGender());
							manager_txf.setText(wrk.getManager_id());
							accountant_txf.setText(wrk.getAccountant_id());
							admin_txf.setText(wrk.getAdmin_id());
						}else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(workerid_txf.getText());
							wrk.setNames(names_txf.getText());
							wrk.setAddress(address_txf.getText());
							wrk.setJob_title(job_txf.getText());
							wrk.setPhone_number(phone_txf.getText());
							wrk.setSalary(sal_txf.getText());
							wrk.setEmployment_status(employstatusBox.getSelectedItem());
							wrk.setMarital_status(MaritalstatusBox.getSelectedItem());
							wrk.setGender(GenderBox.getSelectedItem());
							wrk.setManager_id(manager_txf.getText());
							wrk.setAccountant_id(accountant_txf.getText());
							wrk.setAdmin_id(admin_txf.getText());
							wrk.update(id);
						}else {
							int id=Integer.parseInt(workerid_txf.getText());
							wrk.delete(id);
						}

					}
					public static void main(String[] args) {
						WorkerForm wrkf=new WorkerForm();
						System.out.println(wrkf);

					}



				
				}




