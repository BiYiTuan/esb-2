DROP procedure if exists GetInventory ; 
$$
CREATE PROCEDURE GetInventory(sku VARCHAR(50))
BEGIN
SELECT DISTINCT sms.Sku, sms.Quantity - IFNULL(aol.Quantity,0) as Quantity FROM SageMasterStock sms 
LEFT JOIN (SELECT aoli.Sku, SUM(aoli.Quantity) AS Quantity FROM AllocatedOrderLines aoli WHERE aoli.Status = 1 GROUP BY aoli.Sku) aol ON sms.Sku = aol.Sku
WHERE sms.Sku = sku;
END 

$$