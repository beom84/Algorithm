-- 코드를 입력하세요
SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CD,CATEGORY,PRICE
 from FOOD_PRODUCT
 order by PRICE desc 
 limit 1-- 가격이 제일 비싼 price가 남들보다 가장 높아야한다.
    