# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#             MONTHLY SPENDING SPREAD ACROSS SUBCATEGORIES               #
# ---------------------------------------------------------------------- #
# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'John Doe', -- INSERT FULL NAME
	@search_for_month = '08',       -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED **
    @search_for_category = 'Vacation/Travel'; -- INSERT CATEGORY NAME

WITH Subcategories_Total AS (
    SELECT s.subcategory_name AS subcategory
        , c.category_name AS category
        ,SUM(t.amount) AS subcategory_total
    FROM transactions t
    JOIN subcategories s ON t.subcategory_id = s.subcategory_id
    JOIN categories c ON s.parent_id = c.category_id
    GROUP BY s.subcategory_name, c.category_name
),
Subcategories_Group AS (
    SELECT category
		, SUM(subcategory_total) AS category_total
    FROM Subcategories_Total
    GROUP BY category
)
SELECT 
    st.subcategory
    , st.category
    , st.subcategory_total
    , sg.category_total
    , (st.subcategory_total / sg.category_total) * 100 AS percentage_of_category
FROM Subcategories_Total st
JOIN Subcategories_Group sg ON st.category = sg.category
WHERE st.category = @search_for_category
ORDER BY st.category, st.subcategory;
 

