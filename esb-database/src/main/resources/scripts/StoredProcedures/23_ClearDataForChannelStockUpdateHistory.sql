DROP procedure if exists ClearDataForChannelStockUpdateHistory ; $$
CREATE PROCEDURE ClearDataForChannelStockUpdateHistory(frontend VARCHAR(50))
BEGIN

SET @deleteTable = CONCAT('DELETE FROM ', frontend, '_StockUpdateHistory');

PREPARE deleteStatement FROM @deleteTable;
EXECUTE deleteStatement;

END 
$$