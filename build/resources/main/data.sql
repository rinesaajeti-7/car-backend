-- Fut një admin (fjalëkalimi: admin123)
INSERT INTO users (name, email, password, role) VALUES ('Admin', 'admin@example.com', '$2a$10$NkZP3fB8G5zJQvJ8J8J8J8u8u8u8u8u8u8u8u8u8u8u8u8u8u8u8u', 'ADMIN');

-- Fut disa vetura shembull
INSERT INTO cars (make, model, year, price, mileage, fuel_type, image_url, description, created_at) VALUES
                                                                                                        ('Toyota', 'Corolla', 2020, 18000.00, 25000, 'Petrol', 'https://example.com/corolla.jpg', 'Excellent condition, fully serviced', NOW()),
                                                                                                        ('Honda', 'Civic', 2021, 22000.00, 15000, 'Diesel', 'https://example.com/civic.jpg', 'Low mileage, like new', NOW());