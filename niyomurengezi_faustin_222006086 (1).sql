-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:51 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `niyomurengezi_faustin_222006086`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateSalaryAboveAverageView` ()   BEGIN
    SET @sql = '
    CREATE OR REPLACE VIEW SalaryAboveAverageView AS
    SELECT w.worker_id, w.Names, w.Job_title, w.Salary
    FROM worker w
    WHERE w.Salary > (
        SELECT AVG(s.Salary)
        FROM worker s
        WHERE s.Job_title = w.Job_title
    );
    ';
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteInactiveUsersAndCustomers` ()   BEGIN
    
    DELETE FROM user
    WHERE DATEDIFF(NOW(), last_login_date) > 365;
    
    
    DELETE FROM customer
    WHERE customer_id NOT IN (SELECT customer_id FROM ORDERS WHERE DATEDIFF(NOW(), order_date) <= 365);
    
    SELECT 'Inactive users and customers deleted successfully.' AS message;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteJobDepartmentsByAge` (IN `p_MaxAge` INT)   BEGIN
    DELETE FROM job_departments
    WHERE Age > p_MaxAge;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteWorkersByEmploymentStatus` (IN `p_EmploymentStatus` VARCHAR(100))   BEGIN
    DELETE FROM worker
    WHERE Employment_status = p_EmploymentStatus;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayAccountantData` ()   BEGIN
    SELECT * FROM accountant;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayAdminData` ()   BEGIN
    SET @sql = 'SELECT * FROM admin';
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayFinishesData` ()   BEGIN
    SELECT * FROM finishes;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayJobDepartmentsData` ()   BEGIN
    SELECT * FROM job_departments;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayManagerData` ()   BEGIN
    SELECT * FROM manager;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayPayrollsData` ()   BEGIN
    SELECT * FROM payrolls;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplaySalaryData` ()   BEGIN
    SELECT * FROM salary;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayWorkerData` ()   BEGIN
    SELECT * FROM worker;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertAccountant` (IN `p_First_name` VARCHAR(50), IN `p_Last_name` VARCHAR(100), IN `p_Email` VARCHAR(200), IN `p_Address` VARCHAR(50), IN `p_Salary` INT, IN `p_Education_Level` VARCHAR(25), IN `p_Gender` CHAR, IN `p_Phone_number` VARCHAR(10), IN `p_Admin_id` INT)   BEGIN
    INSERT INTO accountant (First_name, Last_name, Email, Address, Salary, Education_Level, Gender, Phone_number, Admin_id)
    VALUES (p_First_name, p_Last_name, p_Email, p_Address, p_Salary, p_Education_Level, p_Gender, p_Phone_number, p_Admin_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertAdmin` (IN `p_Names` VARCHAR(225), IN `p_Email` VARCHAR(200), IN `p_Address` VARCHAR(40), IN `p_Phone_number` VARCHAR(10))   BEGIN
    INSERT INTO Admin (Names, Email, Address, Phone_number)
    VALUES (p_Names, p_Email, p_Address, p_Phone_number);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFinishes` (IN `p_worker_id` INT, IN `p_Date` DATE, IN `p_Reason_for_leaving` VARCHAR(255))   BEGIN
    INSERT INTO finishes (worker_id, Date, Reason_for_leaving)
    VALUES (p_worker_id, p_Date, p_Reason_for_leaving);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertJobDepartment` (IN `p_Job_title` VARCHAR(225), IN `p_Age` INT, IN `p_Phone_number` VARCHAR(10), IN `p_Income` INT, IN `p_Manager_id` INT)   BEGIN
    INSERT INTO job_department (Job_title, Age, Phone_number, Income, Manager_id)
    VALUES (p_Job_title, p_Age, p_Phone_number, p_Income, p_Manager_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertJobDepartments` (IN `p_Job_title` VARCHAR(225), IN `p_Age` INT, IN `p_Phone_number` VARCHAR(10), IN `p_Income` INT, IN `p_Manager_id` INT)   BEGIN
    INSERT INTO job_department (Job_title, Age, Phone_number, Income, Manager_id)
    VALUES (p_Job_title, p_Age, p_Phone_number, p_Income, p_Manager_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertManager` (IN `p_First_name` VARCHAR(50), IN `p_Last_name` VARCHAR(100), IN `p_Email` VARCHAR(200), IN `p_Address` VARCHAR(50), IN `p_Salary` INT, IN `p_Qualification` VARCHAR(50), IN `p_Phone_number` VARCHAR(10), IN `p_Admin_id` INT)   BEGIN
    INSERT INTO manager (First_name, Last_name, Email, Address, Salary, Qualification, Phone_number, Admin_id)
    VALUES (p_First_name, p_Last_name, p_Email, p_Address, p_Salary, p_Qualification, p_Phone_number, p_Admin_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertPayroll` (IN `p_Job_id` INT, IN `p_Salary_id` INT, IN `p_Finish_id` INT, IN `p_Accountant_id` INT, IN `p_Manager_id` INT, IN `p_worker_id` INT, IN `p_date` DATE, IN `p_total_amount` INT)   BEGIN
    INSERT INTO payrolls (Job_id, Salary_id, Finish_id, Accountant_id, Manager_id, worker_id, date, total_amount)
    VALUES (p_Job_id, p_Salary_id, p_Finish_id, p_Accountant_id, p_Manager_id, p_worker_id, p_date, p_total_amount);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertSalary` (IN `p_worker_id` INT, IN `p_amount` INT)   BEGIN
    INSERT INTO salary (worker_id, amount)
    VALUES (p_worker_id, p_amount);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertWorker` (IN `p_Names` VARCHAR(255), IN `p_Address` VARCHAR(100), IN `p_Job_title` VARCHAR(225), IN `p_Phone_number` VARCHAR(10), IN `p_Salary` INT, IN `p_Employment_status` VARCHAR(100), IN `p_Marital_status` VARCHAR(40), IN `p_Gender` CHAR, IN `p_Manager_id` INT, IN `p_Accountant_id` INT, IN `p_Admin_id` INT)   BEGIN
    INSERT INTO worker (Names, Address, Job_title, Phone_number, Salary, Employment_status, Marital_status, Gender, Manager_id, Accountant_id, Admin_id)
    VALUES (p_Names, p_Address, p_Job_title, p_Phone_number, p_Salary, p_Employment_status, p_Marital_status, p_Gender, p_Manager_id, p_Accountant_id, p_Admin_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateManager` (IN `p_manager_id` INT, IN `p_NewEmail` VARCHAR(200), IN `p_NewAddress` VARCHAR(50))   BEGIN
    UPDATE manager
    SET Email = p_NewEmail, Address = p_NewAddress
    WHERE Manager_id = p_manager_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateWorker` (IN `p_worker_id` INT, IN `p_NewPhone` VARCHAR(10), IN `p_NewSalary` INT)   BEGIN
    UPDATE worker
    SET Phone_number = p_NewPhone, Salary = p_NewSalary
    WHERE worker_id = p_worker_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `above_average_salary_workers`
-- (See below for the actual view)
--
CREATE TABLE `above_average_salary_workers` (
`worker_id` int(11)
,`Names` varchar(255)
,`Job_title` varchar(225)
,`Salary` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `accountant`
--

CREATE TABLE `accountant` (
  `Accountant_id` int(11) NOT NULL,
  `First_name` varchar(50) NOT NULL,
  `Last_name` varchar(100) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Salary` int(11) DEFAULT NULL,
  `Education_Level` varchar(25) NOT NULL,
  `Gender` char(6) DEFAULT NULL,
  `Phone_number` varchar(10) DEFAULT NULL,
  `Admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accountant`
--

INSERT INTO `accountant` (`Accountant_id`, `First_name`, `Last_name`, `Email`, `Address`, `Salary`, `Education_Level`, `Gender`, `Phone_number`, `Admin_id`) VALUES
(1, 'rodrigue', 'ganza', 'ganza@gmail.com', '250 Accountant Street', 450600, 'A2', 'Male', '0734575333', NULL),
(2, 'liliane', 'gahongayire', 'liliane@gmail.com', '250 stock Accountant ', 400600, 'A1', 'Male', '078575333', NULL),
(3, 'didier', 'muckoma', 'mucyo@gmail.com', '250 export collection Accountant ', 556600, 'A2', 'Male', '0794575654', NULL),
(4, 'thierry', 'mugisha', 'ganzathierry@gmail.com', '250 imprt Accountant ', 450600, 'A0', 'Male', '0724572133', NULL),
(5, 'alex', 'ngamije', 'ngamije@gmail.com', '250 local Accountant ', 480600, 'A2', 'Male', '0785672765', NULL),
(6, 'Jane', 'Smith', 'janesmith@example.com', '456 Accountant Ave', 55000, 'CA', 'F', '666-666-66', 2),
(22, 'qwer', 'sdfg', 'asdfgzasdf', 'asdf', 45, 'A0', 'Female', '23456', NULL),
(23, 'didier', 'muckoma', 'mucyo@gmail.com', '250 export collection Accountant ', 556600, 'A2', 'Male', '0794575654', NULL),
(24, 'liliane', 'gahongayire', 'liliane@gmail.com', '250 stock Accountant ', 400600, 'A1', 'Male', '078575333', NULL),
(25, 'wertyu', 'ertyu', 'x@gmail.com', '23456', 123456789, 'A2', 'Male', '0782345674', NULL),
(26, 'rodrigue', 'ganza', 'ganza@gmail.com', '250 Accountant Street', 450600, 'A2', 'Male', '0734575333', NULL),
(27, 'qwertyui', 'asdfghj', 'asdfghj', '1234', 12345678, 'A1', 'Male', '0782345565', NULL),
(28, 'WERTYUI', 'WDFGHJK', 'SDFGHJKL', '234567', 34567890, 'A2', 'Male', '23456789', NULL),
(29, 'wertyui', 'sdfghjk', 'sdfghjkl', 'dfghjkl', 234567890, 'A2', 'Male', '34567890', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `accountants`
--

CREATE TABLE `accountants` (
  `Accountant_id` int(250) NOT NULL,
  `First_name` varchar(250) NOT NULL,
  `Last_name` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Salary` int(250) NOT NULL,
  `Education_Level` varchar(250) NOT NULL,
  `Gender` char(250) NOT NULL,
  `Phone_number` int(250) NOT NULL,
  `Admin_id` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accountants`
--

INSERT INTO `accountants` (`Accountant_id`, `First_name`, `Last_name`, `Email`, `Address`, `Salary`, `Education_Level`, `Gender`, `Phone_number`, `Admin_id`) VALUES
(1, 'x', 'f', 'c', 'v', 2345, 'A2', 'Male', 234532, 1),
(3, 'xan', 'flole', 'cxcv', 'v-tz21', 234500, 'A0', 'Female', 23453212, 2);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_id` int(11) NOT NULL,
  `Names` varchar(225) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Phone_number` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_id`, `Names`, `Email`, `Address`, `Phone_number`) VALUES
(1, 'Jahn Kabera', 'jahn@gmail.com', '123 Admin Street', '0784567890'),
(2, 'asante ', '250 Admin Salary', 'asante@gmail.com', '0784560090'),
(3, 'rukundo mervin', 'rukundo@gmail.com', '250 Admin accountant', '0784500890'),
(4, 'gisa faustin', 'gisa@gmail.com', '250 Admin HR', '0784567880'),
(5, 'Felix Mukuta', 'felix@gmail.com', '456 Admin Avenue', '0786543210'),
(6, 'John Doe', 'johndoe@example.com', '123 Admin St', '555-555-55'),
(7, 'John Doe', 'johndoe@example.com', '123 Admin St', '555-555-55'),
(8, 'John Doe', 'johndoe@.com', '123 Admin St', '555-555-55'),
(9, 'John Doe', 'johndoe@example.com', '123 Admin St', '555-555-55'),
(10, 'John Doe', 'johndoe@.com', '123 Admin St', '555-555-55'),
(11, 'John Doe', 'johndoe@.com', '123 Admin St', '555-555-55'),
(12, 'John Doe', 'johndoe@.com', '123 Admin St', '555-555-55'),
(19, 'werty', 'wert@', '345', '2345678900'),
(21, 'admin', 'xx@gmail.com', 'huye', '23456765'),
(22, 'qwertyu', 'sdfgh', 'sdfghj', '23456789'),
(23, 'rtyuiop', 'ertyuio', 'eertyui', '0782345666');

-- --------------------------------------------------------

--
-- Table structure for table `finishes`
--

CREATE TABLE `finishes` (
  `Finish_id` int(11) NOT NULL,
  `worker_id` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Reason_for_leaving` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `finishes`
--

INSERT INTO `finishes` (`Finish_id`, `worker_id`, `Date`, `Reason_for_leaving`) VALUES
(27, 6, '2023-08-15', 'Personal reasons'),
(28, 7, '2023-07-20', 'Found a better job opportunity'),
(29, 8, '2023-09-10', 'Relocation'),
(30, 9, '2023-06-25', 'Career change'),
(31, 10, '2023-07-05', 'Company downsizing');

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_accountantrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_accountantrview` (
`Accountant_id` int(11)
,`First_name` varchar(50)
,`Last_name` varchar(100)
,`Email` varchar(200)
,`Address` varchar(50)
,`Salary` int(11)
,`Education_Level` varchar(25)
,`Gender` char(6)
,`Phone_number` varchar(10)
,`Admin_id` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_adminrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_adminrview` (
`Admin_id` int(11)
,`Names` varchar(225)
,`Email` varchar(200)
,`Address` varchar(40)
,`Phone_number` varchar(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_data`
-- (See below for the actual view)
--
CREATE TABLE `insert_data` (
`accountant_id` int(11)
,`last_name` varchar(100)
,`admin_id` int(11)
,`finish_id` int(11)
,`date` date
,`job_id` int(11)
,`job_title` varchar(225)
,`manager_id` int(11)
,`first_name` varchar(50)
,`email` varchar(200)
,`payroll_id` int(11)
,`total_amount` int(11)
,`salary_id` int(11)
,`amount` int(11)
,`worker_id` int(11)
,`names` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_finishesrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_finishesrview` (
`Finish_id` int(11)
,`worker_id` int(11)
,`Date` date
,`Reason_for_leaving` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_jobdepartmentsrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_jobdepartmentsrview` (
`Job_id` int(11)
,`Job_title` varchar(225)
,`Age` int(11)
,`Phone_number` varchar(10)
,`Income` int(11)
,`Manager_id` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_managerview`
-- (See below for the actual view)
--
CREATE TABLE `insert_managerview` (
`Manager_id` int(11)
,`First_name` varchar(50)
,`Last_name` varchar(100)
,`Email` varchar(200)
,`Address` varchar(50)
,`Salary` int(11)
,`Qualification` varchar(50)
,`Phone_number` varchar(10)
,`Admin_id` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_payrollssrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_payrollssrview` (
`Payroll_id` int(11)
,`Job_id` int(11)
,`Salary_id` int(11)
,`Finish_id` int(11)
,`Accountant_id` int(11)
,`Manager_id` int(11)
,`worker_id` int(11)
,`date` date
,`total_amount` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_salaryrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_salaryrview` (
`Salary_id` int(11)
,`Job_id` int(11)
,`Amount` int(11)
,`Monthly` int(11)
,`Extra` varchar(20)
,`job_title` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insert_workerrview`
-- (See below for the actual view)
--
CREATE TABLE `insert_workerrview` (
`Worker_id` int(11)
,`Names` varchar(255)
,`Address` varchar(100)
,`Job_title` varchar(225)
,`Phone_number` varchar(10)
,`Salary` int(11)
,`Employment_status` varchar(100)
,`Marital_status` varchar(40)
,`Gender` char(6)
,`Manager_id` int(11)
,`Accountant_id` int(11)
,`Admin_id` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `job_department`
--

CREATE TABLE `job_department` (
  `Job_id` int(11) NOT NULL,
  `Job_title` varchar(250) NOT NULL,
  `Age` int(11) DEFAULT NULL,
  `Phone_number` varchar(10) NOT NULL,
  `Income` int(11) DEFAULT NULL,
  `Manager_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job_department`
--

INSERT INTO `job_department` (`Job_id`, `Job_title`, `Age`, `Phone_number`, `Income`, `Manager_id`) VALUES
(1, 'cooking', 20, '2975842', 3000000, 1),
(2, 'analyist', 20, '29758', 35000000, 1),
(3, 'manager', 20, '2975842', 90000000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `job_departments`
--

CREATE TABLE `job_departments` (
  `Job_id` int(11) NOT NULL,
  `Job_title` varchar(225) NOT NULL,
  `Age` int(11) DEFAULT NULL,
  `Phone_number` varchar(10) NOT NULL,
  `Income` int(11) DEFAULT NULL,
  `Manager_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job_departments`
--

INSERT INTO `job_departments` (`Job_id`, `Job_title`, `Age`, `Phone_number`, `Income`, `Manager_id`) VALUES
(1, 'IT specialist', 34, '0786754321', 60000, 1),
(2, 'Financial Analyst', 28, '0785664321', 5500000, 2),
(3, 'IT Specialist', 32, '07543257', 65000000, 1),
(4, 'IT Specialist', 32, '07543257', 65000000, 3),
(5, 'Sales Representative', 29, '078866655', 50000000, 2),
(6, 'HR Manager', 30, '0786754321', 60000000, 1),
(7, 'Financial Analyst', 28, '0785664321', 5500000, 2),
(9, 'IT Specialist', 32, '07543257', 65000000, 3),
(10, 'Sales Representative', 29, '078866655', 50000000, 2),
(82, 'cook', 31, '12345678', 1234567866, 3),
(83, 'cooking', 32, '3456789777', 23456789, 1),
(84, 'IT specialist', 23, '0786754321', 6000000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `Manager_id` int(11) NOT NULL,
  `First_name` varchar(50) NOT NULL,
  `Last_name` varchar(100) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Salary` int(11) DEFAULT NULL,
  `Qualification` varchar(50) NOT NULL,
  `Phone_number` varchar(10) DEFAULT NULL,
  `Admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`Manager_id`, `First_name`, `Last_name`, `Email`, `Address`, `Salary`, `Qualification`, `Phone_number`, `Admin_id`) VALUES
(1, 'Jean Pierre', 'Niyotwambaza', 'newemail@example.com', 'New Manager Address', 60000, 'A0', '0786453000', 1),
(2, 'ALICE', 'UMUTONI', 'alice@gmail.com', '250 HR Manager ', 550000, 'BSc', '0734500000', 2),
(3, 'jean paul', 'jeanpaul', 'newemail@gmail.com', '250 Manager Avenue', 55000, 'BSc', '0784507600', 3),
(4, 'dany', 'mugisha', 'dany@gmail.com', '250 import/export Manager ', 295000, 'BSc', '0794500740', 4),
(5, 'jeannette', 'UMUTONI', 'jeannette@gmail.com', '250 infrastucture Manager ', 653200, ' A0', '0787454326', 5);

--
-- Triggers `manager`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertmanager` AFTER INSERT ON `manager` FOR EACH ROW BEGIN
    
    INSERT INTO manager_audit (manager_id, action, action_date)
    VALUES (NEW.manager_id, 'INSERT', NOW());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterUpdatemanager` AFTER UPDATE ON `manager` FOR EACH ROW BEGIN
    INSERT INTO manager_audit (manager_id, action, action_date)
VALUES (NEW.manager_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

CREATE TABLE `managers` (
  `Manager_id` int(250) NOT NULL,
  `First_name` varchar(250) NOT NULL,
  `Last_name` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Salary` varchar(250) NOT NULL,
  `Qualification` varchar(250) NOT NULL,
  `Phone_number` int(250) NOT NULL,
  `Admin_id` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `manager_audit`
--

CREATE TABLE `manager_audit` (
  `audit_id` int(11) NOT NULL,
  `First_name` varchar(255) NOT NULL,
  `Last_name` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Salary` varchar(20) NOT NULL,
  `Qualification` varchar(20) NOT NULL,
  `Phone_number` varchar(255) NOT NULL,
  `Admin_id` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manager_audit`
--

INSERT INTO `manager_audit` (`audit_id`, `First_name`, `Last_name`, `Email`, `Address`, `Salary`, `Qualification`, `Phone_number`, `Admin_id`) VALUES
(4, 'asdfghjk', 'asdfghjkl', 'asdfghjkl', 'sfghjkl', 'rtyujkl', 'A2', '234567890', '2'),
(5, 'Jean Pieere', 'Niyotwambaza', 'wertyui', 'sdfghjk', '234567', 'Master', '234567890', '2'),
(6, 'wertyuio', 'wertyhj', 'wertyu', 'huye', '23456789', 'A1', '078345678', '1'),
(7, 'sdfghiop', 'ertyuio', 'drtyuiop', 'sdrtyuiop', 'drtyuiop', 'A1', 'werty7u89', '1');

-- --------------------------------------------------------

--
-- Table structure for table `payrolls`
--

CREATE TABLE `payrolls` (
  `Payroll_id` int(11) NOT NULL,
  `Job_id` int(11) DEFAULT NULL,
  `Salary_id` int(11) DEFAULT NULL,
  `Finish_id` int(11) DEFAULT NULL,
  `Accountant_id` int(11) DEFAULT NULL,
  `Manager_id` int(11) DEFAULT NULL,
  `worker_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `total_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payrolls`
--

INSERT INTO `payrolls` (`Payroll_id`, `Job_id`, `Salary_id`, `Finish_id`, `Accountant_id`, `Manager_id`, `worker_id`, `date`, `total_amount`) VALUES
(7, 1, 1, 27, 1, 1, 6, '2023-07-31', 300000),
(8, 2, 2, 28, 2, 2, 7, '2023-12-31', 230000),
(9, 3, 3, 29, 3, 3, 8, '2023-01-31', 430000),
(10, 4, 4, 30, 4, 4, 9, '0000-00-00', 120000),
(11, 5, 5, 31, 5, 5, 10, '2023-08-31', 280000);

--
-- Triggers `payrolls`
--
DELIMITER $$
CREATE TRIGGER `payrolls` AFTER DELETE ON `payrolls` FOR EACH ROW BEGIN
   INSERT INTO payrolls (payrolls_id, action, action_date)
    VALUES (payrolls_id, 'DELETE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `Salary_id` int(11) NOT NULL,
  `Job_id` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Monthly` int(11) DEFAULT NULL,
  `Extra` varchar(20) NOT NULL,
  `job_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`Salary_id`, `Job_id`, `Amount`, `Monthly`, `Extra`, `job_title`) VALUES
(1, 1, 2500000, 35000, '10000', 'Assistant'),
(2, 1, 200000, 300000, '20000', 'accountant'),
(3, NULL, 500000000, 75000, '70000', 'infrastractue manager'),
(4, NULL, 80000000, 65000, '90000', 'HR manager'),
(5, NULL, 23000000, 32000, '30000', 'Clerk');

--
-- Triggers `salary`
--
DELIMITER $$
CREATE TRIGGER `AfterDeletesalary` AFTER DELETE ON `salary` FOR EACH ROW BEGIN
  UPDATE club SET total_salary = total_salary - 1 WHERE salary_id = salary_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `salaryaboveaverageview`
-- (See below for the actual view)
--
CREATE TABLE `salaryaboveaverageview` (
`worker_id` int(11)
,`Names` varchar(255)
,`Job_title` varchar(225)
,`Salary` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `salarys`
--

CREATE TABLE `salarys` (
  `salary_Id` int(6) NOT NULL,
  `Job_id` varchar(20) NOT NULL,
  `Amount` varchar(250) NOT NULL,
  `Monthly` varchar(250) NOT NULL,
  `Extra` varchar(250) NOT NULL,
  `job_title` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salarys`
--

INSERT INTO `salarys` (`salary_Id`, `Job_id`, `Amount`, `Monthly`, `Extra`, `job_title`) VALUES
(1, '1', '30000', '40000', '150000', 'manager'),
(3, '1', '30000', '40000', '150000', 'cleaner'),
(4, '1', '30000', '40000', '150000', 'cooker'),
(5, '1', '30000', '40000', '150000', 'student');

-- --------------------------------------------------------

--
-- Stand-in structure for view `updatable_admin`
-- (See below for the actual view)
--
CREATE TABLE `updatable_admin` (
`Admin_id` int(11)
,`Names` varchar(225)
,`Email` varchar(200)
,`Address` varchar(40)
,`Phone_number` varchar(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `updatable_manager_info`
-- (See below for the actual view)
--
CREATE TABLE `updatable_manager_info` (
`Manager_id` int(11)
,`First_name` varchar(50)
,`Last_name` varchar(100)
,`Email` varchar(200)
,`Address` varchar(50)
,`Phone_number` varchar(10)
,`Qualification` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `update_manager_info`
-- (See below for the actual view)
--
CREATE TABLE `update_manager_info` (
`Manager_id` int(11)
,`First_name` varchar(50)
,`Last_name` varchar(100)
,`Email` varchar(200)
,`Address` varchar(50)
,`Phone_number` varchar(10)
,`Qualification` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `update_worker_info`
-- (See below for the actual view)
--
CREATE TABLE `update_worker_info` (
`Worker_id` int(11)
,`Names` varchar(255)
,`Job_title` varchar(225)
,`Phone_number` varchar(10)
,`Salary` int(11)
,`Employment_status` varchar(100)
,`Marital_status` varchar(40)
);

-- --------------------------------------------------------

--
-- Table structure for table `userregister`
--

CREATE TABLE `userregister` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(250) NOT NULL,
  `last_name` varchar(250) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(250) NOT NULL,
  `email_id` varchar(250) NOT NULL,
  `mobile_number` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userregister`
--

INSERT INTO `userregister` (`user_id`, `first_name`, `last_name`, `username`, `password`, `email_id`, `mobile_number`) VALUES
(2, 'kagaba', 'llll', 'Faustin', '222006086\r\n', '2', '23456'),
(7, 'wertyui', 'wertyui', 'cc', '23456', 'x@gmail.com', '0782345678');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `Worker_id` int(11) NOT NULL,
  `Names` varchar(255) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Job_title` varchar(225) NOT NULL,
  `Phone_number` varchar(10) NOT NULL,
  `Salary` int(11) NOT NULL,
  `Employment_status` varchar(100) NOT NULL,
  `Marital_status` varchar(40) NOT NULL,
  `Gender` char(6) NOT NULL,
  `Manager_id` int(11) DEFAULT NULL,
  `Accountant_id` int(11) DEFAULT NULL,
  `Admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`Worker_id`, `Names`, `Address`, `Job_title`, `Phone_number`, `Salary`, `Employment_status`, `Marital_status`, `Gender`, `Manager_id`, `Accountant_id`, `Admin_id`) VALUES
(6, 'Alice Mukamana', '123 Worker Street', 'Assistant', '0786543243', 30000, 'Full-time', 'Single', 'F', 1, 1, 1),
(7, 'Jean Kabarebe', '123 Worker Street', 'Assistant', '0786543243', 30000, 'Full-time', 'Single', 'M', 3, 3, 3),
(8, 'Pierre Niyomurengezi', '123 Worker Street', 'Assistant', '0786543243', 870000, 'Full-time', 'Single', 'M', 4, 4, 4),
(9, 'Titien Mbarushimana', '123 Worker Street', 'Assistant', '0786003243', 300000, 'Full-time', 'Single', 'M', 5, 5, 5),
(10, 'Domin Imabera', '456 Worker Avenue', 'Senior Clerk', '0734554567', 28000, 'Full-time', 'Married', 'F', 2, 2, 2);

--
-- Triggers `worker`
--
DELIMITER $$
CREATE TRIGGER `AfterUpdateworker` AFTER UPDATE ON `worker` FOR EACH ROW BEGIN
    INSERT INTO worker_audit (worker_id, action, action_date)
    VALUES (NEW.worker_id, 'UPDATE', NOW());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `WorkerAfterInsert` AFTER INSERT ON `worker` FOR EACH ROW BEGIN
    IF NEW.Salary >= 30000 THEN
        UPDATE worker
        SET Employment_status = 'full_time'
        WHERE worker_id = NEW.worker_id;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `workers_to_delete`
-- (See below for the actual view)
--
CREATE TABLE `workers_to_delete` (
`Worker_id` int(11)
,`Names` varchar(255)
,`Address` varchar(100)
,`Job_title` varchar(225)
,`Phone_number` varchar(10)
,`Salary` int(11)
,`Employment_status` varchar(100)
,`Marital_status` varchar(40)
,`Gender` char(6)
,`Manager_id` int(11)
,`Accountant_id` int(11)
,`Admin_id` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `worker_audit`
--

CREATE TABLE `worker_audit` (
  `worker_id` int(11) NOT NULL,
  `Names` varchar(255) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Job_title` varchar(255) NOT NULL,
  `Phone_number` varchar(10) NOT NULL,
  `Salary` int(11) NOT NULL,
  `Employment_status` varchar(100) NOT NULL,
  `Maritial_status` varchar(40) NOT NULL,
  `Gender` char(6) NOT NULL,
  `Manager` int(11) DEFAULT NULL,
  `Accountant` int(11) DEFAULT NULL,
  `Admin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `worker_audit`
--

INSERT INTO `worker_audit` (`worker_id`, `Names`, `Address`, `Job_title`, `Phone_number`, `Salary`, `Employment_status`, `Maritial_status`, `Gender`, `Manager`, `Accountant`, `Admin`) VALUES
(3, 'cccc', 'xxx', 'vvvvv', '23457654', 2345000, 'Fulltime', 'Married', 'Male', 2, 2, 3),
(4, 'Pierre Niyomurengezi', '123', 'Assistant', 'rtyuio', 123456789, 'parttime', 'Married', 'Female', 2, 2, 2),
(5, 'xxx', 'xxxyyyy', 'xssswww', '234555', 2345, 'Fulltime', 'Married', 'Female', 5, 5, 5);

-- --------------------------------------------------------

--
-- Structure for view `above_average_salary_workers`
--
DROP TABLE IF EXISTS `above_average_salary_workers`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `above_average_salary_workers`  AS SELECT `worker`.`Worker_id` AS `worker_id`, `worker`.`Names` AS `Names`, `worker`.`Job_title` AS `Job_title`, `worker`.`Salary` AS `Salary` FROM `worker` WHERE `worker`.`Salary` > (select avg(`worker`.`Salary`) from `worker`) ;

-- --------------------------------------------------------

--
-- Structure for view `insert_accountantrview`
--
DROP TABLE IF EXISTS `insert_accountantrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_accountantrview`  AS SELECT `accountant`.`Accountant_id` AS `Accountant_id`, `accountant`.`First_name` AS `First_name`, `accountant`.`Last_name` AS `Last_name`, `accountant`.`Email` AS `Email`, `accountant`.`Address` AS `Address`, `accountant`.`Salary` AS `Salary`, `accountant`.`Education_Level` AS `Education_Level`, `accountant`.`Gender` AS `Gender`, `accountant`.`Phone_number` AS `Phone_number`, `accountant`.`Admin_id` AS `Admin_id` FROM `accountant` WHERE `accountant`.`Accountant_id` = 9 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_adminrview`
--
DROP TABLE IF EXISTS `insert_adminrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_adminrview`  AS SELECT `admin`.`Admin_id` AS `Admin_id`, `admin`.`Names` AS `Names`, `admin`.`Email` AS `Email`, `admin`.`Address` AS `Address`, `admin`.`Phone_number` AS `Phone_number` FROM `admin` WHERE `admin`.`Admin_id` = 5 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_data`
--
DROP TABLE IF EXISTS `insert_data`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_data`  AS SELECT `accountant`.`Accountant_id` AS `accountant_id`, `accountant`.`Last_name` AS `last_name`, `admin`.`Admin_id` AS `admin_id`, `finishes`.`Finish_id` AS `finish_id`, `finishes`.`Date` AS `date`, `job_departments`.`Job_id` AS `job_id`, `job_departments`.`Job_title` AS `job_title`, `manager`.`Manager_id` AS `manager_id`, `manager`.`First_name` AS `first_name`, `manager`.`Email` AS `email`, `payrolls`.`Payroll_id` AS `payroll_id`, `payrolls`.`total_amount` AS `total_amount`, `salary`.`Salary_id` AS `salary_id`, `salary`.`Amount` AS `amount`, `worker`.`Worker_id` AS `worker_id`, `worker`.`Names` AS `names` FROM (((((((`accountant` join `admin` on(`accountant`.`Accountant_id` = `admin`.`Admin_id`)) join `finishes` on(`accountant`.`Accountant_id` = `finishes`.`Finish_id`)) join `job_departments` on(`accountant`.`Accountant_id` = `job_departments`.`Job_id`)) join `manager` on(`accountant`.`Accountant_id` = `manager`.`Manager_id`)) join `payrolls` on(`accountant`.`Accountant_id` = `payrolls`.`Payroll_id`)) join `salary` on(`accountant`.`Accountant_id` = `salary`.`Salary_id`)) join `worker` on(`accountant`.`Accountant_id` = `worker`.`Worker_id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `insert_finishesrview`
--
DROP TABLE IF EXISTS `insert_finishesrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_finishesrview`  AS SELECT `finishes`.`Finish_id` AS `Finish_id`, `finishes`.`worker_id` AS `worker_id`, `finishes`.`Date` AS `Date`, `finishes`.`Reason_for_leaving` AS `Reason_for_leaving` FROM `finishes` WHERE `finishes`.`Finish_id` = 3 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_jobdepartmentsrview`
--
DROP TABLE IF EXISTS `insert_jobdepartmentsrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_jobdepartmentsrview`  AS SELECT `job_departments`.`Job_id` AS `Job_id`, `job_departments`.`Job_title` AS `Job_title`, `job_departments`.`Age` AS `Age`, `job_departments`.`Phone_number` AS `Phone_number`, `job_departments`.`Income` AS `Income`, `job_departments`.`Manager_id` AS `Manager_id` FROM `job_departments` WHERE `job_departments`.`Job_id` = 10 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_managerview`
--
DROP TABLE IF EXISTS `insert_managerview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_managerview`  AS SELECT `manager`.`Manager_id` AS `Manager_id`, `manager`.`First_name` AS `First_name`, `manager`.`Last_name` AS `Last_name`, `manager`.`Email` AS `Email`, `manager`.`Address` AS `Address`, `manager`.`Salary` AS `Salary`, `manager`.`Qualification` AS `Qualification`, `manager`.`Phone_number` AS `Phone_number`, `manager`.`Admin_id` AS `Admin_id` FROM `manager` WHERE `manager`.`Manager_id` = 8 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_payrollssrview`
--
DROP TABLE IF EXISTS `insert_payrollssrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_payrollssrview`  AS SELECT `payrolls`.`Payroll_id` AS `Payroll_id`, `payrolls`.`Job_id` AS `Job_id`, `payrolls`.`Salary_id` AS `Salary_id`, `payrolls`.`Finish_id` AS `Finish_id`, `payrolls`.`Accountant_id` AS `Accountant_id`, `payrolls`.`Manager_id` AS `Manager_id`, `payrolls`.`worker_id` AS `worker_id`, `payrolls`.`date` AS `date`, `payrolls`.`total_amount` AS `total_amount` FROM `payrolls` WHERE `payrolls`.`Payroll_id` = 2 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_salaryrview`
--
DROP TABLE IF EXISTS `insert_salaryrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_salaryrview`  AS SELECT `salary`.`Salary_id` AS `Salary_id`, `salary`.`Job_id` AS `Job_id`, `salary`.`Amount` AS `Amount`, `salary`.`Monthly` AS `Monthly`, `salary`.`Extra` AS `Extra`, `salary`.`job_title` AS `job_title` FROM `salary` WHERE `salary`.`Salary_id` = 6 ;

-- --------------------------------------------------------

--
-- Structure for view `insert_workerrview`
--
DROP TABLE IF EXISTS `insert_workerrview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insert_workerrview`  AS SELECT `worker`.`Worker_id` AS `Worker_id`, `worker`.`Names` AS `Names`, `worker`.`Address` AS `Address`, `worker`.`Job_title` AS `Job_title`, `worker`.`Phone_number` AS `Phone_number`, `worker`.`Salary` AS `Salary`, `worker`.`Employment_status` AS `Employment_status`, `worker`.`Marital_status` AS `Marital_status`, `worker`.`Gender` AS `Gender`, `worker`.`Manager_id` AS `Manager_id`, `worker`.`Accountant_id` AS `Accountant_id`, `worker`.`Admin_id` AS `Admin_id` FROM `worker` WHERE `worker`.`Worker_id` = 32 ;

-- --------------------------------------------------------

--
-- Structure for view `salaryaboveaverageview`
--
DROP TABLE IF EXISTS `salaryaboveaverageview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `salaryaboveaverageview`  AS SELECT `w`.`Worker_id` AS `worker_id`, `w`.`Names` AS `Names`, `w`.`Job_title` AS `Job_title`, `w`.`Salary` AS `Salary` FROM `worker` AS `w` WHERE `w`.`Salary` > (select avg(`s`.`Salary`) from `worker` `s` where `s`.`Job_title` = `w`.`Job_title`) ;

-- --------------------------------------------------------

--
-- Structure for view `updatable_admin`
--
DROP TABLE IF EXISTS `updatable_admin`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `updatable_admin`  AS SELECT `admin`.`Admin_id` AS `Admin_id`, `admin`.`Names` AS `Names`, `admin`.`Email` AS `Email`, `admin`.`Address` AS `Address`, `admin`.`Phone_number` AS `Phone_number` FROM `admin` ;

-- --------------------------------------------------------

--
-- Structure for view `updatable_manager_info`
--
DROP TABLE IF EXISTS `updatable_manager_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `updatable_manager_info`  AS SELECT `manager`.`Manager_id` AS `Manager_id`, `manager`.`First_name` AS `First_name`, `manager`.`Last_name` AS `Last_name`, `manager`.`Email` AS `Email`, `manager`.`Address` AS `Address`, `manager`.`Phone_number` AS `Phone_number`, `manager`.`Qualification` AS `Qualification` FROM `manager` ;

-- --------------------------------------------------------

--
-- Structure for view `update_manager_info`
--
DROP TABLE IF EXISTS `update_manager_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `update_manager_info`  AS SELECT `manager`.`Manager_id` AS `Manager_id`, `manager`.`First_name` AS `First_name`, `manager`.`Last_name` AS `Last_name`, `manager`.`Email` AS `Email`, `manager`.`Address` AS `Address`, `manager`.`Phone_number` AS `Phone_number`, `manager`.`Qualification` AS `Qualification` FROM `manager` ;

-- --------------------------------------------------------

--
-- Structure for view `update_worker_info`
--
DROP TABLE IF EXISTS `update_worker_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `update_worker_info`  AS SELECT `worker`.`Worker_id` AS `Worker_id`, `worker`.`Names` AS `Names`, `worker`.`Job_title` AS `Job_title`, `worker`.`Phone_number` AS `Phone_number`, `worker`.`Salary` AS `Salary`, `worker`.`Employment_status` AS `Employment_status`, `worker`.`Marital_status` AS `Marital_status` FROM `worker` ;

-- --------------------------------------------------------

--
-- Structure for view `workers_to_delete`
--
DROP TABLE IF EXISTS `workers_to_delete`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `workers_to_delete`  AS SELECT `worker`.`Worker_id` AS `Worker_id`, `worker`.`Names` AS `Names`, `worker`.`Address` AS `Address`, `worker`.`Job_title` AS `Job_title`, `worker`.`Phone_number` AS `Phone_number`, `worker`.`Salary` AS `Salary`, `worker`.`Employment_status` AS `Employment_status`, `worker`.`Marital_status` AS `Marital_status`, `worker`.`Gender` AS `Gender`, `worker`.`Manager_id` AS `Manager_id`, `worker`.`Accountant_id` AS `Accountant_id`, `worker`.`Admin_id` AS `Admin_id` FROM `worker` WHERE `worker`.`Employment_status` = ' Full-time' ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountant`
--
ALTER TABLE `accountant`
  ADD PRIMARY KEY (`Accountant_id`),
  ADD KEY `Admin_id` (`Admin_id`);

--
-- Indexes for table `accountants`
--
ALTER TABLE `accountants`
  ADD PRIMARY KEY (`Accountant_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_id`);

--
-- Indexes for table `finishes`
--
ALTER TABLE `finishes`
  ADD PRIMARY KEY (`Finish_id`),
  ADD KEY `worker_finishes` (`worker_id`);

--
-- Indexes for table `job_department`
--
ALTER TABLE `job_department`
  ADD PRIMARY KEY (`Job_id`),
  ADD KEY `Manager_id` (`Manager_id`);

--
-- Indexes for table `job_departments`
--
ALTER TABLE `job_departments`
  ADD PRIMARY KEY (`Job_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`Manager_id`),
  ADD KEY `Admin_id` (`Admin_id`);

--
-- Indexes for table `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`Manager_id`);

--
-- Indexes for table `manager_audit`
--
ALTER TABLE `manager_audit`
  ADD PRIMARY KEY (`audit_id`);

--
-- Indexes for table `payrolls`
--
ALTER TABLE `payrolls`
  ADD PRIMARY KEY (`Payroll_id`),
  ADD KEY `Salary_id` (`Salary_id`),
  ADD KEY `Job_id` (`Job_id`),
  ADD KEY `Finish_id` (`Finish_id`),
  ADD KEY `worker_id` (`worker_id`),
  ADD KEY `Manager_id` (`Manager_id`),
  ADD KEY `Accountant_id` (`Accountant_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`Salary_id`);

--
-- Indexes for table `salarys`
--
ALTER TABLE `salarys`
  ADD PRIMARY KEY (`salary_Id`);

--
-- Indexes for table `userregister`
--
ALTER TABLE `userregister`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`Worker_id`),
  ADD KEY `Admin_id` (`Admin_id`),
  ADD KEY `Manager_id` (`Manager_id`),
  ADD KEY `Accountant_id` (`Accountant_id`);

--
-- Indexes for table `worker_audit`
--
ALTER TABLE `worker_audit`
  ADD PRIMARY KEY (`worker_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accountant`
--
ALTER TABLE `accountant`
  MODIFY `Accountant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `accountants`
--
ALTER TABLE `accountants`
  MODIFY `Accountant_id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `finishes`
--
ALTER TABLE `finishes`
  MODIFY `Finish_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `job_department`
--
ALTER TABLE `job_department`
  MODIFY `Job_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `job_departments`
--
ALTER TABLE `job_departments`
  MODIFY `Job_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `Manager_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `manager_audit`
--
ALTER TABLE `manager_audit`
  MODIFY `audit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `payrolls`
--
ALTER TABLE `payrolls`
  MODIFY `Payroll_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `Salary_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `salarys`
--
ALTER TABLE `salarys`
  MODIFY `salary_Id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `userregister`
--
ALTER TABLE `userregister`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `Worker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `worker_audit`
--
ALTER TABLE `worker_audit`
  MODIFY `worker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accountant`
--
ALTER TABLE `accountant`
  ADD CONSTRAINT `accountant_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`Admin_id`);

--
-- Constraints for table `finishes`
--
ALTER TABLE `finishes`
  ADD CONSTRAINT `finishes_ibfk_1` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`Worker_id`),
  ADD CONSTRAINT `worker_finishes` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`Worker_id`);

--
-- Constraints for table `job_department`
--
ALTER TABLE `job_department`
  ADD CONSTRAINT `job_department_ibfk_1` FOREIGN KEY (`Manager_id`) REFERENCES `manager` (`Manager_id`);

--
-- Constraints for table `job_departments`
--
ALTER TABLE `job_departments`
  ADD CONSTRAINT `job_departments_ibfk_1` FOREIGN KEY (`Manager_id`) REFERENCES `manager` (`Manager_id`);

--
-- Constraints for table `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`Admin_id`);

--
-- Constraints for table `payrolls`
--
ALTER TABLE `payrolls`
  ADD CONSTRAINT `payrolls_ibfk_1` FOREIGN KEY (`Salary_id`) REFERENCES `salary` (`Salary_id`),
  ADD CONSTRAINT `payrolls_ibfk_2` FOREIGN KEY (`Job_id`) REFERENCES `job_departments` (`Job_id`),
  ADD CONSTRAINT `payrolls_ibfk_3` FOREIGN KEY (`Finish_id`) REFERENCES `finishes` (`Finish_id`),
  ADD CONSTRAINT `payrolls_ibfk_4` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`Worker_id`),
  ADD CONSTRAINT `payrolls_ibfk_5` FOREIGN KEY (`Manager_id`) REFERENCES `manager` (`Manager_id`),
  ADD CONSTRAINT `payrolls_ibfk_6` FOREIGN KEY (`Accountant_id`) REFERENCES `accountant` (`Accountant_id`);

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`Job_id`) REFERENCES `job_department` (`Job_id`);

--
-- Constraints for table `worker`
--
ALTER TABLE `worker`
  ADD CONSTRAINT `worker_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`Admin_id`),
  ADD CONSTRAINT `worker_ibfk_2` FOREIGN KEY (`Manager_id`) REFERENCES `manager` (`Manager_id`),
  ADD CONSTRAINT `worker_ibfk_3` FOREIGN KEY (`Accountant_id`) REFERENCES `accountant` (`Accountant_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
