
CREATE TABLE shop
(
	id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(100),
    address VARCHAR(500),
    telephone VARCHAR(10),
    
    CONSTRAINT shop_pk PRIMARY KEY(id)
);

CREATE TABLE item
(
	code VARCHAR(30),
    
    quantity INT,
    description VARCHAR(200),
    gross_price DOUBLE,
    net_price DOUBLE,
    price DOUBLE,
    discount_amount INT,
    est_net_profit DOUBLE,
    net_profit  DOUBLE,
    shop_id INT,
    
	CONSTRAINT pk_item PRIMARY KEY(code),
    CONSTRAINT fk_item FOREIGN KEY(shop_id) REFERENCES shop(id) ON DELETE CASCADE 
);

CREATE TABLE temp_barcode_data
(
	code VARCHAR(30),
    price DOUBLE,
    quantity INT,
    
    CONSTRAINT pk_tem_barcode_data PRIMARY KEY(code),
    CONSTRAINT fk_tem_barcode_data FOREIGN KEY(code) REFERENCES item(code) ON DELETE CASCADE
);

CREATE TABLE employee
(
	
    
    empNo VARCHAR(20),
    empName VARCHAR(50),
    empAddress VARCHAR(100),
    jobDate DATE,
    contactNum INT,
    gContactNum INT,
    
	CONSTRAINT pk_item PRIMARY KEY(empNo),

CREATE TABLE users
(
	id INT AUTO_INCREMENT NOT NULL, 
	fname VARCHAR(30),
    lname VARCHAR(30),
    username VARCHAR(30),
    password VARCHAR(30),
    role VARCHAR(30),
 
     CONSTRAINT user_pk PRIMARY KEY(id)
);
  
  
CREATE TABLE employee
(
	
    
    empNo VARCHAR(20),
    empName VARCHAR(50),
    empAddress VARCHAR(100),
    basicSalary DOUBLE,
    jobDate VARCHAR(20),
    contactNum VARCHAR(10),
    gContactNum VARCHAR(10),
    
	CONSTRAINT pk_item PRIMARY KEY(empNo)
 );