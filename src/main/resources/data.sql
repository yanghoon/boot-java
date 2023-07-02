-- User
insert into users (id, version, name, username, email, phone, website) values (1, 1, 'Leanne Graham', 'Bret', 'Sincere@april.biz', '1-770-736-8031 x56442', 'hildegard.org');

-- Post
insert into post (id, user_id, version, title, body) values (
    1, 1, 1,
    'sunt aut facere repellat provident occaecati excepturi optio reprehenderit',
    'quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto'
);