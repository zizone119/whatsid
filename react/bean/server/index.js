const express = require("express");
const app = express();
const PORT = process.env.port || 8000;
const mysql = require("mysql");
const cors = require("cors");
const bodyParser = require("body-parser");

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.json());
let corsOptions = {
  origin: "*",
  credential: true,
};

app.use(cors(corsOptions));

const db = mysql.createPool({
  host: "localhost",
  user: "root",
  password: "1234",
  database: "bean",
});

app.get("/list", (req, res) => {
  const sqlQuery =
    "select board_id, board_title, register_id, date_format(register_date,'%Y-%m-%d %H:%i') as register_date, date_format(updater_date,'%Y-%m-%d %H:%i') as updater_date from board;";
  db.query(sqlQuery, (err, result) => {
    res.send(result);
  });
});

app.post("/insert", (req, res) => {
  var title = req.body.title;
  var content = req.body.content;
  const sqlQuery =
    "insert into board(board_title,board_content,register_id) values(?,?,'atristJoy');";
  db.query(sqlQuery, [title, content], (err, result) => {
    res.send(result);
  });
});

app.post("/update", (req, res) => {
  var title = req.body.title;
  var content = req.body.content;
  var id = req.body.id;
  const sqlQuery =
    "update board set board_title=?, board_content=?, updater_date=now() where board_id = ?;";
  db.query(sqlQuery, [title, content, id], (err, result) => {
    res.send(result);
  });
});

app.post("/delete", (req, res) => {
  const id = req.body.boardList;
  const sqlQuery = `delete from board where board_id in (${id})`;
  db.query(sqlQuery, (err, result) => {
    res.send(result);
  });
});
app.listen(PORT, () => {
  console.log("connected");
});
