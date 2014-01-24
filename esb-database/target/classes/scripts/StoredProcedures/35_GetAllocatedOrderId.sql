DROP procedure if exists GetAllocatedOrderId ; 
\\
CREATE PROCEDURE GetAllocatedOrderId(orderNumber VARCHAR(50))
BEGIN
SELECT ao.Id FROM AllocatedOrders ao WHERE ao.OrderNumber = orderNumber;
END 

\\