
CREATE TABLE IF NOT EXISTS application (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN DEFAULT TRUE,
    updated TIMESTAMP
);


CREATE TABLE IF NOT EXISTS user_application (
    user_id BINARY(16),
    application_id BINARY(16),
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lastAccess TIMESTAMP,
    active BOOLEAN DEFAULT TRUE,
    CONSTRAINT unique_user_application UNIQUE (user_id, application_id)
);
