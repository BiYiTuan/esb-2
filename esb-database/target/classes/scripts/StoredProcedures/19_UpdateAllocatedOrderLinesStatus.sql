DROP procedure if exists UpdateAllocatedOrderLinesStatus ; 
$$

CREATE PROCEDURE UpdateAllocatedOrderLinesStatus(orderStatus INT, allocatedOrderId  INT, sku VARCHAR(50), quantity INT)
BEGIN
UPDATE AllocatedOrderLines 
SET Status = orderStatus 
WHERE AllocatedOrderId = allocatedOrderId 
AND Sku = sku 
AND Quantity = quantity;
END 

$$