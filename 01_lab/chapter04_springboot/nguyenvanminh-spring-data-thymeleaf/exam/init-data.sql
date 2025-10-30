-- Test script để verify Comments feature
-- Chạy sau khi đã có dữ liệu trong database

USE shoppingdb;

-- 1. Xem sản phẩm và comments hiện tại
SELECT p.id, p.name, COUNT(c.id) as total_comments
FROM products p
LEFT JOIN comments c ON p.id = c.product_id
GROUP BY p.id, p.name
ORDER BY p.id;

-- 2. Thêm nhiều comments cho cùng 1 sản phẩm (product_id = 1)
INSERT INTO comments (text, product_id) VALUES 
('Comment thứ nhất - Test Lombok', 1),
('Comment thứ hai - Rất tốt!', 1),
('Comment thứ ba - Đáng đồng tiền', 1);

-- 3. Kiểm tra lại số lượng comments
SELECT p.id, p.name, COUNT(c.id) as total_comments
FROM products p
LEFT JOIN comments c ON p.id = c.product_id
GROUP BY p.id, p.name
ORDER BY p.id;

-- 4. Xem chi tiết tất cả comments của product_id = 1
SELECT c.id, c.text, c.product_id, p.name as product_name
FROM comments c
JOIN products p ON c.product_id = p.id
WHERE p.id = 1
ORDER BY c.id;

-- 5. Đếm tổng số comments trong database
SELECT COUNT(*) as total_comments FROM comments;

-- 6. Top 5 sản phẩm có nhiều comments nhất
SELECT p.id, p.name, COUNT(c.id) as comment_count
FROM products p
LEFT JOIN comments c ON p.id = c.product_id
GROUP BY p.id, p.name
ORDER BY comment_count DESC
LIMIT 5;
