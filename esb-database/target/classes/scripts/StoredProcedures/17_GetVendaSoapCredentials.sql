DROP procedure if exists GetVendaSoapCredentials ; 
\\
CREATE PROCEDURE GetVendaSoapCredentials()
BEGIN
SELECT Operation, ConsumerName, Username, Password FROM VendaSoapCredentials;
END 

\\