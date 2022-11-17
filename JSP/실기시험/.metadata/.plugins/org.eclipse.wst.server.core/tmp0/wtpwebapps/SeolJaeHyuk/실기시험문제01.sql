CREATE TABLE tbl_order(
	num INT AUTO_INCREMENT PRIMARY KEY,
	p_name VARCHAR(200),
	quantity  INT,
	price 	INT
);

INSERT INTO tbl_order(p_name, quantity, price) VALUES('운동화', 3, 50000);
INSERT INTO tbl_order(p_name, quantity, price) VALUES('슬리퍼', 10, 5600);
INSERT INTO tbl_order(p_name, quantity, price) VALUES('샌들', 5, 34500);

SELECT * FROM tbl_order