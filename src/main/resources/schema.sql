DROP TABLE IF EXISTS order_tbl;

CREATE TABLE order_tbl (
  order_id INT AUTO_INCREMENT  PRIMARY KEY,
  order_uuid VARCHAR(250) NOT NULL
);