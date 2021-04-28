-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2021 at 11:47 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id_mcc` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `id_trainer` int(10) DEFAULT NULL,
  `id_kelas` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id_mcc`, `nama`, `email`, `jabatan`, `id_trainer`, `id_kelas`) VALUES
(1, 'Aqira Kelana Mudjiarto', 'aqira.mudjiarto@mii.co.id', 'trainer', NULL, 1),
(2, 'Wahyu Kuncoro', 'wahyu.kuncoro@mii.co.id', 'trainer', NULL, 1),
(3, 'Devid Erliando Bardin', 'devid.bardin@mii.co.id', 'trainer', NULL, 1),
(4, 'Naufal Aji Wibowo', 'naufal.wibowo@mii.co.id', 'trainer', NULL, 2),
(5, 'Muhammad Rifqi', 'muhammad.rifqi@mii.co.id', 'trainer', NULL, 2),
(6, 'Trainer Java', 'trainer.java47@gmail.com', 'trainer', NULL, 1),
(7, 'Trainer Net', 'trainer.net47@mii.co.id', 'trainer', NULL, 2),
(8, 'Ikhsan Nur Syahbanu', 'email8@dummy.com', 'developer jr', 1, 1),
(9, 'Ristia Muhammad Panji Winarman', 'email9@dummy.com', 'developer jr', 1, 1),
(10, 'Fadel Muhammad Nasution', 'email10@dummy.com', 'developer jr', 4, 2),
(11, 'Rafi Mufadhan Difany', 'rafimdifany@gmail.com', 'developer jr', 6, 1),
(12, 'Christina Regita Kumala Sari', 'email12@dummy.com', 'developer jr', 3, 1),
(13, 'Yosie Fridolin', 'email13@dummy.com', 'developer jr', 4, 2),
(14, 'Jaka Brajadenta', 'email14@dummy.com', 'developer jr', 4, 2),
(15, 'Florentina Vela Nindyasari', 'email15@dummy.com', 'developer jr', 3, 1),
(16, 'Jarister Edwins Silalahi', 'email16@dummy.com', 'developer jr', 3, 1),
(17, 'Zahra Zakiyah Salsabila Kurnia', 'zahrazakiyahsk@gmail.com', 'developer jr', 6, 1),
(18, 'Aulia Syifa', 'auliasyifa346@gmail.com', 'developer jr', 6, 1),
(19, 'William Yangjaya', 'email19@dummy.com', 'developer jr', 7, 2),
(20, 'Arnum Sari Khoirunnisa', 'email20@dummy.com', 'developer jr', 7, 2),
(21, 'admin', 'admin@admin.com', 'admin', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id_history` int(10) NOT NULL,
  `info` varchar(50) NOT NULL,
  `waktu` datetime NOT NULL,
  `pesan` text DEFAULT NULL,
  `id_project` int(10) NOT NULL,
  `id_status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id_history`, `info`, `waktu`, `pesan`, `id_project`, `id_status`) VALUES
(1, 'status_link', '2021-04-26 15:06:04', NULL, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` int(10) NOT NULL,
  `nama_kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`) VALUES
(1, 'java'),
(2, '.NET');

-- --------------------------------------------------------

--
-- Table structure for table `privilege`
--

CREATE TABLE `privilege` (
  `id_privilege` int(5) NOT NULL,
  `privilege_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `privilege`
--

INSERT INTO `privilege` (`id_privilege`, `privilege_name`) VALUES
(1, 'create'),
(2, 'read'),
(3, 'update'),
(4, 'delete');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id_project` int(10) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `erd` text DEFAULT NULL,
  `uml` text DEFAULT NULL,
  `skema` text DEFAULT NULL,
  `link` text DEFAULT NULL,
  `current_status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id_project`, `judul`, `deskripsi`, `erd`, `uml`, `skema`, `link`, `current_status`) VALUES
(1, 'Project Dummy', 'Ini adalah sebuah project dummy', 'https://i.ibb.co/Wp19SS0/erd-library-9.png', 'https://i.ibb.co/8dGr5Fb/erd-project-Page-1-3.png', 'https://i.ibb.co/f81SR4w/BPMN-LIBRARY-Page-2-4.png', 'https://github.com/mcc-47/Tugas-2-Springboot/', 1),
(2, 'Update Project kedua', 'looooreeeemmmm update', 'erd', 'uml', 'skema', 'link', 2),
(3, 'judul', 'deskripsi x', 'erd', 'uml', 'skema', 'link', 1),
(4, 'judul 4', 'project 4', 'erd 4', 'uml 4', 'skema 4', 'link 4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(5) NOT NULL,
  `role_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `role_name`) VALUES
(1, 'admin'),
(2, 'trainer'),
(3, 'trainee');

-- --------------------------------------------------------

--
-- Table structure for table `role_privilege`
--

CREATE TABLE `role_privilege` (
  `id_role` int(5) NOT NULL,
  `id_privilege` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_privilege`
--

INSERT INTO `role_privilege` (`id_role`, `id_privilege`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id_status` int(10) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id_status`, `status`) VALUES
(1, 'proses'),
(2, 'ditolak'),
(3, 'diterima'),
(4, 'dikerjakan'),
(5, 'selesai');

-- --------------------------------------------------------

--
-- Table structure for table `trainee`
--

CREATE TABLE `trainee` (
  `id_mcc` int(10) NOT NULL,
  `batch` varchar(10) DEFAULT NULL,
  `status_mcc` enum('trainee','lulus') NOT NULL,
  `id_project` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trainee`
--

INSERT INTO `trainee` (`id_mcc`, `batch`, `status_mcc`, `id_project`) VALUES
(8, '47', 'trainee', 1),
(9, '47', 'trainee', 1),
(10, '48', 'trainee', NULL),
(11, '47', 'trainee', NULL),
(12, '48', 'trainee', 4),
(13, '48', 'trainee', NULL),
(14, '48', 'trainee', NULL),
(15, '47', 'trainee', NULL),
(16, '47', 'trainee', NULL),
(17, '47', 'trainee', 3),
(18, '47', 'trainee', 3),
(19, '48', 'trainee', 2),
(20, '48', 'trainee', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(6, 'trainerjava', '$2b$10$iDja5lyaBw.tYMJI7isq/OPPe4ga31MW9/NukigfBDVwvqwOSRirS'),
(7, 'trainernet', '$2b$10$iDja5lyaBw.tYMJI7isq/OPPe4ga31MW9/NukigfBDVwvqwOSRirS'),
(11, 'rafi', '$2b$10$wcxqCG4IgNJYJlT.b73dI.ctuTcX/syo75SOIBQmv79Dy53wwxnU2'),
(17, 'zakiyah', '$2b$10$wRRkqFRvHYr11uN4TFOv4.Y8ccfYSezPhPdOISMIjaqVqDHKS9u8y'),
(18, 'aulia', '$2b$10$jc300h/zy8Z5GQUoABdoIOsr.iePRi2Q4yApCMDHLq973SNFcKLjC'),
(21, 'admin', '$2b$10$aI8fkDwCXvaj080wswTZy.sLieytCfQw8OmCxrIOj/N6VHAC9Twsm');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id_user` int(10) NOT NULL,
  `id_role` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id_user`, `id_role`) VALUES
(17, 3),
(21, 1),
(18, 3),
(11, 3),
(6, 2),
(7, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_mcc`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_trainer` (`id_trainer`),
  ADD KEY `id_kelas` (`id_kelas`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id_history`),
  ADD KEY `id_project` (`id_project`),
  ADD KEY `id_status` (`id_status`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `privilege`
--
ALTER TABLE `privilege`
  ADD PRIMARY KEY (`id_privilege`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_project`),
  ADD KEY `current_status` (`current_status`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `role_privilege`
--
ALTER TABLE `role_privilege`
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_privilege` (`id_privilege`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `trainee`
--
ALTER TABLE `trainee`
  ADD PRIMARY KEY (`id_mcc`),
  ADD KEY `id_project` (`id_project`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_role` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id_mcc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id_history` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id_project` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `trainee`
--
ALTER TABLE `trainee`
  MODIFY `id_mcc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`id_trainer`) REFERENCES `employee` (`id_mcc`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`);

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`current_status`) REFERENCES `status` (`id_status`);

--
-- Constraints for table `role_privilege`
--
ALTER TABLE `role_privilege`
  ADD CONSTRAINT `role_privilege_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  ADD CONSTRAINT `role_privilege_ibfk_2` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`id_privilege`);

--
-- Constraints for table `trainee`
--
ALTER TABLE `trainee`
  ADD CONSTRAINT `trainee_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`),
  ADD CONSTRAINT `trainee_ibfk_2` FOREIGN KEY (`id_mcc`) REFERENCES `employee` (`id_mcc`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `employee` (`id_mcc`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
