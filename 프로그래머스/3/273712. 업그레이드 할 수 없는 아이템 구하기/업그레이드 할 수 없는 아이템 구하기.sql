-- 코드를 작성해주세요
SELECT item_id, item_name, rarity
FROM ITEM_INFO
WHERE item_id NOT IN (
    SELECT DISTINCT(parent_item_id)
    FROM ITEM_TREE
    WHERE parent_item_id IS NOT NULL
)
ORDER BY 1 desc