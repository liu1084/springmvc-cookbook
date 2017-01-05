/**
 * Created by jim on 2016/12/14.
 *
 */
(function ($, utf) {
	utf.Ajax = function () {
		this.deferred = $.Deferred();
	};
	utf.Ajax.prototype = {
		xmlRequest: function (params) {
			var _this = this;
			var cache = params.cache;
			var url = params.url;
			var async = params.async;
			var data = params.data;
			var type = params.type;
			var callback = params.callback;
			var headers = params.headers;


			$.ajax({
				cache: cache ? cache : false,
				url: url,
				async: async || false,
				data: data ? data : {},
				type: type ? type : 'POST',
				contentType: "application/json; charset=utf-8",
				headers: $.extend({}, headers, {ajaxRequest: true}),
				success: function (dc) {
					_this.deferred.resolve(dc);
				},
				error: function (err) {
					_this.deferred.reject(err);
				},
				complete: function () {
					if (callback && $.isFunction(callback)) {
						callback();
					}
				}
			});

			return _this.deferred;
		},
		xmlLoad: function (params) {
			var url = params.url;
			if (!url) return false;
			var target = params.target;
			$.ajax({
				dataType: 'html',
				url: url,
				success: function (html) {
					$(target).html(html);
				},
				error: function (err) {
					$(target).text(err);
				}
			});

			//$.get(url, function(html){
			//	$(target).html($.parseHTML(html));
			//});
		},
		//以POST的方式提交JSON数据
		postJsonData: function (options) {
			var _callback = function (json) {
			};
			var defaults = {
				url: null,
				data: null,
				async: true,
				global: true,
				callback: _callback
			};
			options = $.extend(defaults, options);

			$.ajax({
				type: "post",
				url: options.url,
				global: options.global,
				contentType: 'application/json',
				data: JSON.stringify(options.data),
				dataType: "json",
				async: options.async,
				success: function (json) {
					options.callback(json);
				},
				error: function (json) {
					console.info(json);
				}
			});
		}
	};
})(jQuery, $.ude.utf);