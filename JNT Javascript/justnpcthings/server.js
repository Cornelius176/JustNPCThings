const express = require('express');
var SQLiteDB = require('./SQLite');

const app = express();
const port = process.env.PORT || 5000;

app.get('/api/hello', (req, res) => {
	res.send({ express: 'Hello From Express' });
});

app.get('/api/test', (req, res) => {
	var dbTest = new SQLiteDB();
	var txt = dbTest.dbName;
	dbTest.connect();
	res.send({ test: txt });
});

app.listen(port, () => console.log(`Listening on port ${port}`));