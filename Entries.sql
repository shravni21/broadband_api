use api
INSERT INTO plan (name, duration, amount)
VALUES ('Basic Plan', 12, 50.00),
       ('Premium Plan', 24, 100.00),
       ('Family Plan', 24, 120.00),
       ('Corporate Plan', 60, 250.00);
INSERT INTO broadband (connection_id, provider_name, plan_id)
VALUES (1, 'XYZ Broadband', 1), 
       (2, 'ABC Internet', 2),  
       (3, '123 Telecom', 3);   
INSERT INTO customer (name, address, contact_number, broadband_connection_id)
VALUES ('John Doe', '123 Main Street', '+918432713596', 1),
       ('Jane Smith', '456 Elm Avenue', '+918541024856', 2),
       ('Mike Johnson', '789 Oak Lane', '+918273645951', 3),
       ('Emily Brown', '246 Pine Road', '+919876543210', 1),
       ('Chris Wilson', '789 Maple Drive', '+919012345678', 2),
       ('Sarah Davis', '1010 Oak Avenue', '+918754210369', 3),
       ('Kevin Miller', '1313 Elm Street', '+917845629301', 1),
       ('Amanda Taylor', '1515 Cedar Lane', '+918753694201', 2),
       ('Robert Harris', '1818 Maple Road', '+919865432109', 3),
       ('Jessica Lee', '2020 Birch Street', '+917856341290', 1),
       ('Mark Thompson', '2222 Pine Avenue', '+918765432109', 4),
       ('Emma White', '3333 Oak Lane', '+917654321098', 4);

