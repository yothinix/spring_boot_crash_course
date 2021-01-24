DROP TABLE IF EXISTS activity;

CREATE TABLE activity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    description VARCHAR(256) NOT NULL,
    created_at BIGINT NOT NULL,
    created_by VARCHAR(256) NOT NULL
);

INSERT INTO activity (name, description, created_at, created_by) VALUES
    ('Login', 'User HuMan is logged into the system', 1611378363, 'HuMan'),
    ('Transaction', 'User HuMan retrieving account summary', 1611378370, 'HuMan'),
    ('Transaction', 'User HuMan withdraw 112', 1611378470, 'HuMan'),
    ('Logout', 'User HuMan is logged out', 1611378870, 'HuMan'),
    ('Login', 'User Gatuk logged into the system', 1611378870, 'Gatuk'),
    ('Transaction', 'User Gatuk retrieving account summary', 1611378875, 'Gatuk');
