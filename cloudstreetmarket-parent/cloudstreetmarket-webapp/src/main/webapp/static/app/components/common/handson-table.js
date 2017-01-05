/**
 * Created by jim on 2016/12/29.
 *
 */
(function ($, utf) {
	'use strict';
	utf.HandsonTable = function () {
		this.container = {};
		this.data = [];
	};

	utf.HandsonTable.prototype = {
		init: function () {
		},
		createHandsontable: function (container, data, columnsMetaData, height) {
			var _this = this;
			_this.container = container;
			_this.data = data;

			var colHeaders = [], colWidths = [], columns = [];
			for (var i = 0, len = columnsMetaData.length; i < len; i++) {
				colHeaders.push(columnsMetaData[i].columnName);
				colWidths.push(columnsMetaData[i].columnWidth);
				columns.push({data: columnsMetaData[i].columnValueKey});
			}

			$(_this.container).handsontable({
				data: _this.data,
				minSpareRows: 1,
				colHeaders: colHeaders,
				colWidths: colWidths,
				manualColumnResize: true,
				manualRowResize: true,
				columnSorting: true,
				rowHeaders: true,
				height: height,
				width: 700,
				contextMenu: {
					items: {
						"row_above": {
							name: "在此行前插入一行"
						},
						"row_below": {
							name: "在此行后插入一行"
						},
						"remove_row": {
							name: "删除此行"
						}
					}
				},
				columns: columns
			});
		}
	};
})(jQuery, $.ude.utf);