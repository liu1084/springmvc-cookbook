/**
 * Created by jim on 2016/12/30.
 *
 */
(function($, utf, _){
	'use strict';
	utf.LeftMenu = function(){
		this.topHeight = 50;
		this.element = {};
		this.windowH = 0;
	};
	utf.LeftMenu.prototype = {
		init: function(){
			var _this = this;
			this.element = $('.neu-left-menu')[0];
			_this.setHeight(600);
			this.bind();
			setTimeout(function(){
				_this.windowH = _this.getDocHeight();
				_this.setHeight(_this.windowH - _this.topHeight);
			}, 500)
		},
		getDocHeight: function() {
			var D = document;
			return Math.max(
					D.body.scrollHeight, D.documentElement.scrollHeight,
					D.body.offsetHeight, D.documentElement.offsetHeight,
					D.body.clientHeight, D.documentElement.clientHeight
			);
		},
		setHeight: function(h){
			$(this.element).height(h);
		},
		bind: function(){
			var _this = this;
			$(window).on('resize', _.debounce(function(){
				_this.getDocHeight();
				_this.setHeight(_this.windowH - _this.topHeight);
			}, 50));
		}
	};

	var leftMenu = new utf.LeftMenu();
	leftMenu.init();
})(jQuery, $.ude.utf, _);