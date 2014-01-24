DROP procedure if exists UpdateSageMasterStock ; \\
CREATE PROCEDURE UpdateSageMasterStock(sku VARCHAR(50), quantity INT, updatedDateTime VARCHAR(50))
BEGIN
INSERT INTO SageMasterStock(Sku, Quantity, UpdatedDateTime) VALUES (sku, quantity, updatedDateTime) 
ON DUPLICATE KEY UPDATE Quantity=quantity, UpdatedDateTime=updatedDateTime;
END 
\\