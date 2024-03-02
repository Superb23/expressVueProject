const mysql = require("mysql")

// 创建连接池
const db = mysql.createPool({
  // host: "47.122.4.234",
  host: "127.0.0.1",
  user: "root",
  password: "root",
  database: "expressProject"
})

module.exports = db