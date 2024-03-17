CREATE TABLE PRICES(
    id IDENTITY PRIMARY KEY,
    brand_id INTEGER NOT NULL,
    start_date DATE,
    end_date DATE,
    price_list INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    priority INTEGER NOT NULL,
    price DECIMAL,
    curr VARCHAR(100)
);