(function($, utf) {
	'use strict';
	utf.Device = function(){
		this.template = '';
		this.devices = [];

		this.USE_STATE = {'using': '使用中','free': '空闲'};
	};
	utf.Device.prototype = {
		init: function(){
			this.bind();
			this.renderProxies();
		},
		bind: function(){
			var _this = this;
			//鼠标点击
			$(document).off('click', '.neu-host')
					.on('click', '.neu-host', function () {
						$(this).siblings().removeClass('active').addClass('inactive');
						$(this).removeClass('inactive').addClass('active');
						//点击一个项目，显示该项目相关的用户
						var proxyId = $(this).data("proxyid");
						_this.getDevicesByServerId(proxyId);
					});
			//add proxy
			$(document).off('click', '.add-proxy')
					.on('click', '.add-proxy', function(e){
						e.preventDefault();
						var loadView = new utf.LoadView();
						loadView.loadJSP(appPath + "/admin/deviceManager/addProxy");
					});
			//edit proxy
			$(document).off('click', '.neu-icon-edit')
					.on('click', '.neu-icon-edit', function(e){
						e.preventDefault();
						var id = $(this).data('proxyid');
						var loadView = new utf.LoadView();
						loadView.loadJSP(appPath + "/admin/deviceManager/edit/id/" + id);
					});
			//delete proxy
			$(document).off('click', '.neu-icon-delete')
					.on('click', '.neu-icon-delete', function(e){
						e.preventDefault();
						var id = $(this).data('proxyid');

						var ajax = new utf.Ajax();
						var params = {
							type: 'POST',
							url: appPath + '/admin/equipmentManage/delete/id/' + id
						};

						ajax.postJsonData(params);
					});


			//显示详细信息
			$(document).off('click', '.neu-device-detail')
					.on('click', '.neu-device-detail', function(e){
						e.preventDefault();
						var id = $(this).data('deviceid');
						var loadView = new utf.LoadView();
						loadView.loadJSP(appPath + "/admin/deviceManager/detail/id/" + id);
					});

		},
		getDevicesByServerId: function(id){
			var _this = this;
			var params = {
				url: appPath + '/admin/equipmentManage/getDevicesByServerId/' + id,
				type: 'GET'
			};

			var ajax = new utf.Ajax();
			var d1 = ajax.xmlRequest(params);

			$.when(d1).done(function (devices) {
				_this.devices = devices;
				var data = {devices: devices, appPath: appPath};
				var target = $('#neu-devices');
				var callback = function(){};

				Handlebars.registerHelper('status', function(useState){
					if (useState > 0) {
						return _this.USE_STATE.using;
					}else{
						return _this.USE_STATE.free;
					}
				});

				_this.renderDevices(data, target, callback);
			});
		},
		renderDevices: function(data, target, callback){
			var _this = this;
			var handlebarsRender = new utf.HandlebarsRender();
			_this.template = templates["template/devices.hbs"];

			handlebarsRender.render(_this.template, data, target, callback);
		},
		renderProxies: function(){
			var _this = this;
			var handlebarsRender = new utf.HandlebarsRender();
			_this.template = templates["template/proxies.hbs"];
			handlebarsRender.render(_this.template, {proxies: proxies}, $('#neu-proxies'));
		}
	};
	
	var device = new utf.Device();
	device.init();
})(jQuery, $.ude.utf);