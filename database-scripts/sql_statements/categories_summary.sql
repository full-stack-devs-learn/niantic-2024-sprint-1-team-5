# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#        DISPLAYS A USERS TOTAL MONTHLY EXPENSES IN EACH CATEGORY        #
# ---------------------------------------------------------------------- #
# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'Sarah Smith', -- INSERT FULL NAME
	@search_for_month = '08';         -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED ** 

SELECT t.*, u.full_name
, s.subcategory_name
, c.category_name
FROM transactions t
JOIN users u ON t.owner = u.user_id
JOIN subcategories s ON t.subcategory_id = s.subcategory_id
JOIN categories c ON s.parent_id = c.category_id
WHERE u.full_name = @search_for_user AND DATE_FORMAT(t.date, '%m') = @search_for_month
ORDER BY c.category_name

