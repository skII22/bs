var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const { createProxyMiddleware } = require('http-proxy-middleware');
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var app = express();



// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// 托管静态资源
app.use(express.static('./dist'));
// 调用 app.listen 方法，指定端口号并启动 web 服务器
process.env.PORT = 4000
app.use('/api', createProxyMiddleware({
  target: 'http://localhost:3000', // 代理目标地址
  changeOrigin: true, // 更改来源IP(默认值:true)
  pathRewrite: {
    '^/api': '', // 移除接口路径前缀
  },
}));



app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
