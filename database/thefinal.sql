-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 28, 2021 at 01:30 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thefinal`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `book_name` varchar(35) NOT NULL,
  `isbn_no` varchar(5) NOT NULL,
  `author` varchar(40) NOT NULL,
  `category` varchar(40) NOT NULL,
  `copies` varchar(5) NOT NULL,
  PRIMARY KEY (`isbn_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_name`, `isbn_no`, `author`, `category`, `copies`) VALUES
('Java', '900', 'James Thomson', 'Computer Science', '2'),
('Chemistry', '987', 'P.K.Thomson', 'Bioscience', '2'),
('Madolduwa', '444', 'Kumarathunga', 'Novel', '3'),
('Python', '152', 'K.John', 'Computer Science', '2'),
('Home Alone', '442', 'Denis De Silva', 'Novels', '2'),
('LET US C', '220', 'Peter Johson', 'Computer Science', '2'),
('How To C', '907', 'K.P.Pathirana', 'Computer Science', '2');

-- --------------------------------------------------------

--
-- Table structure for table `borrow_book`
--

DROP TABLE IF EXISTS `borrow_book`;
CREATE TABLE IF NOT EXISTS `borrow_book` (
  `book_name` varchar(40) NOT NULL,
  `isbn_no` varchar(6) NOT NULL,
  `category` varchar(35) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrow_book`
--

INSERT INTO `borrow_book` (`book_name`, `isbn_no`, `category`, `user_name`, `status`) VALUES
('Python', '152', 'Computer Science', 'Kavini', 'Borrowed'),
('Java', '900', 'Computer Science', 'Kaveesha', 'Reserved'),
('Python', '152', 'Computer Science', 'Kevin', 'Reserved'),
('Madolduwa', '444', 'Novel', 'Kavini', 'Reserved'),
('Chemistry', '987', 'Bioscience', 'Janaki', 'Borrowed');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('Kaveesha', '112'),
('Hasini', '111'),
('Kamani', '000'),
('Tom', 'zzz'),
('Sharuk', 'eee'),
('Kevin', 'nnn'),
('Kavini', 'ppp'),
('Janaki', '888');

-- --------------------------------------------------------

--
-- Table structure for table `login_now`
--

DROP TABLE IF EXISTS `login_now`;
CREATE TABLE IF NOT EXISTS `login_now` (
  `username` varchar(40) NOT NULL,
  `password` varchar(35) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `returned_books`
--

DROP TABLE IF EXISTS `returned_books`;
CREATE TABLE IF NOT EXISTS `returned_books` (
  `book_name` varchar(40) NOT NULL,
  `isbn_no` varchar(6) NOT NULL,
  `category` varchar(40) NOT NULL,
  `user_name` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returned_books`
--

INSERT INTO `returned_books` (`book_name`, `isbn_no`, `category`, `user_name`) VALUES
('Java', '900', 'Computer Science', 'Hasini');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
