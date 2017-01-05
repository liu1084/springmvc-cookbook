/**
 * Created by jim on 2016/12/28.
 *
 */
(function($, utf){
	utf.UserTable = function(){};
	utf.UserTable.prototype = {
		init: function(){
			this.bind();
		},
		bind: function(){
			$(document).off('change', '#user-table input[name="all-account"][type="checkbox"]')
					.on('change', '#user-table input[name="all-account"][type="checkbox"]', function () {
						var checkboxes = $('#user-table').find('input[name="accounts"][type="checkbox"]');
						if ($(this).is(':checked')) {
							$.each(checkboxes, function (index, cBox) {
								$(cBox).prop('checked', true);
							});
						} else {
							$.each(checkboxes, function (index, cBox) {
								$(cBox).prop('checked', false);
							});
						}
					});

			$(document).off('change', '#user-table input[name="accounts"][type="checkbox"]')
					.on('change', '#user-table input[name="accounts"][type="checkbox"]', function () {
						var table = $('#user-table');
						var checkboxes = table.find('input[name="accounts"][type="checkbox"]');
						var checkedBoxes = table.find('input[name="accounts"][type="checkbox"]:checked');

						if (checkboxes.length === checkedBoxes.length) {
							table.find('input[name="all-account"][type="checkbox"]').prop('checked', true);
						} else {
							table.find('input[name="all-account"][type="checkbox"]').prop('checked', false);
						}
					});
		}
	};

	var userTable = new utf.UserTable();
	userTable.init();
})(jQuery, $.ude.utf);