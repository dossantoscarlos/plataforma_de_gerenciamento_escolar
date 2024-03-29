CREATE TABLE IF NOT EXISTS USERS (
    ID_USER UUID DEFAULT gen_random_uuid(),
    USERNAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    VALIDADE_EMAIL BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (ID_USER)
);

CREATE UNIQUE INDEX idx_unique_email ON USERS (EMAIL);
