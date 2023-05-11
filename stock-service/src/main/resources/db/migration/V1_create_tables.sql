CREATE TABLE IF NOT EXISTS public.stocks (
                               id BIGSERIAL primary key,
                               stock_name VARCHAR NOT NULL,
                               stock_type INT NOT NULL
);