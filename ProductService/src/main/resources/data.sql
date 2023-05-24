DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL
);


INSERT INTO product (name, price, description, image)
VALUES
    ('iPhone 13 Pro', 1299.99, 'Apple iPhone 13 Pro with advanced features.', '📱'),
    ('Samsung Galaxy S21', 1099.99, 'Samsung Galaxy S21 smartphone with stunning display.', '📱'),
    ('Sony PlayStation 5', 499.99, 'Next-generation gaming console from Sony.', '🎮'),
    ('Dell XPS 15', 1899.99, 'Powerful laptop with a high-resolution display.', '💻'),
    ('Canon EOS R5', 3799.99, 'Professional-grade mirrorless camera for photography enthusiasts.', '📸'),
    ('Bose QuietComfort 35 II', 299.99, 'Wireless noise-cancelling headphones for immersive audio experience.', '🎧'),
    ('Amazon Echo Dot', 49.99, 'Smart speaker powered by Alexa voice assistant.', '🔊'),
    ('Fitbit Versa 3', 199.99, 'Fitness smartwatch with advanced health tracking features.', '⌚'),
    ('Nintendo Switch', 299.99, 'Versatile gaming console for playing at home or on the go.', '🎮'),
    ('LG OLED CX Series', 2499.99, 'Ultra-high-definition OLED TV with rich colors and deep blacks.', '📺'),
    ('Apple MacBook Pro', 2199.99, 'Powerful laptop for professional work and creative tasks.', '💻'),
    ('GoPro HERO9 Black', 449.99, 'Action camera for capturing stunning footage in any environment.', '📷'),
    ('Microsoft Surface Pro 7', 1299.99, 'Versatile 2-in-1 tablet and laptop for productivity.', '💻'),
    ('Sony WH-1000XM4', 349.99, 'Premium wireless noise-cancelling headphones for audiophiles.', '🎧'),
    ('Samsung QLED Q80T', 1499.99, 'High-performance QLED TV with vibrant colors and impressive clarity.', '📺'),
    ('Nikon D850', 3299.99, 'Professional DSLR camera with exceptional image quality.', '📷'),
    ('Logitech G502 Hero', 79.99, 'High-precision gaming mouse with customizable features.', '🖱️'),
    ('Apple AirPods Pro', 249.99, 'Wireless earbuds with active noise cancellation and immersive sound.', '🎧'),
    ('Sony X900H', 1199.99, '4K HDR smart TV with stunning picture quality and smart features.', '📺'),
    ('HP Pavilion Gaming Laptop', 999.99, 'Gaming laptop with powerful performance and dedicated graphics.', '💻');

