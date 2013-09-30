drop table if exists sage_master_stock;

CREATE TABLE `sage_master_stock` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Sku` varchar(255) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UpdatedDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Sku` (`Sku`)
) ENGINE=INNODB ;