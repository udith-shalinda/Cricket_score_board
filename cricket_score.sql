-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2019 at 07:50 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cricket_score`
--

-- --------------------------------------------------------

--
-- Table structure for table `batting`
--

CREATE TABLE `batting` (
  `matchId` int(10) NOT NULL,
  `inning` int(1) NOT NULL,
  `playerId` int(3) NOT NULL,
  `Score` int(3) NOT NULL,
  `balls` int(11) NOT NULL,
  `fours` int(3) NOT NULL,
  `sixes` int(3) NOT NULL,
  `wicketStatus` varchar(100) NOT NULL,
  `average` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batting`
--

INSERT INTO `batting` (`matchId`, `inning`, `playerId`, `Score`, `balls`, `fours`, `sixes`, `wicketStatus`, `average`) VALUES
(1, 1, 1, 103, 86, 7, 2, 'c Virath b Kumblay', 120),
(1, 1, 4, 51, 65, 3, 0, 'b Kumblay', 78),
(1, 1, 11, 42, 80, 2, 0, 'c Shewag b Rahane', 53),
(1, 1, 6, 19, 8, 3, 0, 'not out', 238),
(1, 2, 12, 100, 120, 6, 1, 'c Thirimanna b Malinga', 83),
(1, 2, 15, 56, 50, 5, 0, 'c Dhananjaya b Malinga', 112),
(1, 2, 17, 9, 18, 1, 0, 'b Malinga', 50),
(1, 2, 21, 80, 95, 4, 2, 'not out', 84);

-- --------------------------------------------------------

--
-- Table structure for table `bowling`
--

CREATE TABLE `bowling` (
  `matchId` int(11) NOT NULL,
  `inning` int(11) NOT NULL,
  `playerId` int(11) NOT NULL,
  `wicket` int(11) NOT NULL,
  `runs` int(11) NOT NULL,
  `overs` int(11) NOT NULL,
  `maidens` int(11) NOT NULL,
  `average` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bowling`
--

INSERT INTO `bowling` (`matchId`, `inning`, `playerId`, `wicket`, `runs`, `overs`, `maidens`, `average`) VALUES
(1, 1, 2, 5, 37, 10, 1, 4),
(1, 1, 3, 1, 46, 10, 0, 5),
(1, 1, 7, 1, 10, 1, 0, 10),
(1, 1, 8, 0, 60, 6, 0, 10),
(1, 2, 16, 3, 80, 10, 0, 8),
(1, 2, 22, 1, 46, 10, 0, 5),
(1, 2, 20, 2, 53, 10, 1, 5),
(1, 2, 17, 0, 32, 5, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `matchId` int(10) NOT NULL,
  `inningOne` varchar(100) NOT NULL,
  `inningTwo` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `winningTeam` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`matchId`, `inningOne`, `inningTwo`, `location`, `winningTeam`) VALUES
(1, 'Sri Lanka', 'India', 'Green Park Stadium India', 'Sri Lanka won by 1 run'),
(2, 'Australia', 'Sri Lanka', 'R.Premadasa Stadium Sri Lanka', 'Australia won by 4 wickets'),
(3, 'India', 'Australia', 'M.Rajapaksha stadium Sri Lanka', 'India won by 20 runs');

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE `players` (
  `playerId` int(11) NOT NULL,
  `playerName` varchar(100) NOT NULL,
  `team` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`playerId`, `playerName`, `team`) VALUES
(1, 'Dimuth Karunaratne', 'Sri Lanka'),
(2, 'Lasith Malinga', 'Sri Lanka'),
(3, 'Niroshan Dickwella', 'Sri Lanka'),
(4, 'Upul Tharanga	', 'Sri Lanka'),
(5, 'Danushka Gunathilaka', 'Sri Lanka'),
(6, 'Avishka Fernando', 'Sri Lanka'),
(7, 'Roshen Silva', 'Sri Lanka'),
(8, 'Angelo Mathews', 'Sri Lanka'),
(9, 'Dhananjaya de Silva', 'Sri Lanka'),
(10, 'Oshada Fernando', 'Sri Lanka'),
(11, 'Lahiru Thirimanne', 'Sri Lanka'),
(12, 'Sachin Tendulkar', 'India'),
(13, 'Ajay Jadeja	', 'India'),
(14, 'Sourav Ganguly', 'India'),
(15, 'Rahul Dravid', 'India'),
(16, 'Anil Kumble', 'India'),
(17, 'Virender Sehwag', 'India'),
(18, 'Mahendra Singh Dhoni', 'India'),
(19, 'Suresh Raina', 'India'),
(20, 'Gautam Gambhir', 'India'),
(21, 'Virat Kohli', 'India'),
(22, 'Ajinkya Rahane', 'India'),
(23, 'Joe Burns', 'Australia'),
(24, 'Aaron Finch', 'Australia'),
(25, 'Marcus Harris', 'Australia'),
(26, 'Matt Renshaw', 'Australia'),
(27, 'David Warner', 'Australia'),
(28, 'Peter Handscomb', 'Australia'),
(29, 'Nic Maddinson	', 'Australia'),
(30, 'Ben McDermott', 'Australia'),
(31, 'Kurtis Patterson', 'Australia'),
(32, 'Ashton Turner', 'Australia'),
(33, 'Steve Smith', 'Australia');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`matchId`);

--
-- Indexes for table `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`playerId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
