/**
 * Created by jim on 2016年8月9日,0009.
 */
(function ($, utf) {
	utf.Nav = function () {
		this.loadView = new utf.LoadView();
		this.url = '';
	};
	utf.Nav.prototype.init = function () {
		this.bind();
	};
	utf.Nav.prototype.bind = function () {
		var _this = this;
		$(document).off('click', '.neu-menu')
				.on('click', '.neu-menu', function () {
					var mySiblings = $(this).siblings();
					mySiblings.each(function (index, element) {
						$(element).removeClass('active');
						$(element).find('.neu-icon:last').removeClass('neu-icon-keyboard_arrow_down').addClass('neu-icon-keyboard_arrow_right');
						$(element).find('.neu-sub-menu').hide();
					});

					$(this).addClass('active');
					if ($(this).hasClass('active')) {
						$(this).children('.neu-sub-menu').show();
						$(this).find('.neu-icon:last').removeClass('neu-icon-keyboard_arrow_right').addClass('neu-icon-keyboard_arrow_down');
					} else {
						$(this).children('.neu-sub-menu').hide();
						$(this).find('.neu-icon:last').removeClass('neu-icon-keyboard_arrow_down').addClass('neu-icon-keyboard_arrow_right');
					}
				});

		//$(document).off('click', '.neu-sidebar-toggler')
		//		.on('click', '.neu-sidebar-toggler', function(){
		//			$(this).toggleClass('active');
		//			var myParent = $(this).parent('.neu-left-menu');
		//			if ($(this).hasClass('active')){
		//				myParent.addClass('inactive');
		//			}else{
		//				myParent.removeClass('inactive');
		//			}
		//		});

		//click menu
		$(document).off('click', '.menu-link')
				.on('click', '.menu-link', function (e) {
					e.preventDefault();
					$('.menu-link').css({'background': 'rgba(0,0,0,0)'});
					$(this).css({background: '#eee'});
					var leftMenu = new utf.LeftMenu();
					leftMenu.init();
				});

		$(document).off('click', '.home')
				.on('click', '.home', function(){
					_this.url = appPath + '/dashboard';
					_this.loadView.loadJSP(_this.url);
				});

		$(document).off('click', '.project.maintenance')
				.on('click', '.project.maintenance', function (e) {
					_this.url = appPath + '/admin/projectManager';
					_this.loadView.loadJSP(_this.url);
				});

		$(document).off('click', '.account.maintenance')
				.on('click', '.account.maintenance', function (e) {
					_this.url = appPath + '/admin/accountManager';
					_this.loadView.loadJSP(_this.url);
				});

		$(document).off('click', '.config.maintenance')
				.on('click', '.config.maintenance', function (e) {
					_this.url = appPath + '/admin/configManager';
					_this.loadView.loadJSP(_this.url);
				});

		$(document).off('click', '.device.maintenance')
				.on('click', '.device.maintenance', function (e) {
					e.preventDefault();
					_this.url = appPath + '/admin/deviceManager';
					_this.loadView.loadJSP(_this.url);
				});
		$(document).off('click', '.device.proxy')
				.on('click', '.device.proxy', function (e) {
					_this.url = appPath + '/admin/deviceManager/addProxy';
					_this.loadView.loadJSP(_this.url);
				});
		$(document).off('click', '.device.config')
				.on('click', '.device.config', function (e) {
					_this.url = appPath + '/admin/deviceManager/config';
					_this.loadView.loadJSP(_this.url);
				});
		$(document).off('click', '.config.maintenance')
				.on('click', '.config.maintenance', function (e) {
					_this.url = appPath + '/admin/configManager';
					_this.loadView.loadJSP(_this.url);
				});

		$(document).off('click', '#account-create')
				.on('click', '#account-create', function () {
					_this.url = appPath + '/admin/accountManager/create';
					_this.loadView.loadJSP(_this.url);
				});

		$(document).off('click', '.manual-test')
			.on('click', '.manual-test', function(){
				//点击手动测试的功能
				_this.url = appPath + '/utf/testcase/caseDesign/menu/manualTest.action';
				_this.loadView.loadJSP(_this.url);
			});
	};
	var nav = new utf.Nav();
	nav.init();
})(jQuery, $.ude.utf);
