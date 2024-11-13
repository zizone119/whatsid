const errorhandler = (err, req, res, next) => {
  const status = err.status || 500;
  switch (status) {
    case 300:
      res.status(status).json({
        title: "bad request",
        msg: err.message,
      });
      break;
    case 401:
      res.status(status).json({
        title: "unauthorized",
        msg: err.message,
      });
      break;
    case 403:
      res.status(status).json({
        title: "forbidden",
        msg: err.message,
      });
      break;
    case 404:
      res.status(status).json({
        title: "not found",
        msg: err.message,
      });
      break;
    case 404:
      res.status(status).json({
        title: "internal server error",
        msg: err.message,
      });
      break;
    default:
      res.status(status).json({
        title: "no error",
        msg: err.message,
      });
      break;
  }
};

module.exports = errorhandler;
