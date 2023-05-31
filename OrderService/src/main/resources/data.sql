-- Create the orders table
DROP TABLE IF EXISTS orders;
CREATE TABLE IF NOT EXISTS orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id VARCHAR(255),
    customer_id BIGINT,
    product_id BIGINT,
    quantity INT,
    order_date TIMESTAMP,
    status VARCHAR(40)
);

-- Insert sample data
INSERT INTO orders (order_id, customer_id, product_id, quantity, order_date, status)
VALUES ('ORD001', 1, 101, 2, '2022-01-01 10:00:00','ORDERED'),
       ('ORD002', 2, 102, 3, '2022-02-02 12:00:00','SHIPPED'),
       ('ORD002', 2, 104, 3, '2022-02-02 12:00:00','DELIVERED'),
       ('ORD003', 3, 103, 1, '2022-03-03 14:00:00','CANCELED');
