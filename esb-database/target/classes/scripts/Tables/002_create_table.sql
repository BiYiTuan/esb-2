
DROP TABLE IF EXISTS `AllocatedOrderLines`;

CREATE TABLE `AllocatedOrderLines` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AllocatedOrderId` int(11) NOT NULL,
  `Sku` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `AllocatedOrderLines_Archive`;

CREATE TABLE `AllocatedOrderLines_Archive` (
  `Id` int(11) NOT NULL,
  `AllocatedOrderId` int(11) NOT NULL,
  `Sku` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `AllocatedOrders`;

CREATE TABLE `AllocatedOrders` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `OrderNumber` varchar(50) NOT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_OrderNumber` (`OrderNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `AllocatedOrders_Archive`;

CREATE TABLE `AllocatedOrders_Archive` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `OrderNumber` varchar(50) NOT NULL,
  `Status` int(11) NOT NULL,
  `UpdatedDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `AllocatedStatus`;

CREATE TABLE `AllocatedStatus` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `AllocatedStatus` WRITE;
/*!40000 ALTER TABLE `AllocatedStatus` DISABLE KEYS */;

INSERT INTO `AllocatedStatus` (`Id`, `Name`)
VALUES
	(1,'InVenda'),
	(2,'InSage'),
	(3,'IsCancelled');

/*!40000 ALTER TABLE `AllocatedStatus` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `changelog`;

CREATE TABLE `changelog` (
  `change_number` bigint(20) NOT NULL,
  `complete_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `applied_by` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`change_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `changelog` WRITE;
/*!40000 ALTER TABLE `changelog` DISABLE KEYS */;

INSERT INTO `changelog` (`change_number`, `complete_dt`, `applied_by`, `description`)
VALUES
	(15,'2013-06-16 11:51:12','root','15_ChangeLog.sql');

/*!40000 ALTER TABLE `changelog` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `ConsumerCount`;

CREATE TABLE `ConsumerCount` (
  `ConsumerId` int(11) NOT NULL AUTO_INCREMENT,
  `Route` varchar(50) NOT NULL,
  `NumberOfConsumers` int(11) NOT NULL,
  PRIMARY KEY (`ConsumerId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `FrontendConnections`;

CREATE TABLE `FrontendConnections` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `RpcUrl` varchar(255) NOT NULL,
  `DocLitUrl` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `IsCategoryUpdates` tinyint(1) NOT NULL,
  `IsProductUpdates` tinyint(1) NOT NULL,
  `IsStockUpdates` tinyint(1) NOT NULL,
  `IsOrderRetrieval` tinyint(1) NOT NULL,
  `IsPriceUpdates` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Name` (`Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `FrontendConnectionsAdditional`;

CREATE TABLE `FrontendConnectionsAdditional` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FrontendConnectionId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `AdditionalValue` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_TimerPollsId` (`FrontendConnectionId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `SageMasterStock`;

CREATE TABLE `SageMasterStock` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Sku` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UpdatedDateTime` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Sku` (`Sku`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `SageMasterStock` WRITE;

INSERT INTO `SageMasterStock` (`Id`, `Sku`, `Quantity`, `UpdatedDateTime`)
VALUES
	(361681,'azz123456',10,'2013-01-30 13:49:27 +0000'),
	(361682,'AZZ7827019733',0,'2013-01-30 13:50:25 +0000');

UNLOCK TABLES;

DROP TABLE IF EXISTS `StockUpdateHistory`;

CREATE TABLE `StockUpdateHistory` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Sku` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UpdatedDateTime` varchar(50) NOT NULL,
  `ReasonForChange` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IX_Sku` (`Sku`),
  KEY `UpdatedDateTime_IDX` (`UpdatedDateTime`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `TimerPolls`;

CREATE TABLE `TimerPolls` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `LastDateTime` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `PollDateTime` (`LastDateTime`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `TimerPollsAdditional`;

CREATE TABLE `TimerPollsAdditional` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TimerPollsId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `AdditionalValue` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_TimerPollsId` (`TimerPollsId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `VendaFtpCredentials`;

CREATE TABLE `VendaFtpCredentials` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Hostname` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Name` (`Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `VendaSoapCredentials`;

CREATE TABLE `VendaSoapCredentials` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Operation` varchar(50) NOT NULL,
  `ConsumerName` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Operation_ConsumerName` (`Operation`,`ConsumerName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
