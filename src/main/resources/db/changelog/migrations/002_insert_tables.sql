INSERT INTO users (username, email, password) VALUES
                                                      ('Bakyt', 'bakyt@example.com', 'pass'),
                                                      ('Aizada', 'aizada@example.com', 'pass'),
                                                      ('Nursultan', 'nursultan@example.com', 'pass');

INSERT INTO quizzes (id, title, description, creator_id) VALUES
                                                             (1, 'Города Кыргызстана', 'Проверь знания о городах Кыргызстана', 1),
                                                             (2, 'Общие знания', 'Викторина по базовым знаниям', 2);

INSERT INTO questions (id, question, quiz_id) VALUES
                                                  (1, 'Какой город является столицей Кыргызстана?', 1),
                                                  (2, 'Город на юге Кыргызстана?', 1),
                                                  (3, 'Сколько континентов на Земле?', 2),
                                                  (4, 'Столица Франции?', 2);


INSERT INTO options (id, option, is_correct, question_id) VALUES
                                                              (1, 'Бишкек', true, 1),
                                                              (2, 'Ош', false, 1),
                                                              (3, 'Нарын', false, 1),
                                                              (4, 'Каракол', false, 1);

INSERT INTO options (id, option, is_correct, question_id) VALUES
                                                              (5, 'Ош', true, 2),
                                                              (6, 'Бишкек', false, 2),
                                                              (7, 'Баткен', false, 2),
                                                              (8, 'Чолпон-Ата', false, 2);

INSERT INTO options (id, option, is_correct, question_id) VALUES
                                                              (9, 'Калифорния', true, 3),
                                                              (10, 'Вашингтон', false, 3),
                                                              (11, 'Чикаго', false, 3),
                                                              (12, 'Теннеси', false, 3);

INSERT INTO options (id, option, is_correct, question_id) VALUES
                                                              (13, 'Париж', true, 4),
                                                              (14, 'Берлин', false, 4),
                                                              (15, 'Лион', false, 4),
                                                              (16, 'Марсель', false, 4);

INSERT INTO results (id, score, user_id, quiz_id) VALUES
                                                      (1, 2.0, 1, 1),
                                                      (2, 1.0, 2, 2),
                                                      (3, 0.0, 3, 1);