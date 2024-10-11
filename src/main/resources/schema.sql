CREATE TABLE IF NOT EXISTS clients (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    role VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    number VARCHAR(10) NOT NULL UNIQUE,
    balance DOUBLE NOT NULL,
    type VARCHAR(10) NOT NULL,
    creation_date DATE NOT NULL,
    client_id UUID,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE IF NOT EXISTS transactions (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    amount DOUBLE NOT NULL,
    type VARCHAR(15) NOT NULL,
    description VARCHAR(101) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    account_id UUID,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);