# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#               MONTHLY SPENDING SPREAD ACROSS CATEGORIES                #
# ---------------------------------------------------------------------- #
# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'John Doe', -- INSERT FULL NAME
	@search_for_user_id = (SELECT users.id FROM users WHERE users.full_name = @search_for_user),
	@search_for_month = '08';         -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED ** 

WITH CategoryTotals AS 
(
	SELECT c.category_name 
		, SUM(amount) AS category_total
    FROM transactions t
    JOIN userbudgets b ON t.owner = b.owner
    JOIN subcategories s ON t.subcategory_id = s.id
    JOIN categories c ON s.id = c.id
    WHERE b.owner = @search_for_user_id AND DATE_FORMAT(t.date, '%m') = @search_for_month
    GROUP BY c.category_name
),
TotalAmount AS (
	SELECT SUM(category_total) AS monthly_total
    FROM CategoryTotals
)
SELECT
    ct.category_name,
    ct.category_total,
    ta.monthly_total,
    CONCAT(ROUND((ct.category_total / ta.monthly_total) * 100, 2), "%") AS percentage_of_total
FROM CategoryTotals ct
JOIN TotalAmount ta;

