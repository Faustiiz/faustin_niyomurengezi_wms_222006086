package menu; 
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Forms.AccountantForm;
import Forms.AdminForm;
import Forms.job_departmentsForm;
import Forms.ManagerForm;
import Forms.SalaryForm;
import Forms.UserRegisterForm;
import Forms.WorkerForm;

public class MenuForm  extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
 
	    private JMenuBar menuBar;
	    
	    private JMenu AccountantMenu;
	    private JMenu AdminMenu;
	    private JMenu job_departmentsMenu;
	    private JMenu ManagerMenu;
	    private JMenu SalaryMenu;
	    private JMenu UserRegisterMenu;
	    private JMenu WorkerMenu;
	    private JMenu logoutMenu;

	    private JMenuItem AccountantItem;
	    private JMenuItem AdminItem;
	    private JMenuItem job_departmentsItem;
	    private JMenuItem ManagerItem;
	    private JMenuItem SalaryItem;
	    private JMenuItem UserRegisterItem;
	    private JMenuItem WorkerItem;
	    private JMenuItem LogoutItem;

	    private String loggedInUser;

	    public MenuForm(String username) {
	        this.loggedInUser = username;
	        setTitle("Dashboard");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Create menu bar
	        menuBar = new JMenuBar();

	        // Create menu items
	        AccountantMenu = new JMenu("Accountant");
	        AccountantItem = new JMenuItem("Accountant Form");
	        AccountantItem.addActionListener(this);

	        AdminMenu = new JMenu("Admin");
	        AdminItem = new JMenuItem("Admin Form");
	        AdminItem.addActionListener(this);

	        job_departmentsMenu = new JMenu("job_departments");
	        job_departmentsItem = new JMenuItem("job_departments Form");
	        job_departmentsItem.addActionListener(this);

	        ManagerMenu = new JMenu("Manager");
	        ManagerItem = new JMenuItem("Manager Form");
	        ManagerItem.addActionListener(this);

	        SalaryMenu = new JMenu("Salary");
	        SalaryItem = new JMenuItem("Salary Form");
	        SalaryItem.addActionListener(this);

	        UserRegisterMenu = new JMenu("UserRegister");
	        UserRegisterItem = new JMenuItem("UserRegister Form");
	        UserRegisterItem.addActionListener(this);
	        
	        
	        
	        WorkerMenu = new JMenu("Worker");
	        WorkerItem = new JMenuItem("Worker Form");
	        WorkerItem.addActionListener(this);

	        logoutMenu = new JMenu("Logout");
	        LogoutItem = new JMenuItem("Logout");
	        LogoutItem.addActionListener(this);

	        // Add menu items to respective menus
	        AccountantMenu.add(AccountantItem);
	        AdminMenu.add(AdminItem);
	        job_departmentsMenu.add(job_departmentsItem);
	        ManagerMenu.add(ManagerItem);
	        SalaryMenu.add(SalaryItem);
	        UserRegisterMenu.add(UserRegisterItem);
	        WorkerMenu.add(WorkerItem);
	        logoutMenu.add(LogoutItem);

	        // Add menus to menu bar
	        menuBar.add(AccountantMenu);
	        menuBar.add(AdminMenu);
	        menuBar.add(job_departmentsMenu);
	        menuBar.add(ManagerMenu);
	        menuBar.add(SalaryMenu);
	        menuBar.add(UserRegisterMenu);
	        menuBar.add(WorkerMenu);
	        menuBar.add(logoutMenu);

	        // Set menu bar to frame
	        setJMenuBar(menuBar);

	        // Initialize dashboard panel
	        JPanel dashboardPanel = new JPanel();
	        dashboardPanel.setLayout(new BorderLayout());

	        // Add components to dashboard panel
	        JLabel titleLabel = new JLabel("WELCOME TO THE "+loggedInUser+"");
	        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 50));
	        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

	        // Add dashboard panel to frame
	        add(dashboardPanel);

	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == AccountantItem) {
	            new AccountantForm();
	        } else if (e.getSource() == AdminItem) {
	            new AdminForm();
	        } else if (e.getSource() == job_departmentsItem) {
	            new job_departmentsForm();
	        } else if (e.getSource() == ManagerItem) {
	            new ManagerForm();
	        } else if (e.getSource() == SalaryItem) {
	            new SalaryForm();
	        } else if (e.getSource() == UserRegisterItem) {
	            new UserRegisterForm();
	        } else if (e.getSource() == WorkerItem) {
	            new WorkerForm();
	        
	        } else if (e.getSource() == LogoutItem) {
	            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	                dispose();
	            }
	        }
	    }
	    public static void main(String[] args) {
	    	SwingUtilities.invokeLater(() -> new MenuForm("Worker_management_system_project"));
	    }
	}

