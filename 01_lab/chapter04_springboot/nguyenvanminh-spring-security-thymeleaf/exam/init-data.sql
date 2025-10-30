-- Mock Data Script for Shopping Database
-- Tao du lieu test cho toan bo he thong

USE shoppingdb;

-- Tat foreign key checks tam thoi
SET FOREIGN_KEY_CHECKS = 0;

-- =====================================================
-- XOA DU LIEU CU - Theo thu tu: OrderLines > Orders > Comments > Products > Customers > Categories > Users
-- =====================================================
DELETE FROM order_lines;
DELETE FROM orders;
DELETE FROM comments;
DELETE FROM products;
DELETE FROM customers;
DELETE FROM categories;
DELETE FROM users;

-- Bat lai foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- =====================================================
-- 1. USERS - Tai khoan nguoi dung
-- =====================================================
INSERT INTO users (username, password, email) VALUES 
('admin', '$2a$10$E9LD0.KZNQ3GQv.mC0Z5K.L6cIPvP3Occ9qjJiM5LmJGVyVqnz9Bu', 'admin@example.com'),
('user1', 'pass123', 'user1@example.com'),
('user2', 'pass456', 'user2@example.com'),
('user3', 'pass789', 'user3@example.com'),
('user4', 'pass000', 'user4@example.com');

-- =====================================================
-- 2. CATEGORIES - Danh muc san pham
-- =====================================================
INSERT INTO categories (name) VALUES 
('Electronics'),
('Clothing'),
('Books'),
('Food & Beverages'),
('Home & Garden'),
('Sports & Outdoors'),
('Beauty & Personal Care');

-- =====================================================
-- 3. PRODUCTS - San pham
-- =====================================================
INSERT INTO products (name, price, in_stock, category_id) VALUES 
-- Electronics (category_id = 1)
('Laptop Dell XPS 13', 999.99, 1, 1),
('Wireless Mouse Logitech', 29.99, 1, 1),
('USB-C Cable 2m', 12.99, 1, 1),
('Monitor LG 27 inch 4K', 399.99, 1, 1),
('Mechanical Keyboard RGB', 149.99, 1, 1),
('Webcam HD 1080p', 59.99, 1, 1),
('Headphone Sony WH-1000XM4', 349.99, 0, 1),

-- Clothing (category_id = 2)
('T-Shirt Cotton 100%', 19.99, 1, 2),
('Jeans Blue Dark', 49.99, 1, 2),
('Jacket Winter Warm', 89.99, 1, 2),
('Shoes Running Nike', 129.99, 1, 2),
('Hat Baseball Cap', 14.99, 1, 2),

-- Books (category_id = 3)
('Clean Code by Robert Martin', 39.99, 1, 3),
('Design Patterns Gang of Four', 44.99, 1, 3),
('The Pragmatic Programmer', 34.99, 1, 3),
('Refactoring by Martin Fowler', 54.99, 1, 3),

-- Food & Beverages (category_id = 4)
('Coffee Beans Premium 500g', 15.99, 1, 4),
('Green Tea Organic 100g', 12.99, 1, 4),
('Dark Chocolate 70% Cocoa', 7.99, 1, 4),
('Organic Honey 500ml', 18.99, 1, 4),

-- Home & Garden (category_id = 5)
('Pillow Memory Foam', 29.99, 1, 5),
('Bed Sheet Cotton Queen', 34.99, 1, 5),
('Plant Pot Ceramic Large', 22.99, 1, 5),

-- Sports & Outdoors (category_id = 6)
('Yoga Mat Non-Slip', 24.99, 1, 6),
('Dumbbells Set 20kg', 79.99, 1, 6),
('Bicycle Road 21 Speed', 299.99, 0, 6),

-- Beauty & Personal Care (category_id = 7)
('Face Moisturizer SPF 30', 25.99, 1, 7),
('Shampoo Sulfate Free', 12.99, 1, 7),
('Skincare Set 5 Items', 59.99, 1, 7);

-- =====================================================
-- 4. COMMENTS - Binh luan san pham
-- =====================================================
INSERT INTO comments (text, product_id) VALUES 
-- Comments cho Laptop Dell XPS 13 (id = 1)
('May tinh rat tuyet voi, hieu nang cao, man hinh dep. Rat hai long!', 1),
('Gia hoi cao nhung chat luong xung dang. Giao hang nhanh, dong goi can than.', 1),
('Pin keo dai rat lau, thich hop cho nguoi hay di cong tac', 1),
('Thiet ke sang trong, mong nhe, de mang theo', 1),

-- Comments cho Wireless Mouse (id = 2)
('Chuot rat tot, khong do tre, rat smooth', 2),
('Gia re, chat luong tot, pin keo dai 1 thang', 2),
('Mau ma dep, cam bien chinh xac', 2),

-- Comments cho Monitor LG (id = 4)
('Man hinh 4K sieu sac net, mau sac rat song dong', 4),
('Tuyet voi cho lam viec do hoa', 4),
('Gia hoi mac nhung chat luong xung dang', 4),

-- Comments cho T-Shirt (id = 8)
('Ao vua van, chat cotton min, ben lau', 8),
('Gia tot, chat luong tot, se mua tiep', 8),

-- Comments cho Clean Code (id = 14)
('Cuon sach lap trinh tuyet voi, hoc duoc rat nhieu', 14),
('Huyen thoai Robert Martin, bat buoc phai doc', 14),
('Rat chi tiet, vi du ro rang, de hieu', 14),

-- Comments cho Coffee Beans (id = 18)
('Ca phe ngon, thom, rang vua phai', 18),
('Chat luong tot, gia hop ly', 18);

-- =====================================================
-- 5. CUSTOMERS - Khach hang
-- =====================================================
INSERT INTO customers (name, customer_since) VALUES 
('Nguyen Van Minh', '2024-01-15'),
('Tran Thi Hoa', '2024-02-20'),
('Le Quoc Anh', '2024-03-10'),
('Pham Thanh Tuan', '2024-04-05'),
('Do Minh Quan', '2024-05-12'),
('Vu Thi Linh', '2024-06-18'),
('Hoang Van Son', '2024-07-22'),
('Bui Thi Huong', '2024-08-08');

-- =====================================================
-- 6. ORDERS - Don hang
-- =====================================================
INSERT INTO orders (date, customer_id) VALUES 
('2024-09-01', 1),
('2024-09-03', 1),
('2024-09-05', 2),
('2024-09-10', 3),
('2024-09-12', 2),
('2024-09-15', 4),
('2024-09-18', 1),
('2024-09-20', 5),
('2024-09-22', 3),
('2024-09-25', 6),
('2024-09-28', 7),
('2024-10-01', 8),
('2024-10-05', 2),
('2024-10-10', 1),
('2024-10-15', 4);

-- =====================================================
-- 7. ORDER_LINES - Chi tiet don hang
-- =====================================================

-- Order 1 (customer: Nguyen Van Minh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(1, 1, 1, 999.99),
(1, 2, 2, 29.99);

-- Order 2 (customer: Nguyen Van Minh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(2, 8, 3, 19.99),
(2, 14, 1, 39.99);

-- Order 3 (customer: Tran Thi Hoa)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(3, 4, 1, 399.99),
(3, 5, 1, 149.99);

-- Order 4 (customer: Le Quoc Anh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(4, 10, 2, 49.99),
(4, 11, 1, 89.99),
(4, 12, 1, 129.99);

-- Order 5 (customer: Tran Thi Hoa)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(5, 18, 2, 15.99),
(5, 19, 1, 12.99);

-- Order 6 (customer: Pham Thanh Tuan)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(6, 15, 1, 34.99),
(6, 16, 2, 44.99);

-- Order 7 (customer: Nguyen Van Minh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(7, 6, 1, 59.99),
(7, 3, 3, 12.99);

-- Order 8 (customer: Do Minh Quan)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(8, 23, 1, 24.99),
(8, 24, 1, 79.99);

-- Order 9 (customer: Le Quoc Anh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(9, 26, 1, 25.99),
(9, 27, 2, 12.99);

-- Order 10 (customer: Vu Thi Linh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(10, 20, 1, 18.99),
(10, 21, 2, 7.99);

-- Order 11 (customer: Hoang Van Son)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(11, 13, 1, 54.99),
(11, 17, 1, 34.99);

-- Order 12 (customer: Bui Thi Huong)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(12, 9, 1, 14.99),
(12, 28, 1, 59.99);

-- Order 13 (customer: Tran Thi Hoa)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(13, 5, 1, 149.99),
(13, 6, 1, 59.99);

-- Order 14 (customer: Nguyen Van Minh)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(14, 14, 2, 39.99);

-- Order 15 (customer: Pham Thanh Tuan)
INSERT INTO order_lines (order_id, product_id, amount, purchase_price) VALUES 
(15, 22, 3, 22.99),
(15, 20, 1, 18.99);

-- =====================================================
-- VERIFICATION QUERIES
-- =====================================================
-- Kiem tra tong so ban ghi
SELECT 'Users' as entity, COUNT(*) as count FROM users
UNION ALL
SELECT 'Categories', COUNT(*) FROM categories
UNION ALL
SELECT 'Products', COUNT(*) FROM products
UNION ALL
SELECT 'Comments', COUNT(*) FROM comments
UNION ALL
SELECT 'Customers', COUNT(*) FROM customers
UNION ALL
SELECT 'Orders', COUNT(*) FROM orders
UNION ALL
SELECT 'OrderLines', COUNT(*) FROM order_lines;

-- Thong ke san pham theo danh muc
SELECT c.name as category, COUNT(p.id) as product_count
FROM categories c
LEFT JOIN products p ON c.id = p.category_id
GROUP BY c.id, c.name
ORDER BY c.id;

-- Thong ke binh luan theo san pham (top 5)
SELECT p.id, p.name, COUNT(c.id) as comment_count
FROM products p
LEFT JOIN comments c ON p.id = c.product_id
GROUP BY p.id, p.name
HAVING COUNT(c.id) > 0
ORDER BY comment_count DESC
LIMIT 5;

-- Thong ke don hang theo khach hang
SELECT c.name as customer, COUNT(o.id) as order_count
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name
ORDER BY order_count DESC;
