CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER NOT NULL PRIMARY KEY,
    user_login TEXT NOT NULL,
    user_password TEXT NOT NULL,
    user_fname TEXT,
    user_lname TEXT
);

CREATE TABLE IF NOT EXISTS news (
    news_id INTEGER NOT NULL PRIMARY KEY,
    news_title TEXT NOT NULL,
    news_body TEXT NOT NULL,
    news_author INTEGER,
    FOREIGN KEY (news_author)
        REFERENCES users (user_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS idx_users_login ON users (user_login);

------------------------------

INSERT INTO users(user_login, user_password, user_fname, user_lname)
    VALUES (?, ?, ?, ?);

INSERT INTO news(news_title, news_body, news_author)
    VALUES (?, ?, ?);

SELECT * FROM users WHERE user_id = ? LIMIT 1;