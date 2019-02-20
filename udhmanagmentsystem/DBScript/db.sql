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