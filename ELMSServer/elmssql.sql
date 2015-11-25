-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-11-23 18:33:52
-- 服务器版本： 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `elmssql`
--
CREATE DATABASE IF NOT EXISTS `elmssql` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `elmssql`;

-- --------------------------------------------------------

--
-- 表的结构 `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `account`
--

TRUNCATE TABLE `account`;
--
-- 转存表中的数据 `account`
--

INSERT INTO `account` (`id`, `name`, `type`, `password`, `phone`, `email`) VALUES
('000000', 'Adminstrator', 'Adminstrator', '000000', '', ''),
('123456', 'asd强', 'manager', '123236', NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `alarm`
--

DROP TABLE IF EXISTS `alarm`;
CREATE TABLE IF NOT EXISTS `alarm` (
  `city` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `alarm`
--

TRUNCATE TABLE `alarm`;
-- --------------------------------------------------------

--
-- 表的结构 `arriveyydoc`
--

DROP TABLE IF EXISTS `arriveyydoc`;
CREATE TABLE IF NOT EXISTS `arriveyydoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zzid` varchar(45) DEFAULT NULL,
  `sendciry` varchar(45) DEFAULT NULL,
  `goodstate` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `arriveyydoc`
--

TRUNCATE TABLE `arriveyydoc`;
-- --------------------------------------------------------

--
-- 表的结构 `arrivezzdoc`
--

DROP TABLE IF EXISTS `arrivezzdoc`;
CREATE TABLE IF NOT EXISTS `arrivezzdoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zzid` varchar(45) DEFAULT NULL,
  `sendcity` varchar(15) DEFAULT NULL,
  `goodstate` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `arrivezzdoc`
--

TRUNCATE TABLE `arrivezzdoc`;
-- --------------------------------------------------------

--
-- 表的结构 `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `id` varchar(45) NOT NULL,
  `plateNum` varchar(45) DEFAULT NULL,
  `useYear` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息';

--
-- 插入之前先把表清空（truncate） `car`
--

TRUNCATE TABLE `car`;
--
-- 转存表中的数据 `car`
--

INSERT INTO `car` (`id`, `plateNum`, `useYear`) VALUES
('123344', '粤A3453Q', 6);

-- --------------------------------------------------------

--
-- 表的结构 `const`
--

DROP TABLE IF EXISTS `const`;
CREATE TABLE IF NOT EXISTS `const` (
  `id` int(11) NOT NULL,
  `mileinbn` int(11) NOT NULL,
  `mileinbs` int(11) NOT NULL,
  `mileinbg` int(11) NOT NULL,
  `mileinns` int(11) NOT NULL,
  `mileinsg` int(11) NOT NULL,
  `plane` double NOT NULL,
  `train` double NOT NULL,
  `truck` double NOT NULL,
  `paperbox` int(11) NOT NULL,
  `woodbox` int(11) NOT NULL,
  `plasticbag` int(11) NOT NULL,
  `ratio1` int(11) NOT NULL,
  `ratio2` int(11) NOT NULL,
  `ratio3` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='常量表';

--
-- 插入之前先把表清空（truncate） `const`
--

TRUNCATE TABLE `const`;
-- --------------------------------------------------------

--
-- 表的结构 `costincomeform`
--

DROP TABLE IF EXISTS `costincomeform`;
CREATE TABLE IF NOT EXISTS `costincomeform` (
  `income` int(4) NOT NULL,
  `expense` int(4) NOT NULL,
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `costincomeform`
--

TRUNCATE TABLE `costincomeform`;
-- --------------------------------------------------------

--
-- 表的结构 `deposit`
--

DROP TABLE IF EXISTS `deposit`;
CREATE TABLE IF NOT EXISTS `deposit` (
  `ID` int(4) NOT NULL,
  `date` varchar(20) DEFAULT NULL,
  `money` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存款数据信息表';

--
-- 插入之前先把表清空（truncate） `deposit`
--

TRUNCATE TABLE `deposit`;
-- --------------------------------------------------------

--
-- 表的结构 `driver`
--

DROP TABLE IF EXISTS `driver`;
CREATE TABLE IF NOT EXISTS `driver` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `instid` varchar(45) DEFAULT NULL,
  `idCard` varchar(45) DEFAULT NULL,
  `phoneNum` varchar(15) DEFAULT NULL,
  `isman` varchar(8) DEFAULT NULL,
  `licenseyear` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='司机信息表';

--
-- 插入之前先把表清空（truncate） `driver`
--

TRUNCATE TABLE `driver`;
-- --------------------------------------------------------

--
-- 表的结构 `freight`
--

DROP TABLE IF EXISTS `freight`;
CREATE TABLE IF NOT EXISTS `freight` (
  `startdate` varchar(20) NOT NULL,
  `enddate` varchar(20) NOT NULL,
  `money` int(4) NOT NULL,
  `costtype` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `freight`
--

TRUNCATE TABLE `freight`;
-- --------------------------------------------------------

--
-- 表的结构 `inst`
--

DROP TABLE IF EXISTS `inst`;
CREATE TABLE IF NOT EXISTS `inst` (
  `id` varchar(20) NOT NULL,
  `location` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构信息';

--
-- 插入之前先把表清空（truncate） `inst`
--

TRUNCATE TABLE `inst`;
-- --------------------------------------------------------

--
-- 表的结构 `instoredoc`
--

DROP TABLE IF EXISTS `instoredoc`;
CREATE TABLE IF NOT EXISTS `instoredoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `orderpos` text,
  `loc` varchar(45) DEFAULT NULL,
  `location` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `instoredoc`
--

TRUNCATE TABLE `instoredoc`;
-- --------------------------------------------------------

--
-- 表的结构 `loaddoc`
--

DROP TABLE IF EXISTS `loaddoc`;
CREATE TABLE IF NOT EXISTS `loaddoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `yyid` varchar(45) DEFAULT NULL,
  `loadDocID` varchar(45) DEFAULT NULL,
  `arriveCity` varchar(20) DEFAULT NULL,
  `carid` varchar(45) DEFAULT NULL,
  `supervisor` varchar(20) DEFAULT NULL,
  `escort` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='装车单';

--
-- 插入之前先把表清空（truncate） `loaddoc`
--

TRUNCATE TABLE `loaddoc`;
-- --------------------------------------------------------

--
-- 表的结构 `myorder`
--

DROP TABLE IF EXISTS `myorder`;
CREATE TABLE IF NOT EXISTS `myorder` (
  `id` varchar(15) NOT NULL,
  `type` varchar(45) NOT NULL,
  `date` varchar(20) NOT NULL,
  `state` varchar(10) NOT NULL,
  `senderName` varchar(20) DEFAULT NULL,
  `senderPhone` varchar(20) DEFAULT NULL,
  `senderCompany` varchar(20) DEFAULT NULL,
  `senderAddress` varchar(45) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` char(20) DEFAULT NULL,
  `receiverCompany` varchar(20) DEFAULT NULL,
  `receiverAddress` varchar(45) DEFAULT NULL,
  `goodNum` int(4) DEFAULT NULL,
  `goodName` varchar(20) DEFAULT NULL,
  `goodWeight` int(4) DEFAULT NULL,
  `goodLong` int(4) DEFAULT NULL,
  `goodWidth` int(4) DEFAULT NULL,
  `goodHeight` int(4) DEFAULT NULL,
  `goodPack` varchar(20) DEFAULT NULL,
  `orderForm` varchar(20) DEFAULT NULL,
  `orderEestiTime` int(4) DEFAULT NULL,
  `orderCost` int(4) DEFAULT NULL,
  `loadDoc` varchar(20) DEFAULT NULL,
  `arriveZZDoc` varchar(20) DEFAULT NULL,
  `transferDoc` varchar(20) DEFAULT NULL,
  `arriveYYDoc` varchar(20) DEFAULT NULL,
  `sendGoodDoc` varchar(20) DEFAULT NULL,
  `realReceiver` varchar(20) DEFAULT NULL,
  `orderReceiveDate` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

--
-- 插入之前先把表清空（truncate） `myorder`
--

TRUNCATE TABLE `myorder`;
-- --------------------------------------------------------

--
-- 表的结构 `outstoredoc`
--

DROP TABLE IF EXISTS `outstoredoc`;
CREATE TABLE IF NOT EXISTS `outstoredoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `orderpos` text,
  `loc` varchar(45) DEFAULT NULL,
  `transferdoc` text,
  `shipway` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `outstoredoc`
--

TRUNCATE TABLE `outstoredoc`;
-- --------------------------------------------------------

--
-- 表的结构 `pay`
--

DROP TABLE IF EXISTS `pay`;
CREATE TABLE IF NOT EXISTS `pay` (
  `id` int(11) NOT NULL,
  `time` varchar(45) NOT NULL,
  `money` int(4) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `pay`
--

TRUNCATE TABLE `pay`;
-- --------------------------------------------------------

--
-- 表的结构 `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` varchar(45) NOT NULL,
  `instid` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `person`
--

TRUNCATE TABLE `person`;
-- --------------------------------------------------------

--
-- 表的结构 `rent`
--

DROP TABLE IF EXISTS `rent`;
CREATE TABLE IF NOT EXISTS `rent` (
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `money` int(4) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `rent`
--

TRUNCATE TABLE `rent`;
-- --------------------------------------------------------

--
-- 表的结构 `salary`
--

DROP TABLE IF EXISTS `salary`;
CREATE TABLE IF NOT EXISTS `salary` (
  `type` varchar(15) NOT NULL,
  `basicSalary` int(4) NOT NULL,
  `moreMoney` int(4) NOT NULL,
  `way` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资计算方式';

--
-- 插入之前先把表清空（truncate） `salary`
--

TRUNCATE TABLE `salary`;
--
-- 转存表中的数据 `salary`
--

INSERT INTO `salary` (`type`, `basicSalary`, `moreMoney`, `way`) VALUES
('courier', 0, 0, 'byMonth'),
('driver', 0, 0, 'byMonth'),
('financeman', 0, 0, 'byMonth'),
('saleman', 0, 0, 'byMonth'),
('storeman', 0, 0, 'byMonth'),
('storemanager', 0, 0, 'byMonth');

-- --------------------------------------------------------

--
-- 表的结构 `salarycost`
--

DROP TABLE IF EXISTS `salarycost`;
CREATE TABLE IF NOT EXISTS `salarycost` (
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `money` int(4) NOT NULL,
  `costtype` varchar(45) NOT NULL,
  `worker` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `salarycost`
--

TRUNCATE TABLE `salarycost`;
-- --------------------------------------------------------

--
-- 表的结构 `sendgooddoc`
--

DROP TABLE IF EXISTS `sendgooddoc`;
CREATE TABLE IF NOT EXISTS `sendgooddoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `sendMan` varchar(45) DEFAULT NULL,
  `orderBarCode` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `sendgooddoc`
--

TRUNCATE TABLE `sendgooddoc`;
-- --------------------------------------------------------

--
-- 表的结构 `stateform`
--

DROP TABLE IF EXISTS `stateform`;
CREATE TABLE IF NOT EXISTS `stateform` (
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `deposits` text,
  `pays` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `stateform`
--

TRUNCATE TABLE `stateform`;
-- --------------------------------------------------------

--
-- 表的结构 `storecheck`
--

DROP TABLE IF EXISTS `storecheck`;
CREATE TABLE IF NOT EXISTS `storecheck` (
  `date` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `storeLoc` varchar(45) NOT NULL,
  `number` int(4) NOT NULL,
  `inStoreDocs` text,
  `outStoreDocs` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `storecheck`
--

TRUNCATE TABLE `storecheck`;
-- --------------------------------------------------------

--
-- 表的结构 `transferdoc`
--

DROP TABLE IF EXISTS `transferdoc`;
CREATE TABLE IF NOT EXISTS `transferdoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `transferwayid` varchar(45) DEFAULT NULL,
  `sendcity` varchar(15) DEFAULT NULL,
  `containerNum` int(4) DEFAULT NULL,
  `loadmanname` varchar(15) DEFAULT NULL,
  `orderbarcode` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入之前先把表清空（truncate） `transferdoc`
--

TRUNCATE TABLE `transferdoc`;
--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `const`
--
ALTER TABLE `const`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inst`
--
ALTER TABLE `inst`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `instoredoc`
--
ALTER TABLE `instoredoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loaddoc`
--
ALTER TABLE `loaddoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `myorder`
--
ALTER TABLE `myorder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `outstoredoc`
--
ALTER TABLE `outstoredoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pay`
--
ALTER TABLE `pay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`type`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `sendgooddoc`
--
ALTER TABLE `sendgooddoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `storecheck`
--
ALTER TABLE `storecheck`
  ADD PRIMARY KEY (`date`);

--
-- Indexes for table `transferdoc`
--
ALTER TABLE `transferdoc`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pay`
--
ALTER TABLE `pay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
