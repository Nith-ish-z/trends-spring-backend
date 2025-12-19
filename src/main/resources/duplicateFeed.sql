USE trends;

-- =====================================================
-- BRANDS TABLE (Approx. 35 Fashion & Beauty Brands)
-- =====================================================

INSERT INTO brands (name, description, img_url) VALUES
('Zara', 'International fashion brand offering trendy mens and womens wear.', 'https://i.pinimg.com/1200x/13/33/9b/13339b5ae6629c0e53e1393e5afe4c57.jpg'),
('H&M', 'Global fashion retailer for men, women, and beauty essentials.', 'https://i.pinimg.com/736x/13/19/c0/1319c023694bb21a9f668796c6ea33b6.jpg'),
('Uniqlo', 'Minimalist clothing brand known for comfort and quality.', 'https://i.pinimg.com/1200x/95/4e/cb/954ecb98fa32ae670f64e70c784a56f3.jpg'),
('Levis', 'Iconic denim brand known for jeans and casual wear.', 'https://i.pinimg.com/1200x/8f/01/97/8f01970e1bc1b13b40531d40c87f9ca7.jpg'),
('Nike', 'Sportswear and lifestyle brand for men and women.', 'https://i.pinimg.com/736x/cb/bc/32/cbbc3211078a77fc8771c76c273ffce9.jpg'),
('Adidas', 'Athletic apparel brand blending fashion and performance.', 'https://i.pinimg.com/736x/68/21/4b/68214b8db3a809e8de10f1a344a2bc85.jpg'),
('Puma', 'Sports and casual fashion brand.', 'https://i.pinimg.com/736x/67/f7/c9/67f7c990076073ad4ff91fd38c6fba91.jpg'),
('Gucci', 'Luxury fashion brand offering clothing, bags, and beauty.', 'https://i.pinimg.com/736x/62/76/32/6276327ee9ee965cfe426561a9b14ff7.jpg'),
('Prada', 'High-end fashion brand for modern luxury wear.', 'https://i.pinimg.com/1200x/8f/cf/5f/8fcf5fb946f7f7513e7ed4d7f0bace3f.jpg'),
('Louis Vuitton', 'Luxury brand known for handbags and premium fashion.', 'https://i.pinimg.com/736x/b2/82/4d/b2824d097cf6bab12362e9f481382b03.jpg'),
('Chanel', 'Classic luxury brand for fashion and beauty products.', 'https://i.pinimg.com/736x/92/de/46/92de46f55a67ad97a1f1facdafa3c967.jpg'),
('Dior', 'Luxury fashion house for clothing, bags, and cosmetics.', 'https://i.pinimg.com/736x/62/5a/cc/625acc97d73356a1a561aeeaa77417f5.jpg'),
('Calvin Klein', 'Modern fashion brand for apparel and accessories.', 'https://i.pinimg.com/1200x/4f/c5/ba/4fc5ba64c64162bac8bcd81350fc971d.jpg'),
('Tommy Hilfiger', 'American fashion brand offering classic wear.', 'https://i.pinimg.com/1200x/52/58/b5/5258b5ec6ac478aa244c0f63977372a0.jpg'),
('Versace', 'Bold luxury fashion brand.', 'https://i.pinimg.com/1200x/8e/e4/cc/8ee4ccedbb5fb39bec8c2af6c0bc5e26.jpg'),
('Burberry', 'British luxury brand with iconic designs.', 'https://i.pinimg.com/736x/96/ea/fa/96eafaedc9df66fe69ab833230d8ab46.jpg'),
('Forever 21', 'Fast fashion brand for trendy apparel.', 'https://i.pinimg.com/1200x/54/13/b8/5413b89c2da8b27f0c56c7844aab91ca.jpg'),
('Urban Outfitters', 'Youth-focused fashion and lifestyle brand.', 'https://i.pinimg.com/736x/d2/e2/b6/d2e2b62117812fefb801f8f1c7f6055b.jpg'),
('Mango', 'Contemporary fashion brand for men and women.', 'https://i.pinimg.com/736x/bc/f4/47/bcf44756c86e47ad7c1dfc5a61c2c71d.jpg'),
('Guess', 'Fashion brand known for denim and accessories.', 'https://i.pinimg.com/736x/f3/dc/cb/f3dccbbaf3e96f644fb969a38da976b8.jpg'),
('Bata', 'Footwear and fashion accessories brand.', 'https://i.pinimg.com/736x/96/8b/2f/968b2f8f9838a155912381ba3c69dbec.jpg'),
('Allen Solly', 'Formal and casual wear brand.', 'https://i.pinimg.com/1200x/a4/48/66/a448663f61e275ec5b8b6f4fe7d114c3.jpg'),
('Van Heusen', 'Premium formal wear brand.', 'https://i.pinimg.com/736x/49/cf/03/49cf035d58c92c4076e34ee3caed1e23.jpg'),
('Raymond', 'Classic menswear brand.', 'https://i.pinimg.com/736x/6e/56/f5/6e56f5d86dfbdbe6fa61f1f0058ca3f1.jpg'),
('Pantaloons', 'Indian fashion retail brand.', 'https://i.pinimg.com/1200x/b7/5b/1c/b75b1cac5a2e7a56b9e69ac95c9fc859.jpg'),
('FabIndia', 'Traditional and ethnic fashion brand.', 'https://i.pinimg.com/736x/7a/97/fe/7a97fe9d5bcd7ca2f172c084a3d8d3e6.jpg'),
('Biba', 'Women ethnic wear brand.', 'https://i.pinimg.com/1200x/95/96/c7/9596c75991f99dc9feb979b439e90f8b.jpg'),
('W', 'Contemporary women ethnic wear brand.', 'https://i.pinimg.com/1200x/2c/f9/16/2cf9164e94841c26f84d81cbdd809951.jpg'),
('Lakme', 'Beauty and cosmetic brand.', 'https://i.pinimg.com/1200x/55/90/0b/55900beeff90476e34df8f7303a060e3.jpg'),
('Maybelline', 'Makeup and beauty brand.', 'https://i.pinimg.com/1200x/38/82/ba/3882bacc12e0ba2bedf5f0c3083eb08a.jpg'),
('L’Oreal', 'Global beauty and personal care brand.', 'https://i.pinimg.com/1200x/c8/9b/28/c89b283f9f6f516ec6af70277279e930.jpg'),
('MAC', 'Professional makeup brand.', 'https://i.pinimg.com/736x/55/eb/f8/55ebf8bbaaa36837a7f35ddba4f4ee89.jpg'),
('The Body Shop', 'Natural beauty and skincare brand.', 'https://i.pinimg.com/1200x/49/0e/2a/490e2a9372c851e331900caee2d4c1bd.jpg'),
('Fossil', 'Fashion accessories and bags brand.', 'https://i.pinimg.com/1200x/46/8d/e9/468de9ebd4f9aa6377eab17dfab5df93.jpg'),
('Michael Kors', 'Luxury fashion and handbag brand.', 'https://i.pinimg.com/736x/81/8d/2d/818d2d271ab6dd9aa638ad4e4ed121ac.jpg');

-- =====================================================
-- CATEGORIES TABLE
-- =====================================================

INSERT INTO categories (name, description, img_url) VALUES
('Mens Wear', 'Clothing and fashion items for men.', 'https://i.pinimg.com/1200x/c9/4b/80/c94b80778cc44b28a45fe4aea8415e52.jpg'),
('Mens Fashion Wear', 'Trendy and modern mens fashion clothing.', 'https://i.pinimg.com/736x/37/ed/d8/37edd82ef385e0e33bcddbdd885152be.jpg'),
('Womens Wear', 'Clothing and fashion items for women.', 'https://i.pinimg.com/1200x/cb/71/41/cb7141083471301d19c4d24f09a7d42c.jpg'),
('Womens Traditional Wear', 'Ethnic and traditional wear for women.', 'https://i.pinimg.com/1200x/11/14/0a/11140ad8fa0e27ac29116f7d00b854a1.jpg'),
('Beauty Items', 'Cosmetics, skincare, and beauty products.', 'https://i.pinimg.com/1200x/e7/47/8b/e7478b2b186ad96baeedc1d97dc24ed2.jpg'),
('Handbags & Purses', 'Fashion handbags, purses, and wallets.', 'https://i.pinimg.com/1200x/07/4c/8d/074c8d1d02f32cccc00e6b8c0c57c064.jpg'),
('Footwear', 'Shoes, sandals, and footwear for all.', 'https://i.pinimg.com/736x/c1/d0/aa/c1d0aab87ffbe1b1bfd5da75e3606536.jpg'),
('Accessories', 'Fashion accessories for men and women.', 'https://i.pinimg.com/1200x/96/53/f6/9653f6102b68c96dd8f59808b3ceed9d.jpg'),
('Kids Wear', 'Clothing and accessories for kids.', 'https://i.pinimg.com/736x/5a/9f/f1/5a9ff120b428dc0715227c28e64d90c1.jpg'),
('Sports & Activewear', 'Sportswear and fitness clothing.', 'https://i.pinimg.com/1200x/36/85/1e/36851ec566fcf618e356b5f557259671.jpg'),
('Winter Wear', 'Warm clothing for winter season.', 'https://i.pinimg.com/1200x/0d/0d/49/0d0d4901bdce421292838a2747314ccc.jpg'),
('Jewelry & Watches', 'Fashion jewelry and watches.', 'https://i.pinimg.com/736x/88/04/16/880416248d729617b25e810116f5f780.jpg');

-- =====================================================
-- SUBCATEGORIES TABLE
-- Assumed category IDs:
-- 1 Mens Wear
-- 2 Mens Fashion Wear
-- 3 Womens Wear
-- 4 Womens Traditional Wear
-- 5 Beauty Items
-- 6 Handbags & Purses
-- =====================================================

INSERT INTO subcategories (category_id, name, description, img_url) VALUES
-- Mens Wear (1)
(1, 'T-Shirts', 'Casual and comfortable mens t-shirts.', 'https://i.pinimg.com/1200x/77/f0/8d/77f08d3db54ac8d72ba5cb7ebe8796a2.jpg'),
(1, 'Shirts', 'Formal and casual shirts for men.', 'https://img.fantaskycdn.com/cec0a83cb5ecf289b2e6af963a00c674_2056x.jpeg'),
(1, 'Jeans', 'Denim jeans for everyday wear.', 'https://i.pinimg.com/1200x/aa/26/4d/aa264db047663ddc0be5c7b3eab10448.jpg'),
(1, 'Trousers', 'Formal and semi-formal trousers.', 'https://i.pinimg.com/1200x/e3/d0/1a/e3d01aad3e51cafe748bff5813d8b8f4.jpg'),
(1, 'Jackets', 'Outerwear jackets for men.', 'https://i.pinimg.com/1200x/26/5a/7a/265a7add90f5682fc56ad7ccb656fd01.jpg'),

-- Mens Fashion Wear (2)
(2, 'Hoodies', 'Trendy hoodies and sweatshirts.', 'https://i.pinimg.com/736x/b6/8f/86/b68f86d5fdc7541398baab32f98301f2.jpg'),
(2, 'Sneakers', 'Stylish fashion sneakers.', 'https://i.pinimg.com/736x/de/2d/02/de2d021e61235ccfcd81fa355f6790fc.jpg'),
(2, 'Streetwear', 'Urban and street fashion clothing.', 'https://i.pinimg.com/736x/a0/4c/e6/a04ce665c79042238b0b425067b6d336.jpg'),
(2, 'Blazers', 'Modern slim-fit blazers.', 'https://i.pinimg.com/1200x/89/13/0d/89130d56d2224f82fc808a461500d22b.jpg'),
(2, 'Co-ord Sets', 'Matching fashion outfit sets.', 'https://i.pinimg.com/1200x/aa/1a/ec/aa1aecc2d2df2ab841c7e304fe1838ca.jpg'),

-- Womens Wear (3)
(3, 'Tops', 'Casual and party wear tops.', 'https://i.pinimg.com/736x/ec/ba/31/ecba3108ea2c4ab750f108ddad06c883.jpg'),
(3, 'Dresses', 'Western dresses for women.', 'https://i.pinimg.com/736x/61/59/b6/6159b6f00b2377483752f5898de30c98.jpg'),
(3, 'Jeans', 'Women denim jeans.', 'https://i.pinimg.com/1200x/70/18/23/701823b45e8bf3a9b664ef68cbb69b44.jpg'),
(3, 'Skirts', 'Fashionable skirts.', 'https://i.pinimg.com/1200x/ea/c0/ae/eac0ae1323469985e85f56f0fdf37bef.jpg'),
(3, 'Jumpsuits', 'One-piece fashion outfits.', 'https://i.pinimg.com/736x/24/01/49/2401492293581b5c7be02e99f910f829.jpg'),

-- Womens Traditional Wear (4)
(4, 'Sarees', 'Traditional Indian sarees.', 'https://i.pinimg.com/1200x/ff/fb/38/fffb385bbd86160fea401e4d7e3f754e.jpg'),
(4, 'Kurtis', 'Everyday ethnic kurtis.', 'https://i.pinimg.com/736x/4d/73/de/4d73de942c79ea30814d3c6178f96865.jpg'),
(4, 'Lehenga', 'Festive and bridal lehengas.', 'https://i.pinimg.com/1200x/58/90/1e/58901e15242552f87d63a7233efcd7cf.jpg'),
(4, 'Salwar Suits', 'Traditional salwar suit sets.', 'https://i.pinimg.com/736x/d1/51/90/d15190354c97c49857cd86a5ff6fcff7.jpg'),
(4, 'Dupattas', 'Ethnic dupattas and stoles.', 'https://i.pinimg.com/736x/f1/b4/f1/f1b4f11e2032769aeafa7f9c37106920.jpg'),

-- Beauty Items (5)
(5, 'Makeup', 'Cosmetics and makeup products.', 'https://i.pinimg.com/736x/0d/62/3a/0d623a9caa9d3540f9cbad09f7229581.jpg'),
(5, 'Skincare', 'Skin treatment and care products.', 'https://i.pinimg.com/736x/07/1d/b3/071db3824939667672566be9394333df.jpg'),
(5, 'Haircare', 'Hair care and styling products.', 'https://i.pinimg.com/1200x/bc/1b/bc/bc1bbc34a47c5b87640b9b59fb5d5354.jpg'),
(5, 'Perfumes', 'Fragrances and deodorants.', 'https://i.pinimg.com/736x/dc/be/16/dcbe1686965e8a95fa5dba135491017d.jpg'),
(5, 'Beauty Tools', 'Brushes and beauty accessories.', 'https://i.pinimg.com/1200x/ff/0a/71/ff0a71b502ac0d5e1828aa82f3115e99.jpg'),

-- Handbags & Purses (6)
(6, 'Handbags', 'Fashion handbags for women.', 'https://i.pinimg.com/1200x/8c/d4/79/8cd47955f1d5c4a100874aae45f159f3.jpg'),
(6, 'Purses', 'Small purses and clutches.', 'https://i.pinimg.com/736x/2c/d9/b8/2cd9b86b152e811cebcc6bc643eebc22.jpg'),
(6, 'Wallets', 'Men and women wallets.', 'https://i.pinimg.com/1200x/9d/77/fd/9d77fda8e26654275627ba27702be43e.jpg'),
(6, 'Backpacks', 'Fashion and travel backpacks.', 'https://i.pinimg.com/736x/2b/d7/05/2bd705c344729224e107739ef2932f1f.jpg'),
(6, 'Sling Bags', 'Casual sling bags.', 'https://i.pinimg.com/736x/d6/99/db/d699db1f70e4ba7d6745c4f462d89299.jpg'),

-- Footwear (7)
(7, 'Casual Shoes', 'Everyday casual footwear.', 'https://i.pinimg.com/736x/93/67/f8/9367f8ff6181f322823cac9d7ef6eb06.jpg'),
(7, 'Formal Shoes', 'Office and formal shoes.', 'https://i.pinimg.com/736x/68/ef/5a/68ef5ab0ce15d5c9582bce3f8bf0e7ce.jpg'),
(7, 'Sneakers', 'Comfortable fashion sneakers.', 'https://i.pinimg.com/736x/a1/7d/9a/a17d9a900eea4d103ca31d2a3d25483c.jpg'),
(7, 'Sandals', 'Open footwear for daily use.', 'https://i.pinimg.com/1200x/12/e1/d8/12e1d8e55d671cfef45896ff90ec1a7a.jpg'),
(7, 'Heels', 'Stylish heels for women.', 'https://i.pinimg.com/1200x/03/41/58/0341587b1bdf5b413694acdd49dbda7c.jpg'),

-- Accessories (8)
(8, 'Belts', 'Leather and fabric belts.', 'https://i.pinimg.com/1200x/8f/8f/8e/8f8f8eb0f6afa2540c404916eff12e52.jpg'),
(8, 'Caps & Hats', 'Fashion caps and hats.', 'https://i.pinimg.com/736x/d2/95/40/d29540c593f7400bc6debc34feef9d52.jpg'),
(8, 'Sunglasses', 'Stylish sunglasses.', 'https://i.pinimg.com/1200x/9b/50/ad/9b50adc241403ab5f96c64a45bda2a4f.jpg'),
(8, 'Scarves', 'Scarves and stoles.', 'https://i.pinimg.com/736x/7f/cb/3f/7fcb3f23ff0d16f2faafa566c37fbb20.jpg'),
(8, 'Watches', 'Fashion and casual watches.', 'https://i.pinimg.com/736x/dd/a6/2a/dda62a139cf181ac45236d3e9203cd8a.jpg'),

-- Kids Wear (9)
(9, 'Boys Clothing', 'Clothing for boys.', 'https://i.pinimg.com/1200x/9b/43/ce/9b43cea3f4b94ce76563e8b1229578f6.jpg'),
(9, 'Girls Clothing', 'Clothing for girls.', 'https://i.pinimg.com/1200x/a7/b0/e1/a7b0e1816f54b9d3551ee88cf9403a43.jpg'),
(9, 'Kids Ethnic Wear', 'Traditional wear for kids.', 'https://i.pinimg.com/736x/6e/e3/e2/6ee3e2efa73d196ba8d1fa287b95b82a.jpg'),
(9, 'Kids Footwear', 'Shoes and sandals for kids.', 'https://i.pinimg.com/1200x/3a/fb/4a/3afb4a6ebb563f9dc191cabbbaf4d097.jpg'),
(9, 'Kids Accessories', 'Caps, belts, and bags for kids.', 'https://i.pinimg.com/1200x/62/01/04/6201047dcf7d93eff9672193440af169.jpg'),

-- Sports & Activewear (10)
(10, 'Gym Wear', 'Workout and gym clothing.', 'https://i.pinimg.com/736x/1d/78/ab/1d78ab763bbe887cdcc5741a8d588f64.jpg'),
(10, 'Yoga Wear', 'Comfortable yoga outfits.', 'https://i.pinimg.com/736x/6a/2c/57/6a2c57f36b05846bb0398c5a75f3c087.jpg'),
(10, 'Running Wear', 'Running and jogging apparel.', 'https://i.pinimg.com/736x/96/43/c5/9643c5ae81b58781f4608cf3176ba8f6.jpg'),
(10, 'Track Pants', 'Sports track pants.', 'https://i.pinimg.com/1200x/fd/66/e5/fd66e542121c8084ea5ba99af598eb30.jpg'),
(10, 'Sports T-Shirts', 'Breathable sports t-shirts.', 'https://i.pinimg.com/736x/4f/37/fe/4f37fef5e19ae21d3d7cc005dfaaedb0.jpg'),

-- Winter Wear (11)
(11, 'Sweaters', 'Woolen sweaters.', 'https://i.pinimg.com/1200x/9e/54/07/9e540776485e17ab81c54914711c1c29.jpg'),
(11, 'Jackets', 'Winter jackets and coats.', 'https://i.pinimg.com/1200x/1a/5a/34/1a5a34cc33ae2db8091c4d5058da1c83.jpg'),
(11, 'Thermal Wear', 'Thermal innerwear.', 'https://i.pinimg.com/1200x/08/b9/b3/08b9b3ed7e2a81a723cd2491302762ac.jpg'),
(11, 'Hoodies', 'Warm hoodies and sweatshirts.', 'https://i.pinimg.com/736x/f9/02/0c/f9020cf15f4909b5d73bae69836ee107.jpg'),
(11, 'Scarves & Gloves', 'Winter accessories.', 'https://i.pinimg.com/1200x/9a/f5/38/9af538dd0979e8e137597fc43cc8b1d5.jpg'),

-- Jewelry & Watches (12)
(12, 'Necklaces', 'Fashion necklaces.', 'https://i.pinimg.com/1200x/a4/00/e3/a400e3130c1d2688810302983264a3cc.jpg'),
(12, 'Earrings', 'Studs and long earrings.', 'https://i.pinimg.com/736x/66/6d/2f/666d2fa55af551bf1841d0e2ccc8195a.jpg'),
(12, 'Bracelets', 'Bracelets and bangles.', 'https://i.pinimg.com/1200x/74/34/a1/7434a1d87c2c40917344c6857596ad2b.jpg'),
(12, 'Rings', 'Fashion and wedding rings.', 'https://i.pinimg.com/736x/d4/ef/65/d4ef65601f3d370d5e50a4a97f79b8bc.jpg'),
(12, 'Luxury Watches', 'Premium and branded watches.', 'https://i.pinimg.com/736x/60/85/b7/6085b78e4a2426e927fc07e9e5ec1c08.jpg');

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES

-- =======================
-- MENS WEAR (More)
-- =======================
('Calvin Klein Crew Neck T-Shirt', 'Soft cotton everyday t-shirt by Calvin Klein', 13, 1, 1, 2199, 140),
('Tommy Hilfiger Checked Shirt', 'Classic checked casual shirt', 14, 1, 2, 3299, 125),
('Raymond Tailored Jeans', 'Premium denim jeans for men', 24, 1, 3, 3799, 115),
('Van Heusen Slim Fit Trousers', 'Formal slim fit office trousers', 23, 1, 4, 2999, 160),
('Burberry Casual Jacket', 'Lightweight luxury jacket', 16, 1, 5, 15999, 100);

INSERT INTO product_images (product_id,image_url) VALUES
(1,'https://i.pinimg.com/1200x/6c/ec/94/6cec94d75eac0f6f59028941d527fe25.jpg'),
(2,'https://i.pinimg.com/1200x/22/6f/c9/226fc9093e8db5975f37c7231a7fd0a7.jpg'),
(3,'https://i.pinimg.com/1200x/86/e4/f7/86e4f79a7a3e6c38dfee64410c07deb8.jpg'),
(4,'https://i.pinimg.com/736x/e9/71/3b/e9713b2fb36ad307e10a2382a4801ee1.jpg'),
(5,'https://i.pinimg.com/736x/1c/b3/fd/1cb3fd97aaf73054b4a7dcd9b223b3a2.jpg')

-- =======================
-- MENS FASHION WEAR
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Nike Streetwear Hoodie', 'Urban street style hoodie', 5, 2, 6, 3999, 145),
('Adidas Fashion Sneakers', 'Trendy lifestyle sneakers', 6, 2, 7, 5499, 150),
('Puma Oversized Street Tee', 'Loose fit streetwear t-shirt', 7, 2, 8, 1799, 170),
('Zara Slim Fit Blazer', 'Modern slim-fit blazer', 1, 2, 9, 6999, 110),
('H&M Co-ord Set', 'Matching top and bottom fashion set', 2, 2, 10, 3499, 135);

INSERT INTO product_images (product_id,image_url) VALUES
(6,'https://i.pinimg.com/1200x/6d/25/09/6d25096ecef8b7d9ddb8f563014fef44.jpg'),
(7,'https://i.pinimg.com/736x/23/a8/59/23a859029eb426aa6ce515c5be844d61.jpg'),
(8,'https://i.pinimg.com/1200x/0e/ac/eb/0eaceb1d647fd4f75a6236f9f2ce399a.jpg'),
(9,'https://i.pinimg.com/736x/91/6a/39/916a39df9bbf86088b22d65ae7fcdc39.jpg'),
(10,'https://i.pinimg.com/736x/37/17/76/371776894e184fc5a7d60e5a03f14a78.jpg');

-- =======================
-- WOMENS WEAR (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Guess Party Dress', 'Stylish party wear dress', 20, 3, 12, 4999, 120),
('Zara Ribbed Top', 'Comfort fit ribbed top', 1, 3, 11, 1799, 150),
('Levis Women Skinny Jeans', 'High-rise skinny denim jeans', 4, 3, 13, 3599, 130),
('Forever 21 Pleated Skirt', 'Trendy pleated skirt', 17, 3, 14, 1499, 165),
('Mango Casual Jumpsuit', 'Relaxed fit casual jumpsuit', 19, 3, 15, 3299, 140);

INSERT INTO product_images (product_id,image_url) VALUES
(11,'https://i.pinimg.com/736x/3d/23/a4/3d23a49f0ca1fdbb0968f615c16517e9.jpg'),
(12,'https://i.pinimg.com/1200x/28/72/0f/28720ff8e59b2e0718795db50e5c8532.jpg'),
(13,'https://i.pinimg.com/1200x/a3/86/d5/a386d566a98ddfe84f16babbc5350dfe.jpg'),
(14,'https://i.pinimg.com/736x/e6/0c/49/e60c491dad4393c894387a32f92094f6.jpg'),
(15,'https://i.pinimg.com/736x/50/0d/b3/500db30aab4430910ee7549b514f9deb.jpg');

-- =======================
-- WOMENS TRADITIONAL (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('FabIndia Silk Saree', 'Premium festive silk saree', 26, 4, 16, 6999, 105),
('Biba Embroidered Kurti', 'Elegant embroidered kurti', 27, 4, 17, 2499, 155),
('W Bridal Lehenga', 'Designer bridal lehenga set', 28, 4, 18, 14999, 100),
('Pantaloons Cotton Salwar', 'Comfortable cotton salwar suit', 25, 4, 19, 2799, 140),
('FabIndia Printed Dupatta', 'Handcrafted ethnic dupatta', 26, 4, 20, 1599, 180);

INSERT INTO product_images (product_id,image_url) VALUES
(16,'https://i.pinimg.com/1200x/31/ad/e9/31ade9f97a89546bc16b6ec3f9fe5142.jpg'),
(17,'https://i.pinimg.com/736x/22/1a/47/221a47a7182947cf7a3663c0f7603904.jpg'),
(18,'https://i.pinimg.com/1200x/f3/c6/62/f3c6621283ac8b1d0b30e012f1170054.jpg'),
(19,'https://i.pinimg.com/736x/ca/57/23/ca5723daae1bc2f940eb0759cf9d170f.jpg'),
(20,'https://i.pinimg.com/1200x/c9/57/8b/c9578b2dcade1f6e7be4d0d9ea1ad378.jpg');

-- =======================
-- BEAUTY ITEMS (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Lakme Liquid Foundation', 'Smooth liquid foundation', 29, 5, 21, 999, 200),
('Maybelline Mascara', 'Volumizing waterproof mascara', 30, 5, 21, 699, 220),
('L’Oreal Hair Serum', 'Nourishing hair serum', 31, 5, 23, 899, 190),
('MAC Compact Powder', 'Matte finish compact powder', 32, 5, 21, 2799, 150),
('The Body Shop Face Wash', 'Gentle daily face cleanser', 33, 5, 22, 1199, 170);

INSERT INTO product_images (product_id,image_url) VALUES
(21,'https://i.pinimg.com/1200x/07/e6/0c/07e60caf3b537493183b2e70f01b36f5.jpg'),
(22,'https://i.pinimg.com/1200x/bb/f1/85/bbf185cf28f507ff7bff51c9ba5b8ada.jpg'),
(23,'https://i.pinimg.com/736x/39/90/f7/3990f7e52ca2932491a7094108fac585.jpg'),
(24,'https://i.pinimg.com/1200x/57/6a/d8/576ad8c41d91f4f7614477db92cf37bb.jpg'),
(25,'https://i.pinimg.com/736x/ff/bb/b4/ffbbb40b4a9dff30ca834a00ec3e23ca.jpg');

-- =======================
-- HANDBAGS & PURSES (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Louis Vuitton Handbag', 'Luxury monogram leather handbag', 10, 6, 26, 89999, 100),
('Michael Kors Crossbody Bag', 'Stylish crossbody sling bag', 35, 6, 30, 10999, 120),
('Fossil Backpack', 'Leather travel backpack', 34, 6, 29, 8999, 130),
('Gucci Wallet', 'Designer leather wallet', 8, 6, 28, 25999, 105),
('Prada Clutch Purse', 'Minimal luxury clutch purse', 9, 6, 27, 45999, 100),\;

INSERT INTO product_images (product_id,image_url) VALUES
(26,'https://i.pinimg.com/1200x/76/ba/87/76ba87e723aaabaa61fb5a040c3277fd.jpg'),
(27,'https://i.pinimg.com/1200x/a4/1b/42/a41b426cceb438ff95c4424271cae1a5.jpg'),
(28,'https://i.pinimg.com/736x/0d/a8/af/0da8afe8a75bc1cb54521d6556b3edbb.jpg'),
(29,'https://i.pinimg.com/1200x/d3/bb/d2/d3bbd2099a2f3b5c9646d6f8ee5e6f4c.jpg'),
(30,'https://i.pinimg.com/1200x/90/8a/85/908a8511e8bd02bdb03681d792ad9412.jpg');

-- =======================
-- FOOTWEAR (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Nike Air Max Sneakers', 'Cushioned everyday sneakers', 5, 7, 33, 7999, 145),
('Adidas Formal Shoes', 'Stylish office formal shoes', 6, 7, 32, 6499, 120),
('Bata Casual Sandals', 'Comfortable daily sandals', 21, 7, 34, 1799, 180),
('Puma Training Shoes', 'Durable gym and training shoes', 7, 7, 31, 5699, 155),
('Gucci Women Heels', 'Luxury high heel footwear', 8, 7, 35, 45999, 100);

INSERT INTO product_images (product_id,image_url) VALUES
(31,'https://i.pinimg.com/1200x/e4/b4/52/e4b452e517db6aa441e89a5e1784fcff.jpg'),
(32,'https://i.pinimg.com/1200x/ec/e5/99/ece599a47b8562a1884ccd728a975519.jpg'),
(33,'https://i.pinimg.com/736x/af/c0/d4/afc0d4654be0e764c1dda1440fe9511d.jpg'),
(34,'https://i.pinimg.com/1200x/b9/29/a3/b929a3c53f2ffcc2a6037f080d3aee6d.jpg'),
(35,'https://i.pinimg.com/736x/72/2c/b5/722cb5dce8c2f874d066d72a609cdf58.jpg');

-- =======================
-- ACCESSORIES & WATCHES
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Fossil Analog Watch', 'Classic leather strap watch', 34, 8, 40, 7999, 140),
('Michael Kors Sunglasses', 'Stylish UV-protection sunglasses', 35, 8, 38, 9999, 120),
('Raymond Silk Tie', 'Premium silk formal tie', 24, 8, 36, 1299, 200),
('Gucci Leather Belt', 'Designer leather belt', 8, 8, 36, 21999, 105),
('Tommy Hilfiger Cap', 'Casual everyday cap', 14, 8, 37, 1999, 160);

INSERT INTO product_images (product_id,image_url) VALUES
(36,'https://i.pinimg.com/1200x/67/9a/46/679a466058a8923eae1d407a28cbd7df.jpg'),
(37,'https://i.pinimg.com/1200x/60/12/9b/60129b19cb8bc4d2e40bfe584616b2db.jpg'),
(38,'https://i.pinimg.com/736x/33/a1/0d/33a10d491450c216e0e148057d99c182.jpg'),
(39,'https://i.pinimg.com/1200x/b0/cb/d1/b0cbd15cd0e0d1d11762aad751a7e5c3.jpg'),
(40,'https://i.pinimg.com/1200x/6c/14/95/6c1495686b609a9bb8db10e978ad3a86.jpg');

-- =======================
-- SPORTS & ACTIVEWEAR (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Nike Yoga Pants', 'Stretchable yoga wear pants', 5, 10, 42, 2999, 170),
('Adidas Sports T-Shirt', 'Sweat-wicking sports tee', 6, 10, 44, 2499, 160),
('Puma Track Pants', 'Comfort fit running pants', 7, 10, 43, 2799, 150),
('Nike Gym Shorts', 'Lightweight workout shorts', 5, 10, 41, 2299, 180);

INSERT INTO product_images (product_id,image_url) VALUES
(41,'https://i.pinimg.com/1200x/41/06/41/4106412595ce578c3580eb8724fa4218.jpg'),
(42,'https://i.pinimg.com/1200x/15/93/48/15934805269e35c2712fcb0f7359ad64.jpg'),
(43,'https://i.pinimg.com/1200x/98/1a/e4/981ae4f4854c2c3f66777665f68900ef.jpg'),
(44,'https://i.pinimg.com/1200x/6c/f6/fa/6cf6fa9eb93ef2383e213cbcb4c23683.jpg');

-- =======================
-- WINTER WEAR (More)
-- =======================

INSERT INTO products
(name, description, brand_id, category_id, subcategory_id, price, stock)
VALUES
('Uniqlo Thermal Wear Set', 'Warm inner thermal wear', 3, 11, 48, 1999, 190),
('H&M Wool Sweater', 'Soft knit winter sweater', 2, 11, 46, 2799, 160),
('Zara Winter Coat', 'Long stylish winter coat', 1, 11, 47, 8999, 120),
('Burberry Winter Gloves', 'Luxury wool gloves', 16, 11, 50, 12999, 100);

INSERT INTO product_images (product_id,image_url) VALUES
(45,'https://i.pinimg.com/736x/52/e8/bc/52e8bc303f9dc3b689d88d5eccc23dbd.jpg'),
(46,'https://i.pinimg.com/1200x/dd/16/02/dd1602cc46c2f9967bb0d9c73b13a81e.jpg'),
(47,'https://i.pinimg.com/1200x/cd/24/aa/cd24aa84d55f2ef3af386c6bc272857b.jpg'),
(48,'https://i.pinimg.com/1200x/08/75/f4/0875f45a3825980739af4dbe8d2074b1.jpg');
