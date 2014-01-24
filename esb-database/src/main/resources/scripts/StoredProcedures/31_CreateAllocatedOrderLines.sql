DROP procedure if exists CreateAllocatedOrderLines ; \\
CREATE PROCEDURE CreateAllocatedOrderLines(allocatedOrderId INT, sku VARCHAR(50), quantity INT, statusToInsert INT)
BEGIN
INSERT INTO AllocatedOrderLines(AllocatedOrderId, Sku, Quantity, Status) 
VALUES (allocatedOrderId, sku, quantity, statusToInsert);
END 

\\