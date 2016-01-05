-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016-01-05 01:38:04
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
-- 转存表中的数据 `alarm`
--

INSERT INTO `alarm` (`city`, `value`) VALUES
('BEIJING', '90%'),
('GUANGZHOU', '0'),
('NANJING', '10'),
('SHANGHAI', '0');

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
  `sendInst` varchar(45) DEFAULT NULL,
  `goodstate` varchar(45) DEFAULT NULL,
  `orderBarCodes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `arriveyydoc`
--

INSERT INTO `arriveyydoc` (`id`, `type`, `date`, `state`, `zzid`, `sendInst`, `goodstate`, `orderBarCodes`) VALUES
('JSD1512310000001', 'arriveYYDoc', '2015-12-31-0-21-17', 'wait', '123123', 'transportCenter', 'Complete', '1231231231,');

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
  `goodstate` varchar(45) DEFAULT NULL,
  `orderBarCodes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `arrivezzdoc`
--

INSERT INTO `arrivezzdoc` (`id`, `type`, `date`, `state`, `zzid`, `sendcity`, `goodstate`, `orderBarCodes`) VALUES
('123456', 'arriveZZDoc', '2015-12-24', 'pass', '123345', 'NANJING', 'Complete', NULL),
('DDD1512300000001', 'arriveZZDoc', '2015-12-30-23-27-3', 'wait', '123132', 'NANJING', 'Complete', '1231231231,'),
('DDD1512300000002', 'arriveZZDoc', '2015-12-30-23-54-42', 'wait', '123213', 'BEIJING', 'Complete', '1231231231,'),
('DDD1512310000001', 'arriveZZDoc', '2015-12-31-0-4-23', 'wait', '908093', 'BEIJING', 'Complete', '1231231231,');

-- --------------------------------------------------------

--
-- 表的结构 `bankaccount`
--

DROP TABLE IF EXISTS `bankaccount`;
CREATE TABLE IF NOT EXISTS `bankaccount` (
  `id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `money` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bankaccount`
--

INSERT INTO `bankaccount` (`id`, `password`, `money`) VALUES
('000002', '123123', '18222'),
('1321321', '123212', '876');

-- --------------------------------------------------------

--
-- 表的结构 `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `financeman` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `instituations` text NOT NULL,
  `persons` text NOT NULL,
  `cars` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `id` varchar(45) NOT NULL,
  `instid` varchar(45) NOT NULL,
  `plateNum` varchar(45) DEFAULT NULL,
  `useYear` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息';

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

-- --------------------------------------------------------

--
-- 表的结构 `freight`
--

DROP TABLE IF EXISTS `freight`;
CREATE TABLE IF NOT EXISTS `freight` (
  `id` varchar(45) NOT NULL,
  `startdate` varchar(20) NOT NULL,
  `enddate` varchar(20) NOT NULL,
  `money` int(4) NOT NULL,
  `costtype` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `freight`
--

INSERT INTO `freight` (`id`, `startdate`, `enddate`, `money`, `costtype`) VALUES
('123123', '2015-12-23', '2015-12-23', 1232, 'FREIGHT');

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
-- 转存表中的数据 `inst`
--

INSERT INTO `inst` (`id`, `location`, `type`) VALUES
('123123', 'NANJING', 'transportCenter'),
('123255', 'SHANGHAI', 'transportCenter'),
('1246546', 'NANJING', 'businessHall'),
('234567', 'NANJING', 'transportCenter'),
('345574', 'NANJING', 'transportCenter');

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
-- 转存表中的数据 `instoredoc`
--

INSERT INTO `instoredoc` (`id`, `type`, `date`, `state`, `orderpos`, `loc`, `location`) VALUES
('RKD1512260000001', 'inStoreDoc', '2015-12-26', 'pass', '1231231112,', 'NANJING', '航运区1排1架1位,'),
('RKD1512300000001', 'inStoreDoc', '2015-12-30', 'pass', '1123333123,', 'NANJING', '航运区1排2架2位,'),
('RKD1512300000002', 'inStoreDoc', '2015-12-30', 'pass', '8881182811,', 'NANJING', '汽运区12排2架1位,'),
('RKD1512300000003', 'inStoreDoc', '2015-12-30', 'pass', '', 'NANJING', ''),
('RKD1512300000004', 'inStoreDoc', '2015-12-30', 'pass', '', 'NANJING', ''),
('RKD1512300000005', 'inStoreDoc', '2015-12-30-23-29-38', 'pass', '1231231231,', 'NANJING', '汽运区1排1架1位,'),
('RKD1512300000006', 'inStoreDoc', '2015-12-30-23-43-15', 'pass', '1231231231,', 'NANJING', '汽运区2排2架4位,'),
('RKD1512310000001', 'inStoreDoc', '2015-12-31-0-6-12', 'pass', '1231231231,', 'NANJING', '汽运区3排3架3位,'),
('RKD1512310000002', 'inStoreDoc', '2015-12-31-15-29-45', 'wait', '2312222123,', 'GUANGZHOU', '汽运区3排4架3位,');

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
  `escort` varchar(20) DEFAULT NULL,
  `orderbarcodes` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='装车单';

--
-- 转存表中的数据 `loaddoc`
--

INSERT INTO `loaddoc` (`id`, `type`, `date`, `state`, `yyid`, `loadDocID`, `arriveCity`, `carid`, `supervisor`, `escort`, `orderbarcodes`) VALUES
('ZCD1512300000001', 'loadDoc', '2015-12-30', 'wait', '231232', '123231', 'NANJING', '24123123', '1231', '1', '1231231231,'),
('ZCD1512300000002', 'loadDoc', '2015-12-30', 'wait', '213123', '123213', 'NANJING', '123123', '123', '12', '1231231,'),
('ZCD1512300000003', 'loadDoc', '2015-12-30', 'wait', '123123', '123123', 'NANJING', '123123', '123', '123', '1231231231,'),
('ZCD1512300000004', 'loadDoc', '2015-12-30', 'wait', '123213', '123213', 'NANJING', '123213', '123', '11', '1231231231,'),
('ZCD1512300000005', 'loadDoc', '2015-12-30', 'wait', '1231232', '21312321321', 'NANJING', '312312', '31', '23', '1231231231,'),
('ZCD1512300000006', 'loadDoc', '2015-12-30-21-8-23', 'wait', '231231', '231231', 'NANJING', '2321321', '312', '31', '1231231231,');

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
  `orderstartdate` varchar(45) NOT NULL,
  `orderEestiTime` int(4) DEFAULT NULL,
  `orderCost` float DEFAULT NULL,
  `loadDoc` varchar(20) DEFAULT NULL,
  `arriveZZOneDoc` varchar(20) DEFAULT NULL,
  `inStoreOneDoc` varchar(45) DEFAULT NULL,
  `outStoreOneDoc` varchar(45) DEFAULT NULL,
  `transferDoc` varchar(20) DEFAULT NULL,
  `arriveZZTwoDoc` varchar(45) NOT NULL,
  `instoreTwoDoc` varchar(45) DEFAULT NULL,
  `outStoreTwoDoc` varchar(45) DEFAULT NULL,
  `arriveYYDoc` varchar(20) DEFAULT NULL,
  `sendGoodDoc` varchar(20) DEFAULT NULL,
  `alldocs` text NOT NULL,
  `realReceiver` varchar(20) DEFAULT NULL,
  `orderReceiveDate` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

--
-- 转存表中的数据 `myorder`
--

INSERT INTO `myorder` (`id`, `type`, `date`, `state`, `senderName`, `senderPhone`, `senderCompany`, `senderAddress`, `receiverName`, `receiverPhone`, `receiverCompany`, `receiverAddress`, `goodNum`, `goodName`, `goodWeight`, `goodLong`, `goodWidth`, `goodHeight`, `goodPack`, `orderForm`, `orderstartdate`, `orderEestiTime`, `orderCost`, `loadDoc`, `arriveZZOneDoc`, `inStoreOneDoc`, `outStoreOneDoc`, `transferDoc`, `arriveZZTwoDoc`, `instoreTwoDoc`, `outStoreTwoDoc`, `arriveYYDoc`, `sendGoodDoc`, `alldocs`, `realReceiver`, `orderReceiveDate`) VALUES
('1231231231', 'order', '2015-12-31', 'pass', '', '12312312312', '', '南京市null', '', '12312312312', '', '北京市null', 1, '', 1, 1, 1, 1, 'woodCase', 'quickOrder', '2015-12-30', 0, 21.9, 'ZCD1512300000006', 'DDD1512300000002', 'RKD1512300000006', 'CKD1512300000001', 'ZZD1512300000001', 'DDD1512310000001', 'RKD1512310000001', 'CKD1512310000001', 'JSD1512310000001', '', '', '', '0-0-0'),
('1234567890', 'order', '2015-12-31', 'wait', '邢程', '12345678901', '北大', '北京市崇文区内一环1号', '陈自强', '12345678901', '中大', '广州市天河区天河中学', 1, '手套 ', 1, 20, 10, 10, 'bag', 'economicOrder', '2015-12-31-21-10-34', 0, 2.725, '', '', '', '', '', '', '', '', '', '', '', '', '0-0-0');

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
-- 转存表中的数据 `outstoredoc`
--

INSERT INTO `outstoredoc` (`id`, `type`, `date`, `state`, `orderpos`, `loc`, `transferdoc`, `shipway`) VALUES
('CKD1512300000001', 'outStoreDoc', '2015-12-30-23-47-18', 'pass', '1231231231,', 'NANJING', 'ZZD1512300000001', 'car'),
('CKD1512310000001', 'outStoreDoc', '2015-12-31-0-6-23', 'wait', '1231231231,', 'NANJING', '1231324134', 'plane');

-- --------------------------------------------------------

--
-- 表的结构 `pay`
--

DROP TABLE IF EXISTS `pay`;
CREATE TABLE IF NOT EXISTS `pay` (
  `id` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL,
  `money` int(4) NOT NULL,
  `person` varchar(45) NOT NULL,
  `rent` int(4) NOT NULL,
  `freight` int(4) NOT NULL,
  `salary` int(4) NOT NULL,
  `state` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `pay`
--

INSERT INTO `pay` (`id`, `time`, `account`, `money`, `person`, `rent`, `freight`, `salary`, `state`) VALUES
('123123', '2015-12-24', '1321321', 123123, '123123', 123123, 213213, 120, 'wait');

-- --------------------------------------------------------

--
-- 表的结构 `paydoc`
--

DROP TABLE IF EXISTS `paydoc`;
CREATE TABLE IF NOT EXISTS `paydoc` (
  `id` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `money` int(8) NOT NULL,
  `yyid` varchar(45) NOT NULL,
  `courier` varchar(45) NOT NULL,
  `orders` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `paydoc`
--

INSERT INTO `paydoc` (`id`, `type`, `date`, `state`, `money`, `yyid`, `courier`, `orders`) VALUES
('123123', 'payDoc', '2015-12-23', 'pass', 231, '123123', '123', '123123,123123,'),
('234123', 'payDoc', '2015-12-23', 'pass', 123, '123123', '123', '123123,123345,');

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
-- 转存表中的数据 `person`
--

INSERT INTO `person` (`id`, `instid`, `name`, `type`, `phone`) VALUES
('000001', '000000', '陈平', 'courier', '13142321234'),
('123456', '000001', '陈安杰', 'financeman', '13923689344'),
('1234572', '1234567', '123', 'financeman', '12345678905');

-- --------------------------------------------------------

--
-- 表的结构 `rent`
--

DROP TABLE IF EXISTS `rent`;
CREATE TABLE IF NOT EXISTS `rent` (
  `id` varchar(45) NOT NULL,
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `money` int(4) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `rent`
--

INSERT INTO `rent` (`id`, `startdate`, `enddate`, `money`, `type`) VALUES
('213123', '2015-12-23', '2015-12-23', 123123, 'RENT');

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
  `id` varchar(45) NOT NULL,
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `money` int(4) NOT NULL,
  `costtype` varchar(45) NOT NULL,
  `worker` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `salarycost`
--

INSERT INTO `salarycost` (`id`, `startdate`, `enddate`, `money`, `costtype`, `worker`) VALUES
('123123', '2015-12-23', '2015-12-23', 500, 'SALARY', 'financeman'),
('123213', '2015-12-23', '2015-12-23', 1231, 'SALARY', 'financeman'),
('123456', '2015-12-23', '2015-12-23', 500, 'SALARY', 'financeman');

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
-- 转存表中的数据 `sendgooddoc`
--

INSERT INTO `sendgooddoc` (`id`, `type`, `date`, `state`, `sendMan`, `orderBarCode`) VALUES
('PSD1512310000001', 'sendGoodDoc', '2015-12-31-15-51-35', 'wait', '陈自强', '1231231231,');

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
  `total` int(8) NOT NULL,
  `inStoreDocs` text,
  `outStoreDocs` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- 转存表中的数据 `transferdoc`
--

INSERT INTO `transferdoc` (`id`, `type`, `date`, `state`, `transferwayid`, `sendcity`, `containerNum`, `loadmanname`, `orderbarcode`) VALUES
('ZZD1511130000001', 'transferDoc', '2015-11-13', 'wait', 'K155', 'SHANGHAI', 3, 'cee', '1234536433,2069601212,4902720820,'),
('ZZD1512300000001', 'transferDoc', '2015-12-30-23-52-6', 'wait', '4123', 'NANJING', 21, '1', '1231231231,');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `alarm`
--
ALTER TABLE `alarm`
  ADD PRIMARY KEY (`city`);

--
-- Indexes for table `arriveyydoc`
--
ALTER TABLE `arriveyydoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `arrivezzdoc`
--
ALTER TABLE `arrivezzdoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bankaccount`
--
ALTER TABLE `bankaccount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`date`);

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
-- Indexes for table `costincomeform`
--
ALTER TABLE `costincomeform`
  ADD PRIMARY KEY (`startdate`);

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
-- Indexes for table `freight`
--
ALTER TABLE `freight`
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
-- Indexes for table `paydoc`
--
ALTER TABLE `paydoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`type`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `salarycost`
--
ALTER TABLE `salarycost`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sendgooddoc`
--
ALTER TABLE `sendgooddoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stateform`
--
ALTER TABLE `stateform`
  ADD PRIMARY KEY (`startdate`);

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
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
