INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(1, 'Samsung', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');
INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(2, 'Apple', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');
INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(3, 'Google', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');
INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(4, 'Oppo', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');
INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(5, 'Vivo', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');
INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(6, 'Motorola', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');
INSERT INTO public.brand
(id, name, creation_date, update_date)
VALUES(7, 'OnePlus', '2023-01-28 00:23:13.602', '2023-01-28 00:23:13.602');

INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(6, 3, 'Pixel 6a', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'google_pixel_6a.png');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(4, 3, 'Pixel 7 Pro', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'google_pixel_7_pro.png');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(7, 2, 'iPhone 14', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'iphone_14.png');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(3, 2, 'iPhone 14 Pro', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'iphone_14_pro.png');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(10, 6, 'Edge 30 Ultra', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'motorola_edge_30_ultra.png');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(11, 7, '10 Pro', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'oneplus_10_pro.jpeg');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(5, 4, 'Find X5 Pro', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'oppo_find_x5_pro.jpeg');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(2, 1, 'Galaxy S22 Ultra', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'samsung_galaxy_s22_ultra.jpeg');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(8, 1, 'Galaxy Z Flip 4', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'samsung_galaxy_z_flip_4.png');
INSERT INTO public.model
(id, brand_id, "name", creation_date, update_date, image_source)
VALUES(9, 5, 'X80 Pro', '2023-01-28 00:28:54.350', '2023-01-28 00:28:54.350', 'vivo_x80_pro.jpeg');

INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(1, 2, $500.00, 100, 5, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(2, 3, $1,000.00, 100, 4, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(3, 4, $1,500.00, 100, 4, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(4, 5, $2,000.00, 100, 5, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(5, 6, $2,500.00, 100, 4, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(6, 7, $3,000.00, 100, 5, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(7, 8, $3,500.00, 100, 5, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(8, 9, $4,000.00, 100, 3, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(10, 11, $1,000.00, 100, 3, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
INSERT INTO public.stock
(id, model_id, price, in_stock, rating, creation_date, update_date)
VALUES(9, 10, $600.00, 100, 3, '2023-01-29 09:36:08.110', '2023-01-29 09:36:08.110');
