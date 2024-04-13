
-- Створення таблиці "Користувачі", якщо вона не існує
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'users') THEN
            CREATE TABLE users
            (
                id           SERIAL PRIMARY KEY,
                name         VARCHAR(100)        NOT NULL,
                email        VARCHAR(100) UNIQUE NOT NULL,
                password     VARCHAR(255)        NOT NULL,
                role      VARCHAR(20)                   NOT NULL,
                date_of_birth DATE NOT NULL
            );
        END IF;
    END
$$;

-- Створення таблиці "Місця заходів", якщо вона не існує
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'event_places') THEN
            CREATE TABLE event_places
            (
                id            SERIAL PRIMARY KEY,
                place_name    VARCHAR(255) NOT NULL,
                place_address VARCHAR(255),
                capacity      INT,
                accessibility BOOLEAN
            );
        END IF;
    END
$$;

-- Створення таблиці "Заходи", якщо вона не існує
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'events') THEN
            CREATE TABLE events
            (
                id                     SERIAL PRIMARY KEY,
                event_name             VARCHAR(255) NOT NULL,
                event_date             DATE         NOT NULL,
                event_time             TIME         NOT NULL,
                place_id               INT          NOT NULL,
                number_of_participants INT          NOT NULL,
                event_description      TEXT,
                organizer_contact_info VARCHAR(255),
                access_type            VARCHAR(20),
                CONSTRAINT fk_place FOREIGN KEY (place_id) REFERENCES event_places (id)
            );
        END IF;
    END
$$;

-- Створення таблиці "Місця заходів", якщо вона не існує (дублювання)
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'event_places') THEN
            CREATE TABLE event_places
            (
                id            SERIAL PRIMARY KEY,
                place_name    VARCHAR(255) NOT NULL,
                place_address VARCHAR(255),
                capacity      INT,
                accessibility BOOLEAN
            );
        END IF;
    END
$$;

-- Створення таблиці "Статистика", якщо вона не існує
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'statistics') THEN
            CREATE TABLE statistics
            (
                id                SERIAL PRIMARY KEY,
                -- Найменування таблиці для статистики (вибіркова назва)
                stat_date         DATE         NOT NULL,
                request_count     INT,
                participant_count INT,
                event_type_count  INT
                -- Додайте тут інші показники аналітики, якщо потрібно
            );
        END IF;
    END
$$;