"use strict";

var http = require('http');
var dataManager = require('./DataManager');
var SQLiteDB = require('./SQLite');
var url = require('url');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write("The date and time are currently: " + dataManager.myDateTime());
	res.write(req.url);
	var q = url.parse(req.url, true).query;
	var txt = q.year + " " + q.month;
	var dbTest = new SQLiteDB();
	res.write("   " + dbTest.dbName + "   ");
	dbTest.connect();
    res.end(txt);
}).listen(8080);

