# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#      DISPLAYS ALL SUB-CATEGORIES BY PERSON/MONTH/PARENT CATEGORY       #
# ---------------------------------------------------------------------- #

# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'John Doe', -- INSERT FULL NAME
	@search_for_month = '09',      -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED **
    @search_for_category = 'Vacation/Travel'; -- INSERT CATEGORY NAME
    
    
SELECT t.amount, u.full_name
, s.subcategory_name
, c.category_name
FROM transactions t
JOIN users u ON t.owner = u.id
JOIN subcategories s ON t.subcategory_id = s.id
JOIN categories c ON s.parent_id = c.id
WHERE u.full_name = @search_for_user
AND DATE_FORMAT(t.date, '%m') = @search_for_month
AND c.category_name = @search_for_category