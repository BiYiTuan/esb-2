DROP procedure if exists CreateOrUpdateStockUpdateHistory ; 
\\
CREATE PROCEDURE CreateOrUpdateStockUpdateHistory(sku VARCHAR(50), quantity INT, 
updatedDateTime VARCHAR(50), reasonForChange VARCHAR(50), OUT outId INT)
BEGIN

SET @lastQuantity = (SELECT suh.Quantity FROM StockUpdateHistory suh WHERE suh.Sku = sku ORDER BY suh.Id DESC LIMIT 1);
IF (@lastQuantity IS NULL) THEN
	SET @lastQuantity = -1;
END IF;

IF (@lastQuantity <> quantity) THEN 
	INSERT INTO StockUpdateHistory(Sku, Quantity, UpdatedDateTime, ReasonForChange) VALUES (sku, quantity, updatedDateTime, reasonForChange);
	
	SET outId = LAST_INSERT_ID();
END IF;

END 
\\