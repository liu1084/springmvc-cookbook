/**
 * Created by jim on 2016/12/25.
 *
 */

var html2markdown = require('html2markdown');
var fs = require('fs');
var http = require('http');


http.createServer(function(req, res){
	fs.readFile('index.html',function (err, data){
		if (err) throw new Error(err);

		res.writeHead(200, {'Content-Type': 'text/html','Content-Length':data.length});
		res.write(html2markdown(data));
		res.end();
	});
}).listen(8000);