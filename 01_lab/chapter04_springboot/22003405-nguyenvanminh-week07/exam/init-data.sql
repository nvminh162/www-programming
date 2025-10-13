-- Script khởi tạo dữ liệu mẫu cho database shoppingdb

-- Tạo database nếu chưa tồn tại
CREATE DATABASE IF NOT EXISTS shoppingdb;
USE shoppingdb;

-- Insert Categories
INSERT INTO categories (name) VALUES 
('Electronics'),
('Clothing'),
('Books'),
('Food & Beverages'),
('Home & Garden');

-- Insert Customers
INSERT INTO customers (name, customer_since) VALUES 
('Nguyen Van A', '2023-01-15'),
('Tran Thi B', '2023-03-20'),
('Le Van C', '2023-05-10'),
('Pham Thi D', '2023-07-25'),
('Hoang Van E', '2023-09-30');

-- Insert Products
INSERT INTO products (name, price, in_stock, category_id) VALUES 
('Laptop Dell XPS 13', 25000000, true, 1),
('iPhone 15 Pro', 30000000, true, 1),
('Samsung Galaxy S24', 22000000, true, 1),
('T-Shirt Nike', 350000, true, 2),
('Jeans Levis', 1200000, true, 2),
('Sneakers Adidas', 2500000, true, 2),
('Clean Code Book', 450000, true, 3),
('Design Patterns Book', 550000, true, 3),
('Coffee Arabica 1kg', 250000, true, 4),
('Green Tea 500g', 150000, true, 4),
('Garden Tools Set', 850000, true, 5),
('LED Desk Lamp', 450000, true, 5);

-- Insert Users
INSERT INTO users (username, password, email) VALUES 
('admin', 'admin123', 'admin@example.com'),
('user1', 'user123', 'user1@example.com'),
('user2', 'user123', 'user2@example.com');

-- Insert Orders
INSERT INTO orders (date, customer_id) VALUES 
('2024-01-15', 1),
('2024-02-20', 2),
('2024-03-10', 3),
('2024-04-05', 1),
('2024-05-12', 4);

-- Insert Order Lines (giả sử orders có id từ 1-5)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
-- Order 1
(1, 1, 1, 25000000),
(1, 4, 2, 350000),
-- Order 2
(2, 2, 1, 30000000),
(2, 9, 2, 250000),
-- Order 3
(3, 7, 3, 450000),
(3, 8, 2, 550000),
-- Order 4
(4, 3, 1, 22000000),
(4, 6, 1, 2500000),
-- Order 5
(5, 11, 1, 850000),
(5, 12, 2, 450000);

-- Insert Comments
INSERT INTO comments (text, product_id) VALUES 
('Great laptop! Very fast and reliable.', 1),
('Good performance, worth the price.', 1),
('Amazing phone with excellent camera.', 2),
('Battery life could be better.', 2),
('Comfortable and good quality.', 4),
('Must-read for developers!', 7),
('Very insightful book on software design.', 8),
('Fresh and aromatic coffee.', 9),
('Good quality tea, highly recommended.', 10),
('Durable and practical tools.', 11);
