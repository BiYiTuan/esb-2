DROP procedure if exists GetVendaFtpCredentials ; 
$$
CREATE PROCEDURE GetVendaFtpCredentials()
BEGIN
SELECT Name, Hostname, Username, Password FROM VendaFtpCredentials;
END 
$$