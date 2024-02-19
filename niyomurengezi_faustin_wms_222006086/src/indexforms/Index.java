package indexforms;

import javax.swing.*;
import Forms.AccountantForm;
import Forms.AdminForm;
import Forms.ManagerForm;
import Forms.SalaryForm;
import Forms.UserRegisterForm;
import Forms.WorkerForm;
import Forms.job_departmentsForm;

import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener {

    private static final long serialVersionUID = 8986533555870500112L;
    private JMenuBar menuBar;
    private JMenu home, Worker, Accountant, userregister, Manager, Salary, Admin, job_departments;
    private JMenuItem exitMenuItem, storyMenu, aboutWorker, aboutAccountant, aboutUserRegister, aboutManager, aboutSalary, aboutAdmin, aboutjob_departments;
    private JTextArea textArea;

    public Index() {

        setTitle("Worker Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.black);

        // Create file menu
        home = new JMenu("Home");
        home.setForeground(Color.orange);
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setForeground(Color.pink);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        home.add(exitMenuItem);

        // Create worker menu
        Worker = new JMenu("Worker");
        Worker.setForeground(Color.red);
        aboutWorker = new JMenuItem("Worker");
        aboutWorker.addActionListener(this);
        aboutWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aboutWorker) {
                    new WorkerForm();
                }
            }
        });

        // Create accountant menu
        Accountant = new JMenu("Accountant");
        Accountant.setForeground(Color.green);
        aboutAccountant = new JMenuItem("Accountant");
        aboutAccountant.addActionListener(this);
        aboutAccountant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aboutAccountant) {
                    new AccountantForm();
                }
            }
        });

        // Create manager menu
        Manager = new JMenu("Manager");
        Manager.setForeground(Color.blue);
        aboutManager = new JMenuItem("Manager");
        aboutManager.addActionListener(this);
        aboutManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aboutManager) {
                    new ManagerForm();
                }
            }
        });

        // Create salary menu
        Salary = new JMenu("Salary");
        Salary.setForeground(Color.orange);
        aboutSalary = new JMenuItem("Salary");
        aboutSalary.addActionListener(this);
        aboutSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aboutSalary) {
                    new SalaryForm();
                }
            }
        });

        // Create user register menu
        userregister = new JMenu("User Register");
        userregister.setForeground(Color.CYAN);
        aboutUserRegister = new JMenuItem("User Register");
        aboutUserRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aboutUserRegister) {
                    new UserRegisterForm();
                }
            }
        });

        // Create admin menu
        Admin = new JMenu("Admin");
        Admin.setForeground(Color.gray);
        aboutAdmin = new JMenuItem("Admin");
        aboutAdmin.addActionListener(this);
        aboutAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aboutAdmin) {
                    new AdminForm();
                }
            }
        });

        // Create job departments menu
        job_departments = new JMenu("job_departments");
        job_departments.setForeground(Color.green);
        aboutjob_departments = new JMenuItem("job_departments");
        aboutjob_departments.addActionListener(this);
        job_departments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == job_departments) {
                    new job_departmentsForm();
                }
            }
        });

        // Create report menu
        
            
       

        // Create story menu item
        storyMenu = new JMenuItem("About");
        storyMenu.setBackground(Color.BLACK);
        storyMenu.setForeground(Color.YELLOW);
        storyMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStory();
            }
        });
        
            
       

        // Add components to menu bar
        home.add(exitMenuItem);
        Worker.add(aboutWorker);
        Accountant.add(aboutAccountant);
        Manager.add(aboutManager);
        Salary.add(aboutSalary);
        userregister.add(aboutUserRegister);
        Admin.add(aboutAdmin);
        job_departments.add(aboutjob_departments);

        menuBar.add(home);
        menuBar.add(Worker);
        menuBar.add(Accountant);
        menuBar.add(Manager);
        menuBar.add(Salary);
        menuBar.add(userregister);
        menuBar.add(Admin);
        menuBar.add(job_departments);
        menuBar.add(storyMenu);
        

        setJMenuBar(menuBar);

        // Create home page with index paragraphs and short story details
        textArea = new JTextArea();
        textArea.setBackground(new Color(116, 163, 202));
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("WELCOME to Worker_management_system_project_Application!\n\n" +
                "This application allows you to perform various tasks using GUI.\n\n" +
                "OUR MAIN PURPOSE is to Manage company's Workers information in relation to working rate and production.\n\n" +
                "BEFORE I STUDIED JAVA, I was not capable to build such a small project like this.\n\n" +
                "But after taking this course taught by our Lovely lecturer DR BUGINGO EMMANUEL,\n\nalong with this hardest journey, He shaped and transformed us in miraculous ways. " +
                "So about picking up this project after finishing this course,\n\n" +
                "I sit and think how big companies struggle with workers,\n\n" +
                "sometimes they do not produce enough productivity,\n\n" +
                "and also sometimes company loses their best due to overtime working even not getting reward then I decide to develop this system. \n\n" +
                "It held in five parts.\n\n" +
                "where this part of Worker, project, site, user registers, and also session shifted.\n\n" +
                "In all this system allows applying CRUD to every part of this project. In the end, working on that project was a victory.\n\n" +
                "even though there are some issues I have been facing up, " +
                "and I wish we could have enough time to practice not just for doing it as a project.\n\n" +
                "because programming language especially Java needs more practice with experts or\n\n" +
                "someone who has advanced knowledge in case you need help. " +
                "for me, I celebrate what we have been through and what I studied.\n\n" +
                "this project developed and designed by MR NIYOMURENGEZI FAUSTIN, student in BIT Department GROUP 1.\n\n" +
                "alright reserved. copyright \u00A9 2024 ");

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void showStory() {
        JOptionPane.showMessageDialog(null, textArea.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
