SELECT product_code, SUM(price * sales_amount) as sales
  FROM PRODUCT p join OFFLINE_SALE o
 USING (PRODUCT_ID)
 GROUP BY PRODUCT_ID
 ORDER BY sales DESC, product_code ASC;