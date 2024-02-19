package Forms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entityforms.Salary;
public class SalaryForm implements ActionListener{
	JFrame frame;
				JLabel id_lb=new JLabel("salary-id");
				JLabel Job_lb=new JLabel("job_id");
				JLabel Amount_lb=new JLabel("Amount");
				JLabel Monthly_lb=new JLabel("Monthly");
				JLabel Extra_lb=new JLabel("Extra");
				JLabel job_title_lb=new JLabel("Job_title");     
				JTextField id_txf=new JTextField();
				JTextField job_id_txf=new JTextField();
				JTextField Amount_txf=new JTextField();
				JTextField Monthly_txf=new JTextField();
				JTextField Extra_txf=new JTextField();
				JTextField job_title_txf=new JTextField();
                       //Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Read_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				
				public SalaryForm() {
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
					frame.setTitle("Salary FORM");
					frame.setBounds(10, 10, 800, 400);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().setBackground(Color.GRAY);
					frame.setVisible(true);
				     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(true);
					setLocationandSize();
				}


				private void setLocationandSize() {
					id_lb.setBounds(10, 10, 100, 30);
					Job_lb.setBounds(10, 50, 100, 30);
					Amount_lb.setBounds(10, 90, 100, 30);
					Monthly_lb.setBounds(10, 130, 100, 30);
					Extra_lb.setBounds(10, 170, 100, 30);
					job_title_lb.setBounds(10, 210, 100, 30);
                     
					id_txf.setBounds(160, 10, 250, 30);
					job_id_txf.setBounds(160, 50, 250, 30);
					Amount_txf.setBounds(160, 90, 250, 30);
					Monthly_txf.setBounds(160, 130, 250, 30);
					Extra_txf.setBounds(160, 170, 250, 30);
					job_title_txf.setBounds(160, 210, 250, 30);
					//Buttons CRUD
					insert_btn.setBounds(10,250, 100, 30);
					Read_btn.setBounds(120,250, 125, 30);
					update_tbtn.setBounds(260,250, 150, 30);
					delete_btn.setBounds(420,250, 175, 30);
					setFontforall();
					addcomponentforFrame();

				}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					id_lb.setFont(font);
					Job_lb.setFont(font);
					Amount_lb.setFont(font);
					Monthly_lb.setFont(font);
					Extra_lb.setFont(font);
					job_title_lb.setFont(font);

					id_txf.setFont(font);
					job_id_txf.setFont(font);
					Amount_txf.setFont(font);
					Monthly_txf.setFont(font);
					Extra_txf.setFont(font);
					job_title_lb.setFont(font);
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.BOLD, 15);

					insert_btn.setFont(fonti);
					Read_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(id_lb);
					frame.add(Job_lb);
					frame.add(Amount_lb);
					frame.add(Monthly_lb);
					frame.add(job_title_lb);
					frame.add(Extra_lb);
					
					frame.add(id_txf);
					frame.add(job_id_txf);
					frame.add(Amount_txf);
					frame.add(Monthly_txf);
					frame.add(Extra_txf);
					frame.add(job_title_txf);
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Read_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					ActionEvent();
				}
				@Override
				public void actionPerformed(ActionEvent e) {
					Salary SL=new Salary();
					if(e.getSource()==insert_btn) {
						SL.setJob_id(job_id_txf.getText());
						SL.setAmount(Amount_txf.getText());
						SL.setMonthly(Monthly_txf.getText());
						SL.setExtra(Extra_txf.getText());
						SL.setJob_title(job_title_txf.getText());
						SL.insertData();
					}else if (e.getSource()==Read_btn) {
						int id=Integer.parseInt(id_txf.getText());
						SL.readwithID(id);
						id_txf.setText(String.valueOf(SL.getSalary_id()));
						job_id_txf.setText(SL.getJob_id());
						Amount_txf.setText(SL.getAmount());
						Monthly_txf.setText(SL.getMonthly());
						Extra_txf.setText(SL.getExtra());
						job_title_txf.setText(SL.getJob_title());
					}else if (e.getSource()==update_tbtn) {
						int id=Integer.parseInt(id_txf.getText());
						SL.setJob_id(job_id_txf.getText());
						SL.setAmount(Amount_txf.getText());
						SL.setMonthly(Monthly_txf.getText());
						SL.setExtra(Extra_txf.getText());
						SL.setJob_title(job_title_txf.getText());
						SL.update(id);
					}else {
						int id=Integer.parseInt(id_txf.getText());
						SL.delete(id);
					}

				}
				public static void main(String[] args) {
					SalaryForm SLf=new SalaryForm();
					System.out.println(SLf);

				}

}
