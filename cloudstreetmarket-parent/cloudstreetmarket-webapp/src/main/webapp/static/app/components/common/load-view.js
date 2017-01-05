/**
 * Created by jim on 2016/12/22.
 *
 */
(function($, utf){
	'use strict';
	utf.LoadView = function(){};
	utf.LoadView.prototype = {
		loadJSP: function(url, target){
			if (!url){
				return false;
			}

			if (!target){
				target = CONTAINER;
			}

			var request = new utf.Ajax();
			var params = {
				url: url,
				target: target
			};

			request.xmlLoad(params);
		}
	};
})(jQuery, $.ude.utf);