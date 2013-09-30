DROP procedure if exists GetIncorrectInventoryFor ; 
$$
CREATE PROCEDURE GetIncorrectInventoryFor(frontend VARCHAR(50))
BEGIN

SET @selectInVendaButNotUpdated = CONCAT('SELECT Sku FROM ', frontend, '_StockUpdateHistory WHERE LENGTH(Sku) > 8 AND Sku NOT IN(SELECT Sku FROM StockUpdateHistory) GROUP BY Sku');
SET @selectUpdatedButNotOnVenda = CONCAT('SELECT Sku FROM StockUpdateHistory WHERE Sku NOT IN(SELECT Sku FROM ', frontend, '_StockUpdateHistory WHERE LENGTH(Sku) > 8) GROUP BY Sku');
SET @selectQuantityDifferent = CONCAT('SELECT csuh.Sku FROM ', frontend, '_StockUpdateHistory csuh JOIN StockUpdateHistory suh ON csuh.StockUpdateHistoryId = suh.Id WHERE csuh.Quantity <> suh.Quantity');

SET @getData = CONCAT('SELECT DISTINCT T.Sku FROM (', @selectInVendaButNotUpdated, ' UNION ', @selectUpdatedButNotOnVenda, ' UNION ', @selectQuantityDifferent, ') AS T WHERE LENGTH(T.Sku) > 8;');

PREPARE getStatement FROM @getData;
EXECUTE getStatement;

END 
$$