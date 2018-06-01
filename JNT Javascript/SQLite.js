"use strict";
const sqlite3 = require('sqlite3').verbose();

class SQLiteDB {
	constructor () {
		this.dbName = "testnpc.db";
	}
	
	connect () {
		let db = new sqlite3.Database('../testnpc.db', sqlite3.OPEN_READWRITE, (err) => {
			if (err) {
				console.error(err.message);
			}
			console.log('Connected to the testnpc database.');
		});
	}
}

module.exports = SQLiteDB;