DROP TABLE IF EXISTS kahvit;

CREATE TABLE kahvit (
    kahvi_id INT PRIMARY KEY,
    nimi VARCHAR(255),
    kuvaus VARCHAR(255),
    alkupera VARCHAR(255),
    paahtoaste INT,
    luomu BOOLEAN
);

INSERT INTO kahvit (kahvi_id, nimi, kuvaus, alkupera, paahtoaste, luomu)
VALUES (1, 'Juhla Mokka', 'Ankean perinteinen', 'Suomi', 1, false);