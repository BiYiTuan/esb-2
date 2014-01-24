DROP procedure if exists UpdateAllocatedOrderStatus ; \\

CREATE PROCEDURE UpdateAllocatedOrderStatus(orderStatus INT, id INT)
BEGIN
UPDATE AllocatedOrders SET Status = orderStatus WHERE Id = id;
END 

\\