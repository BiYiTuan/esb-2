DROP procedure if exists CreateAllocatedOrder ; \\
CREATE PROCEDURE CreateAllocatedOrder(orderNumber VARCHAR(50), orderStatus INT, OUT outId INT)
BEGIN
INSERT INTO AllocatedOrders(OrderNumber, Status) VALUES (orderNumber, orderStatus);

SET outId = LAST_INSERT_ID();
END 

\\