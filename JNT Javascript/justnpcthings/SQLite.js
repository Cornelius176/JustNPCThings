"use strict";
const sqlite3 = require('sqlite3').verbose();
const path = require('path');
const dbPath = 'C:\\GitHub\\JustNPCThings\\testnpc.db';

class SQLiteDB {
	constructor () {
		this.dbName = 'testnpc.db';
	}
	
	connect () {
		var db = new sqlite3.Database(dbPath, sqlite3.OPEN_READWRITE, (err) => {
			console.log(dbPath);
			if (err) {
				console.error(err.message);
				return;
			}
			console.log('Connected to the testnpc database.');
		});
		
		let sql = 'SELECT DISTINCT Word word FROM placeword ORDER BY word';
 
		db.all(sql, [], (err, rows) => {
			if (err) {
				throw err;
			}
			rows.forEach((row) => {
				console.log(row.word);
			});
		});
		
		return db;
	}
	
	getwords () {
		var db = connect();
	}
}

module.exports = SQLiteDB;