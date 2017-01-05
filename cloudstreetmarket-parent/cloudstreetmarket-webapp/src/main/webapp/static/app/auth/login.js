/**
 * Created by jim on 2016/12/14.
 *
 */
(function($){
	'use strict';
	var Login = function(){};
	Login.prototype = {
		submit_form: function(){
			document.getElementById("logonform").submit();
		}
	}
})(jQuery);