-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-12-25 09:16:26
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
('000001', '陈自强', 'manager', '000000', '', ''),
('000002', '陈自强', 'financeman', '000000', '', ''),
('1111111', NULL, 'courier', 'aaaaaa', NULL, NULL),
('112233', NULL, 'courier', 'zxcvbn', '', '');

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
('NANJING', '0'),
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
  `sendciry` varchar(45) DEFAULT NULL,
  `goodstate` varchar(45) DEFAULT NULL,
  `orderBarCodes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `arriveyydoc`
--

INSERT INTO `arriveyydoc` (`id`, `type`, `date`, `state`, `zzid`, `sendciry`, `goodstate`, `orderBarCodes`) VALUES
('123123123', 'arriveYYDoc', '115-11-3', 'wait', '123123123', 'NANJING', 'Lost', '12312312312,'),
('123123123123', 'arriveYYDoc', '115-11-3', 'wait', '123123123123', 'NANJING', 'Complete', '123123123123,'),
('123123213', 'arriveYYDoc', '115-11-3', 'wait', '213213123', 'NANJING', 'Complete', '123123123,123123123123,'),
('123213', 'arriveYYDoc', '115-11-3', 'pass', '123213213', 'NANJING', 'Complete', '12321323,1232132311,'),
('12321312', 'arriveYYDoc', '115-11-3', 'wait', '123213213', 'NANJING', 'Complete', '123213123123,1232132,12321321321,12321323,'),
('1232131211', 'arriveYYDoc', '115-11-3', 'pass', '123213213', 'NANJING', 'Complete', '123213123123,1232132,12321321321,12321323,'),
('123213213', 'arriveYYDoc', '115-11-3', 'wait', '123123123', 'NANJING', 'Complete', '12312312,'),
('12321322', 'arriveYYDoc', '2015-12-16', 'wait', '123213', 'NANJING', 'Complete', '123213123,1232123,'),
('12341241', 'arriveYYDoc', '115-11-3', 'wait', '123412343124', 'NANJING', 'Complete', '1234124,1234124124,1234124124345,'),
('1321321321', 'arriveYYDoc', '115-11-3', 'wait', '213123123', 'NANJING', 'Complete', '123123123,123121233123,'),
('JSD000001', 'arriveYYDoc', '2015-12-17', 'wait', 'asdasd', 'NANJING', 'Complete', NULL);

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
('123456', 'arriveZZDoc', '2015-12-24', 'pass', '123345', 'NANJING', 'Complete', NULL);

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
('000002', '123123', '22222'),
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

--
-- 转存表中的数据 `car`
--

INSERT INTO `car` (`id`, `instid`, `plateNum`, `useYear`) VALUES
('000000', '000003', '京A88888', 4),
('123412', '025000001', '粤VDC798', 8);

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

--
-- 转存表中的数据 `driver`
--

INSERT INTO `driver` (`id`, `name`, `birthday`, `instid`, `idCard`, `phoneNum`, `isman`, `licenseyear`) VALUES
('000001', '章撒', '1992-4-12', '123456', '445202199204121134', '18324522334', '1', 5),
('000002', '陈自强', '1996-4-14', '000000', '445202199604143071', '18362910989', '1', 3),
('000003', '邢A', '1996-4-16', '000000', '442121142323451111', '18377651389', '0', 3),
('000004', '陈泽强', '1998-4-15', '000000', '445202199804153011', '19362217867', '1', 4);

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
('123123', '2015-12-23', '2015-12-23', 1232, 'FREIGHT'),
('123678', '2015-12-23', '2015-12-23', 2000, 'FREIGHT');

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
('123124', 'NANJING', 'transportCenter'),
('123255', 'SHANGHAI', 'transportCenter'),
('1246546', 'NANJING', 'transportCenter'),
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
('11111111', 'loadDoc', '115-11-3', 'wait', '12341212', '23432412%', 'NANJING', '123213213', '12323', '213213', ''),
('1111111123', 'loadDoc', '115-11-3', 'wait', '123213213', '123123123', 'NANJING', '123123123', '123123123', '123123123', '123213213,123213213,123213213123,'),
('111111112311', 'loadDoc', '115-11-3', 'wait', '123213213', '123123123', 'NANJING', '123123123', '123123123', '123123123', '123213213,123213213,123213213123,'),
('1231231', 'loadDoc', '115-11-3', 'wait', '123123213', '12321312', 'NANJING', '123123123', '12321321', '3123123213', '123123123,123123123123,'),
('1231231123', 'loadDoc', '115-11-3', 'wait', '123123213', '12321312', 'NANJING', '123123123', '12321321', '3123123213', '123123123,123123123123,'),
('123123112311', 'loadDoc', '115-11-3', 'wait', '123123213', '12321312', 'NANJING', '123123123', '12321321', '3123123213', '123123123,123123123123,'),
('12321', 'loadDoc', '115-11-3', 'wait', '1232113%12', '123213221', 'NANJING', '', '', '', ''),
('12321312', 'loadDoc', '115-11-3', 'wait', '123213123', '123213213', 'NANJING', '123213213', '123213213', '12321312312', '123213213,123213123,12312312321,'),
('123213123', 'loadDoc', '115-11-3', 'wait', '123123123', '12312312', 'NANJING', '12321312', '123213123', '123123123', '1223123123,122312312312312,12323311,123233,'),
('1232131232', 'loadDoc', '115-11-3', 'wait', '1232113%12', '123213221', 'NANJING', '', '', '', ''),
('12321321', 'loadDoc', '2015-2015-2015', 'wait', '123123', '213211', 'NANJING', '12321321', '12321321', '213213213', '123213213213,1232132123,12321123,'),
('1242341', 'loadDoc', '115-11-3', 'wait', '1241241', '124124', 'NANJING', '124124124', '12421411243', '2341124124', ''),
('213213123', 'loadDoc', '115-11-3', 'wait', '213123213', '123213213', 'NANJING', '123213213', '213123213', '123213123213', ''),
('22222222', 'loadDoc', '115-11-3', 'wait', '222222', '2222222', 'NANJING', '123213213', '1232132132', '123213213', '123213123,12312312321,123123213123,123123213123,'),
('234322343', 'loadDoc', '115-11-3', 'wait', '234323432', '23423243', 'NANJING', '23423432', '但是', '额', '1234567,123456733,12345673322,'),
('ZCD000001', 'loadDoc', '2015-11-4', 'wait', '2011123123', '123213123', 'NANJING', '123123', '123', '123', ''),
('ZCD1511120000001', 'loadDoc', '2015-11-12', 'wait', '02500', '02501511120000001', 'GUANGZHOU', '001', 'ttt', NULL, '1234536433,2069601212,4902720820,');

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
  `arriveZZDoc` varchar(20) DEFAULT NULL,
  `inStoreOneDoc` varchar(45) DEFAULT NULL,
  `outStoreOneDoc` varchar(45) DEFAULT NULL,
  `transferDoc` varchar(20) DEFAULT NULL,
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

INSERT INTO `myorder` (`id`, `type`, `date`, `state`, `senderName`, `senderPhone`, `senderCompany`, `senderAddress`, `receiverName`, `receiverPhone`, `receiverCompany`, `receiverAddress`, `goodNum`, `goodName`, `goodWeight`, `goodLong`, `goodWidth`, `goodHeight`, `goodPack`, `orderForm`, `orderstartdate`, `orderEestiTime`, `orderCost`, `loadDoc`, `arriveZZDoc`, `inStoreOneDoc`, `outStoreOneDoc`, `transferDoc`, `instoreTwoDoc`, `outStoreTwoDoc`, `arriveYYDoc`, `sendGoodDoc`, `alldocs`, `realReceiver`, `orderReceiveDate`) VALUES
('123456', 'order', '2015-12-4', 'wait', '123', '123', '123', '123213', '123', '123', '123', '123', 2, '123', 12, 123, 12, 12, '12', '123', '', 4, 23, 'ZCD000001', 'JSD000001', 'RKD000001', 'CKD000001', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL);

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
  `date` varchar(45) NOT NULL,
  `yyid` varchar(45) NOT NULL,
  `money` int(8) NOT NULL,
  `courier` varchar(45) NOT NULL,
  `orders` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `paydoc`
--

INSERT INTO `paydoc` (`id`, `date`, `yyid`, `money`, `courier`, `orders`) VALUES
('123123', '2015-12-23', '123123', 231, '123', '123123,123123,'),
('234123', '2015-12-23', '123123', 123, '123', '123123,123345,');

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
('123124', '123234', '终场前', 'financeman', '12312312312'),
('123456', '000001', '陈安杰', 'financeman', '13923689344');

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
('courier', 1000, 3000, 'byTimes'),
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
  `orderBarCode` text,
  `sendCity` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `sendgooddoc`
--

INSERT INTO `sendgooddoc` (`id`, `type`, `date`, `state`, `sendMan`, `orderBarCode`, `sendCity`) VALUES
('123123', 'sendGoodDoc', '115-11-3', 'wait', '123', '123213123123', 'NANJING'),
('123123213', 'sendGoodDoc', '115-11-3', 'pass', '123123123', '12312312312', 'NANJING'),
('123213', 'sendGoodDoc', '115-11-3', 'pass', '123123', '1232131231223', 'NANJING'),
('123213123', 'sendGoodDoc', '115-11-3', 'wait', '123123123', '123123213123', 'NANJING'),
('12321325661', 'sendGoodDoc', '115-11-3', 'pass', '123123', '1232131231223', 'NANJING'),
('PSD1511120000001', 'sendGoodDoc', '2015-11-12', 'wait', 'moxigan', '3213640812', 'BEIJING');

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
('ZZD1511130000001', 'transferDoc', '2015-11-13', 'wait', 'K155', 'SHANGHAI', 3, 'cee', '1234536433,2069601212,4902720820,');

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
