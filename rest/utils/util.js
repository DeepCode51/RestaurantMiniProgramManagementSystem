const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return `${[year, month, day].map(formatNumber).join('/')} ${[hour, minute, second].map(formatNumber).join(':')}`
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : `0${n}`
}

const dateCompare = (dateTimeStamp1, dateTimeStamp2) => {
  let dayNum = 0
  if (dateTimeStamp1 > dateTimeStamp2) {
    dayNum = Math.floor((dateTimeStamp1 - dateTimeStamp2) / 86400)
  } else {
    dayNum = Math.floor((dateTimeStamp2 - dateTimeStamp1) / 86400)
  }
  return dayNum
}

module.exports = {
  formatTime,
  dateCompare
}
